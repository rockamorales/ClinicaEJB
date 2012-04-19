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
public class TblDetalleTrasladoProductosPK implements Serializable {
    @Basic(optional = false)
    @NotNull(message = "Ingrese el número de producto")
    @Column(name = "NUM_PRODUCTO")
    private int numProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el número de traslado")
    @Column(name = "NUM_TRASLADO")
    private int numTraslado;

    public TblDetalleTrasladoProductosPK() {
    }

    public TblDetalleTrasladoProductosPK(int numProducto, int numTraslado) {
        this.numProducto = numProducto;
        this.numTraslado = numTraslado;
    }

    public int getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(int numProducto) {
        this.numProducto = numProducto;
    }

    public int getNumTraslado() {
        return numTraslado;
    }

    public void setNumTraslado(int numTraslado) {
        this.numTraslado = numTraslado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numProducto;
        hash += (int) numTraslado;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleTrasladoProductosPK)) {
            return false;
        }
        TblDetalleTrasladoProductosPK other = (TblDetalleTrasladoProductosPK) object;
        if (this.numProducto != other.numProducto) {
            return false;
        }
        if (this.numTraslado != other.numTraslado) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.farmacia.TblDetalleTrasladoProductosPK[ numProducto=" + numProducto + ", numTraslado=" + numTraslado + " ]";
    }
    
}
