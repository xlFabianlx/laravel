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
@Table(name = "G_Firmantes")

public class GFirmantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GFirmantesPK gFirmantesPK;
    @Basic(optional = false)
    @Column(name = "TerCod")
    private long terCod;
    @Basic(optional = false)
    @Column(name = "FirFecIni")
    @Temporal(TemporalType.TIMESTAMP)
    private Date firFecIni;
    @Basic(optional = false)
    @Column(name = "FirFecFin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date firFecFin;
    @Basic(optional = false)
    @Column(name = "FirPrioridad")
    private short firPrioridad;

   
}
