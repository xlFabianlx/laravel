package com.apirest.financiero.models.services;

import java.util.List;

import com.apirest.financiero.models.dao.ICPucDao;
import com.apirest.financiero.models.entity.CPuc;
import com.apirest.financiero.models.entity.CPucPK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CPucService {

    @Autowired
    private ICPucDao iCPucDao;  

    public List<CPuc> findAll() {
        return iCPucDao.findAll();
    }

    public List<CPuc> findByCueCod() {
        return iCPucDao.findByCueCod();
    }

    public List<CPuc> findByFilter(String cuecod) {
        cuecod = cuecod + "%";
        Integer len = cuecod.length()+1;
        return iCPucDao.findByFilter(cuecod, len);
    }

    public List<CPuc> findPrincipal() {
        return iCPucDao.findPricipal();
    }

    public CPuc findByPK(CPucPK cPucPK) {
        return iCPucDao.findById(cPucPK).orElse(null);
    }

    public CPuc save(CPuc cPuc) {
        return iCPucDao.save(cPuc);
    }

    public Boolean findIfExist(String cuecod) {
        Boolean valid = false;

        // buscar si la cuenta existe 
        CPuc cPuc = iCPucDao.findIfExist(cuecod);

        if(cPuc == null) {
            CPuc cPucToFind = new CPuc();

            Integer longitud = cuecod.length();
    
            switch (longitud) {
                case 2:
                // nivel 2
                    cuecod = cuecod.replace(cuecod.substring(cuecod.length()-1), "");
                    break;
                
                case 4:
                // nivel 3
                    cuecod = cuecod.replace(cuecod.substring(cuecod.length()-2), "");
                    break;
    
                case 6:
                // nivel 4
                    cuecod = cuecod.replace(cuecod.substring(cuecod.length()-2), "");
                    break;
                default:
                    break;
            }
    
            char[] cadena = cuecod.toCharArray();
            String codigo = "";
            
            for(int x = 0; x<cadena.length; x++) {
                codigo = codigo + cadena[x];
                cPucToFind = iCPucDao.findIfExist(codigo);
    
                if(cPucToFind != null) {
                    valid = true;
                } else {
                    valid = false;
                }
            }
        } else { valid = false; }


      return valid;
    }
    
}