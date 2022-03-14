package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.apirest.financiero.models.entity.CTipoCompContable;
import com.apirest.financiero.models.entity.CTipoCompContablePK;

public interface ICTipoCompContableDao extends JpaRepository<CTipoCompContable, CTipoCompContablePK> {

    @Query("SELECT d.cTipoCompContablePK.docCod from CTipoCompContable d where d.cTipoCompContablePK.docCod = (SELECT MAX (d.cTipoCompContablePK.docCod) from CTipoCompContable d)")
    public Long findTipo();

}
 
