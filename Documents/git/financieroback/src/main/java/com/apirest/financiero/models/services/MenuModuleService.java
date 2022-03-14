package com.apirest.financiero.models.services;

import java.util.List;
import com.apirest.financiero.models.entity.MenuModulos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apirest.financiero.models.dao.MenuModuleDao;

@Service
public class MenuModuleService {
    @Autowired
    private MenuModuleDao dao;

    public List<MenuModulos> listModulos(){
        return dao.listModulos();
    }

}
