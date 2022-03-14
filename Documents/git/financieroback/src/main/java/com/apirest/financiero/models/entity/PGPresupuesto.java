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
@Table(name = "PG_Presupuesto")

public class PGPresupuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PGPresupuestoPK pGPresupuestoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PptoVlr")
    private BigDecimal pptoVlr;
    @Column(name = "PptoDebPucCod")
    private String pptoDebPucCod;
    @Column(name = "PptoCrePucCod")
    private String pptoCrePucCod;
    @Column(name = "PptoCptCod")
    private String pptoCptCod;
    @Column(name = "PptoDepCod")
    private String pptoDepCod;
    @Column(name = "PptoDerCod")
    private String pptoDerCod;
    @Column(name = "PptoFinCod")
    private String pptoFinCod;
    @Column(name = "PptoOeiCod")
    private String pptoOeiCod;
    @Column(name = "PptoRcpCod")
    private String pptoRcpCod;
    @Column(name = "PptoRcsCod")
    private String pptoRcsCod;
    @Column(name = "PptoFdo")
    private String pptoFdo;
    @Column(name = "PptoFutCptCod")
    private String pptoFutCptCod;
    @Column(name = "PptoFutSalCod")
    private String pptoFutSalCod;
    @Column(name = "PptoFutRegCod")
    private String pptoFutRegCod;
    @Column(name = "PptoFutFueTip")
    private String pptoFutFueTip;
    @Column(name = "PptoFutFueCod")
    private Short pptoFutFueCod;
    @Column(name = "PptoUej")
    private Short pptoUej;
    @Column(name = "PptoFutTipRbr")
    private String pptoFutTipRbr;
    @Column(name = "PptoFutTpd")
    private Character pptoFutTpd;
    @Column(name = "PptoFutTpo")
    private Character pptoFutTpo;
    @Column(name = "PptoFutFlsFueTip")
    private String pptoFutFlsFueTip;
    @Column(name = "PptoFutFlsFueCod")
    private Short pptoFutFlsFueCod;
    @Column(name = "PptoCptRegCod")
    private String pptoCptRegCod;
    @Column(name = "PptoCodBPIN")
    private String pptoCodBPIN;
    @Column(name = "PptoTerRegCod")
    private Long pptoTerRegCod;
    @Column(name = "PptoFutCxpParmFue")
    private Short pptoFutCxpParmFue;
    @Column(name = "PptoFutRsvParmFue")
    private Short pptoFutRsvParmFue;
    @Column(name = "PptoFutCxpParmCod")
    private String pptoFutCxpParmCod;
    @Column(name = "PptoFutRsvParmCod")
    private String pptoFutRsvParmCod;

 
}
