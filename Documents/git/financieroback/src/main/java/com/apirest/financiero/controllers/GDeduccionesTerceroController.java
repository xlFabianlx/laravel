package com.apirest.financiero.controllers;

import com.apirest.financiero.models.entity.GDeduccionesTercero;
import com.apirest.financiero.models.services.GDeduccionesTerceroService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({ "*" })
@RequestMapping("/api/v1")
public class GDeduccionesTerceroController {

  @Autowired
  private GDeduccionesTerceroService service;

  @GetMapping("/gdeduccionestercero/list")
  public List<GDeduccionesTercero> findAll() {
    return service.findAll();
  }

  @GetMapping("/gdeduccionestercero/idtercero/{idtercero}")
  public List<GDeduccionesTercero> findByTercero(
    @PathVariable("idtercero") Long idtercero
  ) {
    return service.findByTercero(idtercero);
  }

  @PostMapping("/gdeduccionestercero/saveall/{idtercero}")
  public ResponseEntity<?> create(
    @RequestBody List<GDeduccionesTercero> gdeduccionesterceros,
    @PathVariable("idtercero") Long idtercero
  ) {

    System.out.println("---------------------------------------");
    System.out.println(gdeduccionesterceros.get(0).getIdTercero().getTerCod());
    System.out.println("---------------------------------------");
    System.out.println(gdeduccionesterceros.get(0).getIdDeduccion().getDedCod());
    List<GDeduccionesTercero> gDeduccionesTerceroNew;
    Map<String, Object> response = new HashMap<>();
    try {
      service.deleteByTercero(idtercero);
      gDeduccionesTerceroNew =
        service.saveAllGdeduccionesTercero(gdeduccionesterceros);
    } catch (DataAccessException e) {
      response.put("mensaje", "Error");
      response.put(
        "error",
        e.getMessage() + ": " + (e.getMostSpecificCause().getMessage())
      );
      return new ResponseEntity<Map<String, Object>>(
        response,
        HttpStatus.INTERNAL_SERVER_ERROR
      );
    }
    response.put("gdeduccionestercero", gDeduccionesTerceroNew);
    response.put("mensaje", "Las deducciones han sido creadas con éxito!");
    return new ResponseEntity<Map<String, Object>>(
      response,
      HttpStatus.CREATED
    );
  }
/*@DeleteMapping("/gdeduccionestercero/idtercero/{idtercero}")
    public ResponseEntity<?> deleteIdTercero(@PathVariable("idtercero") Long idtercero) {
        Map<String, Object> response = new HashMap<>();
        try {
            userService.deleteIdTercero(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "Eliminado con éxito!");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    } */
}
