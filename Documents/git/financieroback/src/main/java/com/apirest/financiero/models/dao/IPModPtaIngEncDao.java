package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.PModPtaIngEnc;
import com.apirest.financiero.models.entity.PModPtaIngEncPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPModPtaIngEncDao extends JpaRepository<PModPtaIngEnc, PModPtaIngEncPK> {
}
