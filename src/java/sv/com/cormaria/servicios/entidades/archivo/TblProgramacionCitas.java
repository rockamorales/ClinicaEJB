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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_programacion_citas")
@NamedQueries({
    @NamedQuery(name = "TblProgramacionCitas.findAll", query = "SELECT t FROM TblProgramacionCitas t")})
public class TblProgramacionCitas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_CITA")
    private Integer numCita;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la fecha otorgación de cita")
    @Column(name = "FEC_OTO_CITA")
    @Temporal(TemporalType.DATE)
    private Date fecOtoCita;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la fecha de la cita")
    @Column(name = "FEC_CITA")
    @Temporal(TemporalType.DATE)
    private Date fecCita;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la hora de la cita")
    @Column(name = "HOR_CITA")
    @Temporal(TemporalType.TIME)
    private Date horCita;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el estado de la cita")
    @Column(name = "EST_CITA")
    private short estCita;

    public TblProgramacionCitas() {
    }

    public TblProgramacionCitas(Integer numCita) {
        this.numCita = numCita;
    }

    public TblProgramacionCitas(Integer numCita, Date fecOtoCita, Date fecCita, Date horCita, short estCita) {
        this.numCita = numCita;
        this.fecOtoCita = fecOtoCita;
        this.fecCita = fecCita;
        this.horCita = horCita;
        this.estCita = estCita;
    }

    public Integer getNumCita() {
        return numCita;
    }

    public void setNumCita(Integer numCita) {
        this.numCita = numCita;
    }

    public Date getFecOtoCita() {
        return fecOtoCita;
    }

    public void setFecOtoCita(Date fecOtoCita) {
        this.fecOtoCita = fecOtoCita;
    }

    public Date getFecCita() {
        return fecCita;
    }

    public void setFecCita(Date fecCita) {
        this.fecCita = fecCita;
    }

    public Date getHorCita() {
        return horCita;
    }

    public void setHorCita(Date horCita) {
        this.horCita = horCita;
    }

    public short getEstCita() {
        return estCita;
    }

    public void setEstCita(short estCita) {
        this.estCita = estCita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCita != null ? numCita.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProgramacionCitas)) {
            return false;
        }
        TblProgramacionCitas other = (TblProgramacionCitas) object;
        if ((this.numCita == null && other.numCita != null) || (this.numCita != null && !this.numCita.equals(other.numCita))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.archivo.TblProgramacionCitas[ numCita=" + numCita + " ]";
    }
    
}
