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
@Table(name = "P_OrdenPago")
public class POrdenPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected POrdenPagoPK pOrdenPagoPK;
    @Size(max = 256)
    @Column(name = "PagCptRes")
    private String pagCptRes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "PagCta")
    private String pagCta;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagEje")
    private BigDecimal pagEje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagDetVlrbas")
    private BigDecimal pagDetVlrbas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagDetVlrIva")
    private BigDecimal pagDetVlrIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagResF")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pagResF;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagRes")
    private long pagRes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CtaxPaga")
    private String ctaxPaga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagDed")
    private short pagDed;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagCan")
    private short pagCan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "OrdCodP")
    private String ordCodP;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagFue")
    private short pagFue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagResEje")
    private BigDecimal pagResEje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "PagCpt")
    private String pagCpt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ResCod")
    private int resCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ResInd")
    private short resInd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pagFec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "PagHor")
    private String pagHor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PagEst")
    private String pagEst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date pagFecAnu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "PagHorAnu")
    private String pagHorAnu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "PagCptAnu")
    private String pagCptAnu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "PagUsuAnu")
    private String pagUsuAnu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PagUsu")
    private String pagUsu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagVlr")
    private BigDecimal pagVlr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetPaFVlr")
    private BigDecimal detPaFVlr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagSal")
    private BigDecimal pagSal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagVlrBs")
    private BigDecimal pagVlrBs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagCont")
    private short pagCont;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagVlrIv")
    private BigDecimal pagVlrIv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagBenRes")
    private long pagBenRes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SiCxp")
    private short siCxp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Mes")
    private short mes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Numero")
    private int numero;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EstadoContable")
    private short estadoContable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagBen")
    private long pagBen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 65)
    @Column(name = "PagBenN")
    private String pagBenN;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "PagCtaRes")
    private String pagCtaRes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CuentaGasto")
    private String cuentaGasto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CuentaPagar")
    private String cuentaPagar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagResFue")
    private short pagResFue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Documento")
    private short documento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FuenteCxP")
    private short fuenteCxP;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CXPCenCod")
    private String cXPCenCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "EntOrden")
    private String entOrden;
    @Column(name = "VAPagFue")
    private Short vAPagFue;
    @Size(max = 16)
    @Column(name = "VAPagRubro")
    private String vAPagRubro;
    @Column(name = "PagFirIni")
    private BigDecimal pagFirIni;
    @Column(name = "PagFirFin")
    private BigDecimal pagFirFin;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PagAltCod")
    private String pagAltCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PagAutEst")
    private boolean pagAutEst;
}
