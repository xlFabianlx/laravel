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

public class PACodigoProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ProPrdCod")
    private String proPrdCod;
    @Basic(optional = false)
    @Column(name = "ProPrdDes")
    private String proPrdDes;
    @Column(name = "ProPrdTip")
    private String proPrdTip;
    @Column(name = "ProPrdDiasVen")
    private Short proPrdDiasVen;
    @Column(name = "ProPrdDiasUti")
    private Short proPrdDiasUti;
    @Column(name = "UndMedCod")
    private Short undMedCod;
    @Column(name = "ProPrdAct")
    private Boolean proPrdAct;
    @Column(name = "ProPrdMov")
    private String proPrdMov;
    @Column(name = "ProPrdEst")
    private String proPrdEst;
    @Column(name = "ProPrdEspe")
    private String proPrdEspe;
    @Column(name = "ProPrdGrpPlaCod")
    private String proPrdGrpPlaCod;
    @Column(name = "ProPrdDesAux")
    private String proPrdDesAux;

 
}
