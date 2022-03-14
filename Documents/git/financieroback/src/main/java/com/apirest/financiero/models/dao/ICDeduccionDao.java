package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Map;

import com.apirest.financiero.models.entity.CDeduccion;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICDeduccionDao extends JpaRepository<CDeduccion, Short> {

    @Query("SELECT d FROM CDeduccion d WHERE d.dedCod = :dedCod")
    public CDeduccion findByDedCod(@Param("dedCod") Short dedCod);

    @Override
    @Query("SELECT d FROM CDeduccion d order by d.dedDes")
    public List<CDeduccion> findAll();

    @Query(value="SELECT d.DedCod as dedCod, d.DedDes as dedDes,  d.DedTip as dedTip, d.DedVlr as dedVlr, d.DedPor as dedPor, d.ConceptoCod as conceptoCod, d.TerDdCod as terDdCod, d.DedCls as dedCls, d.CueCapE as cueCapE, d.CueCapC as cueCapC, d.CueCapDed as cueCapDed, " + 
    "(SELECT COUNT(*) from G_DeduccionesTercero as dt WHERE dt.idDeduccion = d.DedCod and dt.idTercero = :terCod) as activo " + 
    "from C_Deduccion as d ORDER BY dedDes", nativeQuery = true)
    public List<Map<String, ?>> getDeduccionesTercerosActivos(@Param("terCod") Long terCod);

}