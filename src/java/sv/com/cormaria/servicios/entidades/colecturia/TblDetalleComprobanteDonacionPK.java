/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.colecturia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Mackk
 */
@Embeddable
public class TblDetalleComprobanteDonacionPK implements Serializable {
    @Basic
    @Column(name = "NUM_COM_DONACION")
    private int numComDonacion;
    @Basic
    @Column(name = "NUM_PRODUCTO")
    private int numProducto;

    public TblDetalleComprobanteDonacionPK() {
    }

    public TblDetalleComprobanteDonacionPK(int numComDonacion, int numProducto) {
        this.numComDonacion = numComDonacion;
        this.numProducto = numProducto;
    }

    public int getNumComDonacion() {
        return numComDonacion;
    }

    public void setNumComDonacion(int numComDonacion) {
        this.numComDonacion = numComDonacion;
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
        hash += (int) numComDonacion;
        hash += (int) numProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleComprobanteDonacionPK)) {
            return false;
        }
        TblDetalleComprobanteDonacionPK other = (TblDetalleComprobanteDonacionPK) object;
        if (this.numComDonacion != other.numComDonacion) {
            return false;
        }
        if (this.numProducto != other.numProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.colecturia.TblDetalleComprobanteDonacionPK[ numComDonacion=" + numComDonacion + ", numProducto=" + numProducto + " ]";
    }
    
}
