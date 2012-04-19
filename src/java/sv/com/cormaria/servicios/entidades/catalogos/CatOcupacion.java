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
@Table(name = "cat_ocupacion")
@NamedQueries({
    @NamedQuery(name = "CatOcupacion.findAll", query = "SELECT c FROM CatOcupacion c"),
    @NamedQuery(name = "CatOcupacion.findActive", query = "SELECT c FROM CatOcupacion c where actOcupacion=1 ")
})
public class CatOcupacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    
    @Column(name = "COD_OCUPACION")
    private Integer codOcupacion;
    @Basic(optional = false)
    @NotNull(message="Ingrese el nombre de la Ocupación")
    @Size(min = 1, max = 100)
    @Column(name = "NOM_OCUPACION")
    private String nomOcupacion;
    @Size(max = 100)
    @Column(name = "DES_OCUPACION")
    private String desOcupacion;
    @Basic(optional = false)
    @NotNull(message="Ingrese el estado de Ocupación")
    @Column(name = "ACT_OCUPACION")
    private Estado actOcupacion;

    public CatOcupacion() {
    }

    public CatOcupacion(Integer codOcupacion) {
        this.codOcupacion = codOcupacion;
    }

    public CatOcupacion(Integer codOcupacion, String nomOcupacion, Estado actOcupacion) {
        this.codOcupacion = codOcupacion;
        this.nomOcupacion = nomOcupacion;
        this.actOcupacion = actOcupacion;
    }

    public Integer getCodOcupacion() {
        return codOcupacion;
    }

    public void setCodOcupacion(Integer codOcupacion) {
        this.codOcupacion = codOcupacion;
    }

    public String getNomOcupacion() {
        return nomOcupacion;
    }

    public void setNomOcupacion(String nomOcupacion) {
        this.nomOcupacion = nomOcupacion;
    }

    public String getDesOcupacion() {
        return desOcupacion;
    }

    public void setDesOcupacion(String desOcupacion) {
        this.desOcupacion = desOcupacion;
    }

    public Estado getActOcupacion() {
        return actOcupacion;
    }

    public void setActOcupacion(Estado actOcupacion) {
        this.actOcupacion = actOcupacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codOcupacion != null ? codOcupacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatOcupacion)) {
            return false;
        }
        CatOcupacion other = (CatOcupacion) object;
        if ((this.codOcupacion == null && other.codOcupacion != null) || (this.codOcupacion != null && !this.codOcupacion.equals(other.codOcupacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatOcupacion[ codOcupacion=" + codOcupacion + " ]";
    }
    
}
