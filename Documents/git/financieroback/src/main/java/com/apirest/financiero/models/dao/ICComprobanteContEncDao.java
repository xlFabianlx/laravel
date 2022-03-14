package com.apirest.financiero.models.dao;

import java.util.List;

import com.apirest.financiero.models.entity.CComprobanteContEnc;
import com.apirest.financiero.models.entity.CComprobanteContEncPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICComprobanteContEncDao extends JpaRepository<CComprobanteContEnc, CComprobanteContEncPK>{
    @Query(value="Select * from C_ComprobanteContEnc", nativeQuery = true)
    public List<CComprobanteContEnc> findAll();

    
} 