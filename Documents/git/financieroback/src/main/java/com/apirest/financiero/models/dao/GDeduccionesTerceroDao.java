package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

import com.apirest.financiero.models.entity.GDeduccionesTercero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GDeduccionesTerceroDao extends JpaRepository<GDeduccionesTercero, Long>{
    
    @Query("SELECT g FROM GDeduccionesTercero g WHERE g.idTercero.terCod = :TerCod")
    public List<GDeduccionesTercero> findByTercero(@Param("TerCod") Long TerCod);

    @Modifying
    @Query("delete from GDeduccionesTercero g where g.idTercero.terCod = :terCod")
    public void deleteIdTercero(@Param("terCod") Long terCod);
    
}