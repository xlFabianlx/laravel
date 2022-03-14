/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
@Table(name = "N_Novedad")

public class NNovedad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NNovedadPK nNovedadPK;
    @Basic(optional = false)
    @Column(name = "LIQTIPOCONCEPTO")
    private String liqtipoconcepto;
    @Basic(optional = false)
    @Column(name = "LIQCANTIDAD")
    private int liqcantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "LIQVALORCONCEPTO")
    private BigDecimal liqvalorconcepto;
    @Basic(optional = false)
    @Column(name = "LIQFECHAINI")
    @Temporal(TemporalType.DATE)
    private Date liqfechaini;
    @Basic(optional = false)
    @Column(name = "LIQFECHAFIN")
    @Temporal(TemporalType.DATE)
    private Date liqfechafin;
    @Basic(optional = false)
    @Column(name = "LIQDIASLIQUIDADOS")
    private int liqdiasliquidados;
    @Basic(optional = false)
    @Column(name = "LIQPERIODO")
    private int liqperiodo;
    @Basic(optional = false)
    @Column(name = "CODCARGO")
    private String codcargo;
    @Basic(optional = false)
    @Column(name = "CODDEPEN")
    private String coddepen;
    @Basic(optional = false)
    @Column(name = "CODENTIDAD")
    private String codentidad;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Basic(optional = false)
    @Column(name = "CONESTADO")
    private String conestado;
    @Basic(optional = false)
    @Column(name = "EMPTIPOHV")
    private String emptipohv;
    @Basic(optional = false)
    @Column(name = "CONCONSECUTIVOPRESTAMO")
    private String conconsecutivoprestamo;
    @Basic(optional = false)
    @Column(name = "LIQNUMPRESTAMO")
    private String liqnumprestamo;
    @Basic(optional = false)
    @Column(name = "LIQCUOTAS")
    private int liqcuotas;
    @Basic(optional = false)
    @Column(name = "LIQCUOTASP")
    private int liqcuotasp;

}
