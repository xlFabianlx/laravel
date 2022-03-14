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
@Table(name = "PG_SolicitudCDP")

public class PGSolicitudCDP implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PGSolicitudCDPPK pGSolicitudCDPPK;
    @Basic(optional = false)
    @Column(name = "ScdpDes")
    private String scdpDes;
    @Basic(optional = false)
    @Column(name = "ScdpFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scdpFec;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ScdpVlr")
    private BigDecimal scdpVlr;
    @Column(name = "ScdpSolCod")
    private Long scdpSolCod;
    @Column(name = "ScdpFuncCod")
    private Long scdpFuncCod;
    @Column(name = "ScdpId") 
    private Long scdpId;
    @Column(name = "ScdpId2")
    private Short scdpId2;
    @Column(name = "ScdpEntCod")
    private Short scdpEntCod;
    @Column(name = "ScdpJPptoCod")
    private Long scdpJPptoCod;
    @Column(name = "ScdpUsuEla")
    private String scdpUsuEla;
    @Column(name = "ScdpMig")
    private String scdpMig;
    @Column(name = "ScdpOrdCod")
    private Long scdpOrdCod;
    @Column(name = "ScdpAreaCod")
    private Short scdpAreaCod;
    @Column(name = "ScdpFirmElaCod")
    private Long scdpFirmElaCod;
    @Column(name = "ScdpAnoReg")
    private Short scdpAnoReg;
    @Column(name = "ScdpFirmOrd")
    private String scdpFirmOrd;
    @Column(name = "ScdpVisualId")
    private String scdpVisualId;
    @Column(name = "ScdpConsCod")
    private String scdpConsCod;
    @Column(name = "ScdpConsInj")
    private Boolean scdpConsInj;
    @Column(name = "ScdpIpEla")
    private String scdpIpEla;
    @Column(name = "ScdpHorEla")
    private String scdpHorEla;
    @Column(name = "ScdpFecEla")
    @Temporal(TemporalType.TIMESTAMP)
    private Date scdpFecEla;
    @Column(name = "ScdpSrlItm")
    private Short scdpSrlItm;
    @Column(name = "ScdpUnidad")
    private String scdpUnidad;
    @Column(name = "ScdpEjeSolicitante")
    private String scdpEjeSolicitante;
    @Basic(optional = false)
    @Column(name = "ScdpEstado")
    private String scdpEstado;
    @Column(name = "ScdpVlrTtl")
    private BigDecimal scdpVlrTtl;
    @Column(name = "ScdpVlrLib")
    private BigDecimal scdpVlrLib;
    @Column(name = "ScdpVlrSaldo")
    private BigDecimal scdpVlrSaldo;
    @Basic(optional = false)
    @Column(name= "ScdpDependencia")
    private String scdpDependencia;
}
