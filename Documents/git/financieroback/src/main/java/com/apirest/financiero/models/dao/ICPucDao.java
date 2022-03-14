package com.apirest.financiero.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.apirest.financiero.models.entity.CPuc;
import com.apirest.financiero.models.entity.CPucPK;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICPucDao extends JpaRepository<CPuc, CPucPK> {

    @Query(value="SELECT * FROM C_Puc ORDER BY CueCod", nativeQuery = true)
    public List<CPuc> findByCueCod();

    @Query(value="SELECT * FROM C_Puc where CueCod < 10 ORDER BY CueCod", nativeQuery = true)
    public List<CPuc> findPricipal();

    @Query(value="SELECT * FROM C_Puc WHERE CueCod LIKE :cuecod AND LEN(CueCod) <= :len ORDER BY CueCod", nativeQuery = true)
    public List<CPuc> findByFilter(@Param("cuecod") String cuecod, @Param("len") Integer len);

    @Query(value="SELECT * FROM C_Puc where CueCod = :cuecod", nativeQuery = true)
    public CPuc findIfExist(@Param("cuecod") String cuecod);

} 