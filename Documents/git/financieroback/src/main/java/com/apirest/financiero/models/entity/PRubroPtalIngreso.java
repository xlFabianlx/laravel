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
@Table(name = "P_RubroPtalIngreso")
public class PRubroPtalIngreso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PRubroPtalIngresoPK pRubroPtalIngresoPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "CtaIDes")
    private String ctaIDes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaITip")
    private short ctaITip;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaIVlr")
    private BigDecimal ctaIVlr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaIRec")
    private BigDecimal ctaIRec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaIAdi")
    private BigDecimal ctaIAdi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaIEje")
    private BigDecimal ctaIEje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 18)
    @Column(name = "CtaICodAux")
    private String ctaICodAux;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaITra")
    private BigDecimal ctaITra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "Sector_codigo")
    private String sectorcodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CTASWCGRI")
    private short ctaswcgri;
    @Column(name = "CtaISIHO")
    private Integer ctaISIHO;
    @Column(name = "CtaIIndSIHO")
    private Short ctaIIndSIHO;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "EntCodigo")
    private String entCodigo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CtaIRese")
    private short ctaIRese;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CtaParmEstSIRECIIng")
    private String ctaParmEstSIRECIIng;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CtaParmEstFUTIng")
    private String ctaParmEstFUTIng;
}
