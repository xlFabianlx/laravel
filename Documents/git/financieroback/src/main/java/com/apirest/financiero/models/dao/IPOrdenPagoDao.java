package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.POrdenPago;
import com.apirest.financiero.models.entity.POrdenPagoPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPOrdenPagoDao extends JpaRepository<POrdenPago, POrdenPagoPK> {

    @Query("SELECT op FROM POrdenPago op WHERE op.pagSal = 0")
    List<POrdenPago> finOrdenesPagoWithoutEgreso();
}
