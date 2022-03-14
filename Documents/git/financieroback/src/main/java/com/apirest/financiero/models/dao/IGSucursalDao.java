package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.GSucursal;
import com.apirest.financiero.models.entity.GSucursalPK;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IGSucursalDao extends JpaRepository<GSucursal, GSucursalPK>{
    
}