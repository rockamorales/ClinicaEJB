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
@Table(name = "cat_tipo_transaccion")
@NamedQueries({
    @NamedQuery(
        name = "CatTipoTransaccion.findAll", query = "SELECT c FROM CatTipoTransaccion c"
    ),
    @NamedQuery(
        name = "CatTipoTransaccion.findAllActive", query = "SELECT c FROM CatTipoTransaccion c where c.actTipTransaccion = 1"
    )
})
public class CatTipoTransaccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_TIP_TRANSACCION")
    private Integer codTipTransaccion;
    @Basic(optional = false)
    @NotNull(message="Ingrese el nombre del Tipo de Transacción")
    @Size(min = 1, max = 30)
    @Column(name = "NOM_TIP_TRANSACCION")
    private String nomTipTransaccion;
    @Size(max = 100)
    @Column(name = "DES_TIP_TRANSACCION")
    private String desTipTransaccion;
    @Basic(optional = false)
    @NotNull(message="Ingrese el estado del Tipo de Transacción")
    @Column(name = "ACT_TIP_TRANSACCION")
    private Estado actTipTransaccion;

    public CatTipoTransaccion() {
    }

    public CatTipoTransaccion(Integer codTipTransaccion) {
        this.codTipTransaccion = codTipTransaccion;
    }

    public CatTipoTransaccion(Integer codTipTransaccion, String nomTipTransaccion, Estado actTipTransaccion) {
        this.codTipTransaccion = codTipTransaccion;
        this.nomTipTransaccion = nomTipTransaccion;
        this.actTipTransaccion = actTipTransaccion;
    }

    public Integer getCodTipTransaccion() {
        return codTipTransaccion;
    }

    public void setCodTipTransaccion(Integer codTipTransaccion) {
        this.codTipTransaccion = codTipTransaccion;
    }

    public String getNomTipTransaccion() {
        return nomTipTransaccion;
    }

    public void setNomTipTransaccion(String nomTipTransaccion) {
        this.nomTipTransaccion = nomTipTransaccion;
    }

    public String getDesTipTransaccion() {
        return desTipTransaccion;
    }

    public void setDesTipTransaccion(String desTipTransaccion) {
        this.desTipTransaccion = desTipTransaccion;
    }

    public Estado getActTipTransaccion() {
        return actTipTransaccion;
    }

    public void setActTipTransaccion(Estado actTipTransaccion) {
        this.actTipTransaccion = actTipTransaccion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipTransaccion != null ? codTipTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatTipoTransaccion)) {
            return false;
        }
        CatTipoTransaccion other = (CatTipoTransaccion) object;
        if ((this.codTipTransaccion == null && other.codTipTransaccion != null) || (this.codTipTransaccion != null && !this.codTipTransaccion.equals(other.codTipTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatTipoTransaccion[ codTipTransaccion=" + codTipTransaccion + " ]";
    }
    
}
