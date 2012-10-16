/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.farmacia;

import sv.com.cormaria.servicios.entidades.administracion.TblProducto;
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

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_detalle_alquiler_equipo")
@NamedQueries({
    @NamedQuery(name = "TblDetalleAlquilerEquipo.findAll", query = "SELECT t FROM TblDetalleAlquilerEquipo t")})
public class TblDetalleAlquilerEquipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblDetalleAlquilerEquipoPK tblDetalleAlquilerEquipoPK;
    @Basic(optional = false)
    @NotNull (message="Ingres el correlativo del detalle de alquiler")
    @Column(name = "COR_DET_ALQUILER")
    private int corDetAlquiler;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la cantidad del detalle de alquiler")
    @Column(name = "CAN_DET_ALQUILER")
    private int canDetAlquiler;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el precio unitario del detalle de alquiler")
    @Column(name = "PRE_UNI_DET_ALQUILER")
    private float preUniDetAlquiler;
    @JoinColumn(name = "NUM_PRODUCTO", referencedColumnName = "NUM_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblProducto tblProducto;

    public TblDetalleAlquilerEquipo() {
    }

    public TblDetalleAlquilerEquipo(TblDetalleAlquilerEquipoPK tblDetalleAlquilerEquipoPK) {
        this.tblDetalleAlquilerEquipoPK = tblDetalleAlquilerEquipoPK;
    }

    public TblDetalleAlquilerEquipo(TblDetalleAlquilerEquipoPK tblDetalleAlquilerEquipoPK, int corDetAlquiler, int canDetAlquiler, float preUniDetAlquiler) {
        this.tblDetalleAlquilerEquipoPK = tblDetalleAlquilerEquipoPK;
        this.corDetAlquiler = corDetAlquiler;
        this.canDetAlquiler = canDetAlquiler;
        this.preUniDetAlquiler = preUniDetAlquiler;
    }

    public TblDetalleAlquilerEquipo(int numSolAlquiler, int numProducto) {
        this.tblDetalleAlquilerEquipoPK = new TblDetalleAlquilerEquipoPK(numSolAlquiler, numProducto);
    }

    public TblDetalleAlquilerEquipoPK getTblDetalleAlquilerEquipoPK() {
        return tblDetalleAlquilerEquipoPK;
    }

    public void setTblDetalleAlquilerEquipoPK(TblDetalleAlquilerEquipoPK tblDetalleAlquilerEquipoPK) {
        this.tblDetalleAlquilerEquipoPK = tblDetalleAlquilerEquipoPK;
    }

    public int getCorDetAlquiler() {
        return corDetAlquiler;
    }

    public void setCorDetAlquiler(int corDetAlquiler) {
        this.corDetAlquiler = corDetAlquiler;
    }

    public int getCanDetAlquiler() {
        return canDetAlquiler;
    }

    public void setCanDetAlquiler(int canDetAlquiler) {
        this.canDetAlquiler = canDetAlquiler;
    }

    public float getPreUniDetAlquiler() {
        return preUniDetAlquiler;
    }

    public void setPreUniDetAlquiler(float preUniDetAlquiler) {
        this.preUniDetAlquiler = preUniDetAlquiler;
    }

    public TblProducto getTblProducto() {
        return tblProducto;
    }

    public void setTblProducto(TblProducto tblProducto) {
        this.tblProducto = tblProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblDetalleAlquilerEquipoPK != null ? tblDetalleAlquilerEquipoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleAlquilerEquipo)) {
            return false;
        }
        TblDetalleAlquilerEquipo other = (TblDetalleAlquilerEquipo) object;
        if ((this.tblDetalleAlquilerEquipoPK == null && other.tblDetalleAlquilerEquipoPK != null) || (this.tblDetalleAlquilerEquipoPK != null && !this.tblDetalleAlquilerEquipoPK.equals(other.tblDetalleAlquilerEquipoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.farmacia.TblDetalleAlquilerEquipo[ tblDetalleAlquilerEquipoPK=" + tblDetalleAlquilerEquipoPK + " ]";
    }
    
}
