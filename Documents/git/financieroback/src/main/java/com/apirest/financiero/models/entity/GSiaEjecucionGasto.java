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
@Table(name = "G_SiaEjecucionGasto")

public class GSiaEjecucionGasto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GSiaEjecucionGastoPK gSiaEjecucionGastoPK;
    @Basic(optional = false)
    @Column(name = "SiaEjeCtaCod")
    private String siaEjeCtaCod;
    @Basic(optional = false)
    @Column(name = "SiaEjeCtaDes")
    private String siaEjeCtaDes;
    @Basic(optional = false)
    @Column(name = "SiaEjeProgCod")
    private int siaEjeProgCod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SiaEjeDetVlr")
    private BigDecimal siaEjeDetVlr;
    @Basic(optional = false)
    @Column(name = "SiaEjeCredito")
    private BigDecimal siaEjeCredito;
    @Basic(optional = false)
    @Column(name = "SiaEjeCtrCredito")
    private BigDecimal siaEjeCtrCredito;
    @Basic(optional = false)
    @Column(name = "SiaEjeAplVlr")
    private BigDecimal siaEjeAplVlr;
    @Basic(optional = false)
    @Column(name = "SiaEjeDepVlr")
    private BigDecimal siaEjeDepVlr;
    @Basic(optional = false)
    @Column(name = "SiaEjeRecVlr")
    private BigDecimal siaEjeRecVlr;
    @Basic(optional = false)
    @Column(name = "SiaEjeAdiVlr")
    private BigDecimal siaEjeAdiVlr;
    @Basic(optional = false)
    @Column(name = "SiaEjeCompVlr")
    private BigDecimal siaEjeCompVlr;
    @Basic(optional = false)
    @Column(name = "SiaEjeOrdVlr")
    private BigDecimal siaEjeOrdVlr;
    @Basic(optional = false)
    @Column(name = "SiaEjePagVlr")
    private BigDecimal siaEjePagVlr;

 
}
