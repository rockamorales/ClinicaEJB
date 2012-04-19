/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.consultasmedicas;

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
public class TblDetalleOrdenLaboratorioPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_ORD_LABORATORIO")
    private int numOrdLaboratorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_EXA_MEDICO")
    private int codExaMedico;

    public TblDetalleOrdenLaboratorioPK() {
    }

    public TblDetalleOrdenLaboratorioPK(int numOrdLaboratorio, int codExaMedico) {
        this.numOrdLaboratorio = numOrdLaboratorio;
        this.codExaMedico = codExaMedico;
    }

    public int getNumOrdLaboratorio() {
        return numOrdLaboratorio;
    }

    public void setNumOrdLaboratorio(int numOrdLaboratorio) {
        this.numOrdLaboratorio = numOrdLaboratorio;
    }

    public int getCodExaMedico() {
        return codExaMedico;
    }

    public void setCodExaMedico(int codExaMedico) {
        this.codExaMedico = codExaMedico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numOrdLaboratorio;
        hash += (int) codExaMedico;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleOrdenLaboratorioPK)) {
            return false;
        }
        TblDetalleOrdenLaboratorioPK other = (TblDetalleOrdenLaboratorioPK) object;
        if (this.numOrdLaboratorio != other.numOrdLaboratorio) {
            return false;
        }
        if (this.codExaMedico != other.codExaMedico) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.consultasmedicas.TblDetalleOrdenLaboratorioPK[ numOrdLaboratorio=" + numOrdLaboratorio + ", codExaMedico=" + codExaMedico + " ]";
    }
    
}
