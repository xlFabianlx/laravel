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
@Table(name = "P_AdquisicionesPlaneadas")

public class PAdquisicionesPlaneadas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PAdquisicionesPlaneadasPK pAdquisicionesPlaneadasPK;
    @Basic(optional = false)
    @Column(name = "PaaAdqDes")
    private String paaAdqDes;
    @Basic(optional = false)
    @Column(name = "PaaAdqAno")
    private short paaAdqAno;
    @Basic(optional = false)
    @Column(name = "PaaAdqMes")
    private short paaAdqMes;
    @Basic(optional = false)
    @Column(name = "PaaAdqDur")
    private short paaAdqDur;
    @Basic(optional = false)
    @Column(name = "PaaAdqPer")
    private String paaAdqPer;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PaaAdqTotVlr")
    private BigDecimal paaAdqTotVlr;
    @Basic(optional = false)
    @Column(name = "PaaAdqEstVlr")
    private BigDecimal paaAdqEstVlr;
    @Basic(optional = false)
    @Column(name = "PaaAdqVig")
    private String paaAdqVig;
    @Basic(optional = false)
    @Column(name = "PaaAdqVigEst")
    private String paaAdqVigEst;
    @Column(name = "PaaAdqResp")
    private Long paaAdqResp;
    @Basic(optional = false)
    @Column(name = "PaaAdqFecEla")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paaAdqFecEla;
    @Basic(optional = false)
    @Column(name = "PaaAdqUsuEla")
    private String paaAdqUsuEla;
    @Basic(optional = false)
    @Column(name = "PaaAdqHorEla")
    private String paaAdqHorEla;
    @Basic(optional = false)
    @Column(name = "PaaAdqEst")
    private String paaAdqEst;

 
}
