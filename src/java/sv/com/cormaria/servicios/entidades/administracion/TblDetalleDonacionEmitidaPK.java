/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.administracion;

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
public class TblDetalleDonacionEmitidaPK implements Serializable {
    @Basic(optional = false)
    @NotNull(message = "Ingrese el numero de producto")
    @Column(name = "NUM_PRODUCTO")
    private int numProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingreso el numero de donacion")
    @Column(name = "NUM_DONACION")
    private int numDonacion;

    public TblDetalleDonacionEmitidaPK() {
    }

    public TblDetalleDonacionEmitidaPK(int numProducto, int numDonacion) {
        this.numProducto = numProducto;
        this.numDonacion = numDonacion;
    }

    public int getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(int numProducto) {
        this.numProducto = numProducto;
    }

    public int getNumDonacion() {
        return numDonacion;
    }

    public void setNumDonacion(int numDonacion) {
        this.numDonacion = numDonacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numProducto;
        hash += (int) numDonacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleDonacionEmitidaPK)) {
            return false;
        }
        TblDetalleDonacionEmitidaPK other = (TblDetalleDonacionEmitidaPK) object;
        if (this.numProducto != other.numProducto) {
            return false;
        }
        if (this.numDonacion != other.numDonacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblDetalleDonacionEmitidaPK[ numProducto=" + numProducto + ", numDonacion=" + numDonacion + " ]";
    }
    
}
