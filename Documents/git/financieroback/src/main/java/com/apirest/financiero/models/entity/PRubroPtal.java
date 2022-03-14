package com.apirest.financiero.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@Table(name = "P_RubroPtal")
public class PRubroPtal implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PRubroPtalPK pRubroPtalPK;
    @Size(max = 150)
    @Column(name = "CtaDes")
    private String ctaDes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaTip")
    private short ctaTip;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaVlr")
    private BigDecimal ctaVlr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaTraDes")
    private BigDecimal ctaTraDes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaTraHas")
    private BigDecimal ctaTraHas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaPag")
    private BigDecimal ctaPag;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaRec")
    private BigDecimal ctaRec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaAdi")
    private BigDecimal ctaAdi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaTra")
    private BigDecimal ctaTra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaRes")
    private BigDecimal ctaRes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaRei")
    private BigDecimal ctaRei;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaEje")
    private BigDecimal ctaEje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaCDP")
    private BigDecimal ctaCDP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "CtaCodAux")
    private String ctaCodAux;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Sector_codigo")
    private String sectorcodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTASWCGR")
    private short ctaswcgr;
    @Column(name = "CtaSWDB")
    private Short ctaSWDB;
    @Column(name = "CtaSWCR")
    private Short ctaSWCR;
    @Column(name = "CtaSIHO")
    private Integer ctaSIHO;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaTipRubro")
    private short ctaTipRubro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaRese")
    private short ctaRese;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "EntCodigo")
    private String entCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaExcPAA")
    private Character ctaExcPAA;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CtaParmEstSIRECI")
    private String ctaParmEstSIRECI;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CtaParmEstFUT")
    private String ctaParmEstFUT;
}
