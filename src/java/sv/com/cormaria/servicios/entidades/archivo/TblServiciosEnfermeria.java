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
import javax.validation.constraints.Size;

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
    @Basic(optional = false)
    @Column(name = "NUM_SER_ENFERMERIA")
    private Integer numSerEnfermeria;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la fecha de realización del servicio de enferia")
    @Column(name = "FEC_SER_ENFERMERIA")
    @Temporal(TemporalType.DATE)
    private Date fecSerEnfermeria;
    @Basic(optional = false)
    @NotNull(message = "Ingrese los medicamenteos aplicados")
    @Size(min = 1, max = 250, message = "Los medicamentos aplicados de deben ser mayor de 250 caracteres")
    @Column(name = "MED_APLICADOS")
    private String medAplicados;
    @Size(max = 500, message = "Las observaciones no deben ser mayores de 500 caracteres")
    @Column(name = "OBS_SER_ENFERMERIA")
    private String obsSerEnfermeria;

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
