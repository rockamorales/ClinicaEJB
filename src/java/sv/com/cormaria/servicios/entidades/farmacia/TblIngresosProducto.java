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

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_ingresos_producto")
@NamedQueries({
    @NamedQuery(name = "TblIngresosProducto.findAll", query = "SELECT t FROM TblIngresosProducto t where t.estIngresoProducto = 1")})
public class TblIngresosProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_INGRESO")
    private Integer numIngreso;
    @Basic(optional = false)
    @NotNull(message = "Introduzca la fecha de ingreso")
    @Column(name = "FEC_INGRESO")
    @Temporal(TemporalType.DATE)
    private Date fecIngreso;
    @Basic(optional = false)
    @NotNull(message = "Ingrese las observaciones del ingreso")
    @Size(min = 1, max = 500, message = "Las observaciones deben ser menores de 500 caracteres")
    @Column(name = "OBS_INGRESO")
    private String obsIngreso;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el número del documento de ingreso")
    @Size(min = 1, max = 30, message = "El número del documento de ingreso debe ser menor de 30 caracteres")
    @Column(name = "NUM_DOC_INGRESO")
    private String numDocIngreso;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el monto de ingeso")
    @Column(name = "MON_INGRESO")
    private float monIngreso;
    @NotNull(message = "Estado de ingreso")
    @Column(name = "EST_ING_PRODUCTO")
    private int estIngresoProducto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblIngresosProducto")
    private Collection<TblDetalleIngresoProducto> tblDetalleIngresoProductoCollection;

    public TblIngresosProducto() {
    }

    public TblIngresosProducto(Integer numIngreso) {
        this.numIngreso = numIngreso;
    }

    public TblIngresosProducto(Integer numIngreso, Date fecIngreso, String obsIngreso, String numDocIngreso, float monIngreso) {
        this.numIngreso = numIngreso;
        this.fecIngreso = fecIngreso;
        this.obsIngreso = obsIngreso;
        this.numDocIngreso = numDocIngreso;
        this.monIngreso = monIngreso;
    }

    public Integer getNumIngreso() {
        return numIngreso;
    }

    public void setNumIngreso(Integer numIngreso) {
        this.numIngreso = numIngreso;
    }

    public int getEstIngresoProducto() {
        return estIngresoProducto;
    }

    public void setEstIngresoProducto(int estIngresoProducto) {
        this.estIngresoProducto = estIngresoProducto;
    }

    public Date getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(Date fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public String getObsIngreso() {
        return obsIngreso;
    }

    public void setObsIngreso(String obsIngreso) {
        this.obsIngreso = obsIngreso;
    }

    public String getNumDocIngreso() {
        return numDocIngreso;
    }

    public void setNumDocIngreso(String numDocIngreso) {
        this.numDocIngreso = numDocIngreso;
    }

    public float getMonIngreso() {
        return monIngreso;
    }

    public void setMonIngreso(float monIngreso) {
        this.monIngreso = monIngreso;
    }

    public Collection<TblDetalleIngresoProducto> getTblDetalleIngresoProductoCollection() {
        return tblDetalleIngresoProductoCollection;
    }

    public void setTblDetalleIngresoProductoCollection(Collection<TblDetalleIngresoProducto> tblDetalleIngresoProductoCollection) {
        this.tblDetalleIngresoProductoCollection = tblDetalleIngresoProductoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numIngreso != null ? numIngreso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblIngresosProducto)) {
            return false;
        }
        TblIngresosProducto other = (TblIngresosProducto) object;
        if ((this.numIngreso == null && other.numIngreso != null) || (this.numIngreso != null && !this.numIngreso.equals(other.numIngreso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.farmacia.TblIngresosProducto[ numIngreso=" + numIngreso + " ]";
    }
    
}
