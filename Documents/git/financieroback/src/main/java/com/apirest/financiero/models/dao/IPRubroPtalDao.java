package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.PRubroPtal;
import com.apirest.financiero.models.entity.PRubroPtalPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPRubroPtalDao extends JpaRepository<PRubroPtal, PRubroPtalPK> {

    @Query("SELECT RP FROM PRubroPtal RP, PFuenteFinanciacion FF WHERE RP.ctaSIHO = FF.fueCod")
    List<PRubroPtal> findAllRubrosConFuente();

}
