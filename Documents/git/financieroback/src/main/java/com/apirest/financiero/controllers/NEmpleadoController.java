package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.NEmpleado;
import com.apirest.financiero.models.entity.NEmpleadoPK;
import com.apirest.financiero.models.services.NEmpleadoService;
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
public class NEmpleadoController {

	@Autowired
	private NEmpleadoService empleadoServ;

	@GetMapping("/empleado/list")
	public List<NEmpleado> findAll() {
		return empleadoServ.findAll();
	}

	@GetMapping("/empleado/empleadopk")
	public ResponseEntity<?> show (@RequestBody NEmpleadoPK nEmpleadoPK) {
		NEmpleado nEmpleadoActual;
		Map <String, Object> response = new HashMap <>();

		try {
			nEmpleadoActual = empleadoServ.findById(nEmpleadoPK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (nEmpleadoActual == null) {
			response.put("mensaje", "El empleado no existe");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(nEmpleadoActual, HttpStatus.OK);
	}

	@PostMapping("/empleado/new")
	public ResponseEntity<?> create(@RequestBody NEmpleado nEmpleado) {
		Map <String, Object> response = new HashMap <>();

		try {
			response.put("empleado", empleadoServ.save(nEmpleado));
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El empleado ha sido creado con éxito!");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/empleado/update")
	public ResponseEntity<?> update(@RequestBody NEmpleado nEmpleado) {
		NEmpleado nEmpleadoActual = empleadoServ.findById(nEmpleado.getNEmpleadoPK());
		Map<String, Object> response = new HashMap<>();

		if (nEmpleadoActual == null) {
			response.put("mensaje", "Error: no se puede editar, el empleado No existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		try {
			response.put("empleado", empleadoServ.save(nEmpleado));
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el comprobante contable detalle");
			response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El empleado ha sido actualizado con éxito!");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
