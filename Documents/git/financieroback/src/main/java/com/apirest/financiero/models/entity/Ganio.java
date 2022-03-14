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
@Table(name = "G_anio")

public class Ganio implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GanioPK ganioPK;
    @Basic(optional = false)
    @Column(name = "AnoNom")
    private String anoNom;
    @Basic(optional = false)
    @Column(name = "AnoAse")
    private short anoAse;
    @Basic(optional = false)
    @Column(name = "nUsuEgr")
    private short nUsuEgr;
    @Basic(optional = false)
    @Column(name = "AnoCon")
    private int anoCon;
    @Basic(optional = false)
    @Column(name = "AnoICon")
    private int anoICon;
    @Basic(optional = false)
    @Column(name = "Indest")
    private short indest;
    @Basic(optional = false)
    @Column(name = "Inding")
    private short inding;
    @Basic(optional = false)
    @Column(name = "AnoNC")
    private long anoNC;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PaaqEne")
    private BigDecimal paaqEne;
    @Basic(optional = false)
    @Column(name = "PaaqAcuEne")
    private BigDecimal paaqAcuEne;
    @Basic(optional = false)
    @Column(name = "PaaqFeb")
    private BigDecimal paaqFeb;
    @Basic(optional = false)
    @Column(name = "PaaqAcuFeb")
    private BigDecimal paaqAcuFeb;
    @Basic(optional = false)
    @Column(name = "PaaqMar")
    private BigDecimal paaqMar;
    @Basic(optional = false)
    @Column(name = "PaaqAcuMar")
    private BigDecimal paaqAcuMar;
    @Basic(optional = false)
    @Column(name = "PaaqAbr")
    private BigDecimal paaqAbr;
    @Basic(optional = false)
    @Column(name = "PaaqAcuAbr")
    private BigDecimal paaqAcuAbr;
    @Basic(optional = false)
    @Column(name = "PaaqMay")
    private BigDecimal paaqMay;
    @Basic(optional = false)
    @Column(name = "PaaqAcuMay")
    private BigDecimal paaqAcuMay;
    @Basic(optional = false)
    @Column(name = "PaaqJun")
    private BigDecimal paaqJun;
    @Basic(optional = false)
    @Column(name = "PaaqAcuJun")
    private BigDecimal paaqAcuJun;
    @Basic(optional = false)
    @Column(name = "PaaqJul")
    private BigDecimal paaqJul;
    @Basic(optional = false)
    @Column(name = "PaaqAcuJul")
    private BigDecimal paaqAcuJul;
    @Basic(optional = false)
    @Column(name = "PaaqAgo")
    private BigDecimal paaqAgo;
    @Basic(optional = false)
    @Column(name = "PaaqAcuAgo")
    private BigDecimal paaqAcuAgo;
    @Basic(optional = false)
    @Column(name = "PaaqSep")
    private BigDecimal paaqSep;
    @Basic(optional = false)
    @Column(name = "PaaqAcuSep")
    private BigDecimal paaqAcuSep;
    @Basic(optional = false)
    @Column(name = "PaaqOct")
    private BigDecimal paaqOct;
    @Basic(optional = false)
    @Column(name = "PaaqAcuOct")
    private BigDecimal paaqAcuOct;
    @Basic(optional = false)
    @Column(name = "PaaqNov")
    private BigDecimal paaqNov;
    @Basic(optional = false)
    @Column(name = "PaaqAcuNov")
    private BigDecimal paaqAcuNov;
    @Basic(optional = false)
    @Column(name = "PaaqDic")
    private BigDecimal paaqDic;
    @Basic(optional = false)
    @Column(name = "PaaqAcuDic")
    private BigDecimal paaqAcuDic;
    @Basic(optional = false)
    @Column(name = "FutResTaa")
    private String futResTaa;
    @Basic(optional = false)
    @Column(name = "FutResNaa")
    private String futResNaa;
    @Basic(optional = false)
    @Column(name = "FutResFaa")
    @Temporal(TemporalType.TIMESTAMP)
    private Date futResFaa;
    @Basic(optional = false)
    @Column(name = "GeneraCxP")
    private String generaCxP;
    @Basic(optional = false)
    @Column(name = "GeneraRes")
    private String generaRes;
    @Basic(optional = false)
    @Column(name = "FutResI")
    private short futResI;
    @Basic(optional = false)
    @Column(name = "AnoSalMin")
    private BigDecimal anoSalMin;

  
}
