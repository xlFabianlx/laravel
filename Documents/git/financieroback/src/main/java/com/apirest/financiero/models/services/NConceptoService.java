package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.NConceptoDao;
import com.apirest.financiero.models.entity.NConcepto;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NConceptoService implements INConceptoService{
    
    
    @Autowired
    private NConceptoDao conceptoDao;

    @Override
    public List<NConcepto> findAll() {
        return conceptoDao.findAll();
    }

    @Override
    public NConcepto findById(Short id) {
        return conceptoDao.findById(id).orElse(null);
    }

    @Override
    public NConcepto save(NConcepto concepto) {
        return conceptoDao.save(concepto);
    }

    @Override
    public void deleteById(Short id) {
        conceptoDao.deleteById(id);
    }


    
}
