
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

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "PG_CDP")

public class PgCdp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PgCdpPK pgCdpPK;
    @Basic(optional = false)
    @Column(name = "CdpFec")
    private Date cdpFec;
    @Basic(optional = false)
    @Column(name = "ScdpCod")
    private Short scdpCod;
    @Basic(optional = false)
    @Column(name = "CdpDes")
    private String cdpDes;
    @Basic(optional = false)
    @Column(name = "CdpSrlDet")
    private short cdpSrlDet;
    @Basic(optional = false)
    @Column(name = "CdpEst")
    private String cdpEst;
    @Basic(optional = false)
    @Column(name = "CdpId")
    private long cdpId;
    @Column(name = "CdpFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cdpFecAnu;
    @Column(name = "CdpDesAnu")
    private String cdpDesAnu;
    @Basic(optional = false)
    @Column(name = "CdpId2")
    private short cdpId2;
    @Column(name = "CdpEntCod")
    private Short cdpEntCod;
    @Column(name = "CdpJPptoCod")
    private Long cdpJPptoCod;
    @Column(name = "CdpFecVen")
    private Date cdpFecVen;
    @Column(name = "CdpUsuEla")
    private String cdpUsuEla;
    @Column(name = "CdpFecLib")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cdpFecLib;
    @Column(name = "CdpDesLib")
    private String cdpDesLib;
    @Column(name = "CdpAuxPreCod1")
    private Long cdpAuxPreCod1;
    @Column(name = "CdpAuxPreCod2")
    private Long cdpAuxPreCod2;
    @Column(name = "CdpAuxPreCod3")
    private Long cdpAuxPreCod3;
    @Column(name = "CdpMig")
    private String cdpMig;
    @Column(name = "CdpFirmOrd")
    private String cdpFirmOrd;
    @Column(name = "CdpAnoReg")
    private Short cdpAnoReg;
    @Column(name = "CdpDocOfiCod")
    private String cdpDocOfiCod;
    @Column(name = "CdpSrlLib")
    private Short cdpSrlLib;
    @Column(name = "CdpVisualId")
    private String cdpVisualId;
    @Column(name = "CdpConsCod")
    private String cdpConsCod;
    @Column(name = "CdpConsInj")
    private Boolean cdpConsInj;
    @Column(name = "CdpIpEla")
    private String cdpIpEla;
    @Column(name = "CdpHorEla")
    private String cdpHorEla;
    @Column(name = "CdpFecEla")
    private Date cdpFecEla;
    @Basic(optional = false)
    @Column(name = "CdpEstado")
    private String cdpEstado;
    @Column(name = "CdpUnidad")
    private String cdpUnidad;
    @Column(name = "CdpEjeSolicitante")
    private String cdpEjeSolicitante;
    

}
