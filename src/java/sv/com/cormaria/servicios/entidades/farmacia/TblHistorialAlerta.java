/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.farmacia;

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
@Table(name = "tbl_historial_alerta")
@NamedQueries({
    @NamedQuery(name = "TblHistorialAlerta.findAll", query = "SELECT t FROM TblHistorialAlerta t")})
public class TblHistorialAlerta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_ALERTA")
    private Integer numAlerta;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el tipo de alerta")
    @Size(min = 1, max = 50, message = "El tipo de alerta debe ser menor a 50 caracteres")
    @Column(name = "TIP_ALERTA")
    private String tipAlerta;
    @Basic(optional = false)
    @NotNull(message = "Inserte la fecha y hora de la alerta")
    @Column(name = "FEC_HOR_ALERTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHorAlerta;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el usuario alertado")
    @Size(min = 1, max = 30)
    @Column(name = "USU_ALERTADO")
    private String usuAlertado;

    public TblHistorialAlerta() {
    }

    public TblHistorialAlerta(Integer numAlerta) {
        this.numAlerta = numAlerta;
    }

    public TblHistorialAlerta(Integer numAlerta, String tipAlerta, Date fecHorAlerta, String usuAlertado) {
        this.numAlerta = numAlerta;
        this.tipAlerta = tipAlerta;
        this.fecHorAlerta = fecHorAlerta;
        this.usuAlertado = usuAlertado;
    }

    public Integer getNumAlerta() {
        return numAlerta;
    }

    public void setNumAlerta(Integer numAlerta) {
        this.numAlerta = numAlerta;
    }

    public String getTipAlerta() {
        return tipAlerta;
    }

    public void setTipAlerta(String tipAlerta) {
        this.tipAlerta = tipAlerta;
    }

    public Date getFecHorAlerta() {
        return fecHorAlerta;
    }

    public void setFecHorAlerta(Date fecHorAlerta) {
        this.fecHorAlerta = fecHorAlerta;
    }

    public String getUsuAlertado() {
        return usuAlertado;
    }

    public void setUsuAlertado(String usuAlertado) {
        this.usuAlertado = usuAlertado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numAlerta != null ? numAlerta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblHistorialAlerta)) {
            return false;
        }
        TblHistorialAlerta other = (TblHistorialAlerta) object;
        if ((this.numAlerta == null && other.numAlerta != null) || (this.numAlerta != null && !this.numAlerta.equals(other.numAlerta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.farmacia.TblHistorialAlerta[ numAlerta=" + numAlerta + " ]";
    }
    
}
