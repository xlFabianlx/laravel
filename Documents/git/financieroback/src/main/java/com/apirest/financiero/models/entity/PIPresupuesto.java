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
@Table(name = "PI_Presupuesto")

public class PIPresupuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PIPresupuestoPK pIPresupuestoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PptoIVlr")
    private BigDecimal pptoIVlr;
    @Column(name = "PptoICptCod")
    private String pptoICptCod;
    @Column(name = "PptoIRcsCod")
    private String pptoIRcsCod;
    @Column(name = "PptoIOeiCod")
    private String pptoIOeiCod;
    @Column(name = "PptoIDerCod")
    private String pptoIDerCod;
    @Column(name = "PptoIRcpCod")
    private String pptoIRcpCod;
    @Column(name = "PptoIFdo")
    private String pptoIFdo;
    @Column(name = "PptoIFutCptCod")
    private String pptoIFutCptCod;
    @Column(name = "PptoIFutCptFSCod")
    private String pptoIFutCptFSCod;
    @Column(name = "PptoIFutSop")
    private Character pptoIFutSop;
    @Column(name = "PptoIFutDoc")
    private String pptoIFutDoc;
    @Column(name = "PptoIFutPct")
    private BigDecimal pptoIFutPct;
    @Column(name = "PptoIFutDestVlr")
    private BigDecimal pptoIFutDestVlr;
    @Column(name = "PptoIFutTipRbr")
    private String pptoIFutTipRbr;
    @Column(name = "PptoITerRegCod")
    private Long pptoITerRegCod;
    @Column(name = "PptoICptRegCod")
    private String pptoICptRegCod;
    @Column(name = "PptoICodBPIN")
    private String pptoICodBPIN;
 

 
}
