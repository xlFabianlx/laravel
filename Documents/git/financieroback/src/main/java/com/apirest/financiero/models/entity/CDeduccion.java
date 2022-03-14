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
import javax.persistence.Entity;
import javax.persistence.Id;

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
@Table(name = "C_Deduccion")

public class CDeduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DedCod")
    private Short dedCod;
    @Basic(optional = false)
    @Column(name = "DedDes")
    private String dedDes;
    @Basic(optional = false)
    @Column(name = "DedTip")
    private short dedTip;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "DedVlr")
    private BigDecimal dedVlr;
    @Basic(optional = false)
    @Column(name = "DedPor")
    private BigDecimal dedPor;
    @Basic(optional = false)
    @Column(name = "ConceptoCod")
    private short conceptoCod;
    @Basic(optional = false)
    @Column(name = "TerDdCod")
    private long terDdCod;
    @Basic(optional = false)
    @Column(name = "DedCls")
    private short dedCls;
    @Basic(optional = false)
    @Column(name = "CueCapE")
    private String cueCapE;
    @Basic(optional = false)
    @Column(name = "CueCapC")
    private short cueCapC;
    @Basic(optional = false)
    @Column(name = "CueCapDed")
    private String cueCapDed;

}
