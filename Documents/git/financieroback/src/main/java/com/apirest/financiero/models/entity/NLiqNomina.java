/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;


import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

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
@Table(name = "N_LiqNomina")

public class NLiqNomina implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NLiqNominaPK nLiqNominaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VALORCONCEPTO")
    private BigDecimal valorconcepto;
    @Basic(optional = false)
    @Column(name = "DIASTRABAJADOS")
    private int diastrabajados;
    @Basic(optional = false)
    @Column(name = "CODDEPEN")
    private String coddepen;
    @Basic(optional = false)
    @Column(name = "CODENTIDAD")
    private String codentidad;
    @Basic(optional = false)
    @Column(name = "CODCARGO")
    private String codcargo;
    @Basic(optional = false)
    @Column(name = "TIPOCONCEPTO")
    private String tipoconcepto;
    @Basic(optional = false)
    @Column(name = "FECHAPAGO")
    private String fechapago;
    @Basic(optional = false)
    @Column(name = "CONSECUTIVOPRESTAMO")
    private String consecutivoprestamo;
    @Basic(optional = false)
    @Column(name = "TIPOLIQUIDACION")
    private String tipoliquidacion;

 
}
