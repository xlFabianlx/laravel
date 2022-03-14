package com.apirest.financiero.models.dao;



import com.apirest.financiero.models.entity.GDependencia;
import com.apirest.financiero.models.entity.GDependenciaPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IGDependenciaDao extends JpaRepository<GDependencia, GDependenciaPK>{

    @Query("SELECT d.gDependenciaPK.depCod from GDependencia d where d.gDependenciaPK.depCod = (SELECT MAX (d.gDependenciaPK.depCod) from GDependencia d)")
    public Long findConsecutivo();

    

}