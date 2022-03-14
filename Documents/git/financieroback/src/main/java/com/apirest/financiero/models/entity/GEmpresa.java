/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@Table(name = "G_Empresa")

public class GEmpresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "EmpCod")
    private Long empCod;
    @Basic(optional = false)
    @Column(name = "EmpNom")
    private String empNom;
    @Basic(optional = false)
    @Column(name = "EmpDptCod")
    private short empDptCod;
    @Basic(optional = false)
    @Column(name = "NomOfi")
    private String nomOfi;
    @Basic(optional = false)
    @Column(name = "EmpCiuCod")
    private short empCiuCod;
    @Basic(optional = false)
    @Column(name = "CodEmpFunc")
    private Integer codEmpFunc;
    @Basic(optional = false)
    @Column(name = "EmpDir")
    private String empDir;
    @Column(name = "EmpTel1")
    private String empTel1;
    @Column(name = "EmpTel2")
    private String empTel2;
    @Basic(optional = false)
    @Column(name = "EmpWeb")
    private String empWeb;
    @Basic(optional = false)
    @Column(name = "EmpMail")
    private String empMail;
    @Lob
    @Column(name = "EmpImgEnc")
    private byte[] empImgEnc;
    @Basic(optional = false)
    @Column(name = "EmpNit")
    private String empNit;
    @Basic(optional = false)
    @Column(name = "EPpGRegAnu")
    private short ePpGRegAnu;
    @Basic(optional = false)
    @Column(name = "EPpGAdiAnu")
    private short ePpGAdiAnu;
    @Basic(optional = false)
    @Column(name = "EmpTitEnc")
    private String empTitEnc;
    @Lob
    @Column(name = "EmpLogo")
    private byte[] empLogo;
    @Basic(optional = false)
    @Column(name = "EmpCls")
    private short empCls;
    @Basic(optional = false)
    @Column(name = "EPpIIni")
    private short ePpIIni;
    @Basic(optional = false)
    @Column(name = "EPpIAdi")
    private short ePpIAdi;
    @Basic(optional = false)
    @Column(name = "EppIAdiAnu")
    private short eppIAdiAnu;
    @Basic(optional = false)
    @Column(name = "EPpIRec")
    private short ePpIRec;
    @Basic(optional = false)
    @Column(name = "EPpIRecAnu")
    private short ePpIRecAnu;
    @Basic(optional = false)
    @Column(name = "EPpICaj")
    private short ePpICaj;
    @Basic(optional = false)
    @Column(name = "EPpICajAnu")
    private short ePpICajAnu;
    @Basic(optional = false)
    @Column(name = "EmpEstado")
    private Boolean empEstado;
   
}
