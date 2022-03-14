
package com.apirest.financiero.models.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

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
@Entity
@Table(name = "PT_Rubro_Fuente")
public class PTRubroFuente implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PTRubroFuentePK pTRubroFuentePK;


    
}
