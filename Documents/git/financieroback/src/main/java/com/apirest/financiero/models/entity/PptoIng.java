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
@Table(name = "P_ptoIng")
public class PptoIng implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PptoIngPK pptoIngPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FutIngCod")
    private String futIngCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CgrOeiCod")
    private String cgrOeiCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "CgrRcsCod")
    private String cgrRcsCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "CgrDerCod")
    private String cgrDerCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIFdo")
    private Character detIFdo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIVlr")
    private BigDecimal detIVlr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIRec")
    private BigDecimal detIRec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIAdi")
    private BigDecimal detIAdi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetITra")
    private BigDecimal detITra;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "CgrRcpCod")
    private String cgrRcpCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIEje")
    private BigDecimal detIEje;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FsFutIngCod")
    private String fsFutIngCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CPDBAP2")
    private String cpdbap2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CPCRAP2")
    private String cpcrap2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CPDBEJ")
    private String cpdbej;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CPCREJI2")
    private String cpcreji2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CPCREJ2")
    private String cpcrej2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CPDBCI")
    private String cpdbci;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CPCRCI")
    private String cpcrci;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "CPDBMV")
    private String cpdbmv;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 27)
    @Column(name = "CgrCptCod")
    private String cgrCptCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PacIIniFueC")
    private BigDecimal pacIIniFueC;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PacIIniDifC")
    private BigDecimal pacIIniDifC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "DecCod")
    private String decCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "FutResICod")
    private String futResICod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FutFueIngTip")
    private String futFueIngTip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FutFueIngCod")
    private short futFueIngCod;
    @Size(max = 30)
    @Column(name = "SirefRcpCod")
    private String sirefRcpCod;
    @Size(max = 50)
    @Column(name = "SirefCptCod")
    private String sirefCptCod;
    @Size(max = 30)
    @Column(name = "SirefDerCod")
    private String sirefDerCod;
    @Size(max = 30)
    @Column(name = "SirefRcsCod")
    private String sirefRcsCod;
    @Size(max = 30)
    @Column(name = "SirefOeiCod")
    private String sirefOeiCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FutFonFueIng")
    private short futFonFueIng;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "FutFonTipIng")
    private String futFonTipIng;
}
