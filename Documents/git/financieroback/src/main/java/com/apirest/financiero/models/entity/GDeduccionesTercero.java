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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "G_DeduccionesTercero")
public class GDeduccionesTercero implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idDeduccionTercero")
    private Long idDeduccionTercero;
    @JoinColumn(name = "idTercero", referencedColumnName = "TerCod")
    @ManyToOne(optional = false)
    private GTerceroPtal idTercero;
    @JoinColumn(name = "idDeduccion", referencedColumnName = "DedCod")
    @ManyToOne(optional = false)
    private CDeduccion idDeduccion;
} 
