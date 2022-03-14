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
@Table(name = "N_Fondo")

public class NFondo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodigoEntidad")
    private Short codigoEntidad;
    @Basic(optional = false)
    @Column(name = "NombreEntidad")
    private String nombreEntidad;
    @Basic(optional = false)
    @Column(name = "CajacC")
    private boolean cajacC;
    @Basic(optional = false)
    @Column(name = "Eps")
    private boolean eps;
    @Basic(optional = false)
    @Column(name = "Pension")
    private boolean pension;
    @Basic(optional = false)
    @Column(name = "Cesantia")
    private boolean cesantia;
    @Basic(optional = false)
    @Column(name = "Arl")
    private boolean arl;
    @Column(name = "Nit")
    private String nit;
    @Column(name = "CodigoCta")
    private String codigoCta;
    @Column(name = "Rubo")
    private String rubo;
    @Basic(optional = false)
    @Column(name = "Registro")
    private int registro;

 
}
