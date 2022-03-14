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
@Table(name = "G_DocAuditoria")

public class GDocAuditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GDocAuditoriaPK gDocAuditoriaPK;
    @Basic(optional = false)
    @Column(name = "DocAudModulo")
    private String docAudModulo;
    @Basic(optional = false)
    @Column(name = "DocAudDocTip")
    private String docAudDocTip;
    @Basic(optional = false)
    @Column(name = "DocAudDocNum")
    private String docAudDocNum;
    @Basic(optional = false)
    @Column(name = "DocAudDocMode")
    private String docAudDocMode;
    @Basic(optional = false)
    @Column(name = "DocAudUserNick")
    private String docAudUserNick;
    @Basic(optional = false)
    @Column(name = "DocAudEntidad")
    private String docAudEntidad;
    @Basic(optional = false)
    @Column(name = "DocAudIP")
    private String docAudIP;
    @Basic(optional = false)
    @Column(name = "DocAudFecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date docAudFecha;
    @Basic(optional = false)
    @Column(name = "DocAudHora")
    private String docAudHora;
    @Basic(optional = false)
    @Column(name = "DocAudDocInd")
    private String docAudDocInd;

    
}
