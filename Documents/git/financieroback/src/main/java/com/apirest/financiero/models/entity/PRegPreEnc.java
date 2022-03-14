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
@Table(name = "P_RegPreEnc")
public class PRegPreEnc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PRegPreEncPK pRegPreEncPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Resfecapr")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resfecapr;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "DisCdp")
    private BigDecimal disCdp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "Rescta")
    private String rescta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ResCtaD")
    private String resCtaD;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ProyCod")
    private short proyCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ResCtaN")
    private String resCtaN;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Reshorapr")
    private String reshorapr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Reshorliq")
    private String reshorliq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Resusuanu")
    private String resusuanu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "Rescsaanu")
    private String rescsaanu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Resfecanu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resfecanu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "Reshoranu")
    private String reshoranu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ConTip")
    private int conTip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Resdisanu")
    private BigDecimal resdisanu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VlrIva")
    private BigDecimal vlrIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Ejecut")
    private BigDecimal ejecut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TerCod")
    private long terCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BenCod")
    private long benCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CdpCod")
    private int cdpCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ResFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resFec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ResVlr")
    private BigDecimal resVlr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Vlrbas")
    private BigDecimal vlrbas;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Resest")
    private String resest;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "ResHor")
    private String resHor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ResUsu")
    private String resUsu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ResRei")
    private BigDecimal resRei;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ResEje")
    private BigDecimal resEje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 800)
    @Column(name = "ResCpt")
    private String resCpt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ResIva")
    private BigDecimal resIva;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "OrdCodR")
    private String ordCodR;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UniEjeR")
    private short uniEjeR;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "UniEjeNR")
    private String uniEjeNR;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ResDis")
    private BigDecimal resDis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FecResAp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecResAp;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "Rescsaliq")
    private String rescsaliq;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Resfecliq")
    @Temporal(TemporalType.TIMESTAMP)
    private Date resfecliq;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "RubroVA")
    private String rubroVA;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ResRegOri")
    private int resRegOri;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "ResOrd")
    private String resOrd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CtraNum")
    private String ctraNum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtraFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ctraFec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 254)
    @Column(name = "CtraObjeto")
    private String ctraObjeto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtraVlr")
    private BigDecimal ctraVlr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CtraCCInter")
    private String ctraCCInter;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CtraNMInter")
    private String ctraNMInter;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "CtraCCSuper")
    private String ctraCCSuper;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "CtraNMSuper")
    private String ctraNMSuper;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtraPlazo")
    private int ctraPlazo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FTCONCOD")
    private short ftconcod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FMCONCOD")
    private short fmconcod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FACONCOD")
    private String faconcod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FLCONCOD")
    private String flconcod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CenCod")
    private String cenCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "EntRegistro")
    private String entRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ResCtra")
    private short resCtra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ResFir")
    private long resFir;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ResAltCod")
    private String resAltCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ResAutEst")
    private boolean resAutEst;
}
