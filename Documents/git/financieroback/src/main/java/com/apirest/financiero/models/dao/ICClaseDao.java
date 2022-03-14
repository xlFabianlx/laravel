package com.apirest.financiero.models.dao;

import java.util.List;

import com.apirest.financiero.models.entity.CClase;
import com.apirest.financiero.models.entity.CClasePK;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ICClaseDao extends JpaRepository< CClase , CClasePK  > {

    @Query(value="SELECT * FROM C_Clase" , nativeQuery = true)
    public List<CClase> findByIdcla(@Param("Idcla") Short Idcla);
    
}