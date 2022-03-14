package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.POrdenadorGasto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IPOrdenadorGastoDao extends JpaRepository<POrdenadorGasto, String> {
}
