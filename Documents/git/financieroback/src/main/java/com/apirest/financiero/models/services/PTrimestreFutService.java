package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPTrimestreFutDao;
import com.apirest.financiero.models.entity.PTrimestreFut;
import com.apirest.financiero.models.entity.PTrimestreFutPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PTrimestreFutService implements IPTrimestreFutService{
    @Autowired
    private IPTrimestreFutDao iPTrimestreFutDao;

    @Override
    public List<PTrimestreFut> findAll() {
        return iPTrimestreFutDao.findAll();
    }

    @Override
    public PTrimestreFut findById(PTrimestreFutPK pTrimestreFutPK) {
        return iPTrimestreFutDao.findById(pTrimestreFutPK).orElse(null);
    }

    @Override
    public PTrimestreFut save(PTrimestreFut pTrimestreFut) {
        return iPTrimestreFutDao.save(pTrimestreFut);
    }

    @Override
    public void deleteById(PTrimestreFutPK pTrimestreFutPK) {
        iPTrimestreFutDao.deleteById(pTrimestreFutPK);
    }
}
