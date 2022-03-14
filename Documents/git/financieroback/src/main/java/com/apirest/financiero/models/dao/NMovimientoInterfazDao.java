package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.NMovimientoInterfaz;
import com.apirest.financiero.models.entity.NMovimientoInterfazPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NMovimientoInterfazDao extends JpaRepository<NMovimientoInterfaz, NMovimientoInterfazPK>{
    
}
