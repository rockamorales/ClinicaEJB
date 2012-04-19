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

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_detalle_solicitud_donacion")
@NamedQueries({
    @NamedQuery(name = "TblDetalleSolicitudDonacion.findAll", query = "SELECT t FROM TblDetalleSolicitudDonacion t")})
public class TblDetalleSolicitudDonacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblDetalleSolicitudDonacionPK tblDetalleSolicitudDonacionPK;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el correlativo del detalle de solicitud de donacion")
    @Column(name = "COR_DET_SOL_DONACION")
    private int corDetSolDonacion;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la cantidad del detalle de solicitud de donacion")
    @Column(name = "CAN_DET_SOL_DONACION")
    private int canDetSolDonacion;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el precio unitario del detalle de donacion")
    @Column(name = "PRE_UNI_DET_SOL_DONACION")
    private float preUniDetSolDonacion;
    @JoinColumn(name = "NUM_SOL_DONACION", referencedColumnName = "NUM_SOL_DONACION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblSolicitudDonacion tblSolicitudDonacion;

    public TblDetalleSolicitudDonacion() {
    }

    public TblDetalleSolicitudDonacion(TblDetalleSolicitudDonacionPK tblDetalleSolicitudDonacionPK) {
        this.tblDetalleSolicitudDonacionPK = tblDetalleSolicitudDonacionPK;
    }

    public TblDetalleSolicitudDonacion(TblDetalleSolicitudDonacionPK tblDetalleSolicitudDonacionPK, int corDetSolDonacion, int canDetSolDonacion, float preUniDetSolDonacion) {
        this.tblDetalleSolicitudDonacionPK = tblDetalleSolicitudDonacionPK;
        this.corDetSolDonacion = corDetSolDonacion;
        this.canDetSolDonacion = canDetSolDonacion;
        this.preUniDetSolDonacion = preUniDetSolDonacion;
    }

    public TblDetalleSolicitudDonacion(int numProducto, int numSolDonacion) {
        this.tblDetalleSolicitudDonacionPK = new TblDetalleSolicitudDonacionPK(numProducto, numSolDonacion);
    }

    public TblDetalleSolicitudDonacionPK getTblDetalleSolicitudDonacionPK() {
        return tblDetalleSolicitudDonacionPK;
    }

    public void setTblDetalleSolicitudDonacionPK(TblDetalleSolicitudDonacionPK tblDetalleSolicitudDonacionPK) {
        this.tblDetalleSolicitudDonacionPK = tblDetalleSolicitudDonacionPK;
    }

    public int getCorDetSolDonacion() {
        return corDetSolDonacion;
    }

    public void setCorDetSolDonacion(int corDetSolDonacion) {
        this.corDetSolDonacion = corDetSolDonacion;
    }

    public int getCanDetSolDonacion() {
        return canDetSolDonacion;
    }

    public void setCanDetSolDonacion(int canDetSolDonacion) {
        this.canDetSolDonacion = canDetSolDonacion;
    }

    public float getPreUniDetSolDonacion() {
        return preUniDetSolDonacion;
    }

    public void setPreUniDetSolDonacion(float preUniDetSolDonacion) {
        this.preUniDetSolDonacion = preUniDetSolDonacion;
    }

    public TblSolicitudDonacion getTblSolicitudDonacion() {
        return tblSolicitudDonacion;
    }

    public void setTblSolicitudDonacion(TblSolicitudDonacion tblSolicitudDonacion) {
        this.tblSolicitudDonacion = tblSolicitudDonacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblDetalleSolicitudDonacionPK != null ? tblDetalleSolicitudDonacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleSolicitudDonacion)) {
            return false;
        }
        TblDetalleSolicitudDonacion other = (TblDetalleSolicitudDonacion) object;
        if ((this.tblDetalleSolicitudDonacionPK == null && other.tblDetalleSolicitudDonacionPK != null) || (this.tblDetalleSolicitudDonacionPK != null && !this.tblDetalleSolicitudDonacionPK.equals(other.tblDetalleSolicitudDonacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblDetalleSolicitudDonacion[ tblDetalleSolicitudDonacionPK=" + tblDetalleSolicitudDonacionPK + " ]";
    }
    
}
