/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.colecturia;

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
public class TblDetalleChequesPK implements Serializable {
    @Basic(optional = false)
    @NotNull(message = "Ingrese el numero de la liquidacion")
    @Column(name = "NUM_LIQUIDACION")
    private int numLiquidacion;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el codigo del banco")
    @Column(name = "COD_BANCO")
    private int codBanco;

    public TblDetalleChequesPK() {
    }

    public TblDetalleChequesPK(int numLiquidacion, int codBanco) {
        this.numLiquidacion = numLiquidacion;
        this.codBanco = codBanco;
    }

    public int getNumLiquidacion() {
        return numLiquidacion;
    }

    public void setNumLiquidacion(int numLiquidacion) {
        this.numLiquidacion = numLiquidacion;
    }

    public int getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(int codBanco) {
        this.codBanco = codBanco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numLiquidacion;
        hash += (int) codBanco;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleChequesPK)) {
            return false;
        }
        TblDetalleChequesPK other = (TblDetalleChequesPK) object;
        if (this.numLiquidacion != other.numLiquidacion) {
            return false;
        }
        if (this.codBanco != other.codBanco) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.colecturia.TblDetalleChequesPK[ numLiquidacion=" + numLiquidacion + ", codBanco=" + codBanco + " ]";
    }
    
}
