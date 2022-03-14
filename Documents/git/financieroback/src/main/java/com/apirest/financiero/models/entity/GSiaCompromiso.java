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
@Table(name = "G_SiaCompromiso")

public class GSiaCompromiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GSiaCompromisoPK gSiaCompromisoPK;
    @Basic(optional = false)
    @Column(name = "SiaResCta")
    private String siaResCta;
    @Basic(optional = false)
    @Column(name = "SiaResCtaNom")
    private String siaResCtaNom;
    @Basic(optional = false)
    @Column(name = "SiaResCdp")
    private long siaResCdp;
    @Basic(optional = false)
    @Column(name = "SiaResCdpFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date siaResCdpFec;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SiaResCdpVlr")
    private BigDecimal siaResCdpVlr;
    @Basic(optional = false)
    @Column(name = "SiaResFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date siaResFec;
    @Basic(optional = false)
    @Column(name = "SiaResVlr")
    private BigDecimal siaResVlr;
    @Basic(optional = false)
    @Column(name = "SiaResTerNom")
    private String siaResTerNom;
    @Basic(optional = false)
    @Column(name = "SiaResTerCod")
    private long siaResTerCod;

   
}
