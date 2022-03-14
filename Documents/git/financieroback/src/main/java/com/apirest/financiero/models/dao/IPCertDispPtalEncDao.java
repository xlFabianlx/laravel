package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.PCertDispPtalEnc;
import com.apirest.financiero.models.entity.PCertDispPtalEncPK;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IPCertDispPtalEncDao extends JpaRepository<PCertDispPtalEnc, PCertDispPtalEncPK> {
}
