/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.consultasmedicas;

import sv.com.cormaria.servicios.entidades.administracion.TblMedico;
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
import javax.persistence.PrePersist;
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
@Table(name = "tbl_referencia")
@NamedQueries({
    @NamedQuery(name = "TblReferencia.findAll", query = "SELECT t FROM TblReferencia t"),
    @NamedQuery(name = "TblReferencia.findByNumConsulta", query = "SELECT t FROM TblReferencia t where t.numConsulta=:numConsulta")
})
public class TblReferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_REFERENCIA")
    private Integer numReferencia;
    @Column(name = "COD_TIP_REFERENCIA")
    private Integer codTipReferencia;
    @Column(name = "NUM_EXPEDIENTE")
    private Integer numExpediente;
    @Column(name = "NUM_CONSULTA")
    private Integer numConsulta;
    @Column(name = "NUM_EMPLEADO")
    private Integer numEmpleado;
    @Column(name = "COD_ESPECIALIDAD")
    private Integer codEspecialidad;
    @Column(name = "NUM_MEDICO")
    private Integer numMedico;
    @Column(name = "FEC_REFERENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecReferencia;
    @Column(name = "DIA_REFERENCIA")
    private String diaReferencia;
    @Column(name = "REF_A")
    private String refA;
    @Column(name = "MOT_REFERENCIA")
    private String motReferencia;
    @JoinColumn(name = "NUM_MEDICO", referencedColumnName = "NUM_MEDICO", insertable=false, updatable=false)
    @ManyToOne
    private TblMedico tblMedico;

    public TblReferencia() {
    }

    public TblReferencia(Integer numReferencia) {
        this.numReferencia = numReferencia;
    }

    public TblReferencia(Integer numReferencia, Date fecReferencia, String diaReferencia, String refA, String motReferencia) {
        this.numReferencia = numReferencia;
        this.fecReferencia = fecReferencia;
        this.diaReferencia = diaReferencia;
        this.refA = refA;
        this.motReferencia = motReferencia;
    }

    public Integer getNumReferencia() {
        return numReferencia;
    }

    public void setNumReferencia(Integer numReferencia) {
        this.numReferencia = numReferencia;
    }

    public Integer getNumConsulta() {
        return numConsulta;
    }

    public void setNumConsulta(Integer numConsulta) {
        this.numConsulta = numConsulta;
    }
    
    public Integer getCodTipReferencia() {
        return codTipReferencia;
    }

    public void setCodTipReferencia(Integer codTipReferencia) {
        this.codTipReferencia = codTipReferencia;
    }

    public Date getFecReferencia() {
        return fecReferencia;
    }

    public void setFecReferencia(Date fecReferencia) {
        this.fecReferencia = fecReferencia;
    }

    public String getDiaReferencia() {
        return diaReferencia;
    }

    public void setDiaReferencia(String diaReferencia) {
        this.diaReferencia = diaReferencia;
    }

    public String getRefA() {
        return refA;
    }

    public void setRefA(String refA) {
        this.refA = refA;
    }

    public String getMotReferencia() {
        return motReferencia;
    }

    public void setMotReferencia(String motReferencia) {
        this.motReferencia = motReferencia;
    }

    public Integer getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(Integer numExpediente) {
        this.numExpediente = numExpediente;
    }

    public Integer getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(Integer numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public Integer getCodEspecialidad() {
        return codEspecialidad;
    }

    public void setCodEspecialidad(Integer codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
    }

    public Integer getNumMedico() {
        return numMedico;
    }

    public void setNumMedico(Integer numMedico) {
        this.numMedico = numMedico;
    }

    public TblMedico getTblMedico() {
        return tblMedico;
    }

    public void setTblMedico(TblMedico tblMedico) {
        this.tblMedico = tblMedico;
    }
    
    @PrePersist
    public void prePersist(){
        this.fecReferencia = new java.util.Date();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numReferencia != null ? numReferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblReferencia)) {
            return false;
        }
        TblReferencia other = (TblReferencia) object;
        if ((this.numReferencia == null && other.numReferencia != null) || (this.numReferencia != null && !this.numReferencia.equals(other.numReferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.consultasmedicas.TblReferencia[ numReferencia=" + numReferencia + " ]";
    }
    
}
