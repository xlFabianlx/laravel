package com.apirest.financiero.models.entity;

import javax.persistence.Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;

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
@Table(name = "C_TipoUso")

public class CTipoUso implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CTipoUsoPK cTipoUsoPK;
    @Basic(optional = false)
    @Column(name = "TipNom")
    private String tipNom;
    
}