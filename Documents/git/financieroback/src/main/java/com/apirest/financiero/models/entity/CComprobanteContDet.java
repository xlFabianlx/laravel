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
@Table(name = "C_ComprobanteContDet")

public class CComprobanteContDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CComprobanteContDetPK cComprobanteContDetPK;
    @Basic(optional = false)
    @Column(name = "CenCod")
    private String cenCod;
    @Basic(optional = false)
    @Column(name = "AsiCto")
    private String asiCto;
    @Basic(optional = false)
    @Column(name = "TerCod")
    private long terCod;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "AsiDeb")
    private BigDecimal asiDeb;
    @Basic(optional = false)
    @Column(name = "AsiCre")
    private BigDecimal asiCre;
    @Basic(optional = false)
    @Column(name = "AsiPagAno")
    private short asiPagAno;
    @Basic(optional = false)
    @Column(name = "AsiPagInd")
    private short asiPagInd;
    @Basic(optional = false)
    @Column(name = "AsiPagCod")
    private int asiPagCod;
    @Basic(optional = false)
    @Column(name = "CPGDBOPG")
    private String cpgdbopg;
    @Basic(optional = false)
    @Column(name = "CPGCROPG")
    private String cpgcropg;
    @Basic(optional = false)
    @Column(name = "CPGDBINI")
    private String cpgdbini;
    @Basic(optional = false)
    @Column(name = "CPGCRINI")
    private String cpgcrini;
    @Basic(optional = false)
    @Column(name = "CueCap")
    private String cueCap;
    @Basic(optional = false)
    @Column(name = "ProyCod")
    private short proyCod;

   
}
