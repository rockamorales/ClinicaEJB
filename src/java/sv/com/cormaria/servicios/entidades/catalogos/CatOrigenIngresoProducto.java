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
@Table(name = "cat_origen_ingreso_producto")
@NamedQueries({
    @NamedQuery(name = "CatOrigenIngresoProducto.findAll", query = "SELECT c FROM CatOrigenIngresoProducto c "),
    @NamedQuery(name = "CatOrigenIngresoProducto.findActive", query = "SELECT c FROM CatOrigenIngresoProducto c where c.actOriIngreso = 1")
})
public class CatOrigenIngresoProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_ORI_INGRESO")
    private Integer codOriIngreso;
    @Column(name = "NOM_ORI_INGRESO")
    private String nomOriIngreso;
    @Column(name = "DES_ORI_INGRESO")
    private String desOriIngreso;
    @Column(name = "ACT_ORI_INGRESO")
    private Estado actOriIngreso;

    public CatOrigenIngresoProducto() {
    }

    public CatOrigenIngresoProducto(Integer codOriIngreso) {
        this.codOriIngreso = codOriIngreso;
    }

    public CatOrigenIngresoProducto(Integer codOriIngreso, String nomOriIngreso, Estado actOriIngreso) {
        this.codOriIngreso = codOriIngreso;
        this.nomOriIngreso = nomOriIngreso;
        this.actOriIngreso = actOriIngreso;
    }

    public Integer getCodOriIngreso() {
        return codOriIngreso;
    }

    public void setCodOriIngreso(Integer codOriIngreso) {
        this.codOriIngreso = codOriIngreso;
    }

    public String getNomOriIngreso() {
        return nomOriIngreso;
    }

    public void setNomOriIngreso(String nomOriIngreso) {
        this.nomOriIngreso = nomOriIngreso;
    }

    public String getDesOriIngreso() {
        return desOriIngreso;
    }

    public void setDesOriIngreso(String desOriIngreso) {
        this.desOriIngreso = desOriIngreso;
    }

    public Estado getActOriIngreso() {
        return actOriIngreso;
    }

    public void setActOriIngreso(Estado actOriIngreso) {
        this.actOriIngreso = actOriIngreso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codOriIngreso != null ? codOriIngreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatOrigenIngresoProducto)) {
            return false;
        }
        CatOrigenIngresoProducto other = (CatOrigenIngresoProducto) object;
        if ((this.codOriIngreso == null && other.codOriIngreso != null) || (this.codOriIngreso != null && !this.codOriIngreso.equals(other.codOriIngreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatOrigenIngresoProducto[ codOriIngreso=" + codOriIngreso + " ]";
    }
    
}
