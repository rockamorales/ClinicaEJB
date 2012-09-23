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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoServiciosEnfermeria;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_servicios_enfermeria")
@NamedQueries({
    @NamedQuery(name = "TblServiciosEnfermeria.findAll", query = "SELECT t FROM TblServiciosEnfermeria t")})
public class TblServiciosEnfermeria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_SER_ENFERMERIA")
    private Integer numSerEnfermeria;
    
    @Column(name="COD_SER_ENFERMERIA")
    private Integer codServEnfermeria;

    @Column(name="NUM_EMPLEADO")
    private Integer numEmpleado;

    @Column(name="NUM_EXPEDIENTE")
    private Integer numExpediente;
    
    @Column(name = "FEC_SER_ENFERMERIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecSerEnfermeria;
    @Column(name = "MED_APLICADOS")
    private String medAplicados;
    @Column(name = "OBS_SER_ENFERMERIA")
    private String obsSerEnfermeria;

    @Column(name = "EST_SER_ENFERMERIA")
    @Enumerated(EnumType.ORDINAL)
    private EstadoServiciosEnfermeria estSerEnfermeria;
    
    @ManyToOne
    @JoinColumn(name="NUM_EXPEDIENTE", referencedColumnName="NUM_EXPEDIENTE", insertable=false, updatable=false)
    private TblExpedientePacientes expediente;
    
    @ManyToOne
    @JoinColumn(name="COD_SER_ENFERMERIA", referencedColumnName="COD_SER_ENFERMERIA", insertable=false, updatable=false)
    private CatTipoServiciosEnfermeria tipoServicio;

    public TblServiciosEnfermeria() {
    }

    public TblServiciosEnfermeria(Integer numSerEnfermeria) {
        this.numSerEnfermeria = numSerEnfermeria;
    }

    public TblServiciosEnfermeria(Integer numSerEnfermeria, Date fecSerEnfermeria, String medAplicados) {
        this.numSerEnfermeria = numSerEnfermeria;
        this.fecSerEnfermeria = fecSerEnfermeria;
        this.medAplicados = medAplicados;
    }

    public Integer getNumSerEnfermeria() {
        return numSerEnfermeria;
    }

    public void setNumSerEnfermeria(Integer numSerEnfermeria) {
        this.numSerEnfermeria = numSerEnfermeria;
    }

    public Integer getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(Integer numEmpleado) {
        this.numEmpleado = numEmpleado;
    }
    
    public EstadoServiciosEnfermeria getEstSerEnfermeria() {
        return estSerEnfermeria;
    }

    public void setEstSerEnfermeria(EstadoServiciosEnfermeria estSerEnfermeria) {
        this.estSerEnfermeria = estSerEnfermeria;
    }
   
    public Integer getCodServEnfermeria() {
        return codServEnfermeria;
    }

    public void setCodServEnfermeria(Integer codServEnfermeria) {
        this.codServEnfermeria = codServEnfermeria;
    }

    public Integer getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(Integer numExpediente) {
        this.numExpediente = numExpediente;
    }

    public TblExpedientePacientes getExpediente() {
        return expediente;
    }

    public void setExpediente(TblExpedientePacientes expediente) {
        this.expediente = expediente;
    }

    public CatTipoServiciosEnfermeria getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(CatTipoServiciosEnfermeria tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Date getFecSerEnfermeria() {
        return fecSerEnfermeria;
    }

    public void setFecSerEnfermeria(Date fecSerEnfermeria) {
        this.fecSerEnfermeria = fecSerEnfermeria;
    }

    public String getMedAplicados() {
        return medAplicados;
    }

    public void setMedAplicados(String medAplicados) {
        this.medAplicados = medAplicados;
    }

    public String getObsSerEnfermeria() {
        return obsSerEnfermeria;
    }

    public void setObsSerEnfermeria(String obsSerEnfermeria) {
        this.obsSerEnfermeria = obsSerEnfermeria;
    }
    
    @PrePersist
    public void prePersist(){
        this.fecSerEnfermeria = new java.util.Date();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numSerEnfermeria != null ? numSerEnfermeria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblServiciosEnfermeria)) {
            return false;
        }
        TblServiciosEnfermeria other = (TblServiciosEnfermeria) object;
        if ((this.numSerEnfermeria == null && other.numSerEnfermeria != null) || (this.numSerEnfermeria != null && !this.numSerEnfermeria.equals(other.numSerEnfermeria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.archivo.TblServiciosEnfermeria[ numSerEnfermeria=" + numSerEnfermeria + " ]";
    }
    
}
