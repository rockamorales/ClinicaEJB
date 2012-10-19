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
@Table(name = "cat_tipo_servicio")
@NamedQueries({
    @NamedQuery(name = "CatTipoServicio.findAll", query = "SELECT c FROM CatTipoServicio c"),
    @NamedQuery(name = "CatTipoServicio.findActive", query = "SELECT c FROM CatTipoServicio c WHERE c.actTipServicio = 1")
})
public class CatTipoServicio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_TIP_SERVICIO")
    private Integer codTipServicio;
    @Column(name = "NOM_TIP_SERVICIO")
    private String nomTipServicio;
    @Column(name = "DES_TIP_SERVICIO")
    private String desTipServicio;
    @Column(name = "ACT_TIP_SERVICIO")
    private Estado actTipServicio;

    public CatTipoServicio() {
    }

    public CatTipoServicio(Integer codTipServicio) {
        this.codTipServicio = codTipServicio;
    }

    public CatTipoServicio(Integer codTipServicio, String nomTipServicio, Estado actTipServicio) {
        this.codTipServicio = codTipServicio;
        this.nomTipServicio = nomTipServicio;
        this.actTipServicio = actTipServicio;
    }

    public Integer getCodTipServicio() {
        return codTipServicio;
    }

    public void setCodTipServicio(Integer codTipServicio) {
        this.codTipServicio = codTipServicio;
    }

    public String getNomTipServicio() {
        return nomTipServicio;
    }

    public void setNomTipServicio(String nomTipServicio) {
        this.nomTipServicio = nomTipServicio;
    }

    public String getDesTipServicio() {
        return desTipServicio;
    }

    public void setDesTipServicio(String desTipServicio) {
        this.desTipServicio = desTipServicio;
    }

    public Estado getActTipServicio() {
        return actTipServicio;
    }

    public void setActTipServicio(Estado actTipServicio) {
        this.actTipServicio = actTipServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipServicio != null ? codTipServicio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatTipoServicio)) {
            return false;
        }
        CatTipoServicio other = (CatTipoServicio) object;
        if ((this.codTipServicio == null && other.codTipServicio != null) || (this.codTipServicio != null && !this.codTipServicio.equals(other.codTipServicio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatTipoServicio[ codTipServicio=" + codTipServicio + " ]";
    }
    
}
