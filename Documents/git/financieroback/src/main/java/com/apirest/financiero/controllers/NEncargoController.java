package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.NEncargo;
import com.apirest.financiero.models.services.NEncargoService;
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
public class NEncargoController {

	@Autowired
	private NEncargoService encargoService;

	@GetMapping("/encargo/list")
	public List<NEncargo> findAll() {
		return encargoService.findAll();
	}

	@GetMapping("/encargo/{idencargo}")
	public ResponseEntity<?> show (@PathVariable Integer idencargo ) {
		NEncargo nEncargoActual;

		Map<String, Object> response = new HashMap <>();

		try {
			nEncargoActual = encargoService.findById(idencargo);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if(nEncargoActual == null) {
			response.put("mensaje", "El encargo no existe");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(nEncargoActual, HttpStatus.OK);
	}

	@PostMapping("/encargo/new")
	public  ResponseEntity<?> create (@RequestBody NEncargo nEncargo) {
		Map <String, Object> response = new HashMap <>();
		try {
			response.put("encargo", encargoService.save(nEncargo));
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El encargo ha sido creado con éxito!");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/encargo/update/{idencargo}")
	public ResponseEntity<?> update(@RequestBody NEncargo encargo, @PathVariable("idencargo") Integer idencargo) {
		NEncargo encargoActual = encargoService.findById(idencargo);

		Map <String, Object> response = new HashMap <>();
		try {
			encargoActual.setCargoactual(encargo.getCargoactual());
			encargoActual.setCargoasignado(encargo.getCargoasignado());
			encargoActual.setEmpcedula(encargo.getEmpcedula());
			encargoActual.setFechainicio(encargo.getFechainicio());
			encargoActual.setFechafin(encargo.getFechafin());

			response.put("encargo", encargoService.save(encargoActual));
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El encargo ha sido actualizado con éxito!");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
