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
@Table(name = "tbl_orden_laboratorio")
@NamedQueries({
    @NamedQuery(name = "TblOrdenLaboratorio.findAll", query = "SELECT t FROM TblOrdenLaboratorio t")})
public class TblOrdenLaboratorio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_ORD_LABORATORIO")
    private Integer numOrdLaboratorio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_ORD_LABORATORIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecOrdLaboratorio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DIA_LABORATORIO")
    private String diaLaboratorio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "IND_LABORATORIO")
    private String indLaboratorio;
    @Size(max = 500)
    @Column(name = "OBS_LABORATORIO")
    private String obsLaboratorio;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblOrdenLaboratorio")
    private Collection<TblDetalleOrdenLaboratorio> tblDetalleOrdenLaboratorioCollection;
    @JoinColumn(name = "NUM_MEDICO", referencedColumnName = "NUM_MEDICO")
    @ManyToOne(optional = false)
    private TblMedico numMedico;

    public TblOrdenLaboratorio() {
    }

    public TblOrdenLaboratorio(Integer numOrdLaboratorio) {
        this.numOrdLaboratorio = numOrdLaboratorio;
    }

    public TblOrdenLaboratorio(Integer numOrdLaboratorio, Date fecOrdLaboratorio, String diaLaboratorio, String indLaboratorio) {
        this.numOrdLaboratorio = numOrdLaboratorio;
        this.fecOrdLaboratorio = fecOrdLaboratorio;
        this.diaLaboratorio = diaLaboratorio;
        this.indLaboratorio = indLaboratorio;
    }

    public Integer getNumOrdLaboratorio() {
        return numOrdLaboratorio;
    }

    public void setNumOrdLaboratorio(Integer numOrdLaboratorio) {
        this.numOrdLaboratorio = numOrdLaboratorio;
    }

    public Date getFecOrdLaboratorio() {
        return fecOrdLaboratorio;
    }

    public void setFecOrdLaboratorio(Date fecOrdLaboratorio) {
        this.fecOrdLaboratorio = fecOrdLaboratorio;
    }

    public String getDiaLaboratorio() {
        return diaLaboratorio;
    }

    public void setDiaLaboratorio(String diaLaboratorio) {
        this.diaLaboratorio = diaLaboratorio;
    }

    public String getIndLaboratorio() {
        return indLaboratorio;
    }

    public void setIndLaboratorio(String indLaboratorio) {
        this.indLaboratorio = indLaboratorio;
    }

    public String getObsLaboratorio() {
        return obsLaboratorio;
    }

    public void setObsLaboratorio(String obsLaboratorio) {
        this.obsLaboratorio = obsLaboratorio;
    }

    public Collection<TblDetalleOrdenLaboratorio> getTblDetalleOrdenLaboratorioCollection() {
        return tblDetalleOrdenLaboratorioCollection;
    }

    public void setTblDetalleOrdenLaboratorioCollection(Collection<TblDetalleOrdenLaboratorio> tblDetalleOrdenLaboratorioCollection) {
        this.tblDetalleOrdenLaboratorioCollection = tblDetalleOrdenLaboratorioCollection;
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
        hash += (numOrdLaboratorio != null ? numOrdLaboratorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOrdenLaboratorio)) {
            return false;
        }
        TblOrdenLaboratorio other = (TblOrdenLaboratorio) object;
        if ((this.numOrdLaboratorio == null && other.numOrdLaboratorio != null) || (this.numOrdLaboratorio != null && !this.numOrdLaboratorio.equals(other.numOrdLaboratorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.consultasmedicas.TblOrdenLaboratorio[ numOrdLaboratorio=" + numOrdLaboratorio + " ]";
    }
    
}
