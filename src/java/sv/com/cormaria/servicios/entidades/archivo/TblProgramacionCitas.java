/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.archivo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import sv.com.cormaria.servicios.enums.EstadoProgramacionCitas;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_programacion_citas")
@NamedQueries({
    @NamedQuery(name = "TblProgramacionCitas.findAll", query = "SELECT t FROM TblProgramacionCitas t"),
    @NamedQuery(name = "TblProgramacionCitas.findByRange", query = "SELECT t FROM TblProgramacionCitas t where t.fecCita between :startDate and :endDate and t.estCita not in (1) order by t.fecCita, t.horCita")
})
public class TblProgramacionCitas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_CITA")
    private Integer numCita;
    @Column(name = "FEC_OTO_CITA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecOtoCita;
    @Column(name = "FEC_CITA")
    @Temporal(TemporalType.DATE)
    private Date fecCita;
    @Column(name = "HOR_CITA")
    @Temporal(TemporalType.TIME)
    private Date horCita;
    @Column(name = "EST_CITA")
    private EstadoProgramacionCitas estCita;
    
    @Column(name = "NUM_EXPEDIENTE")
    private Integer numExpediente;
    @Column(name = "COD_ESPECIALIDAD")
    private Integer codEspecialidad;
    @Column(name = "NUM_EMPLEADO")
    private Integer numEmpleado;
    @Column(name = "COD_CONSULTORIO")
    private Integer codConsultorio;
    @Column(name = "NUM_MEDICO")
    private Integer numMedico;
    
    @ManyToOne
    @JoinColumn(name="NUM_EXPEDIENTE", referencedColumnName="NUM_EXPEDIENTE", insertable=false, updatable=false)
    private TblExpedientePacientes expediente;
    
    public TblProgramacionCitas() {
    }

    public Integer getNumCita() {
        return numCita;
    }

    public void setNumCita(Integer numCita) {
        this.numCita = numCita;
    }
    
    public String getHorCitaStr(){
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        String str = formatter.format(horCita);
        return str;
    }

    public TblExpedientePacientes getExpediente() {
        return expediente;
    }

    public void setExpediente(TblExpedientePacientes expediente) {
        this.expediente = expediente;
    }

    public Integer getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(Integer numExpediente) {
        this.numExpediente = numExpediente;
    }

    public Integer getCodEspecialidad() {
        return codEspecialidad;
    }

    public void setCodEspecialidad(Integer codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
    }

    public Integer getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(Integer numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public Integer getCodConsultorio() {
        return codConsultorio;
    }

    public void setCodConsultorio(Integer codConsultorio) {
        this.codConsultorio = codConsultorio;
    }

    public Integer getNumMedico() {
        return numMedico;
    }

    public void setNumMedico(Integer numMedico) {
        this.numMedico = numMedico;
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

    public EstadoProgramacionCitas getEstCita() {
        return estCita;
    }

    public void setEstCita(EstadoProgramacionCitas estCita) {
        this.estCita = estCita;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numCita != null ? numCita.hashCode() : 0);
        return hash;
    }

    @PrePersist
    public void prePersist(){
        this.fecOtoCita = new java.util.Date();
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
