/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;


import java.io.Serializable;
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
@Table(name = "CNT_HomologacionPUC")

public class CNTHomologacionPUC implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CNTHomologacionPUCPK cNTHomologacionPUCPK;
    @Column(name = "HomPucOri")
    private String homPucOri;
    @Column(name = "HomPucDest")
    private String homPucDest;
    @Column(name = "HomPucEst")
    private String homPucEst;
    @Column(name = "HomPucJson")
    private String homPucJson;
    @Column(name = "HomPucDes")
    private String homPucDes;
    @Column(name = "HomPucTerCod")
    private Long homPucTerCod;
    @Column(name = "HomPucTip")
    private String homPucTip;

    
}
