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
@Table(name = "C_DeduccOrdPago")

public class CDeduccOrdPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CDeduccOrdPagoPK cDeduccOrdPagoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "DetPaDPor")
    private BigDecimal detPaDPor;
    @Basic(optional = false)
    @Column(name = "DetPaDBas")
    private BigDecimal detPaDBas;
    @Basic(optional = false)
    @Column(name = "DetEst")
    private String detEst;
    @Basic(optional = false)
    @Column(name = "DetPadDvlr")
    private BigDecimal detPadDvlr;
    @Basic(optional = false)
    @Column(name = "DedPagEgr")
    private BigDecimal dedPagEgr;

    
}
