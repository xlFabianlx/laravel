package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.NLiqNomina;
import com.apirest.financiero.models.entity.NLiqNominaPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NLiqNominaDao extends JpaRepository<NLiqNomina, NLiqNominaPK>{
    
}
