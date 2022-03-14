package com.apirest.financiero.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "P_CertDispPtalDet")
public class PCertDispPtalDet implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PCertDispPtalDetPK pCertDispPtalDetPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetCdpVlr")
    private BigDecimal detCdpVlr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetComp")
    private BigDecimal detComp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DetLibr")
    private BigDecimal detLibr;
}
