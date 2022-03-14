package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.financiero.models.entity.CCuentaBancaria;
import com.apirest.financiero.models.entity.CCuentaBancariaPK;

public interface ICCuentaBancariaDao extends JpaRepository<CCuentaBancaria, CCuentaBancariaPK> {
    
}
