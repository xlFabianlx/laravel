package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPptoIngDao;
import com.apirest.financiero.models.entity.PptoIng;
import com.apirest.financiero.models.entity.PptoIngPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PptoIngService implements IPptoIngService {
    @Autowired
    private IPptoIngDao iPptoIngDao;

    @Override
    public List<PptoIng> findAll() {
        return iPptoIngDao.findAll();
    }

    @Override
    public PptoIng findById(PptoIngPK pptoIngPK) {
        return iPptoIngDao.findById(pptoIngPK).orElse(null);
    }

    @Override
    public PptoIng save(PptoIng pptoIng) {
        return iPptoIngDao.save(pptoIng);
    }

    @Override
    public void deleteById(PptoIngPK pptoIngPK) {
        iPptoIngDao.deleteById(pptoIngPK);
    }
}
