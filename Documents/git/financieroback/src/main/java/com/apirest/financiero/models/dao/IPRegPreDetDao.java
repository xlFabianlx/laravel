package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.PRegPreDet;
import com.apirest.financiero.models.entity.PRegPreDetPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPRegPreDetDao extends JpaRepository<PRegPreDet, PRegPreDetPK> {
}
