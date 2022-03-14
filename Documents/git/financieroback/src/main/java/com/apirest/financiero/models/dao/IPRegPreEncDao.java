package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.PRegPreEnc;
import com.apirest.financiero.models.entity.PRegPreEncPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPRegPreEncDao extends JpaRepository<PRegPreEnc, PRegPreEncPK> {
}
