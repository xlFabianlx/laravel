package com.apirest.financiero.models.dao;

import java.util.List;

import com.apirest.financiero.models.entity.PgCdp;
import com.apirest.financiero.models.entity.PgCdpPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface PGCDPDao extends JpaRepository<PgCdp, PgCdpPK> {
    @Query(value="SELECT ISNULL((SELECT TOP (1) ([CdpCod] + 1) FROM [PG_CDP] " + 
    "where AnoCod = :AnoCod order by [CdpCod] desc), 0) AS CONSECUTIVO", nativeQuery = true)
    public Long getConsecutivo(@Param("AnoCod") short AnoCod); 

    @Query("SELECT g FROM PgCdp g ORDER BY g.pgCdpPK.anoCod desc")
    public List<PgCdp> findAllDesc();
}
