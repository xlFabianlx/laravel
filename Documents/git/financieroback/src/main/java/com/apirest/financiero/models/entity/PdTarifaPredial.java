/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *
 * @author jonathan mendoza
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "PD_TARIFA_PREDIAL")

public class PdTarifaPredial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CODIGO_TARIFA")
    private String codigoTarifa;
    @Column(name = "CODIGO_ZONA")
    private String codigoZona;
    @Column(name = "CODIGO_DESTINO")
    private String codigoDestino;
    @Column(name = "CdgCnc")
    private String cdgCnc;
    @Column(name = "L_INI")
    private Integer lIni;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "L_FIN")
    private Double lFin;
    @Column(name = "PORCENTAJE")
    private Double porcentaje;

 
}
