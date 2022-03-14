package com.apirest.financiero.models.dao;

import java.util.List;

import com.apirest.financiero.models.entity.CNTComprobantes;
import com.apirest.financiero.models.entity.CNTComprobantesPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICNTComprobantesDao extends JpaRepository<CNTComprobantes,CNTComprobantesPK>{
    
    @Query("Select p from CNTComprobantes p")
    public List<CNTComprobantes> findAllComprobantes();

    @Query("SELECT c.cNTComprobantesPK.compCod from CNTComprobantes c where c.cNTComprobantesPK.compCod  = (SELECT MAX (c.cNTComprobantesPK.compCod ) from CNTComprobantes c)")
    public Long findConsecutivo();

    @Query("SELECT p from CNTComprobantes p where p.cNTComprobantesPK.compCod = :compCod")
    public CNTComprobantes findComprobantesId(@Param("compCod") Long compCod);

    @Query("SELECT g from CNTComprobantes g where g.cNTComprobantesPK.compCod = :compCod")
    public List<CNTComprobantesPK>findByComprobantes(@Param("compCod") Long compCod);

}
