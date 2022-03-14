package com.apirest.financiero.models.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "CNT_Comprobantes")

public class CNTComprobantes implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CNTComprobantesPK cNTComprobantesPK;

    @Basic(optional = false)
    @Column(name = "CodTip")
    private Integer codTip;

    @Basic(optional = false) 
    @Column(name = "TipDoc")
    private String tipDoc;

    @Column(name = "FecComp")
    private Date fecComp;

    @Column(name = "ConComp")
    private String conComp;

    @Basic(optional = false)
    @Column(name = "TotDeb")
    private Integer totDeb;

    @Basic(optional = false)
    @Column(name = "TotCre")
    private Integer totCre;

    @Column(name = "TipComp")
    private String tipComp;

    @Basic(optional = false)
    @Column (name = "DesComp")
    private String desComp;

    @Basic(optional = false)
    @Column (name = "CenCost")
    private String cenCost;

    @Basic(optional = false)
    @Column (name = "NomTer")
    private String nomTer;

    @Basic(optional = false)
    @Column (name = "CodTer")
    private Integer codTer;

    @Basic(optional = false)
    @Column (name = "NomCue")
    private String nomCue;

    @Basic(optional = false)
    @Column (name = "CueCod")
    private Integer cueCod;
}
