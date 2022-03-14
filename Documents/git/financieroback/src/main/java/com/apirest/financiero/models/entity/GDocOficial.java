package com.apirest.financiero.models.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "G_DocOficial")
public class GDocOficial implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected GDocOficialPK gDocOficialPK;
    @Size(max = 150)
    @Column(name = "DecDes")
    private String decDes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Decfec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date decfec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DecTip")
    private short decTip;
}
