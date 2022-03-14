package com.apirest.financiero.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.apirest.financiero.models.entity.Grupos;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface GruposDao extends CrudRepository<Grupos, Long> {
    
    @Query("select g from Grupos g")
    public List<Grupos> findAllGrupos();
}
