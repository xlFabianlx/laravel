package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.GSiaCompromiso;
import com.apirest.financiero.models.entity.GSiaCompromisoPK;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IGSiaCompromisoDao extends JpaRepository<GSiaCompromiso, GSiaCompromisoPK>{
    
}
