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
@Table(name = "tbl_detalle_donacion_emitida")
@NamedQueries({
    @NamedQuery(name = "TblDetalleDonacionEmitida.findAll", query = "SELECT t FROM TblDetalleDonacionEmitida t")})
public class TblDetalleDonacionEmitida implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblDetalleDonacionEmitidaPK tblDetalleDonacionEmitidaPK;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el correlativo del detalle de donacion")
    @Column(name = "COR_DET_DONACION")
    private int corDetDonacion;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la cantidad del producto donado")
    @Column(name = "CAN_PRO_DONACION")
    private int canProDonacion;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el presio unitario del producto donado")
    @Column(name = "PRE_UNI_DONACION")
    private float preUniDonacion;
    @JoinColumn(name = "NUM_DONACION", referencedColumnName = "NUM_DONACION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblDonacionEmitida tblDonacionEmitida;

    public TblDetalleDonacionEmitida() {
    }

    public TblDetalleDonacionEmitida(TblDetalleDonacionEmitidaPK tblDetalleDonacionEmitidaPK) {
        this.tblDetalleDonacionEmitidaPK = tblDetalleDonacionEmitidaPK;
    }

    public TblDetalleDonacionEmitida(TblDetalleDonacionEmitidaPK tblDetalleDonacionEmitidaPK, int corDetDonacion, int canProDonacion, float preUniDonacion) {
        this.tblDetalleDonacionEmitidaPK = tblDetalleDonacionEmitidaPK;
        this.corDetDonacion = corDetDonacion;
        this.canProDonacion = canProDonacion;
        this.preUniDonacion = preUniDonacion;
    }

    public TblDetalleDonacionEmitida(int numProducto, int numDonacion) {
        this.tblDetalleDonacionEmitidaPK = new TblDetalleDonacionEmitidaPK(numProducto, numDonacion);
    }

    public TblDetalleDonacionEmitidaPK getTblDetalleDonacionEmitidaPK() {
        return tblDetalleDonacionEmitidaPK;
    }

    public void setTblDetalleDonacionEmitidaPK(TblDetalleDonacionEmitidaPK tblDetalleDonacionEmitidaPK) {
        this.tblDetalleDonacionEmitidaPK = tblDetalleDonacionEmitidaPK;
    }

    public int getCorDetDonacion() {
        return corDetDonacion;
    }

    public void setCorDetDonacion(int corDetDonacion) {
        this.corDetDonacion = corDetDonacion;
    }

    public int getCanProDonacion() {
        return canProDonacion;
    }

    public void setCanProDonacion(int canProDonacion) {
        this.canProDonacion = canProDonacion;
    }

    public float getPreUniDonacion() {
        return preUniDonacion;
    }

    public void setPreUniDonacion(float preUniDonacion) {
        this.preUniDonacion = preUniDonacion;
    }

    public TblDonacionEmitida getTblDonacionEmitida() {
        return tblDonacionEmitida;
    }

    public void setTblDonacionEmitida(TblDonacionEmitida tblDonacionEmitida) {
        this.tblDonacionEmitida = tblDonacionEmitida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblDetalleDonacionEmitidaPK != null ? tblDetalleDonacionEmitidaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleDonacionEmitida)) {
            return false;
        }
        TblDetalleDonacionEmitida other = (TblDetalleDonacionEmitida) object;
        if ((this.tblDetalleDonacionEmitidaPK == null && other.tblDetalleDonacionEmitidaPK != null) || (this.tblDetalleDonacionEmitidaPK != null && !this.tblDetalleDonacionEmitidaPK.equals(other.tblDetalleDonacionEmitidaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblDetalleDonacionEmitida[ tblDetalleDonacionEmitidaPK=" + tblDetalleDonacionEmitidaPK + " ]";
    }
    
}
