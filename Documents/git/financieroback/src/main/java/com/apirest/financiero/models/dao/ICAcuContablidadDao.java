package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.financiero.models.entity.CAcuContablidad;
import com.apirest.financiero.models.entity.CAcuContablidadPK;

public interface ICAcuContablidadDao extends JpaRepository<CAcuContablidad, CAcuContablidadPK> {
    
}