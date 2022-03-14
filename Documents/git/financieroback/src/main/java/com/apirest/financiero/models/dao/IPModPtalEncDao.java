package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.PModPtalEnc;
import com.apirest.financiero.models.entity.PModPtalEncPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPModPtalEncDao extends JpaRepository<PModPtalEnc, PModPtalEncPK> {
}
