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
@Table(name = "P_ModIPtalngDet")
public class PModIPtalngDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PModIPtalngDetPK pModIPtalngDetPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIAdiVlr")
    private BigDecimal detIAdiVlr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIRecVlr")
    private BigDecimal detIRecVlr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetITrVlrd")
    private BigDecimal detITrVlrd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetITrVlrh")
    private BigDecimal detITrVlrh;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIPac01")
    private BigDecimal detIPac01;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIPac02")
    private BigDecimal detIPac02;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIPac03")
    private BigDecimal detIPac03;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIPac04")
    private BigDecimal detIPac04;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIPac05")
    private BigDecimal detIPac05;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIPac06")
    private BigDecimal detIPac06;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIPac07")
    private BigDecimal detIPac07;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIPac08")
    private BigDecimal detIPac08;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIPac09")
    private BigDecimal detIPac09;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIPac10")
    private BigDecimal detIPac10;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIPac11")
    private BigDecimal detIPac11;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetIPac12")
    private BigDecimal detIPac12;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetITrVlrhas")
    private BigDecimal detITrVlrhas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetITrVlrdes")
    private BigDecimal detITrVlrdes;
}
