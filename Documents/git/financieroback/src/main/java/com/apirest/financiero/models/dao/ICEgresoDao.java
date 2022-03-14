package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.financiero.models.entity.CEgreso;
import com.apirest.financiero.models.entity.CEgresoPK;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICEgresoDao extends JpaRepository<CEgreso, CEgresoPK> {

    @Query(value="SELECT * FROM C_Egreso where EgrCod = :egrCod", nativeQuery = true)
    public CEgreso findByEgrCod(@Param("egrCod") Integer egrCod);

}