package com.apirest.financiero.models.dao;

import java.util.List;
import com.apirest.financiero.models.entity.CCNTSaldoInicial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICNTSaldoInicialDao extends JpaRepository<CCNTSaldoInicial, Long> {
    @Query(value = "select * from CNT_SaldoInicial", nativeQuery = true)
    public List<CCNTSaldoInicial> findAllSaldo();
}
