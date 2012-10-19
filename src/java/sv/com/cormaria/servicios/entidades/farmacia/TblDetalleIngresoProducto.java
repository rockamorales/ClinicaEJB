/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.farmacia;

import sv.com.cormaria.servicios.entidades.administracion.TblProducto;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_detalle_ingreso_producto")
@NamedQueries({
    @NamedQuery(name = "TblDetalleIngresoProducto.findAll", query = "SELECT t FROM TblDetalleIngresoProducto t")})
public class TblDetalleIngresoProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblDetalleIngresoProductoPK tblDetalleIngresoProductoPK;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el correlativo del detalle de ingreso")
    @Column(name = "COR_DET_INGRESO")
    private int corDetIngreso;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la cantidad del detalle de Ingreso")
    @Column(name = "CAN_DET_INGRESO")
    private int canDetIngreso;
    @Basic(optional = false)
    @NotNull(message = "Inrese el costo unitario del detalle de ingreso")
    @Column(name = "COS_UNI_DET_INGRESO")
    private float cosUniDetIngreso;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la fecha de expiracion del detalle de ingreso")
    @Column(name = "FEC_EXP_DET_INGRESO")
    @Temporal(TemporalType.DATE)
    private Date fecExpDetIngreso;
    @JoinColumn(name = "NUM_INGRESO", referencedColumnName = "NUM_INGRESO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblIngresosProducto tblIngresosProducto;
    @JoinColumn(name = "NUM_PRODUCTO", referencedColumnName = "NUM_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblProducto tblProducto;

    public TblDetalleIngresoProducto() {
    }

    public TblDetalleIngresoProducto(TblDetalleIngresoProductoPK tblDetalleIngresoProductoPK) {
        this.tblDetalleIngresoProductoPK = tblDetalleIngresoProductoPK;
    }

    public TblDetalleIngresoProducto(TblDetalleIngresoProductoPK tblDetalleIngresoProductoPK, int corDetIngreso, int canDetIngreso, float cosUniDetIngreso, Date fecExpDetIngreso) {
        this.tblDetalleIngresoProductoPK = tblDetalleIngresoProductoPK;
        this.corDetIngreso = corDetIngreso;
        this.canDetIngreso = canDetIngreso;
        this.cosUniDetIngreso = cosUniDetIngreso;
        this.fecExpDetIngreso = fecExpDetIngreso;
    }

    public TblDetalleIngresoProducto(int numProducto, int numIngreso) {
        this.tblDetalleIngresoProductoPK = new TblDetalleIngresoProductoPK(numProducto, numIngreso);
    }

    public TblDetalleIngresoProductoPK getTblDetalleIngresoProductoPK() {
        return tblDetalleIngresoProductoPK;
    }

    public void setTblDetalleIngresoProductoPK(TblDetalleIngresoProductoPK tblDetalleIngresoProductoPK) {
        this.tblDetalleIngresoProductoPK = tblDetalleIngresoProductoPK;
    }

    public int getCorDetIngreso() {
        return corDetIngreso;
    }

    public void setCorDetIngreso(int corDetIngreso) {
        this.corDetIngreso = corDetIngreso;
    }

    public int getCanDetIngreso() {
        return canDetIngreso;
    }

    public void setCanDetIngreso(int canDetIngreso) {
        this.canDetIngreso = canDetIngreso;
    }

    public float getCosUniDetIngreso() {
        return cosUniDetIngreso;
    }

    public void setCosUniDetIngreso(float cosUniDetIngreso) {
        this.cosUniDetIngreso = cosUniDetIngreso;
    }

    public Date getFecExpDetIngreso() {
        return fecExpDetIngreso;
    }

    public void setFecExpDetIngreso(Date fecExpDetIngreso) {
        this.fecExpDetIngreso = fecExpDetIngreso;
    }

    public TblIngresosProducto getTblIngresosProducto() {
        return tblIngresosProducto;
    }

    public void setTblIngresosProducto(TblIngresosProducto tblIngresosProducto) {
        this.tblIngresosProducto = tblIngresosProducto;
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
        hash += (tblDetalleIngresoProductoPK != null ? tblDetalleIngresoProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleIngresoProducto)) {
            return false;
        }
        TblDetalleIngresoProducto other = (TblDetalleIngresoProducto) object;
        if ((this.tblDetalleIngresoProductoPK == null && other.tblDetalleIngresoProductoPK != null) || (this.tblDetalleIngresoProductoPK != null && !this.tblDetalleIngresoProductoPK.equals(other.tblDetalleIngresoProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.farmacia.TblDetalleIngresoProducto[ tblDetalleIngresoProductoPK=" + tblDetalleIngresoProductoPK + " ]";
    }
    
}
