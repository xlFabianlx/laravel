package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.PModIPtalngDet;
import com.apirest.financiero.models.entity.PModIPtalngDetPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPModIPtalngDetDao extends JpaRepository<PModIPtalngDet, PModIPtalngDetPK> {
}
