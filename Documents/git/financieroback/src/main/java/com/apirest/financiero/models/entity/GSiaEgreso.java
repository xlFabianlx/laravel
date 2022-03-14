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
@Table(name = "G_SiaEgreso")

public class GSiaEgreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GSiaEgresoPK gSiaEgresoPK;
    @Basic(optional = false)
    @Column(name = "SiaEgrFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date siaEgrFec;
    @Basic(optional = false)
    @Column(name = "SiaEgrCtaCod")
    private String siaEgrCtaCod;
    @Basic(optional = false)
    @Column(name = "SiaEgrCCod")
    private int siaEgrCCod;
    @Basic(optional = false)
    @Column(name = "SiaEgrTerNom")
    private String siaEgrTerNom;
    @Basic(optional = false)
    @Column(name = "SiaEgrTerCod")
    private long siaEgrTerCod;
    @Basic(optional = false)
    @Column(name = "SiaEgrCpt")
    private String siaEgrCpt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SiaEgrPagVlr")
    private BigDecimal siaEgrPagVlr;
    @Basic(optional = false)
    @Column(name = "SiaEgrDedSoc")
    private BigDecimal siaEgrDedSoc;
    @Basic(optional = false)
    @Column(name = "SiaEgrDedRet")
    private BigDecimal siaEgrDedRet;
    @Basic(optional = false)
    @Column(name = "SiaEgrDedOtr")
    private BigDecimal siaEgrDedOtr;
    @Basic(optional = false)
    @Column(name = "SiaEgrNeto")
    private BigDecimal siaEgrNeto;
    @Basic(optional = false)
    @Column(name = "SiaEgrCueNro")
    private String siaEgrCueNro;
    @Basic(optional = false)
    @Column(name = "SiaEgrChe")
    private long siaEgrChe;

   
}
