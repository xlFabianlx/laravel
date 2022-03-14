package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.financiero.models.entity.CCuentaEquivalente;
import com.apirest.financiero.models.entity.CCuentaEquivalentePK;

public interface ICCuentaEquivalenteDao extends JpaRepository<CCuentaEquivalente, CCuentaEquivalentePK> {
    
}