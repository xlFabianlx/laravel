package com.apirest.financiero.models.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
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
@Table(name = "P_FormatoRendicion")
public class PFormatoRendicion implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PFormatoRendicionPK pFormatoRendicionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "ForRenDes")
    private String forRenDes;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ForRenCod")
    private String forRenCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ForRenInd")
    private Character forRenInd;
}
