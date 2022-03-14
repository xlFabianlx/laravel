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
import javax.persistence.Entity;
import javax.persistence.Id;

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
@Table(name = "N_PLey100")

public class NPLey100 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "Fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "TEP")
    private double tep;
    @Basic(optional = false)
    @Column(name = "TTP")
    private double ttp;
    @Basic(optional = false)
    @Column(name = "TES")
    private double tes;
    @Basic(optional = false)
    @Column(name = "TTS")
    private double tts;
    @Basic(optional = false)
    @Column(name = "TEPR")
    private double tepr;
    @Basic(optional = false)
    @Column(name = "TEPAR")
    private double tepar;
    @Basic(optional = false)
    @Column(name = "FSP")
    private double fsp;
    @Basic(optional = false)
    @Column(name = "FSS")
    private double fss;
    @Basic(optional = false)
    @Column(name = "FRP")
    private double frp;
    @Basic(optional = false)
    @Column(name = "FIBCMAX")
    private double fibcmax;
    @Basic(optional = false)
    @Column(name = "FIBCMIN")
    private double fibcmin;
    @Basic(optional = false)
    @Column(name = "IBCINTG")
    private double ibcintg;
    @Basic(optional = false)
    @Column(name = "DIASMAXI")
    private double diasmaxi;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "INTERES")
    private Double interes;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;


}
