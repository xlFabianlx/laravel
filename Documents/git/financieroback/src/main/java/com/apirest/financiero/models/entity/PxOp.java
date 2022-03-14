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
@Table(name = "PX_OP")

public class PxOp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PxOpPK pxOpPK;
    @Basic(optional = false)
    @Column(name = "OpxId")
    private long opxId;
    @Basic(optional = false)
    @Column(name = "OpxId2")
    private short opxId2;
    @Column(name = "OpxAmortFirst")
    private Boolean opxAmortFirst;
    @Basic(optional = false)
    @Column(name = "OpxDes")
    private String opxDes;
    @Basic(optional = false)
    @Column(name = "OpxFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date opxFec;
    @Basic(optional = false)
    @Column(name = "OpxEst")
    private String opxEst;
    @Basic(optional = false)
    @Column(name = "OpxOblNum")
    private long opxOblNum;
    @Column(name = "OpxFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date opxFecAnu;
    @Column(name = "OpxDesAnu")
    private String opxDesAnu;
    @Column(name = "OpxMig")
    private String opxMig;
    @Column(name = "OpxEntCod")
    private Short opxEntCod;


 
}
