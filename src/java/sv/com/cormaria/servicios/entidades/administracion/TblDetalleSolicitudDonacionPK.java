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
public class TblDetalleSolicitudDonacionPK implements Serializable {
    @Basic(optional = false)
    @NotNull(message = "Ingrese el numero del producto")
    @Column(name = "NUM_PRODUCTO")
    private int numProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el numero de solicitud de donacion")
    @Column(name = "NUM_SOL_DONACION")
    private int numSolDonacion;

    public TblDetalleSolicitudDonacionPK() {
    }

    public TblDetalleSolicitudDonacionPK(int numProducto, int numSolDonacion) {
        this.numProducto = numProducto;
        this.numSolDonacion = numSolDonacion;
    }

    public int getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(int numProducto) {
        this.numProducto = numProducto;
    }

    public int getNumSolDonacion() {
        return numSolDonacion;
    }

    public void setNumSolDonacion(int numSolDonacion) {
        this.numSolDonacion = numSolDonacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numProducto;
        hash += (int) numSolDonacion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleSolicitudDonacionPK)) {
            return false;
        }
        TblDetalleSolicitudDonacionPK other = (TblDetalleSolicitudDonacionPK) object;
        if (this.numProducto != other.numProducto) {
            return false;
        }
        if (this.numSolDonacion != other.numSolDonacion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblDetalleSolicitudDonacionPK[ numProducto=" + numProducto + ", numSolDonacion=" + numSolDonacion + " ]";
    }
    
}
