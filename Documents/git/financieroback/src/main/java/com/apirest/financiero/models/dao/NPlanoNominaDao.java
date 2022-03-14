package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.NPlanoNomina;
import com.apirest.financiero.models.entity.NPlanoNominaPK;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NPlanoNominaDao extends JpaRepository<NPlanoNomina, NPlanoNominaPK>{
    
}
