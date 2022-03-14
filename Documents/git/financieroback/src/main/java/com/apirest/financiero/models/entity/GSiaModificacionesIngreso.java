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
@Table(name = "G_SiaModificacionesIngreso")

public class GSiaModificacionesIngreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GSiaModificacionesIngresoPK gSiaModificacionesIngresoPK;
    @Basic(optional = false)
    @Column(name = "SiaModiCtaICod")
    private String siaModiCtaICod;
    @Basic(optional = false)
    @Column(name = "SiaModiIDecCod")
    private String siaModiIDecCod;
    @Basic(optional = false)
    @Column(name = "SiaModiIFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date siaModiIFec;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SiaModiIAdiVlr")
    private BigDecimal siaModiIAdiVlr;
    @Basic(optional = false)
    @Column(name = "SiaModiIRecVlr")
    private BigDecimal siaModiIRecVlr;
    @Basic(optional = false)
    @Column(name = "SiaModiIAplVlr")
    private BigDecimal siaModiIAplVlr;
    @Basic(optional = false)
    @Column(name = "SiaModiIDepVlr")
    private BigDecimal siaModiIDepVlr;

 
}
