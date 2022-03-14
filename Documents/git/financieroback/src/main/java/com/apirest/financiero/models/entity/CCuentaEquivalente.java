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
@Table(name = "C_CuentaEquivalente")

public class CCuentaEquivalente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CCuentaEquivalentePK cCuentaEquivalentePK;
    @Basic(optional = false)
    @Column(name = "CueCap")
    private String cueCap;
    @Basic(optional = false)
    @Column(name = "CtaNva")
    private String ctaNva;
    @Basic(optional = false)
    @Column(name = "CtaDsc")
    private String ctaDsc;
    @Basic(optional = false)
    @Column(name = "HomoInd")
    private short homoInd;
    @Basic(optional = false)
    @Column(name = "HomoFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date homoFec;
    @Basic(optional = false)
    @Column(name = "HomoUsu")
    private String homoUsu;
    @Basic(optional = false)
    @Column(name = "CueOrg")
    private String cueOrg;

   
}
