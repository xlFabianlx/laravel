package com.apirest.financiero.models.dao;

import java.util.List;

import com.apirest.financiero.models.entity.MenuModulos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MenuModuleDao extends CrudRepository<MenuModulos, Long> {

    @Query(value="SELECT * from menu_modulos",nativeQuery = true)
    public List<MenuModulos> listModulos();
    
}
