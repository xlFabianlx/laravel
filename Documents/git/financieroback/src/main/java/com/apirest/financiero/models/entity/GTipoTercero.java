package com.apirest.financiero.models.entity;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "G_TipoTercero")
public class GTipoTercero {
    @Id
    @Basic(optional = false)
    @Column(name = "idPersona")
    private Long idPersona;
    @Basic(optional = false)
    @Column(name = "NombrePersona")
    private String NombrePersona;    
}
