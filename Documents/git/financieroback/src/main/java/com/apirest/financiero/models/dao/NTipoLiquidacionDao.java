package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.NTipoLiquidacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NTipoLiquidacionDao extends JpaRepository<NTipoLiquidacion, Short>{
    
}
