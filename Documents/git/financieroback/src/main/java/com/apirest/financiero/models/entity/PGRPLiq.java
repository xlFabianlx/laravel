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
import javax.xml.bind.annotation.XmlRootElement;

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
@Table(name = "PG_RPLiq")
@XmlRootElement
public class PGRPLiq implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PGRPLiqPK pGRPLiqPK;
    @Basic(optional = false)
    @Column(name = "ResLiqDes")
    private String resLiqDes;
    @Basic(optional = false)
    @Column(name = "ResLiqFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resLiqFec;
    @Column(name = "ResLiqConsCod")
    private String resLiqConsCod;
    @Column(name = "ResLiqVisualId")
    private String resLiqVisualId;
    @Column(name = "ResLiqId2")
    private Short resLiqId2;
    @Column(name = "ResLiqId")
    private Long resLiqId;

}
