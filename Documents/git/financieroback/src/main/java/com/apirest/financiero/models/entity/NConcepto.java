/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *
 * @author jonathan mendoza
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "N_Concepto")

public class NConcepto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CON_CODIGO")
    private Short conCodigo;
    @Basic(optional = false)
    @Column(name = "CON_NOMBRE2")
    private String conNombre2;
    @Basic(optional = false)
    @Column(name = "CON_TIPO")
    private String conTipo;
    @Column(name = "CON_SIGLA")
    private String conSigla;
    @Column(name = "CON_INDICA_SALARIO")
    private String conIndicaSalario;
    @Basic(optional = false)
    @Column(name = "CON_INDICA_RETENCION")
    private String conIndicaRetencion;
    @Basic(optional = false)
    @Column(name = "CON_INDICA_CESANTIA")
    private String conIndicaCesantia;
    @Column(name = "CON_INDICA_VACACION")
    private String conIndicaVacacion;
    @Basic(optional = false)
    @Column(name = "CON_MANUAL")
    private String conManual;
    @Column(name = "AX_COD_MAY")
    private Short axCodMay;
    @Column(name = "AX_COD_SUB")
    private Short axCodSub;
    @Column(name = "AX_COD_AUX1")
    private Short axCodAux1;
    @Basic(optional = false)
    @Column(name = "AX_AUX_NATURALEZA")
    private String axAuxNaturaleza;
    @Basic(optional = false)
    @Column(name = "CON_CONLEY_100")
    private String conConley100;
    @Basic(optional = false)
    @Column(name = "CON_APORTE_PARAFISCA")
    private String conAporteParafisca;
    @Column(name = "CON_PRIO_CAL")
    private Short conPrioCal;
    @Column(name = "CON_PRI_DES")
    private Short conPriDes;
    @Column(name = "CON_INDICA_PROVISION")
    private String conIndicaProvision;
    @Column(name = "CON_FACTOR")
    private String conFactor;
    @Basic(optional = false)
    @Column(name = "CON_NOMBRE")
    private String conNombre;
    @Column(name = "CON_IND_PRIM_NAV")
    private String conIndPrimNav;
    @Column(name = "CON_IND_PRIM_SERV")
    private String conIndPrimServ;
    @Column(name = "CON_IND_PRIM_VAC")
    private String conIndPrimVac;
    @Column(name = "CON_IND_VACACION")
    private String conIndVacacion;
    @Basic(optional = false)
    @Column(name = "CON_INDICA_APORTE")
    private String conIndicaAporte;
    @Column(name = "CON_INDICA_EMBARGOS")
    private String conIndicaEmbargos;
    @Column(name = "CON_CTA_DEBITO")
    private String conCtaDebito;
    @Column(name = "CON_CTA_CREDITO")
    private String conCtaCredito;
    @Column(name = "CON_TIENE_FORMULA")
    private String conTieneFormula;
    @Column(name = "CON_CONDICIONAL")
    private String conCondicional;
    @Column(name = "CON_CONDICION")
    private String conCondicion;
    @Column(name = "CON_FORMULA_NO")
    private String conFormulaNo;
    @Column(name = "CON_TABLAS_ADICIONALES")
    private String conTablasAdicionales;
    @Column(name = "CON_INDICA_APORTEVOL")
    private String conIndicaAportevol;
    @Column(name = "COD_CTA")
    private BigInteger codCta;
    @Column(name = "PAR_CTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date parCta;
    @Column(name = "CON_IND_COOP")
    private String conIndCoop;
    @Column(name = "CON_IND_APORTE")
    private String conIndAporte;
    @Column(name = "CON_IND_COOP1")
    private String conIndCoop1;
    @Column(name = "CONCEPTO_NIT")
    private BigInteger conceptoNit;
    @Column(name = "COD_CTA_CREDITO")
    private BigInteger codCtaCredito;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "COD_CTA_OFICIALES")
    private Double codCtaOficiales;
    @Column(name = "COD_CTA_CREDITO_OFICIALES")
    @Temporal(TemporalType.TIMESTAMP)
    private Date codCtaCreditoOficiales;
    @Column(name = "PAR_CTA_OFICIALES")
    private Double parCtaOficiales;
    @Column(name = "COD_CTA_SALUD")
    private BigInteger codCtaSalud;
    @Column(name = "COD_CTA_CREDITO_SALUD")
    @Temporal(TemporalType.TIMESTAMP)
    private Date codCtaCreditoSalud;
    @Column(name = "PAR_CTA_SALUD")
    private Double parCtaSalud;
    @Column(name = "CON_ES_EMBARGO")
    private String conEsEmbargo;
    @Column(name = "CON_ES_PRIMA")
    private String conEsPrima;
    @Column(name = "CON_APORTE_PARAFISCA_OFICIAL")
    private String conAporteParafiscaOficial;
    @Column(name = "CON_PENSION")
    private String conPension;
    @Column(name = "CON_SALUD")
    private String conSalud;
    @Column(name = "CON_FON_SOL")
    private String conFonSol;
    @Basic(optional = false)
    @Column(name = "CON_LEY100_OTRO_MES")
    private String conLey100OtroMes;
    @Column(name = "CON_COBRO_ANTICIPADO_VAC")
    private String conCobroAnticipadoVac;
    @Column(name = "CPRE_ID")
    private String cpreId;
    @Column(name = "CAU_ID")
    private String cauId;
    @Column(name = "DES_ID")
    private String desId;
    @Basic(optional = false)
    @Column(name = "CON_LEY100_AGRUPADO")
    private String conLey100Agrupado;
    @Column(name = "COD_SECRE_HACIENDA")
    private Short codSecreHacienda;
    @Column(name = "CON_CODIGO_AFECTA")
    private Short conCodigoAfecta;
    @Column(name = "ENT_NIT")
    private String entNit;

 
}
