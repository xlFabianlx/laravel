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
@Table(name = "PT_Fuente")

public class PTFuente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "FueCod")
    private Short fueCod;
    @Basic(optional = false)
    @Column(name = "FueDes")
    private String fueDes;
    @Column(name = "SiaFueCod")
    private String siaFueCod;
    @Column(name = "FueFutCptCod")
    private String fueFutCptCod;
    @Column(name = "FueTip")
    private String fueTip;
    @Column(name = "FueFutAgua")
    private Integer fueFutAgua;
   

  
}
