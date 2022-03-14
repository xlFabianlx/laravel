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
@Table(name = "C_Conpes")

public class CConpes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CConpesPK cConpesPK;
    @Basic(optional = false)
    @Column(name = "ConpFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date conpFec;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ConpEduServ")
    private BigDecimal conpEduServ;
    @Basic(optional = false)
    @Column(name = "ConpEduOfi")
    private BigDecimal conpEduOfi;
    @Basic(optional = false)
    @Column(name = "ConpEduGra")
    private BigDecimal conpEduGra;
    @Basic(optional = false)
    @Column(name = "ConpSalSub")
    private BigDecimal conpSalSub;
    @Basic(optional = false)
    @Column(name = "ConpSalPub")
    private BigDecimal conpSalPub;
    @Basic(optional = false)
    @Column(name = "ConpSalServ")
    private BigDecimal conpSalServ;
    @Basic(optional = false)
    @Column(name = "ConpAguPot")
    private BigDecimal conpAguPot;
    @Basic(optional = false)
    @Column(name = "ConpProDes")
    private BigDecimal conpProDes;
    @Basic(optional = false)
    @Column(name = "ConpProDep")
    private BigDecimal conpProDep;
    @Basic(optional = false)
    @Column(name = "ConpProCul")
    private BigDecimal conpProCul;
    @Basic(optional = false)
    @Column(name = "ConpProInv")
    private BigDecimal conpProInv;
    @Basic(optional = false)
    @Column(name = "ConpAliEsc")
    private BigDecimal conpAliEsc;
    @Basic(optional = false)
    @Column(name = "ConpRib")
    private BigDecimal conpRib;
    @Basic(optional = false)
    @Column(name = "ConpRes")
    private BigDecimal conpRes;
    @Basic(optional = false)
    @Column(name = "ConpDes")
    private String conpDes;
    @Basic(optional = false)
    @Column(name = "ConpPriInf")
    private BigDecimal conpPriInf;

    
}
