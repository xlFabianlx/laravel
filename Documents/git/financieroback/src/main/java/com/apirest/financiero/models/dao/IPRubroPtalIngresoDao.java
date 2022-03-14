package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.PRubroPtalIngreso;
import com.apirest.financiero.models.entity.PRubroPtalIngresoPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPRubroPtalIngresoDao extends JpaRepository<PRubroPtalIngreso, PRubroPtalIngresoPK> {
}
