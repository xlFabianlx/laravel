package com.apirest.financiero.models.services;

import com.apirest.financiero.models.entity.PTrimestreFut;
import com.apirest.financiero.models.entity.PTrimestreFutPK;


import java.util.List;


public interface IPTrimestreFutService{
    List<PTrimestreFut> findAll();

    PTrimestreFut findById(PTrimestreFutPK pTrimestreFutPK);

    PTrimestreFut save(PTrimestreFut pTrimestreFut);

    void deleteById(PTrimestreFutPK pTrimestreFutPK);
}
