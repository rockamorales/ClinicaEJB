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
@Table(name = "cat_tipo_producto")
@NamedQueries({
    @NamedQuery(name = "CatTipoProducto.findAll", query = "SELECT c FROM CatTipoProducto c"),
    @NamedQuery(name = "CatTipoProducto.findActive", query = "SELECT c FROM CatTipoProducto c where c.actTipProducto = 1")
})
public class CatTipoProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_TIP_PRODUCTO")
    private Integer codTipProducto;
    @Column(name = "NOM_TIP_PRODUCTO")
    private String nomTipProducto;
    @Column(name = "DES_TIP_PRODUCTO")
    private String desTipProducto;
    @Column(name = "ACT_TIP_PRODUCTO")
    private Estado actTipProducto;

    public CatTipoProducto() {
    }

    public CatTipoProducto(Integer codTipProducto) {
        this.codTipProducto = codTipProducto;
    }

    public CatTipoProducto(Integer codTipProducto, String nomTipProducto, String desTipProducto, Estado actTipProducto) {
        this.codTipProducto = codTipProducto;
        this.nomTipProducto = nomTipProducto;
        this.desTipProducto = desTipProducto;
        this.actTipProducto = actTipProducto;
    }

    public Integer getCodTipProducto() {
        return codTipProducto;
    }

    public void setCodTipProducto(Integer codTipProducto) {
        this.codTipProducto = codTipProducto;
    }

    public String getNomTipProducto() {
        return nomTipProducto;
    }

    public void setNomTipProducto(String nomTipProducto) {
        this.nomTipProducto = nomTipProducto;
    }

    public String getDesTipProducto() {
        return desTipProducto;
    }

    public void setDesTipProducto(String desTipProducto) {
        this.desTipProducto = desTipProducto;
    }

    public Estado getActTipProducto() {
        return actTipProducto;
    }

    public void setActTipProducto(Estado actTipProducto) {
        this.actTipProducto = actTipProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipProducto != null ? codTipProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatTipoProducto)) {
            return false;
        }
        CatTipoProducto other = (CatTipoProducto) object;
        if ((this.codTipProducto == null && other.codTipProducto != null) || (this.codTipProducto != null && !this.codTipProducto.equals(other.codTipProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatTipoProducto[ codTipProducto=" + codTipProducto + " ]";
    }
    
}
