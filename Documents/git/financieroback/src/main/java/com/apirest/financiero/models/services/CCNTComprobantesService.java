package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICNTComprobantesDao;
import com.apirest.financiero.models.entity.CNTComprobantes;
import com.apirest.financiero.models.entity.CNTComprobantesPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CCNTComprobantesService {
    @Autowired
    private ICNTComprobantesDao iCNTComprobantesDao;
 
    public List<CNTComprobantes> findAll(){
        return iCNTComprobantesDao.findAll();
    }

    public Long findConsecutivo(){
		return iCNTComprobantesDao.findConsecutivo();
	}
    
    public CNTComprobantes findById(CNTComprobantesPK cNTComprobantesPK){
        return iCNTComprobantesDao.findById(cNTComprobantesPK).orElse(null);
    }

    public CNTComprobantes findComprobantesId(Long compCod){
		return iCNTComprobantesDao.findComprobantesId(compCod);
	}

    public CNTComprobantes save(CNTComprobantes cNTComprobantes){
        return iCNTComprobantesDao.save(cNTComprobantes);
    }

    public List<CNTComprobantes> findAllComprobantes(){
		return iCNTComprobantesDao.findAllComprobantes();
	}

    public List<CNTComprobantesPK> findByComprobantes(Long compCod){
        return iCNTComprobantesDao.findByComprobantes(compCod);
    }
}
