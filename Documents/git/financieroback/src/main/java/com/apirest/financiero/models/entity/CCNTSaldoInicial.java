package com.apirest.financiero.models.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "CNT_SaldoInicial")

public class CCNTSaldoInicial implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)
    @Column(name = "Consec")
    private String consec;

    @Basic(optional = false)
    @Column(name = "Cuecod")
    private int cuecod;

    @Column(name = "DesCont")
    private String descont;

    @Column(name = "TerCont")
    private int tercont;

    @Basic(optional = false)
    @Column(name = "TerNom")
    private String ternom;

    @Basic(optional = false)
    @Column(name = "CenCost")
    private String cenCost;

    @Basic(optional = false)
    @Column(name = "DesNom")
    private String desnom;

}
