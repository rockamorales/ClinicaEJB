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
public class TblDetalleAlquilerEquipoPK implements Serializable {
    @Basic(optional = false)
    @NotNull (message = "Ingrese el número de la solicitud de alquiler")
    @Column(name = "NUM_SOL_ALQUILER")
    private int numSolAlquiler;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el número del producto")
    @Column(name = "NUM_PRODUCTO")
    private int numProducto;

    public TblDetalleAlquilerEquipoPK() {
    }

    public TblDetalleAlquilerEquipoPK(int numSolAlquiler, int numProducto) {
        this.numSolAlquiler = numSolAlquiler;
        this.numProducto = numProducto;
    }

    public int getNumSolAlquiler() {
        return numSolAlquiler;
    }

    public void setNumSolAlquiler(int numSolAlquiler) {
        this.numSolAlquiler = numSolAlquiler;
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
        hash += (int) numSolAlquiler;
        hash += (int) numProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleAlquilerEquipoPK)) {
            return false;
        }
        TblDetalleAlquilerEquipoPK other = (TblDetalleAlquilerEquipoPK) object;
        if (this.numSolAlquiler != other.numSolAlquiler) {
            return false;
        }
        if (this.numProducto != other.numProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.farmacia.TblDetalleAlquilerEquipoPK[ numSolAlquiler=" + numSolAlquiler + ", numProducto=" + numProducto + " ]";
    }
    
}
