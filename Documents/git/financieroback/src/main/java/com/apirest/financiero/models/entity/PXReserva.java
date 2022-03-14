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
@Table(name = "PX_Reserva")

public class PXReserva implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PXReservaPK pXReservaPK;
    @Basic(optional = false)
    @Column(name = "RsxId")
    private long rsxId;
    @Basic(optional = false)
    @Column(name = "RsxId2")
    private short rsxId2;
    @Basic(optional = false)
    @Column(name = "RsxDes")
    private String rsxDes;
    @Basic(optional = false)
    @Column(name = "RsxFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rsxFec;
    @Basic(optional = false)
    @Column(name = "RsxBenCod")
    private long rsxBenCod;
    @Basic(optional = false)
    @Column(name = "RsxEst")
    private String rsxEst;
    @Basic(optional = false)
    @Column(name = "RsxSrlDet")
    private short rsxSrlDet;
    @Column(name = "RsxResCod")
    private Long rsxResCod;
    @Column(name = "RsxResFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rsxResFec;
    @Column(name = "RsxMig")
    private String rsxMig;
    @Column(name = "RsxTAntCod")
    private Short rsxTAntCod;
    @Column(name = "RsxEntCod")
    private Short rsxEntCod;
    @Column(name = "RsxUsuEla")
    private String rsxUsuEla;
    @Column(name = "RsxDesLiq")
    private String rsxDesLiq;
    @Column(name = "RsxFecLiq")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rsxFecLiq;
    @Column(name = "RsxDesAnu")
    private String rsxDesAnu;
    @Column(name = "RsxFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rsxFecAnu;
    @Column(name = "RsxCtraId")
    private String rsxCtraId;
  

  
}
