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
@Table(name = "PA_Reserva")

public class PAReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PAReservaPK pAReservaPK;
    @Basic(optional = false)
    @Column(name = "RsvDes")
    private String rsvDes;
    @Basic(optional = false)
    @Column(name = "RsvFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rsvFec;
    @Basic(optional = false)
    @Column(name = "RsvBenCod")
    private long rsvBenCod;
    @Basic(optional = false)
    @Column(name = "RsvEst")
    private String rsvEst;
    @Basic(optional = false)
    @Column(name = "RsvSrlDet")
    private short rsvSrlDet;
    @Basic(optional = false)
    @Column(name = "RsvId")
    private long rsvId;
    @Basic(optional = false)
    @Column(name = "RsvId2")
    private short rsvId2;
    @Column(name = "RsvCtraId")
    private String rsvCtraId;
    @Column(name = "RsvTAntCod")
    private Short rsvTAntCod;
    @Column(name = "RsvEntCod")
    private Short rsvEntCod;
    @Column(name = "RsvJPptoCod")
    private Long rsvJPptoCod;
    @Column(name = "RsvOrdCod")
    private Long rsvOrdCod;
    @Column(name = "RsvUsuEla")
    private String rsvUsuEla;
    @Column(name = "RsvFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rsvFecAnu;
    @Column(name = "RsvDesAnu")
    private String rsvDesAnu;
    @Column(name = "RsvFecLiq")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rsvFecLiq;
    @Column(name = "RsvDesLiq")
    private String rsvDesLiq;
    @Column(name = "RsvResCod")
    private Long rsvResCod;
    @Column(name = "RsvResFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rsvResFec;
    @Column(name = "RsvAuxPreCod1")
    private Long rsvAuxPreCod1;
    @Column(name = "RsvAuxPreCod2")
    private Long rsvAuxPreCod2;
    @Column(name = "RsvAuxPreCod3")
    private Long rsvAuxPreCod3;
    @Column(name = "RsvMig")
    private String rsvMig;
    @Column(name = "RsvFirmOrd")
    private String rsvFirmOrd;
    @Column(name = "RsvVisualId")
    private String rsvVisualId;
    @Column(name = "RsvConsCod")
    private String rsvConsCod;
    @Column(name = "RsvConsInj")
    private Boolean rsvConsInj;
    @Column(name = "RsvIpEla")
    private String rsvIpEla;
    @Column(name = "RsvHorEla")
    private String rsvHorEla;
    @Column(name = "RsvFecEla")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rsvFecEla;

 
    
}
