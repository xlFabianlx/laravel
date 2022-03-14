package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.NLiqNomina;
import com.apirest.financiero.models.entity.NLiqNominaPK;
import com.apirest.financiero.models.services.NLiqNominaService;
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
public class NLiqNominaController {

	@Autowired
	private NLiqNominaService liqNominaService;

	@GetMapping("/liquidacion/list")
	public List<NLiqNomina> findAll() {
		return liqNominaService.findAll();
	}

	@GetMapping("/liquidacion/liqnompk")
	public ResponseEntity<?> show (@RequestBody NLiqNominaPK nLiqNominaPK) {
		NLiqNomina nLiqNominaActual;
		Map <String, Object> response = new HashMap<>();

		try {
			nLiqNominaActual = liqNominaService.findById(nLiqNominaPK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (nLiqNominaActual == null) {
			response.put("mensaje", "La liquidacion no existe");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(nLiqNominaActual, HttpStatus.OK);
	}

	@PostMapping("/liquidacion/new")
	public ResponseEntity<?> create(@RequestBody NLiqNomina nLiqNomina) {
		Map <String, Object> response = new HashMap <>();

		try {
			response.put("liquidacion", liqNominaService.save(nLiqNomina));
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La liquidacion ha sido creada con éxito!");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/liquidacion/update")
	public ResponseEntity<?> update(@RequestBody NLiqNomina nLiqNomina) {
		NLiqNomina liquidacionActual = liqNominaService.findById(nLiqNomina.getNLiqNominaPK());
		Map<String, Object> response = new HashMap<>();

		if (liquidacionActual == null) {
			response.put("mensaje", "Error: no se puede editar, la liquidacion No existe");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		try {
			response.put("liquidacion", liqNominaService.save(nLiqNomina));
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la liquidacion detalle");
			response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "La liquidacion ha sido actualizada con éxito!");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}
