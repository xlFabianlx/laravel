package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.ICCentroCostContDao;
import com.apirest.financiero.models.entity.CCentroCostoCont;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CCentroCostContService implements ICCentroCostContService {

    @Autowired
    private ICCentroCostContDao icCentroCostContDao ;

    @Override
    public List<CCentroCostoCont> findAll() {
        return icCentroCostContDao.findAll();
    }

    @Override
    public CCentroCostoCont findById(Long id) {
        return icCentroCostContDao.findById(id).orElse(null);
    }

    @Override
    public CCentroCostoCont save(CCentroCostoCont cCentroCostoCont) {
        return icCentroCostContDao.save(cCentroCostoCont);
    }

    @Override
    public void deleteById(Long id) {
        icCentroCostContDao.deleteById(id);
    }


}
