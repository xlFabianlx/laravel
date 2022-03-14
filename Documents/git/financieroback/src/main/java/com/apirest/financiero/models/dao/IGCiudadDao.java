package com.apirest.financiero.models.dao;

import java.util.List;

import com.apirest.financiero.models.entity.GCiudad;
import com.apirest.financiero.models.entity.GCiudadPK;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IGCiudadDao extends JpaRepository<GCiudad, GCiudadPK > {

    @Query(value="SELECT DptCod ,CiuCod ,CiuNom FROM G_Ciudad WHERE DptCod = :DptCod", nativeQuery = true)
    public List<GCiudad> findByDptCod(@Param("DptCod") Short DptCod);
    
}