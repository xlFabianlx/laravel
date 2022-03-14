package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.financiero.models.entity.CEgresoDeduccion;
import com.apirest.financiero.models.entity.CEgresoDeduccionPK;

public interface ICEgresoDeduccionDao extends JpaRepository<CEgresoDeduccion, CEgresoDeduccionPK> {

    
}