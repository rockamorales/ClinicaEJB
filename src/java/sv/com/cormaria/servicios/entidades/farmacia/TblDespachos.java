/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.farmacia;

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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import sv.com.cormaria.servicios.enums.EstadoDetalleDespacho;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_despachos")
@NamedQueries({
    @NamedQuery(name = "TblDespachos.findAll", query = "SELECT t FROM TblDespachos t"),
    @NamedQuery(name = "TblDespachos.findByNumReceta", query = "SELECT t FROM TblDespachos t where t.numReceta = :numReceta")
})
public class TblDespachos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_DESPACHO")
    private Integer numDespacho;
    @Basic(optional = false)
    @NotNull (message="Ingrese la fecha de despacho")
    @Column(name = "FEC_DESPACHO")
    @Temporal(TemporalType.DATE)
    private Date fecDespacho;
    @Size(max = 500, message="Las observaciones no deben se mayores a 500 caracteres") 
    @Column(name = "OBS_DESPACHO")
    private String obsDespacho;
    @Basic(optional = false)
    @NotNull(message="Ingrese el nombre del depacho")
    @Column(name = "MON_DESPACHO")
    private float monDespacho;
    @Column(name = "NUM_EMPLEADO")
    private Integer numEmpleado;
    @Column(name = "COD_TIP_SALIDA")
    private Integer codTipSalida;
    @Column(name = "EST_DESPACHO")
    private EstadoDetalleDespacho estDespacho;
    @Column(name = "NUM_RECETA")
    private Integer numReceta;
    @NotNull(message="Ingrese el numero del documento de despacho")
    @Size(min = 1, max = 30, message="El numero de documento de despacho debe ser menor a 30 caracteres")
    @Column(name = "NUM_DOC_DESPACHO")
    private String numDocDespacho;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblDespachos")
    private Collection<TblDetalleDespacho> tblDetalleDespachoCollection;

    public TblDespachos() {
    }

    public TblDespachos(Integer numDespacho) {
        this.numDespacho = numDespacho;
    }

    public TblDespachos(Integer numDespacho, Date fecDespacho, float monDespacho, String numDocDespacho) {
        this.numDespacho = numDespacho;
        this.fecDespacho = fecDespacho;
        this.monDespacho = monDespacho;
        this.numDocDespacho = numDocDespacho;
    }

    public Integer getNumDespacho() {
        return numDespacho;
    }

    public void setNumDespacho(Integer numDespacho) {
        this.numDespacho = numDespacho;
    }

    public Integer getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(Integer numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public Integer getNumReceta() {
        return numReceta;
    }

    public void setNumReceta(Integer numReceta) {
        this.numReceta = numReceta;
    }
    
    public Integer getCodTipSalida() {
        return codTipSalida;
    }

    public void setCodTipSalida(Integer codTipSalida) {
        this.codTipSalida = codTipSalida;
    }

    public EstadoDetalleDespacho getEstDespacho() {
        return estDespacho;
    }

    public void setEstDespacho(EstadoDetalleDespacho estDespacho) {
        this.estDespacho = estDespacho;
    }

    public Date getFecDespacho() {
        return fecDespacho;
    }

    public void setFecDespacho(Date fecDespacho) {
        this.fecDespacho = fecDespacho;
    }

    public String getObsDespacho() {
        return obsDespacho;
    }

    public void setObsDespacho(String obsDespacho) {
        this.obsDespacho = obsDespacho;
    }

    public float getMonDespacho() {
        return monDespacho;
    }

    public void setMonDespacho(float monDespacho) {
        this.monDespacho = monDespacho;
    }

    public String getNumDocDespacho() {
        return numDocDespacho;
    }

    public void setNumDocDespacho(String numDocDespacho) {
        this.numDocDespacho = numDocDespacho;
    }

    public Collection<TblDetalleDespacho> getTblDetalleDespachoCollection() {
        return tblDetalleDespachoCollection;
    }

    public void setTblDetalleDespachoCollection(Collection<TblDetalleDespacho> tblDetalleDespachoCollection) {
        this.tblDetalleDespachoCollection = tblDetalleDespachoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numDespacho != null ? numDespacho.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDespachos)) {
            return false;
        }
        TblDespachos other = (TblDespachos) object;
        if ((this.numDespacho == null && other.numDespacho != null) || (this.numDespacho != null && !this.numDespacho.equals(other.numDespacho))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.farmacia.TblDespachos[ numDespacho=" + numDespacho + " ]";
    }
    
}
