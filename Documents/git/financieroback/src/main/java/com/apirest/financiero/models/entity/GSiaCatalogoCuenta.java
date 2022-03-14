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
@Table(name = "G_SiaCatalogoCuenta")

public class GSiaCatalogoCuenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GSiaCatalogoCuentaPK gSiaCatalogoCuentaPK;
    @Basic(optional = false)
    @Column(name = "SiaCataCueCap")
    private String siaCataCueCap;
    @Basic(optional = false)
    @Column(name = "SiaCataCueNom")
    private String siaCataCueNom;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "SiaCataSalAnt")
    private BigDecimal siaCataSalAnt;
    @Basic(optional = false)
    @Column(name = "SiaCataDeb")
    private BigDecimal siaCataDeb;
    @Basic(optional = false)
    @Column(name = "SiaCataCrd")
    private BigDecimal siaCataCrd;
    @Basic(optional = false)
    @Column(name = "SiaCataSalFin")
    private BigDecimal siaCataSalFin;
    @Basic(optional = false)
    @Column(name = "SiaCataSalFinC")
    private BigDecimal siaCataSalFinC;
    @Basic(optional = false)
    @Column(name = "SiaCataSalFinN")
    private BigDecimal siaCataSalFinN;
    @Basic(optional = false)
    @Column(name = "SiaCataPer")
    private short siaCataPer;

    
}
