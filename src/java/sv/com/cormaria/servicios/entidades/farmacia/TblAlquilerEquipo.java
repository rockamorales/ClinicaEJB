/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.farmacia;

import sv.com.cormaria.servicios.entidades.archivo.TblExpedientePacientes;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Claudia
 */
@Entity
@Table(name = "tbl_alquiler_equipo")
@NamedQueries({
    @NamedQuery(name = "TblAlquilerEquipo.findAll", query = "SELECT t FROM TblAlquilerEquipo t")})
public class TblAlquilerEquipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_SOL_ALQUILER")
    private Integer numSolAlquiler;
    @Basic(optional = false)
    @NotNull(message="Ingrese la fecha de Registro del Alquiler")
    @Column(name = "FEC_REG_ALQUILER")
    @Temporal(TemporalType.DATE)
    private Date fecRegAlquiler;
    @Basic(optional = false)
    @NotNull(message="Ingrese Motivo de Solicitud del alquiler")
    @Size(min = 1, max = 500)
    @Column(name = "MOT_SOL_ALQUILER")
    private String motSolAlquiler;
    @JoinColumn(name = "NUM_EXPEDIENTE", referencedColumnName = "NUM_EXPEDIENTE")
    @ManyToOne(optional = false)
    private TblExpedientePacientes numExpediente;

    public TblAlquilerEquipo() {
    }

    public TblAlquilerEquipo(Integer numSolAlquiler) {
        this.numSolAlquiler = numSolAlquiler;
    }

    public TblAlquilerEquipo(Integer numSolAlquiler, Date fecRegAlquiler, String motSolAlquiler) {
        this.numSolAlquiler = numSolAlquiler;
        this.fecRegAlquiler = fecRegAlquiler;
        this.motSolAlquiler = motSolAlquiler;
    }

    public Integer getNumSolAlquiler() {
        return numSolAlquiler;
    }

    public void setNumSolAlquiler(Integer numSolAlquiler) {
        this.numSolAlquiler = numSolAlquiler;
    }

    public Date getFecRegAlquiler() {
        return fecRegAlquiler;
    }

    public void setFecRegAlquiler(Date fecRegAlquiler) {
        this.fecRegAlquiler = fecRegAlquiler;
    }

    public String getMotSolAlquiler() {
        return motSolAlquiler;
    }

    public void setMotSolAlquiler(String motSolAlquiler) {
        this.motSolAlquiler = motSolAlquiler;
    }

    public TblExpedientePacientes getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(TblExpedientePacientes numExpediente) {
        this.numExpediente = numExpediente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numSolAlquiler != null ? numSolAlquiler.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblAlquilerEquipo)) {
            return false;
        }
        TblAlquilerEquipo other = (TblAlquilerEquipo) object;
        if ((this.numSolAlquiler == null && other.numSolAlquiler != null) || (this.numSolAlquiler != null && !this.numSolAlquiler.equals(other.numSolAlquiler))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.TblAlquilerEquipo[ numSolAlquiler=" + numSolAlquiler + " ]";
    }
    
}
