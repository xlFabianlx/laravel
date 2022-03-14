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
@Table(name = "G_SiaModificacionesGasto")

public class GSiaModificacionesGasto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GSiaModificacionesGastoPK gSiaModificacionesGastoPK;
    @Basic(optional = false)
    @Column(name = "SiaModiCtacod")
    private String siaModiCtacod;
    @Basic(optional = false)
    @Column(name = "SiaModiDecCod")
    private String siaModiDecCod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SiaModiAdiVlr")
    private BigDecimal siaModiAdiVlr;
    @Basic(optional = false)
    @Column(name = "SiaModiRecVlr")
    private BigDecimal siaModiRecVlr;
    @Basic(optional = false)
    @Column(name = "SiaModiCredito")
    private BigDecimal siaModiCredito;
    @Basic(optional = false)
    @Column(name = "SiaModiCtrCredito")
    private BigDecimal siaModiCtrCredito;
    @Basic(optional = false)
    @Column(name = "SiaModiAplVlr")
    private BigDecimal siaModiAplVlr;
    @Basic(optional = false)
    @Column(name = "SiaModiDepVlr")
    private BigDecimal siaModiDepVlr;
    @Basic(optional = false)
    @Column(name = "SiaModiFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date siaModiFec;

 
}
