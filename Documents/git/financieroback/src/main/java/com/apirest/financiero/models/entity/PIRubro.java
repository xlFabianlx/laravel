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
@Table(name = "PI_Rubro")

public class PIRubro implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PIRubroPK pIRubroPK;
    @Basic(optional = false)
    @Column(name = "CtaIDes")
    private String ctaIDes;
    @Basic(optional = false)
    @Column(name = "CtaITip")
    private String ctaITip;
    @Column(name = "CtaIEntCod")
    private Short ctaIEntCod;
    @Column(name = "CtaIFutCod")
    private String ctaIFutCod;
    @Column(name = "CtaIDocOfiCod")
    private String ctaIDocOfiCod;
    @Column(name = "CtaISiaParmCod")
    private String ctaISiaParmCod;
    @Column(name = "CtaITran")
    private Boolean ctaITran;
    

 
}
