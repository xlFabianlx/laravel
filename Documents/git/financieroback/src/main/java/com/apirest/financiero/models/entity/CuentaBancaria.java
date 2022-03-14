/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
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
@Entity
@Table(name = "CuentaBancaria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CuentaBancaria.findAll", query = "SELECT c FROM CuentaBancaria c")
    , @NamedQuery(name = "CuentaBancaria.findByEmpCod", query = "SELECT c FROM CuentaBancaria c WHERE c.cuentaBancariaPK.empCod = :empCod")
    , @NamedQuery(name = "CuentaBancaria.findByColCod", query = "SELECT c FROM CuentaBancaria c WHERE c.cuentaBancariaPK.colCod = :colCod")
    , @NamedQuery(name = "CuentaBancaria.findByCueNro", query = "SELECT c FROM CuentaBancaria c WHERE c.cuentaBancariaPK.cueNro = :cueNro")
    , @NamedQuery(name = "CuentaBancaria.findByBanCod", query = "SELECT c FROM CuentaBancaria c WHERE c.banCod = :banCod")
    , @NamedQuery(name = "CuentaBancaria.findBySucCod", query = "SELECT c FROM CuentaBancaria c WHERE c.sucCod = :sucCod")
    , @NamedQuery(name = "CuentaBancaria.findByCueCapB", query = "SELECT c FROM CuentaBancaria c WHERE c.cueCapB = :cueCapB")
    , @NamedQuery(name = "CuentaBancaria.findByNomBanCue", query = "SELECT c FROM CuentaBancaria c WHERE c.nomBanCue = :nomBanCue")
    , @NamedQuery(name = "CuentaBancaria.findByCueSalIni", query = "SELECT c FROM CuentaBancaria c WHERE c.cueSalIni = :cueSalIni")
    , @NamedQuery(name = "CuentaBancaria.findByTerCodB", query = "SELECT c FROM CuentaBancaria c WHERE c.terCodB = :terCodB")
    , @NamedQuery(name = "CuentaBancaria.findByCueRec", query = "SELECT c FROM CuentaBancaria c WHERE c.cueRec = :cueRec")
    , @NamedQuery(name = "CuentaBancaria.findByCueClsTip", query = "SELECT c FROM CuentaBancaria c WHERE c.cueClsTip = :cueClsTip")
    , @NamedQuery(name = "CuentaBancaria.findByCueNum", query = "SELECT c FROM CuentaBancaria c WHERE c.cueNum = :cueNum")
    , @NamedQuery(name = "CuentaBancaria.findByCueDsp", query = "SELECT c FROM CuentaBancaria c WHERE c.cueDsp = :cueDsp")})
public class CuentaBancaria implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CuentaBancariaPK cuentaBancariaPK;
    @Basic(optional = false)
    @Column(name = "BanCod")
    private String banCod;
    @Basic(optional = false)
    @Column(name = "SucCod")
    private short sucCod;
    @Column(name = "CueCapB")
    private String cueCapB;
    @Basic(optional = false)
    @Column(name = "NomBanCue")
    private String nomBanCue;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CueSalIni")
    private BigDecimal cueSalIni;
    @Column(name = "TerCodB")
    private Long terCodB;
    @Basic(optional = false)
    @Column(name = "CueRec")
    private short cueRec;
    @Basic(optional = false)
    @Column(name = "CueClsTip")
    private String cueClsTip;
    @Basic(optional = false)
    @Column(name = "CueNum")
    private long cueNum;
    @Basic(optional = false)
    @Column(name = "CueDsp")
    private short cueDsp;

   
}
