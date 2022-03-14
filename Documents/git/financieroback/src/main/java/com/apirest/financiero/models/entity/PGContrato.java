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
@Table(name = "PG_Contrato")

public class PGContrato implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PGContratoPK pGContratoPK;
    @Basic(optional = false)
    @Column(name = "CtraId")
    private String ctraId;
    @Basic(optional = false)
    @Column(name = "CtraFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ctraFec;
    @Basic(optional = false)
    @Column(name = "CtraDes")
    private String ctraDes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CtraVlr")
    private BigDecimal ctraVlr;
    @Basic(optional = false)
    @Column(name = "CtraAntVlr")
    private BigDecimal ctraAntVlr;
    @Column(name = "CtraApoPen")
    private Boolean ctraApoPen;
    @Column(name = "CtraApoSal")
    private Boolean ctraApoSal;
    @Column(name = "CtraLey1819")
    private Boolean ctraLey1819;
    @Column(name = "CtraOtroVlr")
    private BigDecimal ctraOtroVlr;
    @Column(name = "CtraApoARLVlr")
    private BigDecimal ctraApoARLVlr;
    @Column(name = "CtraMedPreVlr")
    private BigDecimal ctraMedPreVlr;
    @Column(name = "CtraDedViveVlr")
    private BigDecimal ctraDedViveVlr;
    @Column(name = "CtraAFCVlr")
    private BigDecimal ctraAFCVlr;
    @Column(name = "CtraApoVoluVlr")
    private BigDecimal ctraApoVoluVlr;
    @Column(name = "CtraIBCVlr")
    private BigDecimal ctraIBCVlr;
    @Column(name = "CtraFecFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ctraFecFin;
    @Column(name = "CtraFecIni")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ctraFecIni;
    @Column(name = "CtraRpAntVlr")
    private BigDecimal ctraRpAntVlr;
    @Column(name = "CtraFecActCan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ctraFecActCan;
    @Column(name = "CtraEjeEst")
    private Short ctraEjeEst;
    @Column(name = "CtraLoc")
    private Short ctraLoc;
    @Column(name = "CtraAct")
    private String ctraAct;
    @Column(name = "CtraMod")
    private Short ctraMod;
    @Column(name = "CtraTipCtra")
    private Short ctraTipCtra;
    @Column(name = "CtraPlazo")
    private Short ctraPlazo;
    @Column(name = "CtraEjeFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ctraEjeFec;
  

  
}
