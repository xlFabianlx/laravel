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
@Table(name = "PG_ModificacionPrc")

public class PGModificacionPrc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PGModificacionPrcPK pGModificacionPrcPK;
    @Basic(optional = false)
    @Column(name = "MovPrcId")
    private long movPrcId;
    @Basic(optional = false)
    @Column(name = "MovPrcId2")
    private short movPrcId2;
    @Basic(optional = false)
    @Column(name = "MovPrcTip")
    private String movPrcTip;
    @Basic(optional = false)
    @Column(name = "MovPrcFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movPrcFec;
    @Column(name = "MovPrcDocOfiCod")
    private String movPrcDocOfiCod;
    @Basic(optional = false)
    @Column(name = "MovPrcDes")
    private String movPrcDes;
    @Basic(optional = false)
    @Column(name = "MovPrcEst")
    private String movPrcEst;
    @Basic(optional = false)
    @Column(name = "MovPrcSrlGto")
    private short movPrcSrlGto;
    @Basic(optional = false)
    @Column(name = "MovPrcSrlIng")
    private short movPrcSrlIng;
    @Basic(optional = false)
    @Column(name = "MovPrcFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movPrcFecAnu;
    @Basic(optional = false)
    @Column(name = "MovPrcDesAnu")
    private String movPrcDesAnu;
    @Column(name = "MovPrcEntCod")
    private Short movPrcEntCod;
    @Column(name = "MovPrcIngId2")
    private Short movPrcIngId2;
    @Column(name = "MovPrcMovCod")
    private Long movPrcMovCod;
    @Column(name = "MovPrcMovICod")
    private Long movPrcMovICod;
    @Column(name = "MovPrcIngId")
    private Long movPrcIngId;
    @Column(name = "MovPrcIpEla")
    private String movPrcIpEla;
    @Column(name = "MovPrcHorEla")
    private String movPrcHorEla;
    @Column(name = "MovPrcUsuEla")
    private String movPrcUsuEla;
    @Column(name = "MovPrcFecEla")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movPrcFecEla;

  
}
