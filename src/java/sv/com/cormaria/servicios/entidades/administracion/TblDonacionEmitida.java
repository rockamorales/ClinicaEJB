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
@Table(name = "tbl_donacion_emitida")
@NamedQueries({
    @NamedQuery(name = "TblDonacionEmitida.findAll", query = "SELECT t FROM TblDonacionEmitida t")})
public class TblDonacionEmitida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_DONACION")
    private Integer numDonacion;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la fecha de la donacion")
    @Column(name = "FEC_DONACION")
    @Temporal(TemporalType.DATE)
    private Date fecDonacion;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el monto donado")
    @Column(name = "MON_DONADO")
    private float monDonado;
    @Size(max = 500, message = "Las obsevaciones de la donacion no deben ser mayor a 500 caracteres")
    @Column(name = "OBS_DONACION")
    private String obsDonacion;
    @JoinColumn(name = "NUM_BENEFICIARIO", referencedColumnName = "NUM_BENEFICIARIO")
    @ManyToOne(optional = false)
    private TblBeneficiarios numBeneficiario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblDonacionEmitida")
    private Collection<TblDetalleDonacionEmitida> tblDetalleDonacionEmitidaCollection;

    public TblDonacionEmitida() {
    }

    public TblDonacionEmitida(Integer numDonacion) {
        this.numDonacion = numDonacion;
    }

    public TblDonacionEmitida(Integer numDonacion, Date fecDonacion, float monDonado) {
        this.numDonacion = numDonacion;
        this.fecDonacion = fecDonacion;
        this.monDonado = monDonado;
    }

    public Integer getNumDonacion() {
        return numDonacion;
    }

    public void setNumDonacion(Integer numDonacion) {
        this.numDonacion = numDonacion;
    }

    public Date getFecDonacion() {
        return fecDonacion;
    }

    public void setFecDonacion(Date fecDonacion) {
        this.fecDonacion = fecDonacion;
    }

    public float getMonDonado() {
        return monDonado;
    }

    public void setMonDonado(float monDonado) {
        this.monDonado = monDonado;
    }

    public String getObsDonacion() {
        return obsDonacion;
    }

    public void setObsDonacion(String obsDonacion) {
        this.obsDonacion = obsDonacion;
    }

    public TblBeneficiarios getNumBeneficiario() {
        return numBeneficiario;
    }

    public void setNumBeneficiario(TblBeneficiarios numBeneficiario) {
        this.numBeneficiario = numBeneficiario;
    }

    public Collection<TblDetalleDonacionEmitida> getTblDetalleDonacionEmitidaCollection() {
        return tblDetalleDonacionEmitidaCollection;
    }

    public void setTblDetalleDonacionEmitidaCollection(Collection<TblDetalleDonacionEmitida> tblDetalleDonacionEmitidaCollection) {
        this.tblDetalleDonacionEmitidaCollection = tblDetalleDonacionEmitidaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numDonacion != null ? numDonacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDonacionEmitida)) {
            return false;
        }
        TblDonacionEmitida other = (TblDonacionEmitida) object;
        if ((this.numDonacion == null && other.numDonacion != null) || (this.numDonacion != null && !this.numDonacion.equals(other.numDonacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblDonacionEmitida[ numDonacion=" + numDonacion + " ]";
    }
    
}
