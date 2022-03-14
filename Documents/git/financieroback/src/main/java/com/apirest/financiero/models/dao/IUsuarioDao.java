package com.apirest.financiero.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.apirest.financiero.models.entity.Usuarios;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUsuarioDao extends CrudRepository<Usuarios, Long> {

    public Usuarios findByUsername(String username);
    
    @Query("select u from Usuarios u")
    public List<Usuarios> findAllUsers();

	@Query("select u from Usuarios u where u.id= :id")
	public Usuarios findByUsernameId(Long id);

	@Query(value = "SELECT COUNT(*) FROM Usuarios where enabled = :estado", nativeQuery = true)
	public long countByEstado(@Param("estado") Integer estado);

    @Query(value = "select * from usuarios where fk_ma_entidad=:idEntidad", nativeQuery = true)
    public List<Usuarios> findByIdEntidad(@Param("idEntidad") Integer idEntidad);

    @Query("select count(u) from Usuarios u where u.username = :username")
	public long countUsersByName(@Param("username") String username);

	@Query("select count(u) from Usuarios u where u.documento = :documento")
	public long countUsersByDoc(@Param("documento") String documento);

	@Query("select count(u) from Usuarios u where u.email = :email")
	public long countUsersByEmail(@Param("email") String email);
}
