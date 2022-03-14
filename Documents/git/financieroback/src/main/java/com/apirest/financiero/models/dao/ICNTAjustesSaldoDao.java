package com.apirest.financiero.models.dao;

import java.util.List;

import com.apirest.financiero.models.entity.CCNTAjustesSaldo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICNTAjustesSaldoDao extends JpaRepository<CCNTAjustesSaldo, Long>{
    
    @Query(value = "select * from CNT_AjustesSaldo", nativeQuery = true)
    public List<CCNTAjustesSaldo> findAllAjustesSaldo();
}
