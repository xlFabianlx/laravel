package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.financiero.models.entity.CPerContable;
import com.apirest.financiero.models.entity.CPerContablePK;

public interface ICPerContableDao extends JpaRepository<CPerContable, CPerContablePK> {
    
}