/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Table(name = "PG_Rubro")

public class PGRubro implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PGRubroPK pGRubroPK;
    @Basic(optional = false)
    @Column(name = "CtaDes")
    private String ctaDes;
    @Basic(optional = false)
    @Column(name = "CtaTip")
    private String ctaTip;
    @Column(name = "CtaEntCod")
    private Short ctaEntCod;
    @Column(name = "CtaFutCod")
    private String ctaFutCod;
    @Column(name = "CtaTipRub")
    private String ctaTipRub;
    @Column(name = "CtaDocOfiCod")
    private String ctaDocOfiCod;
    @Column(name = "CtaSiaParmCod")
    private String ctaSiaParmCod;
    @Column(name = "CtaSiaParmPagCod")
    private String ctaSiaParmPagCod;
    @Column(name = "CtaAplPaa")
    private Boolean ctaAplPaa;
    @Column(name = "CtaFutDes")
    private String ctaFutDes;
    @Column(name = "CtaDesProyReg")
    private String ctaDesProyReg;
    @Column(name = "CtaSecReg")
    private String ctaSecReg;
    @Column(name = "CtaTran")
    private Boolean ctaTran;
    @Column(name = "CtaVigFut")
    private Boolean ctaVigFut;
    @Column(name = "CtaAreaCod")
    private Short ctaAreaCod;

 
}
