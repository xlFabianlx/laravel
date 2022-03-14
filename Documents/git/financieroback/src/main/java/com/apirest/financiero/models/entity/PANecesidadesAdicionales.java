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
@Table(name = "PA_NecesidadesAdicionales")

public class PANecesidadesAdicionales implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PANecesidadesAdicionalesPK pANecesidadesAdicionalesPK;
    @Basic(optional = false)
    @Column(name = "PaaNecDes")
    private String paaNecDes;
    @Column(name = "PaaNecResp")
    private Long paaNecResp;
    @Basic(optional = false)
    @Column(name = "PaaNecFecEla")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paaNecFecEla;
    @Basic(optional = false)
    @Column(name = "PaaNecHorEla")
    private String paaNecHorEla;
    @Basic(optional = false)
    @Column(name = "PaaNecUsuEla")
    private String paaNecUsuEla;
    @Basic(optional = false)
    @Column(name = "PaaNecEst")
    private String paaNecEst;
}
