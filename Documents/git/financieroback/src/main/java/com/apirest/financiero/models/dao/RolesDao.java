package com.apirest.financiero.models.dao;

import com.apirest.financiero.models.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesDao extends JpaRepository<Roles, Short>{
    
}
