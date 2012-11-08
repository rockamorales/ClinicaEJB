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
@Table(name = "tbl_detalle_despacho")
@NamedQueries({
    @NamedQuery(name = "TblDetalleDespacho.findAll", query = "SELECT t FROM TblDetalleDespacho t"),
    @NamedQuery(name = "TblDetalleDespacho.findByDespachoProducto", query = "SELECT t FROM TblDetalleDespacho t WHERE t.tblDetalleDespachoPK.numDespacho = :numDespacho")
})

public class TblDetalleDespacho implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblDetalleDespachoPK tblDetalleDespachoPK = new TblDetalleDespachoPK();
    @NotNull(message = "Ingrese el correlativo del detalle de despacho")
    @Column(name = "COR_DET_DESPACHO")
    private int corDetDespacho;
    @NotNull(message = "Ingrese la cantidad del detalle de depacho")
    @Column(name = "CAN_DET_DESPACHO")
    private int canDetDespacho;
    @NotNull(message = "Ingrese el precio unitario del detalle de despacho")
    @Column(name = "PRE_UNI_DET_DESPACHO")
    private float preUniDetDespacho;
    @JoinColumn(name = "NUM_DESPACHO", referencedColumnName = "NUM_DESPACHO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblDespachos tblDespachos;
    @JoinColumn(name = "NUM_PRODUCTO", referencedColumnName = "NUM_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblProducto tblProducto;

    public TblDetalleDespacho() {
    }

    public TblDetalleDespacho(TblDetalleDespachoPK tblDetalleDespachoPK) {
        this.tblDetalleDespachoPK = tblDetalleDespachoPK;
    }

    public TblDetalleDespacho(TblDetalleDespachoPK tblDetalleDespachoPK, int corDetDespacho, int canDetDespacho, float preUniDetDespacho) {
        this.tblDetalleDespachoPK = tblDetalleDespachoPK;
        this.corDetDespacho = corDetDespacho;
        this.canDetDespacho = canDetDespacho;
        this.preUniDetDespacho = preUniDetDespacho;
    }

    public TblDetalleDespacho(int numProducto, int numDespacho) {
        this.tblDetalleDespachoPK = new TblDetalleDespachoPK(numProducto, numDespacho);
    }

    public TblDetalleDespachoPK getTblDetalleDespachoPK() {
        return tblDetalleDespachoPK;
    }

    public void setTblDetalleDespachoPK(TblDetalleDespachoPK tblDetalleDespachoPK) {
        this.tblDetalleDespachoPK = tblDetalleDespachoPK;
    }

    public int getCorDetDespacho() {
        return corDetDespacho;
    }

    public void setCorDetDespacho(int corDetDespacho) {
        this.corDetDespacho = corDetDespacho;
    }

    public int getCanDetDespacho() {
        return canDetDespacho;
    }

    public void setCanDetDespacho(int canDetDespacho) {
        this.canDetDespacho = canDetDespacho;
    }

    public float getPreUniDetDespacho() {
        return preUniDetDespacho;
    }

    public void setPreUniDetDespacho(float preUniDetDespacho) {
        this.preUniDetDespacho = preUniDetDespacho;
    }

    public TblDespachos getTblDespachos() {
        return tblDespachos;
    }

    public void setTblDespachos(TblDespachos tblDespachos) {
        this.tblDespachos = tblDespachos;
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
        hash += (tblDetalleDespachoPK != null ? tblDetalleDespachoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleDespacho)) {
            return false;
        }
        TblDetalleDespacho other = (TblDetalleDespacho) object;
        if ((this.tblDetalleDespachoPK == null && other.tblDetalleDespachoPK != null) || (this.tblDetalleDespachoPK != null && !this.tblDetalleDespachoPK.equals(other.tblDetalleDespachoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.farmacia.TblDetalleDespacho[ tblDetalleDespachoPK=" + tblDetalleDespachoPK + " ]";
    }
    
}
