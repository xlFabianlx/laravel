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
@Table(name = "N_PlanoNomina")

public class NPlanoNomina implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NPlanoNominaPK nPlanoNominaPK;
    @Basic(optional = false)
    @Column(name = "FECHANOMINA")
    @Temporal(TemporalType.DATE)
    private Date fechanomina;
    @Basic(optional = false)
    @Column(name = "NOMFUNCIONARIO")
    private String nomfuncionario;
    @Column(name = "CTACORRIENTEF")
    private String ctacorrientef;
    @Basic(optional = false)
    @Column(name = "CODBANCOF")
    private String codbancof;
    @Basic(optional = false)
    @Column(name = "NITBANCO")
    private String nitbanco;
    @Basic(optional = false)
    @Column(name = "CAMBIO")
    private String cambio;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "TOTALDEVENGADO")
    private BigDecimal totaldevengado;
    @Basic(optional = false)
    @Column(name = "TOTALDESCUENTOS")
    private BigDecimal totaldescuentos;
    @Basic(optional = false)
    @Column(name = "PROCESADO")
    private String procesado;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "FECHAPROCESO")
    @Temporal(TemporalType.DATE)
    private Date fechaproceso;

 
}
