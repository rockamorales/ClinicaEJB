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
public class TblDetalleRequisicionPK implements Serializable {
    @Basic
    @Column(name = "NUM_PRODUCTO")
    private Integer numProducto;
    @Basic
    @Column(name = "NUM_REQUISICION")
    private Integer numRequisicion;

    public TblDetalleRequisicionPK() {
    }

    public TblDetalleRequisicionPK(int numProducto, int numRequisicion) {
        this.numProducto = numProducto;
        this.numRequisicion = numRequisicion;
    }

    public Integer getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(Integer numProducto) {
        this.numProducto = numProducto;
    }

    public Integer getNumRequisicion() {
        return numRequisicion;
    }

    public void setNumRequisicion(Integer numRequisicion) {
        this.numRequisicion = numRequisicion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numProducto;
        hash += (int) numRequisicion;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleRequisicionPK)) {
            return false;
        }
        TblDetalleRequisicionPK other = (TblDetalleRequisicionPK) object;
        if (this.numProducto != other.numProducto) {
            return false;
        }
        if (this.numRequisicion != other.numRequisicion) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblDetalleRequisicionPK[ numProducto=" + numProducto + ", numRequisicion=" + numRequisicion + " ]";
    }
    
}
