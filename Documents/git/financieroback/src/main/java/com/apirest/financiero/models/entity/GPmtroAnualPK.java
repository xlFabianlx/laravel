/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apirest.financiero.models.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 *
 * @author jonathan mendoza
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Embeddable
public class GPmtroAnualPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "ParaEmpCod")
    private String paraEmpCod;
    @Basic(optional = false)
    @Column(name = "ParaColCod")
    private short paraColCod;
    @Basic(optional = false)
    @Column(name = "ParaAnoCod")
    private short paraAnoCod;
    @Basic(optional = false)
    @Column(name = "ParaCod")
    private String paraCod;

   
}
