package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.NPrestacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NPrestacionDao extends JpaRepository<NPrestacion, String>{
    
}
