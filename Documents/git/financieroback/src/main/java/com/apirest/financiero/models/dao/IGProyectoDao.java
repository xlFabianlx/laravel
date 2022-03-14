package com.apirest.financiero.models.dao;

import java.util.List;

import com.apirest.financiero.models.entity.GProyecto;
import com.apirest.financiero.models.entity.GProyectoPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IGProyectoDao extends JpaRepository<GProyecto, GProyectoPK>{

    @Query("Select p from GProyecto p")
    public List<GProyecto> findAllProyecto();

    @Query("SELECT c.gProyectoPK.proyCod from GProyecto c where c.gProyectoPK.proyCod = (SELECT MAX (c.gProyectoPK.proyCod) from GProyecto c)")
    public Long findConsecutivo();

    @Query("SELECT p from GProyecto p where p.gProyectoPK.proyCod = :proyCod")
    public GProyecto findProyectoId(@Param("proyCod") Long proyCod);
}