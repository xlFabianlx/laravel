package com.apirest.financiero.models.services;

import java.util.List;



import com.apirest.financiero.models.entity.Parametro;
import com.apirest.financiero.models.dao.ParametroDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ParametroService {

    @Autowired
    private ParametroDao parametroDao;

    public List<Parametro> findAllParametro(){
        return parametroDao.findAllParametro();
    }

    public Parametro saveParametro(Parametro parametro) {
        return parametroDao.save(parametro);
    }

    public Parametro findParametroId(Integer idParametro){
        return parametroDao.findParametroId(idParametro);
    }

    public Parametro findByIdFkGrupo(){
        return parametroDao.findByIdFkGrupo();
    }

    public List<Parametro> findByIdFkGrupo2(){
        return parametroDao.findByIdFkGrupo2();
    }

    public void delete(Integer id){
        parametroDao.deleteById(id);
    }


}
