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
@Table(name = "PG_RP")

public class PgRp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PgRpPK pgRpPK;
    @Basic(optional = false)
    @Column(name = "ResDes")
    private String resDes;
    @Basic(optional = false)
    @Column(name = "ResFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resFec;
    @Basic(optional = false)
    @Column(name = "ResBenCod")
    private long resBenCod;
    @Basic(optional = false)
    @Column(name = "ResEst")
    private String resEst;
    @Basic(optional = false)
    @Column(name = "ResId")
    private long resId;
    @Basic(optional = false)
    @Column(name = "ResFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resFecAnu;
    @Basic(optional = false)
    @Column(name = "ResDesAnu")
    private String resDesAnu;
    @Column(name = "ResCtraId")
    private String resCtraId;
    @Column(name = "ResTAntCod")
    private Short resTAntCod;
    @Basic(optional = false)
    @Column(name = "ResId2")
    private short resId2;
    @Column(name = "ResEntCod")
    private Short resEntCod;
    @Column(name = "ResJPptoCod")
    private Long resJPptoCod;
    @Column(name = "ResOrdCod")
    private Long resOrdCod;
    @Column(name = "ResProyCod")
    private Short resProyCod;
    @Column(name = "ResFecLiq")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resFecLiq;
    @Column(name = "ResDesLiq")
    private String resDesLiq;
    @Column(name = "ResUsuEla")
    private String resUsuEla;
    @Column(name = "ResAuxPreCod1")
    private Long resAuxPreCod1;
    @Column(name = "ResAuxPreCod2")
    private Long resAuxPreCod2;
    @Column(name = "ResAuxPreCod3")
    private Long resAuxPreCod3;
    @Column(name = "ResMig")
    private String resMig;
    @Column(name = "ResCie")
    private Boolean resCie;
    @Column(name = "ResRsvCod")
    private Long resRsvCod;
    @Column(name = "ResFirmOrd")
    private String resFirmOrd;
    @Column(name = "ResAnoReg")
    private Short resAnoReg;
    @Column(name = "ResDocOfiCod")
    private String resDocOfiCod;
    @Column(name = "ResVenFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resVenFec;
    @Column(name = "ResBPIN")
    private String resBPIN;
    @Column(name = "ResCtraCodR")
    private Long resCtraCodR;
    @Column(name = "ResVisualId")
    private String resVisualId;
    @Column(name = "ResConsCod")
    private String resConsCod;
    @Column(name = "ResConsInj")
    private Boolean resConsInj;
    @Column(name = "ResIpEla")
    private String resIpEla;
    @Column(name = "ResHorEla")
    private String resHorEla;
    @Column(name = "ResFecEla")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resFecEla;
    @Column(name = "ResAguaPot")
    private Boolean resAguaPot;



}
