package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.NPlanoNomina;
import com.apirest.financiero.models.entity.NPlanoNominaPK;
import com.apirest.financiero.models.services.NPlanoNominaService;
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
public class NPlanoNominaController {

	@Autowired
	private NPlanoNominaService planoServ;

	@GetMapping("/planonomina/list")
	public List<NPlanoNomina> findAll() {
		return planoServ.findAll();
	}

	@GetMapping("/planonomina/planopk")
	public ResponseEntity<?> show(@RequestBody NPlanoNominaPK planopk) {
		NPlanoNomina planoActual;
		Map<String, Object> response = new HashMap <>();

		try {
			 planoActual = planoServ.findById(planopk);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al realizar la consulta");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity <>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if(planopk == null) {
			response.put("mensaje", "no se puede editar el plano nomina");
			return new ResponseEntity <>(response, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(planoActual, HttpStatus.OK);
	}

	@PostMapping("/planonomina/new")
	public ResponseEntity<?> create (@RequestBody NPlanoNomina planoNomina){
		Map<String, Object> response = new HashMap <>();

		try {
			response.put("planonomina", planoServ.save(planoNomina));
		} catch (DataAccessException e) {
			response.put("mensaje", "error al realizar la consulta");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity <>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El plano nomina ha sido creado con exito");
		return new ResponseEntity <>(response, HttpStatus.CREATED);
	}

	@PutMapping("/planonomina/update")
	public ResponseEntity<?> update(@RequestBody NPlanoNomina planoNomina) {

		NPlanoNomina planoNominaAct = planoServ.findById(planoNomina.getNPlanoNominaPK());

		Map<String, Object> response = new HashMap <>();

		if(planoNominaAct == null) {
			response.put("mensaje", "error no se puede editar el plano nomina no existe");
			return new ResponseEntity <>(response, HttpStatus.NOT_FOUND);
		}

		try {
			response.put("planonomina", planoServ.save(planoNomina));
		} catch (DataAccessException e) {
			response.put("mensaje", "error al realizar la consulta");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity <>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El plano nomina ha sido actualizado con éxito con exito");
		return new ResponseEntity <>(response, HttpStatus.CREATED);
	}
}
