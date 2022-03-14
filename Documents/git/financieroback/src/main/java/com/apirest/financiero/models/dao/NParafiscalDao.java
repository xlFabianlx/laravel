package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.NParafiscales;
import com.apirest.financiero.models.entity.NParafiscalesPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author YAMID
 */
public interface NParafiscalDao extends JpaRepository<NParafiscales, NParafiscalesPK>{
    
}
