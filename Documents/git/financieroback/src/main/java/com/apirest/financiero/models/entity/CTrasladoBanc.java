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
@Table(name = "C_TrasladoBanc")

public class CTrasladoBanc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CTrasladoBancPK cTrasladoBancPK;
    @Basic(optional = false)
    @Column(name = "CueNroOr")
    private String cueNroOr;
    @Basic(optional = false)
    @Column(name = "TrslFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trslFec;
    @Basic(optional = false)
    @Column(name = "TrslHor")
    private String trslHor;
    @Basic(optional = false)
    @Column(name = "TrslUsu")
    private String trslUsu;
    @Basic(optional = false)
    @Column(name = "TrslFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date trslFecAnu;
    @Basic(optional = false)
    @Column(name = "TrslHorAnu")
    private String trslHorAnu;
    @Column(name = "TrslCauAnu")
    private String trslCauAnu;
    @Basic(optional = false)
    @Column(name = "TrslUsuAnu")
    private String trslUsuAnu;
    @Column(name = "TrslCpt")
    private String trslCpt;
    @Basic(optional = false)
    @Column(name = "TrslCtaD")
    private String trslCtaD;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "TrslVlr")
    private BigDecimal trslVlr;
    @Basic(optional = false)
    @Column(name = "TrslEst")
    private String trslEst;
    @Basic(optional = false)
    @Column(name = "EntTrasladoB")
    private String entTrasladoB;
    @Column(name = "CenCod")
    private String cenCod;
    @Basic(optional = false)
    @Column(name = "TrslFirFin")
    private long trslFirFin;
    @Basic(optional = false)
    @Column(name = "TrslFirIni")
    private long trslFirIni;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "noCheque")
    private String noCheque;

  
}
