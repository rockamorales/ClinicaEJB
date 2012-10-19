/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.catalogos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import sv.com.cormaria.servicios.enums.Estado;

/**
 *
 * @author Claudia
 */
@Entity
@Table(name = "cat_parentesco_responsable")
@NamedQueries({
    @NamedQuery(name = "CatParentescoResponsable.findAll", query = "SELECT c FROM CatParentescoResponsable c"),
    @NamedQuery(name = "CatParentescoResponsable.findActive", query = "SELECT c FROM CatParentescoResponsable c where actParResponsable=1 ")
})

public class CatParentescoResponsable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_PAR_RESPONSABLE")
    private Integer codParResponsable;
    @Column(name = "NOM_PAR_RESPONSABLE")
    private String nomParResponsable;
    @Column(name = "DES_PAR_RESPONSABLE")
    private String desParResponsable;
    @Column(name = "ACT_PAR_RESPONSABLE")
    private Estado actParResponsable;

    public CatParentescoResponsable() {
    }

    public CatParentescoResponsable(Integer codParResponsable) {
        this.codParResponsable = codParResponsable;
    }

    public CatParentescoResponsable(Integer codParResponsable, String nomParResponsable, Estado actParResponsable) {
        this.codParResponsable = codParResponsable;
        this.nomParResponsable = nomParResponsable;
        this.actParResponsable = actParResponsable;
    }

    public Integer getCodParResponsable() {
        return codParResponsable;
    }

    public void setCodParResponsable(Integer codParResponsable) {
        this.codParResponsable = codParResponsable;
    }

    public String getNomParResponsable() {
        return nomParResponsable;
    }

    public void setNomParResponsable(String nomParResponsable) {
        this.nomParResponsable = nomParResponsable;
    }

    public String getDesParResponsable() {
        return desParResponsable;
    }

    public void setDesParResponsable(String desParResponsable) {
        this.desParResponsable = desParResponsable;
    }

    public Estado getActParResponsable() {
        return actParResponsable;
    }

    public void setActParResponsable(Estado actParResponsable) {
        this.actParResponsable = actParResponsable;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codParResponsable != null ? codParResponsable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatParentescoResponsable)) {
            return false;
        }
        CatParentescoResponsable other = (CatParentescoResponsable) object;
        if ((this.codParResponsable == null && other.codParResponsable != null) || (this.codParResponsable != null && !this.codParResponsable.equals(other.codParResponsable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatParentescoResponsable[ codParResponsable=" + codParResponsable + " ]";
    }
    
}
