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
@Table(name = "PA_CXP")

public class PaCxp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PaCxpPK paCxpPK;
    @Basic(optional = false)
    @Column(name = "CxpDes")
    private String cxpDes;
    @Basic(optional = false)
    @Column(name = "CxpFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cxpFec;
    @Basic(optional = false)
    @Column(name = "CxpBenCod")
    private long cxpBenCod;
    @Basic(optional = false)
    @Column(name = "CxpEst")
    private String cxpEst;
    @Basic(optional = false)
    @Column(name = "CxpOblNum")
    private long cxpOblNum;
    @Basic(optional = false)
    @Column(name = "CxpSrlDet")
    private short cxpSrlDet;
    @Basic(optional = false)
    @Column(name = "CxpId")
    private long cxpId;
    @Column(name = "CxpFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cxpFecAnu;
    @Column(name = "CxpDesAnu")
    private String cxpDesAnu;
    @Basic(optional = false)
    @Column(name = "CxpId2")
    private short cxpId2;
    @Column(name = "CxpEntCod")
    private Short cxpEntCod;
    @Column(name = "CxpJPptoCod")
    private Long cxpJPptoCod;
    @Column(name = "CxpContCod")
    private Long cxpContCod;
    @Column(name = "CxpOrdCod")
    private Long cxpOrdCod;
    @Column(name = "CxpUsuEla")
    private String cxpUsuEla;
    @Column(name = "CxpPucCod")
    private String cxpPucCod;
    @Column(name = "CxpPagCod")
    private Long cxpPagCod;
    @Column(name = "CxpFecAnt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cxpFecAnt;
    @Column(name = "CxpAuxContaCod1")
    private Long cxpAuxContaCod1;
    @Column(name = "CxpAuxContaCod2")
    private Long cxpAuxContaCod2;
    @Column(name = "CxpAuxContaCod3")
    private Long cxpAuxContaCod3;
    @Column(name = "CxpSecreCod")
    private Long cxpSecreCod;
    @Column(name = "CxpMig")
    private String cxpMig;
    @Column(name = "CxpFirmOrd")
    private String cxpFirmOrd;
    @Column(name = "CxpVisualId")
    private String cxpVisualId;
    @Column(name = "CxpConsCod")
    private String cxpConsCod;
    @Column(name = "CxpConsInj")
    private Boolean cxpConsInj;
    @Column(name = "CxpIpEla")
    private String cxpIpEla;
    @Column(name = "CxpHorEla")
    private String cxpHorEla;
    @Column(name = "CxpFecEla")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cxpFecEla;
    @Column(name = "CxpNoCtra")
    private String cxpNoCtra;


}
