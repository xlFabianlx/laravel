package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.financiero.models.entity.GBanco;
import com.apirest.financiero.models.entity.GBancoPK;



public interface IGBancoDao extends JpaRepository<GBanco, GBancoPK> {


}