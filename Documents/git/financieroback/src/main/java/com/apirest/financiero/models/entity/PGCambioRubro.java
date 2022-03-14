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
@Table(name = "PG_CambioRubro")

public class PGCambioRubro implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PGCambioRubroPK pGCambioRubroPK;
    @Basic(optional = false)
    @Column(name = "CamRbrOriCtaCod")
    private String camRbrOriCtaCod;
    @Basic(optional = false)
    @Column(name = "CamRbrDesCtaCod")
    private String camRbrDesCtaCod;
    @Basic(optional = false)
    @Column(name = "CamRbrUsuEla")
    private String camRbrUsuEla;
    @Basic(optional = false)
    @Column(name = "CamRbrUsuAplica")
    private String camRbrUsuAplica;
    @Basic(optional = false)
    @Column(name = "CamRbrFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date camRbrFecha;
    @Basic(optional = false)
    @Column(name = "CamRbrDataJson")
    private String camRbrDataJson;
    @Basic(optional = false)
    @Column(name = "CamRbrTipoCambio")
    private String camRbrTipoCambio;
    @Column(name = "CamRbrEstado")
    private String camRbrEstado;

}
