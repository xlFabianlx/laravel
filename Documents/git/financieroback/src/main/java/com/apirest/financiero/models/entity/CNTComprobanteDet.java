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
@Table(name = "CNT_ComprobanteDet")

public class CNTComprobanteDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CNTComprobanteDetPK cNTComprobanteDetPK;
    @Column(name = "TerCod")
    private Long terCod;
    @Column(name = "PucCod")
    private String pucCod;
    @Basic(optional = false)
    @Column(name = "AsiDetDes")
    private String asiDetDes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "AsiDeb")
    private BigDecimal asiDeb;
    @Basic(optional = false)
    @Column(name = "AsiCre")
    private BigDecimal asiCre;
    @Column(name = "AsiDetAno")
    private Short asiDetAno;
    @Column(name = "AsiDetCenCod")
    private Short asiDetCenCod;
    @Column(name = "AsiDetReve")
    private String asiDetReve;
    @Column(name = "AsiDetClsRevCod")
    private Short asiDetClsRevCod;
    @Column(name = "AsiDetRevDes")
    private String asiDetRevDes;
    @Column(name = "AsiDetRevFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date asiDetRevFec;
    @Column(name = "AsiDetSrlRev")
    private Short asiDetSrlRev;
    @Column(name = "AsiDetPlaca")
    private String asiDetPlaca;
    @Column(name = "AsiDetCarxInvCod")
    private Long asiDetCarxInvCod;
    @Column(name = "AsiDetCarxInvTip")
    private String asiDetCarxInvTip;
    @Column(name = "AsiDetRef")
    private String asiDetRef;

   
}
