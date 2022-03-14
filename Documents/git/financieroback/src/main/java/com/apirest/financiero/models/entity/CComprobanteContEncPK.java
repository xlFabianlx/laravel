
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
public class CComprobanteContEncPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "EmpCod")
    private String empCod;
    @Basic(optional = false)
    @Column(name = "AnoCod")
    private short anoCod;
    @Basic(optional = false)
    @Column(name = "MesCod")
    private short mesCod;
    @Basic(optional = false)
    @Column(name = "DocCod")
    private short docCod;
    @Basic(optional = false)
    @Column(name = "DocNum")
    private int docNum;

   
}