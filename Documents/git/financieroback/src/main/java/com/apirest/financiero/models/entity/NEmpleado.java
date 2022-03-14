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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

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
@Table(name = "N_Empleado")

public class NEmpleado implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NEmpleadoPK nEmpleadoPK;
    @Basic(optional = false)
    @Column(name = "PAIS_CODIGO")
    private short paisCodigo;
    @Basic(optional = false)
    @Column(name = "EMP_DEPENDENCIA")
    private short empDependencia;
    @Basic(optional = false)
    @Column(name = "EMP_CARGO")
    private int empCargo;
    @Basic(optional = false)
    @Column(name = "EMP_CIUDAD_CEDULA")
    private String empCiudadCedula;
    @Basic(optional = false)
    @Column(name = "EMP_APELLIDOS")
    private String empApellidos;
    @Basic(optional = false)
    @Column(name = "EMP_NOMBRES")
    private String empNombres;
    @Basic(optional = false)
    @Column(name = "EMP_FECHA_NACIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date empFechaNacimiento;
    @Basic(optional = false)
    @Column(name = "EMP_MUNICIPIO_NACIMIENTO")
    private String empMunicipioNacimiento;
    @Basic(optional = false)
    @Column(name = "EMP_PAIS_NACIMIENTO")
    private String empPaisNacimiento;
    @Basic(optional = false)
    @Column(name = "EMP_DEPTO_NACIMIENTO")
    private String empDeptoNacimiento;
    @Column(name = "EMP_MUNICIPIO_RESIDENCIA")
    private Short empMunicipioResidencia;
    @Column(name = "EMP_DEPTO_RESIDENCIA")
    private Short empDeptoResidencia;
    @Basic(optional = false)
    @Column(name = "EMP_PAIS_RESIDENCIA")
    private String empPaisResidencia;
    @Basic(optional = false)
    @Column(name = "EMP_NACIONALIDAD")
    private String empNacionalidad;
    @Basic(optional = false)
    @Column(name = "EMP_DIRECCION_EMP")
    private String empDireccionEmp;
    @Basic(optional = false)
    @Column(name = "EMP_TELEFONOS_EMP")
    private int empTelefonosEmp;
    @Basic(optional = false)
    @Column(name = "EMP_BARRIO")
    private String empBarrio;
    @Basic(optional = false)
    @Column(name = "EMP_SEXO_EMP")
    private String empSexoEmp;
    @Basic(optional = false)
    @Column(name = "EMP_ESTADO_CIVIL")
    private String empEstadoCivil;
    @Basic(optional = false)
    @Column(name = "EMP_LIBRETA_MILITAR")
    private String empLibretaMilitar;
    @Basic(optional = false)
    @Column(name = "EMP_DISTRITO_MILITAR")
    private String empDistritoMilitar;
    @Basic(optional = false)
    @Column(name = "EMP_CERTI_JUDICIAL")
    private String empCertiJudicial;
    @Basic(optional = false)
    @Column(name = "EMP_NUM_PERSONAS_CARGO")
    private String empNumPersonasCargo;
    @Basic(optional = false)
    @Column(name = "EMP_SUELDO_ASPIRA")
    private String empSueldoAspira;
    @Basic(optional = false)
    @Column(name = "EMP_FECHA_REGISTRO")
    private String empFechaRegistro;
    @Basic(optional = false)
    @Column(name = "EMP_FOLIOS")
    private String empFolios;
    @Basic(optional = false)
    @Column(name = "EMP_EXTENSION")
    private String empExtension;
    @Basic(optional = false)
    @Column(name = "EMP_CC_REEMPLA")
    private String empCcReempla;
    @Basic(optional = false)
    @Column(name = "EMP_ENCARGO")
    private String empEncargo;
    @Basic(optional = false)
    @Column(name = "EMP_PUNTAJE")
    private String empPuntaje;
    @Basic(optional = false)
    @Column(name = "EMP_NUMERO_CONVOCATORIA")
    private String empNumeroConvocatoria;
    @Basic(optional = false)
    @Column(name = "EMP_PENSION")
    private short empPension;
    @Column(name = "EMP_CESANTIA")
    private Short empCesantia;
    @Basic(optional = false)
    @Column(name = "EMP_SALUD")
    private short empSalud;
    @Basic(optional = false)
    @Column(name = "EMP_IPS")
    private String empIps;
    @Basic(optional = false)
    @Column(name = "EMP_DESEMPENO")
    private String empDesempeno;
    @Basic(optional = false)
    @Column(name = "EMP_FECHA_INGRESO")
    @Temporal(TemporalType.DATE)
    private Date empFechaIngreso;
    @Basic(optional = false)
    @Column(name = "EMP_CLASE_LIBRETA")
    private String empClaseLibreta;
    @Basic(optional = false)
    @Column(name = "EMP_RH")
    private String empRh;
    @Basic(optional = false)
    @Column(name = "EMP_CUADRO_PLANTA")
    private short empCuadroPlanta;
    @Basic(optional = false)
    @Column(name = "EMP_CAJA")
    private short empCaja;
    @Basic(optional = false)
    @Column(name = "EMP_OBSERVACION")
    private String empObservacion;
    @Basic(optional = false)
    @Column(name = "EMP_FOTO")
    private String empFoto;
    @Basic(optional = false)
    @Column(name = "EMP_FECHA_EMP_CESANTIA")
    private String empFechaEmpCesantia;
    @Basic(optional = false)
    @Column(name = "EMP_TIPOHV_ORIGINAL")
    private String empTipohvOriginal;
    @Basic(optional = false)
    @Column(name = "EMP_FECHA_BS")
    private String empFechaBs;
    @Basic(optional = false)
    @Column(name = "EMP_DEDICACION")
    private String empDedicacion;
    @Basic(optional = false)
    @Column(name = "EMP_CEDULA_REPORTES")
    private int empCedulaReportes;
    @Basic(optional = false)
    @Column(name = "EMP_CAJA_OFICIAL")
    private String empCajaOficial;
    @Basic(optional = false)
    @Column(name = "EMP_CABEZA_FAMILIA")
    private String empCabezaFamilia;
    @Basic(optional = false)
    @Column(name = "EMP_DISCAPACIDAD")
    private String empDiscapacidad;
    @Basic(optional = false)
    @Column(name = "EMP_ETNIA")
    private String empEtnia;
    @Basic(optional = false)
    @Column(name = "EMP_LOCALIDAD")
    private String empLocalidad;
    @Basic(optional = false)
    @Column(name = "EMP_NUMERO_COMVOCATORIA")
    private String empNumeroComvocatoria;
    @Basic(optional = false)
    @Column(name = "EMP_TIPO_HV")
    private String empTipoHv;
    @Basic(optional = false)
    @Column(name = "FOLIOS")
    private short folios;
    @Basic(optional = false)
    @Column(name = "EMP_FECHA_INGRESO_DISTRITO")
    private String empFechaIngresoDistrito;
    @Basic(optional = false)
    @Column(name = "EMP_FECHA_INGRESO_NACION")
    private String empFechaIngresoNacion;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;

  
}
