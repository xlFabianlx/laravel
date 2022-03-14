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
@Table(name = "PG_CDPLib")

public class PGCDPLib implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PGCDPLibPK pGCDPLibPK;
    @Basic(optional = false)
    @Column(name = "CdpLibDes")
    private String cdpLibDes;
    @Basic(optional = false)
    @Column(name = "CdpLibFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cdpLibFec;
    @Column(name = "CdpLibConsCod")
    private String cdpLibConsCod;
    @Column(name = "CdpLibVisualId")
    private String cdpLibVisualId;
    @Column(name = "CdpLibId2")
    private Short cdpLibId2;
    @Column(name = "CdpLibId")
    private Long cdpLibId;


 
}
