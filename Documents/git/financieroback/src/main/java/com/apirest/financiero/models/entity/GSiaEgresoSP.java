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
@Table(name = "G_SiaEgresoSP")

public class GSiaEgresoSP implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GSiaEgresoSPPK gSiaEgresoSPPK;
    @Basic(optional = false)
    @Column(name = "SiaEgrFecSP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date siaEgrFecSP;
    @Basic(optional = false)
    @Column(name = "SiaEgrCCodSP")
    private int siaEgrCCodSP;
    @Basic(optional = false)
    @Column(name = "SiaEgrTerNomSP")
    private String siaEgrTerNomSP;
    @Basic(optional = false)
    @Column(name = "SiaEgrTerCodSP")
    private long siaEgrTerCodSP;
    @Basic(optional = false)
    @Column(name = "SiaEgrCptSP")
    private String siaEgrCptSP;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SiaEgrPagVlrSP")
    private BigDecimal siaEgrPagVlrSP;
    @Basic(optional = false)
    @Column(name = "SiaEgrDedSP")
    private BigDecimal siaEgrDedSP;
    @Basic(optional = false)
    @Column(name = "SiaEgrNetoSP")
    private BigDecimal siaEgrNetoSP;
    @Basic(optional = false)
    @Column(name = "SiaEgrCueNroSP")
    private String siaEgrCueNroSP;
    @Basic(optional = false)
    @Column(name = "SiaEgrCheSP")
    private long siaEgrCheSP;

   
}
