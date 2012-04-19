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

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_receta_medica")
@NamedQueries({
    @NamedQuery(name = "TblRecetaMedica.findAll", query = "SELECT t FROM TblRecetaMedica t")})
public class TblRecetaMedica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_RECETA")
    private Integer numReceta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_RECETA")
    @Temporal(TemporalType.DATE)
    private Date fecReceta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "OTR_RECOMENDACIONES")
    private String otrRecomendaciones;
    @Size(max = 500)
    @Column(name = "PRE_LIB_RECETA")
    private String preLibReceta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EST_RECETA")
    private int estReceta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblRecetaMedica")
    private Collection<TblDetalleReceta> tblDetalleRecetaCollection;
    @JoinColumn(name = "NUM_MEDICO", referencedColumnName = "NUM_MEDICO")
    @ManyToOne(optional = false)
    private TblMedico numMedico;

    public TblRecetaMedica() {
    }

    public TblRecetaMedica(Integer numReceta) {
        this.numReceta = numReceta;
    }

    public TblRecetaMedica(Integer numReceta, Date fecReceta, String otrRecomendaciones, int estReceta) {
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

    public int getEstReceta() {
        return estReceta;
    }

    public void setEstReceta(int estReceta) {
        this.estReceta = estReceta;
    }

    public Collection<TblDetalleReceta> getTblDetalleRecetaCollection() {
        return tblDetalleRecetaCollection;
    }

    public void setTblDetalleRecetaCollection(Collection<TblDetalleReceta> tblDetalleRecetaCollection) {
        this.tblDetalleRecetaCollection = tblDetalleRecetaCollection;
    }

    public TblMedico getNumMedico() {
        return numMedico;
    }

    public void setNumMedico(TblMedico numMedico) {
        this.numMedico = numMedico;
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
