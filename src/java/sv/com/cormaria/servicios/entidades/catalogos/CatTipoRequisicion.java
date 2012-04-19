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
@Table(name = "cat_tipo_requisicion")
@NamedQueries({
    @NamedQuery(name = "CatTipoRequisicion.findAll", query = "SELECT c FROM CatTipoRequisicion c"),
    @NamedQuery(name = "CatTipoRequisicion.findActive", query = "SELECT c FROM CatTipoRequisicion c where actTipRequisicion=1 ")
})

public class CatTipoRequisicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_TIP_REQUISICION")
    private Integer codTipRequisicion;
    @Basic(optional = false)
    @NotNull(message="Ingrese el nombre del Tipo de Requisición")
    @Size(min = 1, max = 30)
    @Column(name = "NOM_TIP_REQUISICION")
    private String nomTipRequisicion;
    @Size(max = 100)
    @Column(name = "DES_TIP_REQUISICION")
    private String desTipRequisicion;
    @Basic(optional = false)
    @NotNull(message="Ingrese el estado del Tipo de Requisición")
    @Column(name = "ACT_TIP_REQUISICION")
    private Estado actTipRequisicion;

    public CatTipoRequisicion() {
    }

    public CatTipoRequisicion(Integer codTipRequisicion) {
        this.codTipRequisicion = codTipRequisicion;
    }

    public CatTipoRequisicion(Integer codTipRequisicion, String nomTipRequisicion, Estado actTipRequisicion) {
        this.codTipRequisicion = codTipRequisicion;
        this.nomTipRequisicion = nomTipRequisicion;
        this.actTipRequisicion = actTipRequisicion;
    }

    public Integer getCodTipRequisicion() {
        return codTipRequisicion;
    }

    public void setCodTipRequisicion(Integer codTipRequisicion) {
        this.codTipRequisicion = codTipRequisicion;
    }

    public String getNomTipRequisicion() {
        return nomTipRequisicion;
    }

    public void setNomTipRequisicion(String nomTipRequisicion) {
        this.nomTipRequisicion = nomTipRequisicion;
    }

    public String getDesTipRequisicion() {
        return desTipRequisicion;
    }

    public void setDesTipRequisicion(String desTipRequisicion) {
        this.desTipRequisicion = desTipRequisicion;
    }

    public Estado getActTipRequisicion() {
        return actTipRequisicion;
    }

    public void setActTipRequisicion(Estado actTipRequisicion) {
        this.actTipRequisicion = actTipRequisicion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipRequisicion != null ? codTipRequisicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatTipoRequisicion)) {
            return false;
        }
        CatTipoRequisicion other = (CatTipoRequisicion) object;
        if ((this.codTipRequisicion == null && other.codTipRequisicion != null) || (this.codTipRequisicion != null && !this.codTipRequisicion.equals(other.codTipRequisicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatTipoRequisicion[ codTipRequisicion=" + codTipRequisicion + " ]";
    }
    
}
