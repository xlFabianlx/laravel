/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;

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
@Table(name = "G_SiaPacTrn")

public class GSiaPacTrn implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GSiaPacTrnPK gSiaPacTrnPK;
    @Basic(optional = false)
    @Column(name = "SiaPacCtaCod")
    private String siaPacCtaCod;
    @Basic(optional = false)
    @Column(name = "SiaPacCtaDes")
    private String siaPacCtaDes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SiaPacAnt")
    private BigDecimal siaPacAnt;
    @Basic(optional = false)
    @Column(name = "SiaPacAdi")
    private BigDecimal siaPacAdi;
    @Basic(optional = false)
    @Column(name = "SiaPacRec")
    private BigDecimal siaPacRec;
    @Basic(optional = false)
    @Column(name = "SiaPacApl")
    private BigDecimal siaPacApl;
    @Basic(optional = false)
    @Column(name = "SiaPacSit")
    private BigDecimal siaPacSit;
    @Basic(optional = false)
    @Column(name = "SiaPacPag")
    private BigDecimal siaPacPag;

   
}