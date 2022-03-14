package com.apirest.financiero.controllers;

import java.util.List;

import com.apirest.financiero.models.entity.MenuModulos;
import com.apirest.financiero.models.services.MenuModuleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1")
public class MenuModuleController {

  @Autowired
  private MenuModuleService service;
  
  @GetMapping("/menumodulos/list")
  public List<MenuModulos> listModulos(){
    try{
        return service.listModulos();
    }catch(DataAccessException e){
      return null;
    }
  }

/*   @GetMapping("/menumodulos/{id}")
  public ResponseEntity<?> show(@PathVariable("id")Short id){
    MenuModulos mMenuModule;
    
    Map<String, Object> response = new HashMap<>();
    
    try {
      mMenuModule = service.findById(id);
      if (mMenuModule == null) {
        response.put("mensaje", "El menu no existe");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
      }
    } catch (DataAccessException e) {
      response.put("mensaje", "Error al realizar la consulta");
      response.put("error", e.getMessage()+": "+(e.getMostSpecificCause().getMessage()));
      return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    return new ResponseEntity<>(mMenuModule, HttpStatus.OK);
  } */


}

