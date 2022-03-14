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
public class GSiaModificacionesIngresoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "EmpCod")
    private String empCod;
    @Basic(optional = false)
    @Column(name = "AnoCod")
    private short anoCod;
    @Basic(optional = false)
    @Column(name = "SiaModiIngresoCod")
    private int siaModiIngresoCod;
    @Basic(optional = false)
    @Column(name = "SiaModiIPer")
    private short siaModiIPer;

   
}
