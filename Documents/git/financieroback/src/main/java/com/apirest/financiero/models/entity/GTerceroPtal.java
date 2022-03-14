/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "G_TerceroPtal")
public class GTerceroPtal implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TerCod")
    private Long terCod;
    @Basic(optional = false)
    @Column(name = "TerNombre")
    private String terNombre;
    @Basic(optional = false)
    @Column(name = "TerNombre2")
    private String terNombre2;
    @Basic(optional = false)
    @Column(name = "TerApellido")
    private String terApellido;
    @Basic(optional = false)
    @Column(name = "TerApellido2")
    private String terApellido2;
    @Basic(optional = false)
    @Column(name = "TerNat")
    private short terNat;
    @Basic(optional = false)
    @Column(name = "CodRut")
    private short codRut;
    @Basic(optional = false)
    @Column(name = "id")
    private short id;
    @Basic(optional = false)
    @Column(name = "PaisCodTer")
    private short paisCodTer;
    @Basic(optional = false)
    @Column(name = "DptCodTer")
    private short dptCodTer;
    @Basic(optional = false)
    @Column(name = "DptCiuCodTer")
    private short dptCiuCodTer;
    @Basic(optional = false)
    @Column(name = "TerDir")
    private String terDir;
    @Basic(optional = false)
    @Column(name = "TerTel")
    private long terTel;
    @Basic(optional = false)
    @Column(name = "TerTipo")
    private short terTipo;
    @Basic(optional = false)
    @Column(name = "CarCod")
    private short carCod;
    @Basic(optional = false)
    @Column(name = "UniEjeT")
    private short uniEjeT;
    @Basic(optional = false)
    @Column(name = "ItemAgregado")
    private short itemAgregado;
    @Basic(optional = false)
    @Column(name = "ItemEntidades")
    private short itemEntidades;
    @Basic(optional = false)
    @Column(name = "TerReg")
    private short terReg;
    @Basic(optional = false)
    @Column(name = "TerContribuyente")
    private short terContribuyente;
    @Basic(optional = false)
    @JoinColumn(name = "TipoDocumento", referencedColumnName = "idDocumento")
    @ManyToOne(optional = false)
    private GTipoDocumento tipoDocumento;
    @Column(name = "NomDocumento")
    private String nomDocumento;
    @Basic(optional = false)
    @Column(name = "Titulo")
    private short titulo;
    @Basic(optional = false)
    @Column(name = "AreaCod")
    private short areaCod;
    @Basic(optional = false)
    @Column(name = "UltConsItem")
    private short ultConsItem;
    @Basic(optional = false)
    @Column(name = "TerCel")
    private long terCel;
    @Basic(optional = false)
    @Column(name = "TerMail")
    private String terMail;
    @Basic(optional = false)
    @Column(name = "TerRcp")
    private Character terRcp;
    @Basic(optional = false)
    @Column(name = "RcpCod")
    private String rcpCod;
    @Basic(optional = false)
    @Column(name = "TerPaa")
    private short terPaa;
    @Column(name = "TerDV")
    private Short terDV;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;
    @JoinColumn(name = "TipoTercero", referencedColumnName = "idPersona")
    @ManyToOne(optional = false)
    private GTipoTercero tipoTercero;
    @JoinColumn(name = "Regimen", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GRegimen regimen;
   
}
