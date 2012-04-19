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
@Table(name = "cat_tipo_donacion")
@NamedQueries({
    @NamedQuery(name = "CatTipoDonacion.findAll", query = "SELECT c FROM CatTipoDonacion c"),
    @NamedQuery(name = "CatTipoDonacion.findActive", query = "SELECT c FROM CatTipoDonacion c WHERE c.actTipDonacion = 1")
})
public class CatTipoDonacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_TIP_DONACION")
    private Integer codTipDonacion;
    @Basic(optional = false)
    @NotNull(message="Ingrese el nombre del Tipo de Donación")
    @Size(min = 1, max = 50)
    @Column(name = "NOM_TIP_DONACION")
    private String nomTipDonacion;
    @Size(max = 100)
    @Column(name = "DES_TIP_DONACION")
    private String desTipDonacion;
    @Basic(optional = false)
    @NotNull(message="Ingrese el estado del Tipo de Donación")
    @Column(name = "ACT_TIP_DONACION")
    private Estado actTipDonacion;

    public CatTipoDonacion() {
    }

    public CatTipoDonacion(Integer codTipDonacion) {
        this.codTipDonacion = codTipDonacion;
    }

    public CatTipoDonacion(Integer codTipDonacion, String nomTipDonacion, Estado actTipDonacion) {
        this.codTipDonacion = codTipDonacion;
        this.nomTipDonacion = nomTipDonacion;
        this.actTipDonacion = actTipDonacion;
    }

    public Integer getCodTipDonacion() {
        return codTipDonacion;
    }

    public void setCodTipDonacion(Integer codTipDonacion) {
        this.codTipDonacion = codTipDonacion;
    }

    public String getNomTipDonacion() {
        return nomTipDonacion;
    }

    public void setNomTipDonacion(String nomTipDonacion) {
        this.nomTipDonacion = nomTipDonacion;
    }

    public String getDesTipDonacion() {
        return desTipDonacion;
    }

    public void setDesTipDonacion(String desTipDonacion) {
        this.desTipDonacion = desTipDonacion;
    }

    public Estado getActTipDonacion() {
        return actTipDonacion;
    }

    public void setActTipDonacion(Estado actTipDonacion) {
        this.actTipDonacion = actTipDonacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipDonacion != null ? codTipDonacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatTipoDonacion)) {
            return false;
        }
        CatTipoDonacion other = (CatTipoDonacion) object;
        if ((this.codTipDonacion == null && other.codTipDonacion != null) || (this.codTipDonacion != null && !this.codTipDonacion.equals(other.codTipDonacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatTipoDonacion[ codTipDonacion=" + codTipDonacion + " ]";
    }
    
}
