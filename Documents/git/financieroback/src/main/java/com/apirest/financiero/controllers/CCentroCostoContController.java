package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.CCentroCostoCont;
import com.apirest.financiero.models.services.CCentroCostContService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1")
public class CCentroCostoContController {

	@Autowired
	private CCentroCostContService cCentroCostContService;

	@GetMapping("/centrocosto/list")
	public List<CCentroCostoCont> findAll() {
		return cCentroCostContService.findAll();
	}

	@GetMapping("/centrocosto/byId/{id}")
	public ResponseEntity<?> show(@PathVariable("id") Long id) {
		CCentroCostoCont cCentroCostoCont;
		Map<String, Object> response = new HashMap<>();

		try {
			cCentroCostoCont = cCentroCostContService.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al Realizar la consulta");
			response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (cCentroCostoCont == null) {
			response.put("mensaje", "El fondo con el ID:" + id + " no existe");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(cCentroCostoCont, HttpStatus.OK);
	}

    @PostMapping("/centrocosto/new")
	public ResponseEntity<?> create(@RequestBody CCentroCostoCont cCentroCostoCont) {
		CCentroCostoCont cCentroCostoContNew;
		Map<String, Object> response = new HashMap<>();

		try {
			cCentroCostoContNew = cCentroCostContService.save(cCentroCostoCont);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar la inserción");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El grupo con el ID: " + cCentroCostoContNew.getCenDes() + " ha sido creado con éxito!");
        response.put("Fondo", cCentroCostoContNew);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@PutMapping("/centrocosto/update/{id}")
	public ResponseEntity<?> update(@Valid @RequestBody CCentroCostoCont cCentroCostoCont, @PathVariable Long id) {
		CCentroCostoCont grupoActual = cCentroCostContService.findById(id);
		CCentroCostoCont grupoActualizado;
		Map<String, Object> response = new HashMap<>();

		if (grupoActual == null){
			response.put("mensaje", "Error: no se puede editar, el grupo con el ID: " + id);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		try {
			grupoActual.setCenDes(cCentroCostoCont.getCenDes());
			grupoActualizado = cCentroCostContService.save(grupoActual);
		}catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar el grupo");
			response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El grupo con el ID: " + cCentroCostoCont.getCenDes() + " ha sido actualizado con éxito!");
        response.put("grupo", grupoActualizado);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@DeleteMapping("/centrocosto/delete/{id}")
	public ResponseEntity<?> deleteEntidad(@PathVariable("id") Long id) {
		Map<String, Object> response = new HashMap<>();

		try {
			cCentroCostContService.deleteById(id);
		} catch (DataAccessException e) { 
			response.put("mensaje", "Error al Eliminar el grupo");
            response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El grupo con ID: " + id + " ha sido eliminado con éxito!");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
