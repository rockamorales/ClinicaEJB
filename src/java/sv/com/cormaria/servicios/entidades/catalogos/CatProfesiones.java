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
@Table(name = "cat_profesiones")
@NamedQueries({
    @NamedQuery(name = "CatProfesiones.findAll", query = "SELECT c FROM CatProfesiones c"),
    @NamedQuery(name = "CatProfesiones.findActive", query = "SELECT c FROM CatProfesiones c where actProfesion=1 ")
})
public class CatProfesiones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_PROFESION")
    private Integer codProfesion;
    @Basic(optional = false)
    @NotNull(message="Ingrese el nombre de la nueva Profesión")
    @Size(min = 1, max = 50)
    @Column(name = "NOM_PROFESION")
    private String nomProfesion;
    @Size(max = 100)
    @Column(name = "DES_PROFESION")
    private String desProfesion;
    @Basic(optional = false)
    @NotNull(message="Ingrese el estado de la Profesión")
    @Column(name = "ACT_PROFESION")
    private Estado actProfesion;

    public CatProfesiones() {
    }

    public CatProfesiones(Integer codProfesion) {
        this.codProfesion = codProfesion;
    }

    public CatProfesiones(Integer codProfesion, String nomProfesion, Estado actProfesion) {
        this.codProfesion = codProfesion;
        this.nomProfesion = nomProfesion;
        this.actProfesion = actProfesion;
    }

    public Integer getCodProfesion() {
        return codProfesion;
    }

    public void setCodProfesion(Integer codProfesion) {
        this.codProfesion = codProfesion;
    }

    public String getNomProfesion() {
        return nomProfesion;
    }

    public void setNomProfesion(String nomProfesion) {
        this.nomProfesion = nomProfesion;
    }

    public String getDesProfesion() {
        return desProfesion;
    }

    public void setDesProfesion(String desProfesion) {
        this.desProfesion = desProfesion;
    }

    public Estado getActProfesion() {
        return actProfesion;
    }

    public void setActProfesion(Estado actProfesion) {
        this.actProfesion = actProfesion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProfesion != null ? codProfesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatProfesiones)) {
            return false;
        }
        CatProfesiones other = (CatProfesiones) object;
        if ((this.codProfesion == null && other.codProfesion != null) || (this.codProfesion != null && !this.codProfesion.equals(other.codProfesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatProfesiones[ codProfesion=" + codProfesion + " ]";
    }
    
}
