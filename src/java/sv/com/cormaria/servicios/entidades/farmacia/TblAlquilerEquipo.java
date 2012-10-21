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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import sv.com.cormaria.servicios.entidades.archivo.TblExpedientePacientes;
import sv.com.cormaria.servicios.enums.EstadoAlquiler;

/**
 *
 * @author Claudia
 */
@Entity
@Table(name = "tbl_alquiler_equipo")
@NamedQueries({
    @NamedQuery(name = "TblAlquilerEquipo.findAll", query = "SELECT t FROM TblAlquilerEquipo t")
})
public class TblAlquilerEquipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name = "NUM_SOL_ALQUILER")
    private Integer numSolAlquiler;
    
    @Basic
    @Column(name = "EST_ALQUILER")
    private EstadoAlquiler estAlquiler;

    @Basic
    @Column(name = "FEC_REG_ALQUILER")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegAlquiler;
    
    @Basic
    @Column(name = "MOT_SOL_ALQUILER")
    private String motSolAlquiler;
    
    @Basic
    @Column(name = "NUM_EXPEDIENTE")
    private Integer numExpediente;

    @ManyToOne
    @JoinColumn(name = "NUM_EXPEDIENTE", referencedColumnName="NUM_EXPEDIENTE", insertable=false, updatable=false)
    private TblExpedientePacientes expediente;

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

    public EstadoAlquiler getEstAlquiler() {
        return estAlquiler;
    }

    public void setEstAlquiler(EstadoAlquiler estAlquiler) {
        this.estAlquiler = estAlquiler;
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
    
    @PrePersist
    public void prePersist(){
        this.fecRegAlquiler = new java.util.Date();
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
