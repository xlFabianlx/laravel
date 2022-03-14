package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.NProyecto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NProyectoDao extends JpaRepository<NProyecto, Short>{
    
}
