package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPRegPreEncDao;
import com.apirest.financiero.models.entity.PRegPreEnc;
import com.apirest.financiero.models.entity.PRegPreEncPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PRegPreEncService implements IPRegPreEncService {
    @Autowired
    private IPRegPreEncDao iPRegPreEncDao;

    @Override
    public List<PRegPreEnc> findAll() {
        return iPRegPreEncDao.findAll();
    }

    @Override
    public PRegPreEnc findById(PRegPreEncPK pRegPreEncPK) {
        return iPRegPreEncDao.findById(pRegPreEncPK).orElse(null);
    }

    @Override
    public PRegPreEnc save(PRegPreEnc pRegPreEnc) {
        return iPRegPreEncDao.save(pRegPreEnc);
    }

    @Override
    public void deleteById(PRegPreEncPK pRegPreEncPK) {
        iPRegPreEncDao.deleteById(pRegPreEncPK);
    }
}
