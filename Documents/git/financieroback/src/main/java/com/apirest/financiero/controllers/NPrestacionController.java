package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.NPrestacion;
import com.apirest.financiero.models.services.NPrestacionService;
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
public class NPrestacionController {

	@Autowired
	private NPrestacionService prestacionServ;

	@GetMapping("/prestacion/list")
	public List<NPrestacion> findAll() {
		return prestacionServ.findAll();
	}

	@GetMapping("/prestacion/{codconcepto}")
	public ResponseEntity<?> show (@PathVariable("codconcepto") String codconcepto) {

		Map<String, Object> response = new HashMap <>();

		try {
			if(codconcepto == null) {
				response.put("mensaje", "No se encuentra la prestacion con el codigo: "+ codconcepto);
				return new ResponseEntity <>(response, HttpStatus.NOT_FOUND);
			}
			response.put("prestacion", prestacionServ.findById(codconcepto));
		} catch (DataAccessException e) {
			response.put("mensaje", "error al realizar la operacion");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
		}

		return new ResponseEntity <>(response, HttpStatus.FOUND);
	}

	@PostMapping("/prestacion/new")
	public ResponseEntity<?> create (@RequestBody NPrestacion prestacion) {
		NPrestacion prestacionNew;
		Map<String, Object> response = new HashMap <>();

		try	{
			prestacionNew  = prestacionServ.save(prestacion);
			response.put("prestacion", prestacionNew);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al realizar el registro");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity <>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "la prestacion con el codigo: "+prestacionNew.getCodConcepto()+ " ha sido creada con exito!");
		return new ResponseEntity <>(prestacionNew, HttpStatus.CREATED);
	}

	@PutMapping("/prestacion/update/{codconcepto}")
	public ResponseEntity<?> create (@RequestBody NPrestacion prestacion, @PathVariable("codconcepto")String codconcepto ) {
		NPrestacion prestacionAct = prestacionServ.findById(codconcepto);
		NPrestacion prestacionUpd;
		Map<String, Object> response = new HashMap <>();
		try	{
			prestacionAct.setDescripcion(prestacion.getDescripcion());
			prestacionAct.setTipo(prestacion.getTipo());
			prestacionAct.setNumero(prestacion.getNumero());
			prestacionAct.setTiempoMinimo(prestacion.getTiempoMinimo());
			prestacionAct.setValorBase(prestacion.getValorBase());
			prestacionAct.setMesPago(prestacion.getMesPago());
			prestacionAct.setMesPago2(prestacion.getMesPago2());
			prestacionAct.setIncluirNomina(prestacion.isIncluirNomina());
			prestacionAct.setFrecuencia(prestacion.getFrecuencia());
			prestacionAct.setPAdicional(prestacion.getPAdicional());
			prestacionAct.setPBase(prestacion.getPBase());

			prestacionUpd  = prestacionServ.save(prestacionAct);
			response.put("prestacion", prestacionUpd);
		} catch (DataAccessException e) {
			response.put("mensaje", "error al realizar el registro");
			response.put("error", e.getMessage()+": "+e.getMostSpecificCause().getMessage());
			return new ResponseEntity <>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "la prestacion con el codigo: "+prestacionUpd.getCodConcepto()+ " ha sido actualizada con exito!");
		return new ResponseEntity <>(prestacionUpd, HttpStatus.CREATED);
	}
}
