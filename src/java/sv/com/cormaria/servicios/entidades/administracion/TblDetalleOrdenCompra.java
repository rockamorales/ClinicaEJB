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
@Table(name = "tbl_detalle_orden_compra")
@NamedQueries({
    @NamedQuery(name = "TblDetalleOrdenCompra.findAll", query = "SELECT t FROM TblDetalleOrdenCompra t")})
public class TblDetalleOrdenCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblDetalleOrdenCompraPK tblDetalleOrdenCompraPK;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el correlativo del detalle de orden de compra")
    @Column(name = "COR_DET_ORD_COMPRA")
    private int corDetOrdCompra;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la cantidad del detalle de orden de compra")
    @Column(name = "CAN_DET_ORD_COMPRA")
    private int canDetOrdCompra;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el presio unitario del detalle de orden de compra")
    @Column(name = "PRE_UNI_DET_ORD_COMPRA")
    private float preUniDetOrdCompra;
    @JoinColumn(name = "NUM_ORD_COMPRA", referencedColumnName = "NUM_ORD_COMPRA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblOrdenCompra tblOrdenCompra;

    public TblDetalleOrdenCompra() {
    }

    public TblDetalleOrdenCompra(TblDetalleOrdenCompraPK tblDetalleOrdenCompraPK) {
        this.tblDetalleOrdenCompraPK = tblDetalleOrdenCompraPK;
    }

    public TblDetalleOrdenCompra(TblDetalleOrdenCompraPK tblDetalleOrdenCompraPK, int corDetOrdCompra, int canDetOrdCompra, float preUniDetOrdCompra) {
        this.tblDetalleOrdenCompraPK = tblDetalleOrdenCompraPK;
        this.corDetOrdCompra = corDetOrdCompra;
        this.canDetOrdCompra = canDetOrdCompra;
        this.preUniDetOrdCompra = preUniDetOrdCompra;
    }

    public TblDetalleOrdenCompra(int numProducto, int numOrdCompra) {
        this.tblDetalleOrdenCompraPK = new TblDetalleOrdenCompraPK(numProducto, numOrdCompra);
    }

    public TblDetalleOrdenCompraPK getTblDetalleOrdenCompraPK() {
        return tblDetalleOrdenCompraPK;
    }

    public void setTblDetalleOrdenCompraPK(TblDetalleOrdenCompraPK tblDetalleOrdenCompraPK) {
        this.tblDetalleOrdenCompraPK = tblDetalleOrdenCompraPK;
    }

    public int getCorDetOrdCompra() {
        return corDetOrdCompra;
    }

    public void setCorDetOrdCompra(int corDetOrdCompra) {
        this.corDetOrdCompra = corDetOrdCompra;
    }

    public int getCanDetOrdCompra() {
        return canDetOrdCompra;
    }

    public void setCanDetOrdCompra(int canDetOrdCompra) {
        this.canDetOrdCompra = canDetOrdCompra;
    }

    public float getPreUniDetOrdCompra() {
        return preUniDetOrdCompra;
    }

    public void setPreUniDetOrdCompra(float preUniDetOrdCompra) {
        this.preUniDetOrdCompra = preUniDetOrdCompra;
    }

    public TblOrdenCompra getTblOrdenCompra() {
        return tblOrdenCompra;
    }

    public void setTblOrdenCompra(TblOrdenCompra tblOrdenCompra) {
        this.tblOrdenCompra = tblOrdenCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblDetalleOrdenCompraPK != null ? tblDetalleOrdenCompraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleOrdenCompra)) {
            return false;
        }
        TblDetalleOrdenCompra other = (TblDetalleOrdenCompra) object;
        if ((this.tblDetalleOrdenCompraPK == null && other.tblDetalleOrdenCompraPK != null) || (this.tblDetalleOrdenCompraPK != null && !this.tblDetalleOrdenCompraPK.equals(other.tblDetalleOrdenCompraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblDetalleOrdenCompra[ tblDetalleOrdenCompraPK=" + tblDetalleOrdenCompraPK + " ]";
    }
    
}
