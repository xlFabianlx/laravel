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
@Table(name = "G_SiaIngresos")

public class GSiaIngresos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GSiaIngresosPK gSiaIngresosPK;
    @Basic(optional = false)
    @Column(name = "SiaIngCtaICod")
    private String siaIngCtaICod;
    @Basic(optional = false)
    @Column(name = "SiaIngFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date siaIngFec;
    @Basic(optional = false)
    @Column(name = "SiaIngConsCod")
    private int siaIngConsCod;
    @Basic(optional = false)
    @Column(name = "SiaIngTerCod")
    private long siaIngTerCod;
    @Basic(optional = false)
    @Column(name = "SiaIngCpt")
    private String siaIngCpt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SiaIngVlr")
    private BigDecimal siaIngVlr;
    @Basic(optional = false)
    @Column(name = "SiaIngCueNro")
    private String siaIngCueNro;

 
}
