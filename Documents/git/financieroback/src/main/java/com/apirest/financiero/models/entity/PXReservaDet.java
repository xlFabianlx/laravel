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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PX_ReservaDet")

public class PXReservaDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PXReservaDetPK pXReservaDetPK;
    @Column(name = "RsxDetCtaCod")
    private String rsxDetCtaCod;
    @Column(name = "RsxDetCtaDes")
    private String rsxDetCtaDes;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "RsxDetVlr")
    private BigDecimal rsxDetVlr;
    @Basic(optional = false)
    @Column(name = "RsxDetLiq")
    private BigDecimal rsxDetLiq;
    @JoinColumn(name = "FueCod", referencedColumnName = "FueCod")
    @ManyToOne(optional = false)
    private PTFuente fueCod;


 
}
