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
@Table(name = "C_EgresoDeduccion")

public class CEgresoDeduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CEgresoDeduccionPK cEgresoDeduccionPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "DetEgrBas")
    private BigDecimal detEgrBas;
    @Basic(optional = false)
    @Column(name = "DetEgrPor")
    private BigDecimal detEgrPor;
    @Basic(optional = false)
    @Column(name = "DetEgrVlr")
    private BigDecimal detEgrVlr;

   
}
