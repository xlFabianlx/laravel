package com.apirest.financiero.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;


import com.apirest.financiero.models.services.VigenciasService;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/auth")
public class WithOutTokenController implements Serializable {

    @Autowired
    VigenciasService vigenciasService;

    @GetMapping("/vigencias/list")
    public List<Short> getListVigencias() {
        return vigenciasService.getVigencias();
    }
}