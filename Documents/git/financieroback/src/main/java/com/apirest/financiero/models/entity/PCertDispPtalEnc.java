package com.apirest.financiero.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "P_CertDispPtalEnc")
public class PCertDispPtalEnc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PCertDispPtalEncPK pCertDispPtalEncPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ScdpCod")
    private long scdpCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CdpEst")
    private String cdpEst;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "CdpCsaAnu")
    private String cdpCsaAnu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CdpFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cdpFecAnu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CdpHorAnu")
    private String cdpHorAnu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CdpUsuAnu")
    private String cdpUsuAnu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "CtaCod")
    private String ctaCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "RegCta")
    private String regCta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "RegCtaD")
    private String regCtaD;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CdRest")
    private String cdRest;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "CdpCpt")
    private String cdpCpt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CdpFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cdpFec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "CdpHor")
    private String cdpHor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CdpUsu")
    private String cdpUsu;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "CdpVlr")
    private BigDecimal cdpVlr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CdpVlrQueda")
    private BigDecimal cdpVlrQueda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CdpComp")
    private BigDecimal cdpComp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CdpLibr")
    private BigDecimal cdpLibr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "EntCertificado")
    private String entCertificado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 800)
    @Column(name = "CdpCptLib")
    private String cdpCptLib;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CdpFecLib")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cdpFecLib;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CdpFecVen")
    @Temporal(TemporalType.TIMESTAMP)
    private Date cdpFecVen;
    @Column(name = "CdpFir")
    private BigDecimal cdpFir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CdpAltCod")
    private String cdpAltCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CdpAutEst")
    private boolean cdpAutEst;
}
