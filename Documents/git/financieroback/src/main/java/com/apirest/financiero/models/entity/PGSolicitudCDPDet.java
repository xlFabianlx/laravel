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
@Table(name = "PG_SolicitudCDPDet")

public class PGSolicitudCDPDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PGSolicitudCDPDetPK pGSolicitudCDPDetPK;
    @Basic(optional = false)
    @Column(name = "CtaCod")
    private String ctaCod;
    @Basic(optional = false)
    @Column(name = "FueCod")
    private short fueCod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "ScdpDetVlr")
    private BigDecimal scdpDetVlr;

  
}
