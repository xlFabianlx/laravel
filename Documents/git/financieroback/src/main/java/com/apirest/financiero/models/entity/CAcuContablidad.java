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
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table(name = "C_AcuContablidad")
public class CAcuContablidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CAcuContablidadPK cAcuContablidadPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALDO")
    private BigDecimal saldo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALDO_CORRIENTE")
    private BigDecimal saldoCorriente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SALDO_NO_CORRIENTE")
    private BigDecimal saldoNoCorriente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEBITO")
    private BigDecimal debito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREDITO")
    private BigDecimal credito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEBITO_CORRIENTE")
    private BigDecimal debitoCorriente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREDITO_CORRIENTE")
    private BigDecimal creditoCorriente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DEBITO_NO_CORRIENTE")
    private BigDecimal debitoNoCorriente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CREDITO_NO_CORRIENTE")
    private BigDecimal creditoNoCorriente;

}
