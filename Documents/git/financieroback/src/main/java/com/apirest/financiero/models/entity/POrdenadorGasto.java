package com.apirest.financiero.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "P_OrdenadorGasto")
public class POrdenadorGasto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "OrdCod")
    private String ordCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "OrdNom")
    private String ordNom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrdCgo")
    private short ordCgo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrdFecIn")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordFecIn;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrdFecFi")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ordFecFi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "UniEjeOrd")
    private short uniEjeOrd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "UniEjeNmOrd")
    private String uniEjeNmOrd;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "FuncCod")
    private String funcCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "OrdCgoNom")
    private String ordCgoNom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Consecutivo")
    private short consecutivo;
}
