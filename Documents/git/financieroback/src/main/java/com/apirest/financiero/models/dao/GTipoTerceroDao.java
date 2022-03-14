package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.financiero.models.entity.GTipoTercero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GTipoTerceroDao extends JpaRepository<GTipoTercero, Long>{
    @Query(value="SELECT * FROM G_TipoTercero WHERE idPersona = :idPersona", nativeQuery = true)
    public GTipoTercero findByidPersona(@Param("idPersona") Long idPersona);
}
