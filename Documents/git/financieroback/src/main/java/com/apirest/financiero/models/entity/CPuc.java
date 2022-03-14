
package com.apirest.financiero.models.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
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
@Entity
@Table(name = "C_Puc")

public class CPuc implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CPucPK cPucPK;
    @Basic(optional = false)
    @Column(name = "CueNom")
    private String cueNom;
    @Basic(optional = false)
    @Column(name = "CuePar")
    private String cuePar;
    @Basic(optional = false)
    @Column(name = "CueCon")
    private String cueCon;
    @Basic(optional = false)
    @Column(name = "CueCod")
    private String cueCod;
    @Column(name = "CueDes")
    private String cueDes;
    @Basic(optional = false)
    @Column(name = "CueDet")
    private Character cueDet;
    @Basic(optional = false)
    @Column(name = "CueTip")
    private String cueTip;
    @Basic(optional = false)
    @Column(name = "CueAju")
    private boolean cueAju;
    @Basic(optional = false)
    @Column(name = "CueCen")
    private String cueCen; 
    @Basic(optional = false)
    @Column(name = "CueBase")
    private short cueBase;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "CueVal")
    private BigDecimal cueVal;
    @Basic(optional = false)
    @Column(name = "CUEACT")
    private boolean cueact;
    @Column(name = "CueSIHO")
    private Short cueSIHO;
    @Basic(optional = false)
    @Column(name = "CueNic")
    private boolean cueNic;
    @Basic(optional = false)
    @Column(name = "CueNit")
    private String cueNit;
    @Basic(optional = false)
    @Column(name = "CueTer")
    private String cueTer;
    @Basic(optional = false)
    @Column(name = "estado")
    private boolean estado;

   
}
