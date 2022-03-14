package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.PFuenteFut;
import com.apirest.financiero.models.entity.PFuenteFutPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPFuenteFutDao extends JpaRepository<PFuenteFut, PFuenteFutPK> {
}
