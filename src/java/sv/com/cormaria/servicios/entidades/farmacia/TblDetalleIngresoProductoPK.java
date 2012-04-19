/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.farmacia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mackk
 */
@Embeddable
public class TblDetalleIngresoProductoPK implements Serializable {
    @Basic(optional = false)
    @NotNull(message = "Ingrese el número de producto")
    @Column(name = "NUM_PRODUCTO")
    private int numProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el número de ingreso")
    @Column(name = "NUM_INGRESO")
    private int numIngreso;

    public TblDetalleIngresoProductoPK() {
    }

    public TblDetalleIngresoProductoPK(int numProducto, int numIngreso) {
        this.numProducto = numProducto;
        this.numIngreso = numIngreso;
    }

    public int getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(int numProducto) {
        this.numProducto = numProducto;
    }

    public int getNumIngreso() {
        return numIngreso;
    }

    public void setNumIngreso(int numIngreso) {
        this.numIngreso = numIngreso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numProducto;
        hash += (int) numIngreso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleIngresoProductoPK)) {
            return false;
        }
        TblDetalleIngresoProductoPK other = (TblDetalleIngresoProductoPK) object;
        if (this.numProducto != other.numProducto) {
            return false;
        }
        if (this.numIngreso != other.numIngreso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.farmacia.TblDetalleIngresoProductoPK[ numProducto=" + numProducto + ", numIngreso=" + numIngreso + " ]";
    }
    
}
