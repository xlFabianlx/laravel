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
@Table(name = "C_CuentaBancaria")

public class CCuentaBancaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CCuentaBancariaPK cCuentaBancariaPK;
    @Basic(optional = false)
    @Column(name = "BanCod")
    private String banCod;
    @Basic(optional = false)
    @Column(name = "SucCod")
    private short sucCod;
    @Basic(optional = false)
    @Column(name = "CueCapB")
    private String cueCapB;
    @Basic(optional = false)
    @Column(name = "NomBanCue")
    private String nomBanCue;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CueSalIni")
    private BigDecimal cueSalIni;
    @Basic(optional = false)
    @Column(name = "TerCodB")
    private long terCodB;
    @Basic(optional = false)
    @Column(name = "CueRec")
    private short cueRec;
    @Basic(optional = false)
    @Column(name = "CueClsTip")
    private String cueClsTip;
    @Basic(optional = false)
    @Column(name = "CueNum")
    private long cueNum;
    @Basic(optional = false)
    @Column(name = "CueDsp")
    private short cueDsp;

    
}
