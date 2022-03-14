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
@Table(name = "N_Encargo")

public class NEncargo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "EMPCEDULA")
    private String empcedula;
    @Basic(optional = false)
    @Column(name = "CARGOACTUAL")
    private String cargoactual;
    @Basic(optional = false)
    @Column(name = "CARGOASIGNADO")
    private String cargoasignado;
    @Basic(optional = false)
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.DATE)
    private Date fechainicio;
    @Basic(optional = false)
    @Column(name = "FECHAFIN")
    private String fechafin;
    @Basic(optional = false)
    @Column(name = "ESTADO")
    private String estado;
    @Id
    @Basic(optional = false)
    @Column(name = "IDENCARGO")
    private Integer idencargo;

 
}
