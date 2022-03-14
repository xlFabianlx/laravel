package com.apirest.financiero.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "P_RegPreDet")
public class PRegPreDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PRegPreDetPK pRegPreDetPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetResDis")
    private BigDecimal detResDis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetResVlr")
    private BigDecimal detResVlr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetResRei")
    private BigDecimal detResRei;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetResEje")
    private BigDecimal detResEje;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetVlrbas")
    private BigDecimal detVlrbas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Detanudis")
    private BigDecimal detanudis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetVlrIva")
    private BigDecimal detVlrIva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SiRes")
    private short siRes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NumRes")
    private short numRes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FFCONCOD")
    private short ffconcod;
}
