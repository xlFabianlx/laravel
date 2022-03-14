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
@Table(name = "C_ComprobanteContEnc")

public class CComprobanteContEnc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CComprobanteContEncPK cComprobanteContEncPK;
    @Basic(optional = false)
    @Column(name = "DocFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date docFecAnu;
    @Basic(optional = false)
    @Column(name = "DocHorAnu")
    private String docHorAnu;
    @Basic(optional = false)
    @Column(name = "DocUsuAnu")
    private String docUsuAnu;
    @Column(name = "DocCsaAnu")
    private String docCsaAnu;
    @Basic(optional = false)
    @Column(name = "AsiFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date asiFec;
    @Column(name = "AsiDes")
    private String asiDes;
    @Basic(optional = false)
    @Column(name = "DocPre")
    private String docPre;
    @Basic(optional = false)
    @Column(name = "UltItem")
    private short ultItem;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "TotDeb")
    private BigDecimal totDeb;
    @Basic(optional = false)
    @Column(name = "TotCre")
    private BigDecimal totCre;
    @Basic(optional = false)
    @Column(name = "DocEst")
    private short docEst;
    @Basic(optional = false)
    @Column(name = "AsiFecGra")
    @Temporal(TemporalType.TIMESTAMP)
    private Date asiFecGra;
    @Basic(optional = false)
    @Column(name = "AsiHorGra")
    private String asiHorGra;
    @Basic(optional = false)
    @Column(name = "DocUsu")
    private String docUsu;
    @Basic(optional = false)
    @Column(name = "AsiProcEst")
    private short asiProcEst;
    @Basic(optional = false)
    @Column(name = "EntAsiento")
    private String entAsiento;
    @Basic(optional = false)
    @Column(name = "CmpFirFin")
    private long cmpFirFin;
    @Basic(optional = false)
    @Column(name = "CmpFirIni")
    private long cmpFirIni;
    @Basic(optional = false)
    @Column(name = "DocAltNum")
    private String docAltNum;
    @Column(name = "AsiNic")
    private Boolean asiNic;
    @Column(name = "AsiIdNic")
    private Integer asiIdNic;

   
}
