package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.NNovedad;
import com.apirest.financiero.models.entity.NNovedadPK;
import com.apirest.financiero.models.services.NNovedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/api/v1")
public class NNovedadController {

	@Autowired
	private NNovedadService novedadServ;

	@GetMapping("/novedad/list")
	public List<NNovedad> findAll() {
		return novedadServ.findAll();
	}

	@GetMapping("/novedad/novedadpk")
	public ResponseEntity<?> show(@RequestBody NNovedadPK novedadPK) {
		NNovedad novedadActual;
		Map<String, Object> response = new HashMap <>();
		try {
			novedadActual = novedadServ.findById(novedadPK);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al realizar la consulta");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity <>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if(novedadActual == null) {
			response.put("mensaje", "la novedad no existe");
			return new ResponseEntity <>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity <>(novedadActual, HttpStatus.OK);
	}

	@PostMapping("/novedad/new")
	public ResponseEntity<?> save(@RequestBody NNovedad novedad) {
		Map<String, Object> response = new HashMap<>();

		try {
			response.put("novedad", novedadServ.save(novedad));
		} catch (DataAccessException e) {
			response.put("mensaje", "error al realizar la consulta");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity <>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "novedad creada con exito");
		return new ResponseEntity <>(response, HttpStatus.CREATED);
	}

	@PutMapping("/novedad/update")
	public ResponseEntity<?> update(@RequestBody NNovedad novedad) {
		NNovedad novedadAct = novedadServ.findById(novedad.getNNovedadPK());
		Map<String, Object> response = new HashMap<>();

		if (novedadAct == null) {
			response.put("mensaje", "Error: no se puede editar, la novedad No existe");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		try {
			response.put("novedad", novedadServ.save(novedad));
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la novedad");
			response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La novedad ha sido actualizada con éxito!");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
