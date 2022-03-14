package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.NPLey100;
import com.apirest.financiero.models.services.NPley100Service;
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
public class NPley100Controller {

	@Autowired
	private NPley100Service ley100Serv;

	@GetMapping("/ley100/list")
	public List<NPLey100> findAll(){
		return ley100Serv.findAll();
	}

	@GetMapping("/ley100/{id}")
	public ResponseEntity<?> show(@PathVariable("id") Integer id) {
		NPLey100 ley100;
		Map<String, Object> response = new HashMap <>();

		try	{
			ley100 = ley100Serv.findById(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al realizar la consulta");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity <>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		if (ley100 == null) {
			response.put("mensaje", "el registro no existe");
			return new ResponseEntity <>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity <>(ley100, HttpStatus.FOUND);
	}

	@PostMapping("/ley100/new")
	public ResponseEntity<?> create (@RequestBody NPLey100 ley100) {
		NPLey100 ley100new;
		Map<String, Object> response = new HashMap <>();

		try {
			ley100new = ley100Serv.save(ley100);
			response.put("ley100", ley100new);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al realizar la insercion");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity <>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "ley 100 con el id: "+ley100new.getId().toString()+" ha sido registrada con éxito!");
		return new ResponseEntity <>(response, HttpStatus.CREATED);
	}

	@PutMapping("/ley100/update/{id}")
	public ResponseEntity<?> create (@RequestBody NPLey100 ley100, @PathVariable("id") Integer id) {
		NPLey100 ley100Act = ley100Serv.findById(id);
		NPLey100 ley100New;

		Map<String, Object> response = new HashMap <>();

		if(ley100Act == null){
			response.put("mensaje","No se encuentra la ley100 con el id: "+id.toString()+" que desea modificar");
			return new ResponseEntity <>(response, HttpStatus.NOT_FOUND);
		}
		try {

			ley100Act.setFecha(ley100.getFecha());
			ley100Act.setTep(ley100.getTep());
			ley100Act.setTtp(ley100.getTtp());
			ley100Act.setTes(ley100.getTes());
			ley100Act.setTts(ley100.getTts());
			ley100Act.setTepr(ley100.getTepr());
			ley100Act.setTepar(ley100.getTepar());
			ley100Act.setFsp(ley100.getFsp());
			ley100Act.setFss(ley100.getFss());
			ley100Act.setFrp(ley100.getFrp());
			ley100Act.setFibcmax(ley100.getFibcmax());
			ley100Act.setFibcmin(ley100.getFibcmin());
			ley100Act.setIbcintg(ley100.getIbcintg());
			ley100Act.setDiasmaxi(ley100.getDiasmaxi());
			ley100Act.setInteres(ley100.getInteres());

			ley100New = ley100Serv.save(ley100Act);
			response.put("ley100", ley100New);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al realizar la insercion");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity <>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "ley 100 con el id: "+ley100New.getId().toString()+" ha sido actualizada con éxito!");
		return new ResponseEntity <>(response, HttpStatus.CREATED);
	}

}
