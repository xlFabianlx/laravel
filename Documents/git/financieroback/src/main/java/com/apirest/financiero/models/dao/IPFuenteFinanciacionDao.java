package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.PFuenteFinanciacion;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IPFuenteFinanciacionDao extends JpaRepository<PFuenteFinanciacion, Short> {
}
