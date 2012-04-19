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
@Table(name = "cat_estado_civil")
@NamedQueries({
    @NamedQuery(name = "CatEstadoCivil.findAll", query = "SELECT c FROM CatEstadoCivil c"),
    @NamedQuery(name = "CatEstadoCivil.findActive", query = "SELECT c FROM CatEstadoCivil c where actEstCivil=1 ")
})
public class CatEstadoCivil implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_EST_CIVIL")
    private Integer codEstCivil;
    @Basic(optional = false)
    @NotNull(message="Ingrese el nombre del Estado Civil")
    @Size(min = 1, max = 15)
    @Column(name = "NOM_EST_CIVIL")
    private String nomEstCivil;
    @Size(max = 100)
    @Column(name = "DES_EST_CIVIL")
    private String desEstCivil;
    @Basic(optional = false)
    @NotNull(message="Ingrese el estado de Estado Civil")
    @Column(name = "ACT_EST_CIVIL")
    private Estado actEstCivil;

    public CatEstadoCivil() {
    }

    public CatEstadoCivil(Integer codEstCivil) {
        this.codEstCivil = codEstCivil;
    }

    public CatEstadoCivil(Integer codEstCivil, String nomEstCivil, Estado actEstCivil) {
        this.codEstCivil = codEstCivil;
        this.nomEstCivil = nomEstCivil;
        this.actEstCivil = actEstCivil;
    }

    public Integer getCodEstCivil() {
        return codEstCivil;
    }

    public void setCodEstCivil(Integer codEstCivil) {
        this.codEstCivil = codEstCivil;
    }

    public String getNomEstCivil() {
        return nomEstCivil;
    }

    public void setNomEstCivil(String nomEstCivil) {
        this.nomEstCivil = nomEstCivil;
    }

    public String getDesEstCivil() {
        return desEstCivil;
    }

    public void setDesEstCivil(String desEstCivil) {
        this.desEstCivil = desEstCivil;
    }

    public Estado getActEstCivil() {
        return actEstCivil;
    }

    public void setActEstCivil(Estado actEstCivil) {
        this.actEstCivil = actEstCivil;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstCivil != null ? codEstCivil.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatEstadoCivil)) {
            return false;
        }
        CatEstadoCivil other = (CatEstadoCivil) object;
        if ((this.codEstCivil == null && other.codEstCivil != null) || (this.codEstCivil != null && !this.codEstCivil.equals(other.codEstCivil))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatEstadoCivil[ codEstCivil=" + codEstCivil + " ]";
    }
    
}
