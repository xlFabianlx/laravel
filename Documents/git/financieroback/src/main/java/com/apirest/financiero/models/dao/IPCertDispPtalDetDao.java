package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.PCertDispPtalDet;
import com.apirest.financiero.models.entity.PCertDispPtalDetPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPCertDispPtalDetDao extends JpaRepository<PCertDispPtalDet, PCertDispPtalDetPK> {
}
