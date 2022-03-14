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
@Table(name = "P_ModPtalEnc")
public class PModPtalEnc implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PModPtalEncPK pModPtalEncPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MovEst")
    private String movEst;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MovFecAnu")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movFecAnu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MovHorAnu")
    private String movHorAnu;
    @Size(max = 256)
    @Column(name = "MovCsaAnu")
    private String movCsaAnu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MovUsuAnu")
    private String movUsuAnu;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "DecCod")
    private String decCod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MovUsu")
    private String movUsu;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Movfec")
    @Temporal(TemporalType.TIMESTAMP)
    private Date movfec;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "MovHor")
    private String movHor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "EntMovimiento")
    private String entMovimiento;
}
