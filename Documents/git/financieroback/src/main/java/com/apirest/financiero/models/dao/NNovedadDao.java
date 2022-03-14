package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.NNovedad;
import com.apirest.financiero.models.entity.NNovedadPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NNovedadDao extends JpaRepository<NNovedad, NNovedadPK>{
    
}
