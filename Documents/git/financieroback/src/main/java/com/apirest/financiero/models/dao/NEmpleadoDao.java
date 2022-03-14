package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.NEmpleado;
import com.apirest.financiero.models.entity.NEmpleadoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NEmpleadoDao extends JpaRepository<NEmpleado, NEmpleadoPK>{
    
}
