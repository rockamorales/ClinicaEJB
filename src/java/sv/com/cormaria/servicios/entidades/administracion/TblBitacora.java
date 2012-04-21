/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.administracion;

import java.io.Serializable;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_bitacora")
@NamedQueries({
    @NamedQuery(name = "TblBitacora.findAll", query = "SELECT t FROM TblBitacora t")})
public class TblBitacora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_BITACORA")
    private Integer numBitacora;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el usuario que ejecuto la transaccion")
    @Size(min = 1, max = 30)
    @Column(name = "USU_BITACORA")
    private String usuBitacora;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el tipo de transaccion ejecutada")
    @Size(min = 1, max = 50)
    @Column(name = "TIP_TRA_BITACORA")
    private String tipTraBitacora;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la fecha y hora de la transaccion ejecutada")
    @Column(name = "FEC_HOR_BITACORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHorBitacora;
    @Basic(optional = false)
    @NotNull(message = "Ingrse la Instruccion SQL ejecutada")
    @Size(min = 1, max = 500, message = "La instruccion SQL ejecutada no debe ser mayor de 500 caracteres")
    @Column(name = "INS_EJECUTADA")
    private String insEjecutada;

    public TblBitacora() {
    }

    public TblBitacora(Integer numBitacora) {
        this.numBitacora = numBitacora;
    }

    public TblBitacora(Integer numBitacora, String usuBitacora, String tipTraBitacora, Date fecHorBitacora, String insEjecutada) {
        this.numBitacora = numBitacora;
        this.usuBitacora = usuBitacora;
        this.tipTraBitacora = tipTraBitacora;
        this.fecHorBitacora = fecHorBitacora;
        this.insEjecutada = insEjecutada;
    }

    public Integer getNumBitacora() {
        return numBitacora;
    }

    public void setNumBitacora(Integer numBitacora) {
        this.numBitacora = numBitacora;
    }

    public String getUsuBitacora() {
        return usuBitacora;
    }

    public void setUsuBitacora(String usuBitacora) {
        this.usuBitacora = usuBitacora;
    }

    public String getTipTraBitacora() {
        return tipTraBitacora;
    }

    public void setTipTraBitacora(String tipTraBitacora) {
        this.tipTraBitacora = tipTraBitacora;
    }

    public Date getFecHorBitacora() {
        return fecHorBitacora;
    }

    public void setFecHorBitacora(Date fecHorBitacora) {
        this.fecHorBitacora = fecHorBitacora;
    }

    public String getInsEjecutada() {
        return insEjecutada;
    }

    public void setInsEjecutada(String insEjecutada) {
        this.insEjecutada = insEjecutada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numBitacora != null ? numBitacora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblBitacora)) {
            return false;
        }
        TblBitacora other = (TblBitacora) object;
        if ((this.numBitacora == null && other.numBitacora != null) || (this.numBitacora != null && !this.numBitacora.equals(other.numBitacora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblBitacora[ numBitacora=" + numBitacora + " ]";
    }
    
}
