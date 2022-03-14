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
@Table(name = "N_ConceptoGrupo")

public class NConceptoGrupo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NConceptoGrupoPK nConceptoGrupoPK;
    @Column(name = "CuentaGasto")
    private String cuentaGasto;
    @Column(name = "CuentaPresupuesto")
    private String cuentaPresupuesto;
    @Column(name = "CuentaPagar")
    private String cuentaPagar;

  
}
