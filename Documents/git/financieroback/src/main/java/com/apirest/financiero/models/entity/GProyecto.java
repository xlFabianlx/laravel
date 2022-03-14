/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
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
@Entity
@Table(name = "G_Proyecto")

public class GProyecto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GProyectoPK gProyectoPK;
    @Basic(optional = false)
    @Column(name = "ProyNombre")
    private String proyNombre;

    @Basic(optional = false)
    @Column(name = "ProyDetalle")
    private String proyDetalle;

    @Basic(optional = false)
    @Column(name = "fechaRegistro")
    private Date fechaRegistro;

    @Basic(optional = false)
    @Column(name = "bpinCod")
    private String bpinCod;

    @Basic(optional = false)
    @Column(name = "sector")
    private String sector;

    @Basic(optional = false)
    @Column(name = "nbenef")
    private Integer nbenef;

    @Basic(optional = false)
    @Column(name = "dependencia")
    private String dependencia;

    @Basic(optional = false)
    @Column(name = "instpart")
    private String instpart;

    @Basic(optional = false)
    @Column(name = "proyectoMes")
    private Integer proyectoMes;

    @Basic(optional = false)
    @Column(name = "proyectoVlr")
    private BigDecimal proyectoVlr;

    @Basic(optional = false)
    @Column(name = "proyectoEstado")
    private String proyectoEstado;

    @Basic(optional = false)
    @Column(name = "avanceFis")
    private BigDecimal avanceFis;

    @Basic(optional = false)
    @Column(name = "avanceFin")
    private BigDecimal avanceFin;
}
