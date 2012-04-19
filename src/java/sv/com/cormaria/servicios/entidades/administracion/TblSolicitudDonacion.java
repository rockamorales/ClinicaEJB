/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.administracion;

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

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_solicitud_donacion")
@NamedQueries({
    @NamedQuery(name = "TblSolicitudDonacion.findAll", query = "SELECT t FROM TblSolicitudDonacion t")})
public class TblSolicitudDonacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull(message = "Ingrese el numbero de solicitud de donacion")
    @Column(name = "NUM_SOL_DONACION")
    private Integer numSolDonacion;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la fecha de registro de la solicitud de donacion")
    @Column(name = "FEC_REG_SOL_DONACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegSolDonacion;
    @Size(max = 500, message = "El motivo de la solicitud de donacion no debe ser mayor de 500 caracteres")
    @Column(name = "MOT_SOL_DONACION")
    private String motSolDonacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblSolicitudDonacion")
    private Collection<TblDetalleSolicitudDonacion> tblDetalleSolicitudDonacionCollection;
    @JoinColumn(name = "NUM_INSTITUCION", referencedColumnName = "NUM_INSTITUCION")
    @ManyToOne(optional = false)
    private TblInstitucion numInstitucion;

    public TblSolicitudDonacion() {
    }

    public TblSolicitudDonacion(Integer numSolDonacion) {
        this.numSolDonacion = numSolDonacion;
    }

    public TblSolicitudDonacion(Integer numSolDonacion, Date fecRegSolDonacion) {
        this.numSolDonacion = numSolDonacion;
        this.fecRegSolDonacion = fecRegSolDonacion;
    }

    public Integer getNumSolDonacion() {
        return numSolDonacion;
    }

    public void setNumSolDonacion(Integer numSolDonacion) {
        this.numSolDonacion = numSolDonacion;
    }

    public Date getFecRegSolDonacion() {
        return fecRegSolDonacion;
    }

    public void setFecRegSolDonacion(Date fecRegSolDonacion) {
        this.fecRegSolDonacion = fecRegSolDonacion;
    }

    public String getMotSolDonacion() {
        return motSolDonacion;
    }

    public void setMotSolDonacion(String motSolDonacion) {
        this.motSolDonacion = motSolDonacion;
    }

    public Collection<TblDetalleSolicitudDonacion> getTblDetalleSolicitudDonacionCollection() {
        return tblDetalleSolicitudDonacionCollection;
    }

    public void setTblDetalleSolicitudDonacionCollection(Collection<TblDetalleSolicitudDonacion> tblDetalleSolicitudDonacionCollection) {
        this.tblDetalleSolicitudDonacionCollection = tblDetalleSolicitudDonacionCollection;
    }

    public TblInstitucion getNumInstitucion() {
        return numInstitucion;
    }

    public void setNumInstitucion(TblInstitucion numInstitucion) {
        this.numInstitucion = numInstitucion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numSolDonacion != null ? numSolDonacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblSolicitudDonacion)) {
            return false;
        }
        TblSolicitudDonacion other = (TblSolicitudDonacion) object;
        if ((this.numSolDonacion == null && other.numSolDonacion != null) || (this.numSolDonacion != null && !this.numSolDonacion.equals(other.numSolDonacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblSolicitudDonacion[ numSolDonacion=" + numSolDonacion + " ]";
    }
    
}
