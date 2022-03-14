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
@Table(name = "C_PerContable")

public class CPerContable implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CPerContablePK cPerContablePK;
    @Basic(optional = false)
    @Column(name = "MesAse")
    private short mesAse;
    @Basic(optional = false)
    @Column(name = "AjuAse")
    private short ajuAse;

   
}
