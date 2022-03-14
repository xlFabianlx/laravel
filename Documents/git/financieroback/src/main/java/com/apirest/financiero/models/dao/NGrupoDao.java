package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.financiero.models.entity.NGrupo;

public interface NGrupoDao extends JpaRepository<NGrupo, String>{
    
}
