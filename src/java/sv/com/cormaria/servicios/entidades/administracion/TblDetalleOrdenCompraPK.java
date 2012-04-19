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
public class TblDetalleOrdenCompraPK implements Serializable {
    @Basic(optional = false)
    @NotNull(message = "Ingrese el numbero de producto")
    @Column(name = "NUM_PRODUCTO")
    private int numProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el numero de orden de compra")
    @Column(name = "NUM_ORD_COMPRA")
    private int numOrdCompra;

    public TblDetalleOrdenCompraPK() {
    }

    public TblDetalleOrdenCompraPK(int numProducto, int numOrdCompra) {
        this.numProducto = numProducto;
        this.numOrdCompra = numOrdCompra;
    }

    public int getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(int numProducto) {
        this.numProducto = numProducto;
    }

    public int getNumOrdCompra() {
        return numOrdCompra;
    }

    public void setNumOrdCompra(int numOrdCompra) {
        this.numOrdCompra = numOrdCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numProducto;
        hash += (int) numOrdCompra;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleOrdenCompraPK)) {
            return false;
        }
        TblDetalleOrdenCompraPK other = (TblDetalleOrdenCompraPK) object;
        if (this.numProducto != other.numProducto) {
            return false;
        }
        if (this.numOrdCompra != other.numOrdCompra) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblDetalleOrdenCompraPK[ numProducto=" + numProducto + ", numOrdCompra=" + numOrdCompra + " ]";
    }
    
}
