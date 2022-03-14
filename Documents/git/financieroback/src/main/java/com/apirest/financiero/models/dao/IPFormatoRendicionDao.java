package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.PFormatoRendicion;
import com.apirest.financiero.models.entity.PFormatoRendicionPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPFormatoRendicionDao extends JpaRepository<PFormatoRendicion, PFormatoRendicionPK> {
}
