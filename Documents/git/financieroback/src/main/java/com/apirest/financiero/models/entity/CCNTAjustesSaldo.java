package com.apirest.financiero.models.entity;

import java.io.Serializable;
import java.util.Date;

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
@Table(name ="CNT_AjustesSaldo")

public class CCNTAjustesSaldo implements Serializable{
    
    // private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Basic(optional = false)
    @Column(name = "TipoDoc")
    private int tipoDoc;

    @Basic(optional = false)
    @Column(name = "NoCompro")
    private int nocompro;

    @Basic(optional = false)
    @Column(name = "FechaCompro")
    private Date fechacompro;

    @Basic(optional = false)
    @Column(name = "CoCompro")
    private String cocompro;

    @Basic(optional = false)
    @Column(name = "Debito")
    private int debito;

    @Basic(optional = false)
    @Column(name = "Credito")
    private int credito;

    @Basic(optional = false)
    @Column(name = "TipCompro")
    private String tipcompro;

    @Basic(optional = false)
    @Column(name = "CenCost")
    private String cencost;

}
