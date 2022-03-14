package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.PModPtalDet;
import com.apirest.financiero.models.entity.PModPtalDetPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPModPtalDetDao extends JpaRepository<PModPtalDet, PModPtalDetPK> {
}
