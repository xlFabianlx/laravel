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
@Table(name = "P_ModPtaIngEnc")
public class PModPtaIngEnc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PModPtaIngEncPK pModPtaIngEncPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MovIHorAnu")
    private String movIHorAnu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MovIUsuAnu")
    private String movIUsuAnu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MovIFec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movIFec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MovIUsu")
    private String movIUsu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MovIHor")
    private String movIHor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MovIest")
    private String movIest;
    @Size(max = 256)
    @Column(name = "MovICsaAnu")
    private String movICsaAnu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MovIMvr")
    private Character movIMvr;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "DecCod")
    private String decCod;
}
