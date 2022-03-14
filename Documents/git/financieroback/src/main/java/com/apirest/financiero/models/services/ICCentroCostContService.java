package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.CCentroCostoCont;
import java.util.List;

public interface ICCentroCostContService {

    public List<CCentroCostoCont> findAll();

    public CCentroCostoCont findById(Long id);

    public CCentroCostoCont save(CCentroCostoCont cCentroCostoCont);

    public void deleteById(Long id);

}
