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
@Entity
@Table(name = "C_Egreso")

public class CEgreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CEgresoPK cEgresoPK;
    @Basic(optional = false)
    @Column(name = "UsuAnu")
    private String usuAnu;
    @Basic(optional = false)
    @Column(name = "BenCodEgr")
    private long benCodEgr;
    @Basic(optional = false)
    @Column(name = "BenCtaEgr")
    private String benCtaEgr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "Egrotr")
    private BigDecimal egrotr;
    @Column(name = "Egrdes")
    private String egrdes;
    @Basic(optional = false)
    @Column(name = "EgrTipGr")
    private short egrTipGr;
    @Basic(optional = false)
    @Column(name = "EgrChe")
    private long egrChe;
    @Basic(optional = false)
    @Column(name = "EgrFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date egrFec;
    @Basic(optional = false)
    @Column(name = "EgrHor")
    private String egrHor;
    @Column(name = "EgrCpt")
    private String egrCpt;
    @Basic(optional = false)
    @Column(name = "EgrFecIni")
    @Temporal(TemporalType.TIMESTAMP)
    private Date egrFecIni;
    @Basic(optional = false)
    @Column(name = "EgrFecFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date egrFecFin;
    @Basic(optional = false)
    @Column(name = "EgrTip")
    private short egrTip;
    @Basic(optional = false)
    @Column(name = "EgrCont")
    private short egrCont;
    @Basic(optional = false)
    @Column(name = "EgrAnu")
    private short egrAnu;
    @Column(name = "EgrCptAnu")
    private String egrCptAnu;
    @Basic(optional = false)
    @Column(name = "EgrFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date egrFecAnu;
    @Basic(optional = false)
    @Column(name = "EgrHorAnu")
    private String egrHorAnu;
    @Basic(optional = false)
    @Column(name = "EgrVal")
    private BigDecimal egrVal;
    @Basic(optional = false)
    @Column(name = "EgrDed")
    private BigDecimal egrDed;
    @Basic(optional = false)
    @Column(name = "EgrNeto")
    private BigDecimal egrNeto;
    @Basic(optional = false)
    @Column(name = "UsuEla")
    private String usuEla;
    @Basic(optional = false)
    @Column(name = "CueNro")
    private String cueNro;
    @Basic(optional = false)
    @Column(name = "EgrEst")
    private String egrEst;
    @Basic(optional = false)
    @Column(name = "EgrValOtr")
    private BigDecimal egrValOtr;
    @Basic(optional = false)
    @Column(name = "EgrDesOtr")
    private String egrDesOtr;
    @Basic(optional = false)
    @Column(name = "EgrConsViejo")
    private int egrConsViejo;
    @Basic(optional = false)
    @Column(name = "EntEgreso")
    private String entEgreso;
    @Column(name = "EgrFirIni")
    private BigDecimal egrFirIni;
    @Column(name = "EgrFirFin")
    private BigDecimal egrFirFin;
    @Basic(optional = false)
    @Column(name = "EgrAltCod")
    private String egrAltCod;
    @Basic(optional = false)
    @Column(name = "EgrCenCod")
    private String egrCenCod;

   
}
