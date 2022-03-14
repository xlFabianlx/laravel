package com.apirest.financiero.models.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "vigencias")
public class Vigencias implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "vigcod")
    private long vigcod;

    @Basic(optional = false)
    @NotNull
    @Column(name = "vigencia")
    private short vigencia;

    @Basic(optional = false)
    @NotNull
    @Column(name = "enabled")
    private boolean enabled;
}
