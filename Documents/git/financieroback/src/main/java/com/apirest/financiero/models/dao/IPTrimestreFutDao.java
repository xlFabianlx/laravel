package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.PTrimestreFut;
import com.apirest.financiero.models.entity.PTrimestreFutPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPTrimestreFutDao extends JpaRepository<PTrimestreFut, PTrimestreFutPK> {
}
