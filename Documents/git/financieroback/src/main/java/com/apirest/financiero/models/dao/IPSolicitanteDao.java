package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.PSolicitante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPSolicitanteDao extends JpaRepository<PSolicitante, String> {
}
