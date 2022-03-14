
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
public class PANecesidadesAdicionalesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "AnoCod")
    private short anoCod;
    @Basic(optional = false)
    @Column(name = "PaaNecCod")
    private long paaNecCod;


}
