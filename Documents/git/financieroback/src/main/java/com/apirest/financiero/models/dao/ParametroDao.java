package com.apirest.financiero.models.dao;

import java.util.List;
import com.apirest.financiero.models.entity.Parametro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ParametroDao extends CrudRepository<Parametro, Integer>{
    
    @Query("select p from Parametro p")
    public List<Parametro> findAllParametro();

    @Query("select p from Parametro p where idParametro = :idParametro")
    public Parametro findParametroId(@Param("idParametro") Integer idParametro);

    @Query("select p from Parametro p where p.fkGrupo.idGrupo = 1")
    public Parametro findByIdFkGrupo();

    @Query("select p from Parametro p where p.fkGrupo.idGrupo = 2")
    public List<Parametro> findByIdFkGrupo2();

}
