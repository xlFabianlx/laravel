/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;import lombok.AllArgsConstructor;


import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;

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
@Table(name = "N_Prestacion")

public class NPrestacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Cod_Concepto")
    private String codConcepto;
    @Column(name = "Descripcion")
    private String descripcion;
    @Column(name = "Tipo")
    private String tipo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Numero")
    private Float numero;
    @Column(name = "Tiempo_Minimo")
    private Integer tiempoMinimo;
    @Column(name = "Valor_Base")
    private BigDecimal valorBase;
    @Column(name = "P_Base")
    private BigDecimal pBase;
    @Column(name = "P_Adicional")
    private BigDecimal pAdicional;
    @Column(name = "Mes_Pago")
    private String mesPago;
    @Column(name = "Mes_Pago2")
    private String mesPago2;
    @Basic(optional = false)
    @Column(name = "Incluir_Nomina")
    private boolean incluirNomina;
    @Column(name = "Frecuencia")
    private String frecuencia;

  
}
