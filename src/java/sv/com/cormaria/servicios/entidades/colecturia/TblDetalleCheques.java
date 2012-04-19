/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.colecturia;

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
@Table(name = "tbl_detalle_cheques")
@NamedQueries({
    @NamedQuery(name = "TblDetalleCheques.findAll", query = "SELECT t FROM TblDetalleCheques t")})
public class TblDetalleCheques implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblDetalleChequesPK tblDetalleChequesPK;
    @Basic(optional = false)
    @NotNull (message = "Ingrese el correlativo del cheque")
    @Column(name = "COR_DET_CHEQUE")
    private int corDetCheque;
    @Basic(optional = false)
    @NotNull (message = "Ingrese la cantidad del detalle de cheque")
    @Column(name = "CAN_DET_CHEQUE")
    private short canDetCheque;
    @Basic(optional = false)
    @NotNull (message = "Ingrese el monto del detalle de cheques")
    @Column(name = "MON_DET_CHEQUE")
    private float monDetCheque;
    @JoinColumn(name = "NUM_LIQUIDACION", referencedColumnName = "NUM_LIQUIDACION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblLiquidacion tblLiquidacion;

    public TblDetalleCheques() {
    }

    public TblDetalleCheques(TblDetalleChequesPK tblDetalleChequesPK) {
        this.tblDetalleChequesPK = tblDetalleChequesPK;
    }

    public TblDetalleCheques(TblDetalleChequesPK tblDetalleChequesPK, int corDetCheque, short canDetCheque, float monDetCheque) {
        this.tblDetalleChequesPK = tblDetalleChequesPK;
        this.corDetCheque = corDetCheque;
        this.canDetCheque = canDetCheque;
        this.monDetCheque = monDetCheque;
    }

    public TblDetalleCheques(int numLiquidacion, int codBanco) {
        this.tblDetalleChequesPK = new TblDetalleChequesPK(numLiquidacion, codBanco);
    }

    public TblDetalleChequesPK getTblDetalleChequesPK() {
        return tblDetalleChequesPK;
    }

    public void setTblDetalleChequesPK(TblDetalleChequesPK tblDetalleChequesPK) {
        this.tblDetalleChequesPK = tblDetalleChequesPK;
    }

    public int getCorDetCheque() {
        return corDetCheque;
    }

    public void setCorDetCheque(int corDetCheque) {
        this.corDetCheque = corDetCheque;
    }

    public short getCanDetCheque() {
        return canDetCheque;
    }

    public void setCanDetCheque(short canDetCheque) {
        this.canDetCheque = canDetCheque;
    }

    public float getMonDetCheque() {
        return monDetCheque;
    }

    public void setMonDetCheque(float monDetCheque) {
        this.monDetCheque = monDetCheque;
    }

    public TblLiquidacion getTblLiquidacion() {
        return tblLiquidacion;
    }

    public void setTblLiquidacion(TblLiquidacion tblLiquidacion) {
        this.tblLiquidacion = tblLiquidacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblDetalleChequesPK != null ? tblDetalleChequesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleCheques)) {
            return false;
        }
        TblDetalleCheques other = (TblDetalleCheques) object;
        if ((this.tblDetalleChequesPK == null && other.tblDetalleChequesPK != null) || (this.tblDetalleChequesPK != null && !this.tblDetalleChequesPK.equals(other.tblDetalleChequesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.colecturia.TblDetalleCheques[ tblDetalleChequesPK=" + tblDetalleChequesPK + " ]";
    }
    
}
