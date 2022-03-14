/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
@Table(name = "PG_OP")

public class PgOp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PgOpPK pgOpPK;
    @Basic(optional = false)
    @Column(name = "PagDes")
    private String pagDes;
    @Basic(optional = false)
    @Column(name = "PagFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pagFec;
    @Basic(optional = false)
    @Column(name = "PagEst")
    private String pagEst;
    @Basic(optional = false)
    @Column(name = "PagOblNum")
    private long pagOblNum;
    @Basic(optional = false)
    @Column(name = "PagId")
    private long pagId;
    @Basic(optional = false)
    @Column(name = "PagFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pagFecAnu;
    @Basic(optional = false)
    @Column(name = "PagDesAnu")
    private String pagDesAnu;
    @Basic(optional = false)
    @Column(name = "PagId2")
    private short pagId2;
    @Column(name = "PagEntCod")
    private Short pagEntCod;
    @Column(name = "PagContCod")
    private Long pagContCod;
    @Column(name = "PagJPptoCod")
    private Long pagJPptoCod;
    @Column(name = "PagOrdCod")
    private Long pagOrdCod;
    @Column(name = "PagAmortFirst")
    private Boolean pagAmortFirst;
    @Column(name = "PagUsuEla")
    private String pagUsuEla;
    @Column(name = "PagAuxContaCod1")
    private Long pagAuxContaCod1;
    @Column(name = "PagAuxContaCod2")
    private Long pagAuxContaCod2;
    @Column(name = "PagAuxContaCod3")
    private Long pagAuxContaCod3;
    @Column(name = "PagSecreCod")
    private Long pagSecreCod;
    @Column(name = "PagMig")
    private String pagMig;
    @Column(name = "PagCie")
    private Boolean pagCie;
    @Column(name = "PagCxpCod")
    private Long pagCxpCod;
    @Column(name = "PagFirmElaCod")
    private Long pagFirmElaCod;
    @Column(name = "PagFirmOrd")
    private String pagFirmOrd;
    @Column(name = "PagAnoReg")
    private Short pagAnoReg;
    @Column(name = "PagVisualId")
    private String pagVisualId;
    @Column(name = "PagConsCod")
    private String pagConsCod;
    @Column(name = "PagConsInj")
    private Boolean pagConsInj;
    @Column(name = "PagInfoPago")
    private String pagInfoPago;
    @Column(name = "PagIpEla")
    private String pagIpEla;
    @Column(name = "PagHorEla")
    private String pagHorEla;
    @Column(name = "PagFecEla")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pagFecEla;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pgOp")
    private Collection<PGOPDet> pGOPDetCollection;

 
}
