/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;

import java.io.Serializable;
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
@Table(name = "C_TipoCompContable")

public class CTipoCompContable implements Serializable {
 
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CTipoCompContablePK cTipoCompContablePK;
    @Basic(optional = false)
    @Column(name = "EmpCod")
    private short empCod;
    @Basic(optional = false)
    @Column(name = "DocTipo")
    private short docTipo;
    @Basic(optional = false)
    @Column(name = "DocDes")
    private String docDes;
    @Basic(optional = false)
    @Column(name = "DocUlt")
    private long docUlt;
    @Basic(optional = false)
    @Column(name = "DocClase")
    private short docClase;
    @Column(name = "DocNicCod")
    private Short docNicCod;
    @Basic(optional = false)
    @Column (name = "TipNom")
    private String tipNom;
    @Basic(optional = false)
    @Column (name = "NomCla")
    private String nomCla;
    
}
