package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apirest.financiero.models.entity.GRegimen;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GRegimenDao extends JpaRepository<GRegimen, Long>{
    @Query(value="SELECT * FROM G_Regimen WHERE id = :id", nativeQuery = true)
    public GRegimen findByid(@Param("id") Long id);
}
