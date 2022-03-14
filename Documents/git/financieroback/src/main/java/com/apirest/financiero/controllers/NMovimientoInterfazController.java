package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.NMovimientoInterfaz;
import com.apirest.financiero.models.entity.NMovimientoInterfazPK;
import com.apirest.financiero.models.services.NMovimientoInterfazService;
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
public class NMovimientoInterfazController {

	@Autowired
	private NMovimientoInterfazService movIntServ;

	@GetMapping("/movimientointer/list")
	public List<NMovimientoInterfaz> findAll() {
		return movIntServ.findAll();
	}


	@GetMapping("/movimientointer/movimientopk")
	public ResponseEntity<?> show (@RequestBody NMovimientoInterfazPK nMovIntePK) {
		NMovimientoInterfaz nMovimientoActual;
		Map<String, Object> response = new HashMap<>();

		try {
			nMovimientoActual = movIntServ.findById(nMovIntePK);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (nMovimientoActual == null) {
			response.put("mensaje", "el movimiento interfaz no existe");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(nMovimientoActual, HttpStatus.OK);
	}

	@PostMapping("/movimientointer/new")
	public ResponseEntity<?> create(@RequestBody NMovimientoInterfaz nMovInt) {
		Map <String, Object> response = new HashMap <>();

		try {
			response.put("movimiento", movIntServ.save(nMovInt));
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la consulta");
			response.put("error", e.getMessage() + ": " + (e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El Movmiento ha sido creado con éxito!");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/movimientointer/update")
	public ResponseEntity<?> update(@RequestBody NMovimientoInterfaz nMovInt) {
		NMovimientoInterfaz movmientoActual = movIntServ.findById(nMovInt.getNMovimientoInterfazPK());
		Map<String, Object> response = new HashMap<>();

		if (movmientoActual == null) {
			response.put("mensaje", "Error: no se puede editar, el movimiento No existe");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		try {
			response.put("movimiento", movIntServ.save(nMovInt));
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar la liquidacion detalle");
			response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El Movmiento ha sido actualizada con éxito!");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
}
