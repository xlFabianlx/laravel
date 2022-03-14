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
@Table(name = "G_Funcionario")

public class GFuncionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FuncCod")
    private Integer funcCod;
    @Basic(optional = false)
    @Column(name = "FuncIndent")
    private long funcIndent;
    @Basic(optional = false)
    @Column(name = "FuncNom")
    private String funcNom;
    @Basic(optional = false)
    @Column(name = "FuncTel")
    private long funcTel;
    @Basic(optional = false)
    @Column(name = "CarCod")
    private short carCod;
    @Basic(optional = false)
    @Column(name = "CarNomSo")
    private String carNomSo;
    @Basic(optional = false)
    @Column(name = "UniEje")
    private short uniEje;

  
}
