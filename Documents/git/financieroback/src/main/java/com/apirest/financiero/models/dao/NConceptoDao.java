package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.NConcepto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NConceptoDao extends JpaRepository<NConcepto, Short>{
    
}
