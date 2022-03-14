/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;

import java.io.Serializable;
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
@Table(name = "C_Comprobante")

public class CComprobante implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CComprobantePK cComprobantePK;
    @Basic(optional = false)
    @Column(name = "AsiFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date asiFec;
    @Basic(optional = false)
    @Column(name = "AsiDes")
    private String asiDes;
    @Basic(optional = false)
    @Column(name = "AsiTip")
    private String asiTip;
    @Basic(optional = false)
    @Column(name = "AsiId")
    private long asiId;
    @Column(name = "AsiEntCod")
    private Short asiEntCod;
    @Column(name = "AsiCenCod")
    private Short asiCenCod;
    @Column(name = "AsiEst")
    private String asiEst;
    @Column(name = "TAsiCod")
    private Short tAsiCod;
    @Basic(optional = false)
    @Column(name = "AsiSrlDet")
    private long asiSrlDet;
    @Column(name = "AsiFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date asiFecAnu;
    @Column(name = "AsiDesAnu")
    private String asiDesAnu;
    @Basic(optional = false)
    @Column(name = "AsiId2")
    private long asiId2;
    @Column(name = "AsiContCod")
    private Long asiContCod;
    @Column(name = "AsiUsuEla")
    private String asiUsuEla;
    @Column(name = "AsiMig")
    private String asiMig;
    @Column(name = "ASiCie")
    private Boolean aSiCie;
    @Column(name = "AsiNicsp")
    private Boolean asiNicsp;
    @Basic(optional = false)
    @Column(name = "AsiCls")
    private String asiCls;
    @Column(name = "AsiLIfzInvCod")
    private Long asiLIfzInvCod;
    @Column(name = "AsiVisualId")
    private String asiVisualId;
    @Column(name = "AsiConsCod")
    private String asiConsCod;
    @Column(name = "AsiConsInj")
    private Short asiConsInj;
    @Column(name = "AsiTerCod")
    private Long asiTerCod;
    @Column(name = "AsiIpEla")
    private String asiIpEla;
    @Column(name = "AsiHorEla")
    private String asiHorEla;
    @Column(name = "AsiFecEla")
    @Temporal(TemporalType.TIMESTAMP)
    private Date asiFecEla;

     
}
