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
@Table(name = "PA_ReservaLiq")

public class PAReservaLiq implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PAReservaLiqPK pAReservaLiqPK;
    @Basic(optional = false)
    @Column(name = "RsvLiqDes")
    private String rsvLiqDes;
    @Basic(optional = false)
    @Column(name = "RsvLiqFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date rsvLiqFec;
    @Column(name = "RsvLiqConsCod")
    private String rsvLiqConsCod;
    @Column(name = "RsvLiqVisualId")
    private String rsvLiqVisualId;
    @Column(name = "RsvLiqId2")
    private Short rsvLiqId2;
    @Column(name = "RsvLiqId")
    private Long rsvLiqId;

  
}
