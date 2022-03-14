package com.apirest.financiero.models.dao;

import java.util.List;

import com.apirest.financiero.models.entity.PGSolicitudCDP;
import com.apirest.financiero.models.entity.PGSolicitudCDPPK;

import org.json.simple.JSONObject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface IPSolicitudCdpDao extends JpaRepository<PGSolicitudCDP, PGSolicitudCDPPK> {
    @Query(value="SELECT ISNULL((SELECT TOP (1) ([ScdpCod] + 1) FROM [PG_SolicitudCDP] " + 
    "where AnoCod = :AnoCod order by [ScdpCod] desc), 0) AS CONSECUTIVO", nativeQuery = true)
    public Long getConsecutivo(@Param("AnoCod") short AnoCod); 

    @Query("SELECT g FROM PGSolicitudCDP g ORDER BY g.pGSolicitudCDPPK.anoCod desc")
    public List<PGSolicitudCDP> findAllDesc();

    @Query(value="SELECT ScdpVlr, ScdpVlrTtl, ScdpVlrLib, ScdpVlrSaldo from PG_SolicitudCDP "+
    "where anoCod = :anoCod and scdpCod = :scdpCod",nativeQuery = true)
    public List<JSONObject> findValores(@Param("anoCod") short anoCod, @Param("scdpCod") long scdpCod);

    @Query(value="SELECT * from [PG_SolicitudCDP]" + "where [anoCod] = :anoCod AND [scdpCod] = :scdpCod", nativeQuery = true)
    public List<PGSolicitudCDP> findByAnoCod(@Param("anoCod") short anoCod, @Param("scdpCod") long scdpCod);
}
