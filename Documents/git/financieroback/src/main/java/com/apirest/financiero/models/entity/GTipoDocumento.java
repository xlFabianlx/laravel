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
@Table(name = "G_TipoDocumento")
public class GTipoDocumento {
    @Id
    @Basic(optional = false)
    @Column(name = "idDocumento")
    private Long idDocumento;
    @Basic(optional = false)
    @Column(name = "NombreDocumento")
    private String NombreDocumento;
}
