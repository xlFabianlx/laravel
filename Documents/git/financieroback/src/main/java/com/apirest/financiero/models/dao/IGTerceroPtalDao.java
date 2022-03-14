package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.GTerceroPtal;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IGTerceroPtalDao extends JpaRepository<GTerceroPtal, Long>{

    @Query(value="SELECT * FROM G_TerceroPtal WHERE TerCod = :terCod", nativeQuery = true)
    public GTerceroPtal findByTerCod(@Param("terCod") Long terCod);
    
}