package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.financiero.models.entity.CTrasladoBanc;
import com.apirest.financiero.models.entity.CTrasladoBancPK;

public interface ICTrasladoBancDao extends JpaRepository<CTrasladoBanc, CTrasladoBancPK> {
    
}