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
@Table(name = "PA_Presupuesto")

public class PAPresupuesto implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PAPresupuestoPK pAPresupuestoPK;
    @Column(name = "FutRsvParmCod")
    private String futRsvParmCod;
    @Column(name = "FutCxpParmCod")
    private String futCxpParmCod;
    @Column(name = "FutRsvParmFue")
    private Short futRsvParmFue;
    @Column(name = "FutCxpParmFue")
    private Short futCxpParmFue;
    @Column(name = "PptaCptCod")
    private String pptaCptCod;
    @Column(name = "PptaDepCod")
    private String pptaDepCod;
    @Column(name = "PptaDerCod")
    private String pptaDerCod;
    @Column(name = "PptaFinCod")
    private String pptaFinCod;
    @Column(name = "PptaOeiCod")
    private String pptaOeiCod;
    @Column(name = "PptaRcpCod")
    private String pptaRcpCod;
    @Column(name = "PptaRcsCod")
    private String pptaRcsCod;
    @Column(name = "PptaFdo")
    private String pptaFdo;
    @Column(name = "PptaFutSalCod")
    private String pptaFutSalCod;

 
}
