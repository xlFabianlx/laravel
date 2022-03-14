/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;

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
@Table(name = "C_conceptIngEnc")

public class CconceptIngEnc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CconceptIngEncPK cconceptIngEncPK;
    @Basic(optional = false)
    @Column(name = "CueDsct")
    private String cueDsct;
    @Basic(optional = false)
    @Column(name = "FueCod")
    private short fueCod;
    @Basic(optional = false)
    @Column(name = "CtaICod")
    private String ctaICod;
    @Basic(optional = false)
    @Column(name = "CcpNom")
    private String ccpNom;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CcpVlr")
    private BigDecimal ccpVlr;
    @Basic(optional = false)
    @Column(name = "Ultcpt")
    private short ultcpt;
    @Basic(optional = false)
    @Column(name = "UsuCodCpt")
    private String usuCodCpt;
    @Basic(optional = false)
    @Column(name = "CueCapCaja")
    private String cueCapCaja;
    @Basic(optional = false)
    @Column(name = "EntConceptoI")
    private String entConceptoI;
    @Basic(optional = false)
    @Column(name = "CcpTerCau")
    private long ccpTerCau;
    @Basic(optional = false)
    @Column(name = "CcpNaturaleza")
    private Character ccpNaturaleza;
    @Basic(optional = false)
    @Column(name = "CcpConsUlt")
    private short ccpConsUlt;
    @Basic(optional = false)
    @Column(name = "CcpBase")
    private int ccpBase;

   
}
