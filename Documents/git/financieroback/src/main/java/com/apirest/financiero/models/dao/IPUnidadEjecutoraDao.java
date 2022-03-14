package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.Punidadejecutora;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPUnidadEjecutoraDao extends JpaRepository<Punidadejecutora, Short> {
}
