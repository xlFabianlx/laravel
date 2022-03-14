package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICTipoUsoDao;
import com.apirest.financiero.models.entity.CTipoUso;
import com.apirest.financiero.models.entity.CTipoUsoPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CTipoUsoService {
    @Autowired
    private ICTipoUsoDao iCTipoUsoDao;

    public List<CTipoUso> findAll(){
        return iCTipoUsoDao.findAll();
    }

    public List<CTipoUso> findByIdTip(Short IdTip){
        return iCTipoUsoDao.findByIdTip(IdTip);
    }

    public CTipoUso findById(CTipoUsoPK cTipoUsoPK){
        return iCTipoUsoDao.findById(cTipoUsoPK).orElse(null);
    }

    public CTipoUso save(CTipoUso cTipoUso){
        return iCTipoUsoDao.save(cTipoUso);
    }
}
