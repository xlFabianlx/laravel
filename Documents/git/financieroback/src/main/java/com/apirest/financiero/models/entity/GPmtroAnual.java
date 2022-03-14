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
@Table(name = "G_PmtroAnual")

public class GPmtroAnual implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GPmtroAnualPK gPmtroAnualPK;
    @Basic(optional = false)
    @Column(name = "ParaNom")
    private String paraNom;
    @Basic(optional = false)
    @Column(name = "ParaValue")
    private String paraValue;
    @Basic(optional = false)
    @Column(name = "ParaMod")
    private String paraMod;

   
}
