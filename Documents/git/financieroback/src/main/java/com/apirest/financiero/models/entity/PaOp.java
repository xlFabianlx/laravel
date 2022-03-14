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
@Table(name = "PA_OP")

public class PaOp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PaOpPK paOpPK;
    @Basic(optional = false)
    @Column(name = "OprDes")
    private String oprDes;
    @Basic(optional = false)
    @Column(name = "OprFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date oprFec;
    @Basic(optional = false)
    @Column(name = "OprEst")
    private String oprEst;
    @Basic(optional = false)
    @Column(name = "OprOblNum")
    private long oprOblNum;
    @Basic(optional = false)
    @Column(name = "OprId")
    private long oprId;
    @Column(name = "OprFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date oprFecAnu;
    @Column(name = "OprDesAnu")
    private String oprDesAnu;
    @Basic(optional = false)
    @Column(name = "OprId2")
    private short oprId2;
    @Column(name = "OprEntCod")
    private Short oprEntCod;
    @Column(name = "OprJPptoCod")
    private Long oprJPptoCod;
    @Column(name = "OprContCod")
    private Long oprContCod;
    @Column(name = "OprOrdCod")
    private Long oprOrdCod;
    @Column(name = "OprUsuEla")
    private String oprUsuEla;
    @Column(name = "OprAmortFirst")
    private Boolean oprAmortFirst;
    @Column(name = "OprAuxContaCod1")
    private Long oprAuxContaCod1;
    @Column(name = "OprAuxContaCod2")
    private Long oprAuxContaCod2;
    @Column(name = "OprAuxContaCod3")
    private Long oprAuxContaCod3;
    @Column(name = "OprSecreCod")
    private Long oprSecreCod;
    @Column(name = "OprMig")
    private String oprMig;
    @Column(name = "OprFirmOrd")
    private String oprFirmOrd;
    @Column(name = "OprVisualId")
    private String oprVisualId;
    @Column(name = "OprConsCod")
    private String oprConsCod;
    @Column(name = "OprConsInj")
    private Boolean oprConsInj;
    @Column(name = "OprInfoPago")
    private String oprInfoPago;
    @Column(name = "OprIpEla")
    private String oprIpEla;
    @Column(name = "OprHorEla")
    private String oprHorEla;
    @Column(name = "OprFecEla")
    @Temporal(TemporalType.TIMESTAMP)
    private Date oprFecEla;

 
}
