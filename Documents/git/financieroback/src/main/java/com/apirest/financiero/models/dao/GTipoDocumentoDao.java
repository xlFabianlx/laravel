package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.apirest.financiero.models.entity.GTipoDocumento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GTipoDocumentoDao extends JpaRepository<GTipoDocumento, Long>{
    @Query(value="SELECT * FROM G_TipoDocumento WHERE idDocumento = :idDocumento", nativeQuery = true)
    public GTipoDocumento findByidDocumento(@Param("idDocumento") Long idDocumento);
}








