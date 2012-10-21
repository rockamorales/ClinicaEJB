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
    private Integer numSolAlquiler;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el número del producto")
    @Column(name = "NUM_PRODUCTO")
    private Integer numProducto;

    public TblDetalleAlquilerEquipoPK() {
    }

    public TblDetalleAlquilerEquipoPK(Integer numSolAlquiler, Integer numProducto) {
        this.numSolAlquiler = numSolAlquiler;
        this.numProducto = numProducto;
    }

    public Integer getNumSolAlquiler() {
        return numSolAlquiler;
    }

    public void setNumSolAlquiler(Integer numSolAlquiler) {
        this.numSolAlquiler = numSolAlquiler;
    }

    public Integer getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(Integer numProducto) {
        this.numProducto = numProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (Integer) numSolAlquiler;
        hash += (Integer) numProducto;
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
