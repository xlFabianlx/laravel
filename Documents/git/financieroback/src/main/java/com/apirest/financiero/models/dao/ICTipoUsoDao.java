package com.apirest.financiero.models.dao;

import java.util.List;

import com.apirest.financiero.models.entity.CTipoUso;
import com.apirest.financiero.models.entity.CTipoUsoPK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ICTipoUsoDao extends JpaRepository< CTipoUso , CTipoUsoPK  > {

    @Query(value="SELECT * FROM C_TipoUso" , nativeQuery = true)
    public List<CTipoUso> findByIdTip(@Param("IdTip") Short IdTip);
    
}