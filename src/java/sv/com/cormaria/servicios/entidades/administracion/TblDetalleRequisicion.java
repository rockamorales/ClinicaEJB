/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.administracion;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_detalle_requisicion")
@NamedQueries({
    @NamedQuery(name = "TblDetalleRequisicion.findAll", query = "SELECT t FROM TblDetalleRequisicion t")})
public class TblDetalleRequisicion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblDetalleRequisicionPK tblDetalleRequisicionPK;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el correlativo de detalle de producto")
    @Column(name = "COR_DET_PRODUCTO")
    private long corDetProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la cantidad de producto")
    @Column(name = "CAN_PRO_REQUISICION")
    private int canProRequisicion;
    @Size(max = 500, message = "El detalle de uso de la requisicion no debe ser mayor de 500 caracteres")
    @Column(name = "DET_USO_REQUISICION")
    private String detUsoRequisicion;
    @JoinColumn(name = "NUM_REQUISICION", referencedColumnName = "NUM_REQUISICION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblRequisiciones tblRequisiciones;

    public TblDetalleRequisicion() {
    }

    public TblDetalleRequisicion(TblDetalleRequisicionPK tblDetalleRequisicionPK) {
        this.tblDetalleRequisicionPK = tblDetalleRequisicionPK;
    }

    public TblDetalleRequisicion(TblDetalleRequisicionPK tblDetalleRequisicionPK, long corDetProducto, int canProRequisicion) {
        this.tblDetalleRequisicionPK = tblDetalleRequisicionPK;
        this.corDetProducto = corDetProducto;
        this.canProRequisicion = canProRequisicion;
    }

    public TblDetalleRequisicion(int numProducto, int numRequisicion) {
        this.tblDetalleRequisicionPK = new TblDetalleRequisicionPK(numProducto, numRequisicion);
    }

    public TblDetalleRequisicionPK getTblDetalleRequisicionPK() {
        return tblDetalleRequisicionPK;
    }

    public void setTblDetalleRequisicionPK(TblDetalleRequisicionPK tblDetalleRequisicionPK) {
        this.tblDetalleRequisicionPK = tblDetalleRequisicionPK;
    }

    public long getCorDetProducto() {
        return corDetProducto;
    }

    public void setCorDetProducto(long corDetProducto) {
        this.corDetProducto = corDetProducto;
    }

    public int getCanProRequisicion() {
        return canProRequisicion;
    }

    public void setCanProRequisicion(int canProRequisicion) {
        this.canProRequisicion = canProRequisicion;
    }

    public String getDetUsoRequisicion() {
        return detUsoRequisicion;
    }

    public void setDetUsoRequisicion(String detUsoRequisicion) {
        this.detUsoRequisicion = detUsoRequisicion;
    }

    public TblRequisiciones getTblRequisiciones() {
        return tblRequisiciones;
    }

    public void setTblRequisiciones(TblRequisiciones tblRequisiciones) {
        this.tblRequisiciones = tblRequisiciones;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblDetalleRequisicionPK != null ? tblDetalleRequisicionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleRequisicion)) {
            return false;
        }
        TblDetalleRequisicion other = (TblDetalleRequisicion) object;
        if ((this.tblDetalleRequisicionPK == null && other.tblDetalleRequisicionPK != null) || (this.tblDetalleRequisicionPK != null && !this.tblDetalleRequisicionPK.equals(other.tblDetalleRequisicionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblDetalleRequisicion[ tblDetalleRequisicionPK=" + tblDetalleRequisicionPK + " ]";
    }
    
}
