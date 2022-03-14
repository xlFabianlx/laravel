package com.apirest.financiero.models.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.apirest.financiero.models.entity.Roles;

public interface IRoleDao extends CrudRepository<Roles, Long>{

    public Roles findByNombre(String nombre);

    public Optional<Roles> findById(Long id);
}
