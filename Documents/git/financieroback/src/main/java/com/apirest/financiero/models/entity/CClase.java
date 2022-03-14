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
@Table(name = "C_Clase")

public class CClase implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CClasePK cClasePK;
    @Basic(optional = false)
    @Column(name = "Nomcla")
    private String nomcla;
    
}
