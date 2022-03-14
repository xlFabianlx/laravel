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
@Table(name = "PI_Modificacion")

public class PIModificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PIModificacionPK pIModificacionPK;
    @Basic(optional = false)
    @Column(name = "MovIId")
    private long movIId;
    @Basic(optional = false)
    @Column(name = "MovITip")
    private String movITip;
    @Basic(optional = false)
    @Column(name = "MovIFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movIFec;
    @Basic(optional = false)
    @Column(name = "MovIDes")
    private String movIDes;
    @Basic(optional = false)
    @Column(name = "MovIEst")
    private String movIEst;
    @Column(name = "MovIEntCod")
    private Short movIEntCod;
    @Column(name = "MovISrlDet")
    private Short movISrlDet;
    @Column(name = "MovIFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movIFecAnu;
    @Column(name = "MovIDesAnu")
    private String movIDesAnu;
    @Column(name = "MovIDocOfi")
    private String movIDocOfi;
    @Column(name = "MovIId2")
    private Short movIId2;
    @Column(name = "MovIBPin")
    private String movIBPin;
    @Column(name = "MovIUsuEla")
    private String movIUsuEla;
    @Column(name = "MovIIpEla")
    private String movIIpEla;
    @Column(name = "MovIHorEla")
    private String movIHorEla;
    @Column(name = "MovIFecEla")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movIFecEla;


}
