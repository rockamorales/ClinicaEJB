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
public class TblDetalleDespachoPK implements Serializable {
    @Basic(optional = false)
    @NotNull(message = "Ingrese el número de producto")
    @Column(name = "NUM_PRODUCTO")
    private int numProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el número del despacho")
    @Column(name = "NUM_DESPACHO")
    private int numDespacho;

    public TblDetalleDespachoPK() {
    }

    public TblDetalleDespachoPK(int numProducto, int numDespacho) {
        this.numProducto = numProducto;
        this.numDespacho = numDespacho;
    }

    public int getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(int numProducto) {
        this.numProducto = numProducto;
    }

    public int getNumDespacho() {
        return numDespacho;
    }

    public void setNumDespacho(int numDespacho) {
        this.numDespacho = numDespacho;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numProducto;
        hash += (int) numDespacho;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleDespachoPK)) {
            return false;
        }
        TblDetalleDespachoPK other = (TblDetalleDespachoPK) object;
        if (this.numProducto != other.numProducto) {
            return false;
        }
        if (this.numDespacho != other.numDespacho) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.farmacia.TblDetalleDespachoPK[ numProducto=" + numProducto + ", numDespacho=" + numDespacho + " ]";
    }
    
}
