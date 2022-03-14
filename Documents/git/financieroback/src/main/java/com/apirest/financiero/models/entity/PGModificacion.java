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
@Table(name = "PG_Modificacion")

public class PGModificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PGModificacionPK pGModificacionPK;
    @Basic(optional = false)
    @Column(name = "MovTip")
    private String movTip;
    @Basic(optional = false)
    @Column(name = "MovFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movFec;
    @Basic(optional = false)
    @Column(name = "MovDes")
    private String movDes;
    @Basic(optional = false)
    @Column(name = "MovEst")
    private String movEst;
    @Basic(optional = false)
    @Column(name = "MovSrlDet")
    private short movSrlDet;
    @Basic(optional = false)
    @Column(name = "MovId")
    private long movId;
    @Column(name = "MovFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movFecAnu;
    @Column(name = "MovDesAnu")
    private String movDesAnu;
    @Column(name = "MovEntCod")
    private Short movEntCod;
    @Column(name = "MovDocOfi")
    private String movDocOfi;
    @Column(name = "MovId2")
    private Short movId2;
    @Column(name = "MovUsuEla")
    private String movUsuEla;
    @Column(name = "MovIpEla")
    private String movIpEla;
    @Column(name = "MovHorEla")
    private String movHorEla;
    @Column(name = "MovFecEla")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movFecEla;


 
}
