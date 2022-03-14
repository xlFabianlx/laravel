package com.apirest.financiero.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "P_ModPtalDet")
public class PModPtalDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PModPtalDetPK pModPtalDetPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DetAdiVlr")
    private BigDecimal detAdiVlr;
    @Column(name = "DetRecVlr")
    private BigDecimal detRecVlr;
    @Column(name = "DetTraVlrdes")
    private BigDecimal detTraVlrdes;
    @Column(name = "DetTraVlrhas")
    private BigDecimal detTraVlrhas;
    @Column(name = "DetPac01")
    private BigDecimal detPac01;
    @Column(name = "DetPac02")
    private BigDecimal detPac02;
    @Column(name = "DetPac03")
    private BigDecimal detPac03;
    @Column(name = "DetPac04")
    private BigDecimal detPac04;
    @Column(name = "DetPac05")
    private BigDecimal detPac05;
    @Column(name = "DetPac06")
    private BigDecimal detPac06;
    @Column(name = "DetPac07")
    private BigDecimal detPac07;
    @Column(name = "DetPac08")
    private BigDecimal detPac08;
    @Column(name = "DetPac09")
    private BigDecimal detPac09;
    @Column(name = "DetPac10")
    private BigDecimal detPac10;
    @Column(name = "DetPac11")
    private BigDecimal detPac11;
    @Column(name = "DetPac12")
    private BigDecimal detPac12;
}
