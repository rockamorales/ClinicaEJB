/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.archivo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import sv.com.cormaria.servicios.enums.Estado;
import sv.com.cormaria.servicios.enums.EstadoTarjeta;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_tarjeta_control_citas")
@NamedQueries({
    @NamedQuery(name = "TblTarjetaControlCitas.findAll", query = "SELECT t FROM TblTarjetaControlCitas t"),
    @NamedQuery(name = "TblTarjetaControlCitas.findByNumExpediente", query = "SELECT c FROM TblTarjetaControlCitas c where c.numExpediente=:numExpediente order by c.fecExpTarjeta desc"),
    @NamedQuery(name = "TblTarjetaControlCitas.findActiveByNumExpediente", query = "SELECT c FROM TblTarjetaControlCitas c where c.numExpediente=:numExpediente and c.actTarjeta = 1"),
    @NamedQuery(name = "TblTarjetaControlCitas.findNoPagadoByNumExpediente", query = "SELECT c FROM TblTarjetaControlCitas c where c.numExpediente=:numExpediente and c.estTarjeta = 1 and c.actTarjeta = 1")
})
public class TblTarjetaControlCitas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUM_TARJETA")
    private Integer numTarjeta;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la fecha de expiracion de la tarjeta")
    @Column(name = "FEC_EXP_TARJETA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecExpTarjeta;
    @Column(name = "NUM_EXPEDIENTE")
    private Integer numExpediente;

    @Column(name="ACT_TARJETA")
    private Estado actTarjeta;
    
    @Column(name="EST_TARJETA")
    private EstadoTarjeta estTarjeta;

    public Estado getActTarjeta() {
        return actTarjeta;
    }

    public void setActTarjeta(Estado actTarjeta) {
        this.actTarjeta = actTarjeta;
    }

    public EstadoTarjeta getEstTarjeta() {
        return estTarjeta;
    }

    public void setEstTarjeta(EstadoTarjeta estTarjeta) {
        this.estTarjeta = estTarjeta;
    }
    
    public Integer getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(Integer numExpediente) {
        this.numExpediente = numExpediente;
    }

    public TblTarjetaControlCitas() {
    }

    public TblTarjetaControlCitas(Integer numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public TblTarjetaControlCitas(Integer numTarjeta, Date fecExpTarjeta) {
        this.numTarjeta = numTarjeta;
        this.fecExpTarjeta = fecExpTarjeta;
    }

    public Integer getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(Integer numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public Date getFecExpTarjeta() {
        return fecExpTarjeta;
    }

    public void setFecExpTarjeta(Date fecExpTarjeta) {
        this.fecExpTarjeta = fecExpTarjeta;
    }

    @PrePersist
    public void prePersist(){
        this.fecExpTarjeta = new java.util.Date();
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numTarjeta != null ? numTarjeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTarjetaControlCitas)) {
            return false;
        }
        TblTarjetaControlCitas other = (TblTarjetaControlCitas) object;
        if ((this.numTarjeta == null && other.numTarjeta != null) || (this.numTarjeta != null && !this.numTarjeta.equals(other.numTarjeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.archivo.TblTarjetaControlCitas[ numTarjeta=" + numTarjeta + " ]";
    }
    
}
