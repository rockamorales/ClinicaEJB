/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.consultasmedicas;

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
public class TblDetalleRecetaPK implements Serializable {
    @Column(name = "NUM_RECETA")
    private int numReceta;
    @Column(name = "NUM_PRODUCTO")
    private int numProducto;

    public TblDetalleRecetaPK() {
    }

    public TblDetalleRecetaPK(int numReceta, int numProducto) {
        this.numReceta = numReceta;
        this.numProducto = numProducto;
    }

    public int getNumReceta() {
        return numReceta;
    }

    public void setNumReceta(int numReceta) {
        this.numReceta = numReceta;
    }

    public int getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(int numProducto) {
        this.numProducto = numProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numReceta;
        hash += (int) numProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleRecetaPK)) {
            return false;
        }
        TblDetalleRecetaPK other = (TblDetalleRecetaPK) object;
        if (this.numReceta != other.numReceta) {
            return false;
        }
        if (this.numProducto != other.numProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.consultasmedicas.TblDetalleRecetaPK[ numReceta=" + numReceta + ", numProducto=" + numProducto + " ]";
    }
    
}
