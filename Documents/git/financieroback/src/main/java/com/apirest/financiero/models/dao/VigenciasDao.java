package com.apirest.financiero.models.dao;

import java.util.List;
import com.apirest.financiero.models.entity.Vigencias;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface VigenciasDao extends CrudRepository<Vigencias, Long>{
    
    @Query("SELECT v.vigencia FROM Vigencias v ORDER BY v.vigencia DESC")
    public List<Short> getVigencias();
}
