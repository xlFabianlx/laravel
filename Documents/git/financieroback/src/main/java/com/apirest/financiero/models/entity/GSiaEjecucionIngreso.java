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
@Table(name = "G_SiaEjecucionIngreso")

public class GSiaEjecucionIngreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GSiaEjecucionIngresoPK gSiaEjecucionIngresoPK;
    @Basic(optional = false)
    @Column(name = "SiaEjeCtaICod")
    private String siaEjeCtaICod;
    @Basic(optional = false)
    @Column(name = "SiaEjeCtaIDes")
    private String siaEjeCtaIDes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SiaEjeDetIVlr")
    private BigDecimal siaEjeDetIVlr;
    @Basic(optional = false)
    @Column(name = "SiaEjeAdiIVlr")
    private BigDecimal siaEjeAdiIVlr;
    @Basic(optional = false)
    @Column(name = "SiaEjeRecIVlr")
    private BigDecimal siaEjeRecIVlr;
    @Basic(optional = false)
    @Column(name = "SiaEjeDefIVlr")
    private BigDecimal siaEjeDefIVlr;
    @Basic(optional = false)
    @Column(name = "SiaEjeRecaIVlr")
    private BigDecimal siaEjeRecaIVlr;

  
}
