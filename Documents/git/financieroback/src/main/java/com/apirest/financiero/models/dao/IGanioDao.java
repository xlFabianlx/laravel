package com.apirest.financiero.models.dao;
import com.apirest.financiero.models.entity.Ganio;
import com.apirest.financiero.models.entity.GanioPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IGanioDao extends JpaRepository<Ganio, GanioPK>{

}