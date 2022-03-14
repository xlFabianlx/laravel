package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.PRendicion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPRendicionDao extends JpaRepository<PRendicion, Short> {
}
