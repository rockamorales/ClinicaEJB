/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.consultasmedicas;

import sv.com.cormaria.servicios.entidades.administracion.TblMedico;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import sv.com.cormaria.servicios.entidades.archivo.TblExpedientePacientes;
import sv.com.cormaria.servicios.enums.EstadoRecetaMedica;

/**
 *
 * @author Mackk
 */
@NamedQueries({
    @NamedQuery(name = "TblRecetaMedica.findAll", query = "SELECT t FROM TblRecetaMedica t"),
    @NamedQuery(name = "TblRecetaMedica.findByNumExpediente", query = "SELECT t FROM TblRecetaMedica t where t.numExpediente = :numExpediente")
})

@Entity
@Table(name = "TBL_RECETA_MEDICA")
public class TblRecetaMedica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_RECETA")
    private Integer numReceta;
    @Column(name = "FEC_RECETA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecReceta;
    @Basic(optional = false)
    @Column(name = "OTR_RECOMENDACIONES")
    private String otrRecomendaciones;
    @Column(name = "PRE_LIB_RECETA")
    private String preLibReceta;
    @Column(name = "NUM_EXPEDIENTE")
    private Integer numExpediente;
    
    @Column(name = "EST_RECETA")
    private EstadoRecetaMedica estReceta;

    @Column(name = "NUM_MEDICO")
    private Integer numMedico;
    
    @ManyToOne
    @JoinColumn(name = "NUM_MEDICO", referencedColumnName = "NUM_MEDICO", insertable=false, updatable=false)
    private TblMedico medico;

    @ManyToOne
    @JoinColumn(name = "NUM_EXPEDIENTE", referencedColumnName = "NUM_EXPEDIENTE", insertable=false, updatable=false)
    private TblExpedientePacientes expediente;

    public TblRecetaMedica() {
    }

    public TblRecetaMedica(Integer numReceta) {
        this.numReceta = numReceta;
    }

    public TblRecetaMedica(Integer numReceta, Date fecReceta, String otrRecomendaciones, EstadoRecetaMedica estReceta) {
        this.numReceta = numReceta;
        this.fecReceta = fecReceta;
        this.otrRecomendaciones = otrRecomendaciones;
        this.estReceta = estReceta;
    }

    public Integer getNumReceta() {
        return numReceta;
    }

    public void setNumReceta(Integer numReceta) {
        this.numReceta = numReceta;
    }

    public Date getFecReceta() {
        return fecReceta;
    }

    public void setFecReceta(Date fecReceta) {
        this.fecReceta = fecReceta;
    }

    public String getOtrRecomendaciones() {
        return otrRecomendaciones;
    }

    public void setOtrRecomendaciones(String otrRecomendaciones) {
        this.otrRecomendaciones = otrRecomendaciones;
    }

    public String getPreLibReceta() {
        return preLibReceta;
    }

    public void setPreLibReceta(String preLibReceta) {
        this.preLibReceta = preLibReceta;
    }

    public Integer getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(Integer numExpediente) {
        this.numExpediente = numExpediente;
    }

    public EstadoRecetaMedica getEstReceta() {
        return estReceta;
    }

    public void setEstReceta(EstadoRecetaMedica estReceta) {
        this.estReceta = estReceta;
    }

    public Integer getNumMedico() {
        return numMedico;
    }

    public void setNumMedico(Integer numMedico) {
        this.numMedico = numMedico;
    }

    public TblMedico getMedico() {
        return medico;
    }

    public void setMedico(TblMedico medico) {
        this.medico = medico;
    }

    public TblExpedientePacientes getExpediente() {
        return expediente;
    }

    public void setExpediente(TblExpedientePacientes expediente) {
        this.expediente = expediente;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numReceta != null ? numReceta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRecetaMedica)) {
            return false;
        }
        TblRecetaMedica other = (TblRecetaMedica) object;
        if ((this.numReceta == null && other.numReceta != null) || (this.numReceta != null && !this.numReceta.equals(other.numReceta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.consultasmedicas.TblRecetaMedica[ numReceta=" + numReceta + " ]";
    }
    
}
