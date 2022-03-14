package com.apirest.financiero.models.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Embeddable
public class PModPtalDetPK implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "EmpCod")
    private String empCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "AnoCod")
    private short anoCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MovTip")
    private short movTip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MovNum")
    private int movNum;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "CtaCod")
    private String ctaCod;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FueCod")
    private short fueCod;
}
