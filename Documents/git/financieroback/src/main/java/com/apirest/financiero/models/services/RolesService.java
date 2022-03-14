package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.RolesDao;
import com.apirest.financiero.models.entity.Roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RolesService {
    @Autowired
    private RolesDao rolesDao;

    
    public List<Roles> findAll(){
    return rolesDao.findAll();
    }

    
    public Roles findById(Short id){
        return rolesDao.findById(id).orElse(null);
    }

}
