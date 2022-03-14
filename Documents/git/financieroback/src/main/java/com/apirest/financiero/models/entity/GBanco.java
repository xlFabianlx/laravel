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
@Table(name = "G_Banco")

public class GBanco implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GBancoPK gBancoPK;
    @Basic(optional = false)
    @Column(name = "BanNom")
    private String banNom;
    @Basic(optional = false)
    @Column(name = "UltSuc")
    private short ultSuc;
    @Column(name = "SuBanCod")
    private String suBanCod;
    @Column(name = "ImgCheque")
    private String imgCheque;
    @Basic(optional = false)
    @Column(name = "BanPro")
    private short banPro;
    @Basic(optional = false)
    @Column(name = "BanDspCod")
    private int banDspCod;

   
}
