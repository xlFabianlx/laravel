package com.apirest.financiero.models.services;

import com.apirest.financiero.models.dao.IPUnidadEjecutoraDao;
import com.apirest.financiero.models.entity.Punidadejecutora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PUnidadEjecutoraService implements IPUnidadEjecutoraService{
    @Autowired
    private IPUnidadEjecutoraDao iPUnidadEjecutoraDao;

    @Override
    public List<Punidadejecutora> findAll() {
        return iPUnidadEjecutoraDao.findAll();
    }

    @Override
    public Punidadejecutora findById(Short UniEje) {
        return iPUnidadEjecutoraDao.findById(UniEje).orElse(null);
    }

    @Override
    public Punidadejecutora save(Punidadejecutora punidadejecutora) {
        return iPUnidadEjecutoraDao.save(punidadejecutora);
    }

    @Override
    public void deleteById(Short UniEje) {
        iPUnidadEjecutoraDao.deleteById(UniEje);
    }
}
