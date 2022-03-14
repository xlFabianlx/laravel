/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

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
@Table(name = "N_Cargo")

public class NCargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "PER_CODIGO_NIVEL")
    private short perCodigoNivel;
    @Basic(optional = false)
    @Column(name = "CAD_CODIGO_CARGO")
    private short cadCodigoCargo;
    @Basic(optional = false)
    @Column(name = "PRO_CODIGO_GRADO")
    private short proCodigoGrado;
    @Basic(optional = false)
    @Column(name = "COD_PLANTA")
    private short codPlanta;
    @Column(name = "TIE_CODIGO")
    private String tieCodigo;
    @Basic(optional = false)
    @Column(name = "CAD_NOMBRE_CARGO")
    private String cadNombreCargo;
    @Basic(optional = false)
    @Column(name = "CAD_SUELDO_BASICO")
    private int cadSueldoBasico;
    @Column(name = "CAD_FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date cadFechaInicio;
    @Column(name = "CAD_ESTADO")
    private String cadEstado;
    @Column(name = "CAD_TIPO_CONTRATO")
    private String cadTipoContrato;
    @Column(name = "CAD_FECHA_DESDE_VAC")
    private String cadFechaDesdeVac;
    @Basic(optional = false)
    @Column(name = "CAD_NUM_RESOLUCION")
    private short cadNumResolucion;
    @Column(name = "CAD_FECHA_TERMINO")
    @Temporal(TemporalType.DATE)
    private Date cadFechaTermino;
    @Column(name = "CAD_PLAZAS")
    private Boolean cadPlazas;
    @Column(name = "CAD_VACANTES")
    private Short cadVacantes;
    @Basic(optional = false)
    @Column(name = "CAD_CONGELADOS")
    private short cadCongelados;
    @Column(name = "CAD_TIPO_CARGO")
    private String cadTipoCargo;
    @Column(name = "CAD_TIPO_NOMBRAMIENTO")
    private String cadTipoNombramiento;
    @Column(name = "CAD_GASTOS_REP")
    private Short cadGastosRep;
    @Column(name = "CAD_PRIMA_TECNICA")
    private Boolean cadPrimaTecnica;
    @Column(name = "PRIMA_COORDINACION")
    private Short primaCoordinacion;
    @Basic(optional = false)
    @Column(name = "CAD_SUELDO_ANTERIOR")
    private int cadSueldoAnterior;
    @Column(name = "CAD_FUNC")
    private String cadFunc;
    @Column(name = "CAD_REQUI")
    private String cadRequi;
    @Basic(optional = false)
    @Column(name = "CAD_TIPO_AUMENTO")
    private short cadTipoAumento;
    @Column(name = "CAD_TOPE_NAL")
    private Short cadTopeNal;
    @Basic(optional = false)
    @Column(name = "CARGO_COMPLETO")
    private int cargoCompleto;
    @Column(name = "CAD_FUNCIONES")
    private String cadFunciones;
    @Column(name = "CAD_REQUISITOS")
    private String cadRequisitos;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

  
}
