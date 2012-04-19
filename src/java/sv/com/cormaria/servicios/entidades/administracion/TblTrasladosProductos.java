/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.administracion;

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
@Table(name = "tbl_traslados_productos")
@NamedQueries({
    @NamedQuery(name = "TblTrasladosProductos.findAll", query = "SELECT t FROM TblTrasladosProductos t")})
public class TblTrasladosProductos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull(message = "Ingrese el numero de traslado")
    @Column(name = "NUM_TRASLADO")
    private Integer numTraslado;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la fecha de donacion")
    @Column(name = "FEC_DONACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDonacion;
    @Size(max = 500, message = "El motivo del traslado no debe ser mayor de 500 caracteres")
    @Column(name = "MOT_TRASLADO")
    private String motTraslado;

    public TblTrasladosProductos() {
    }

    public TblTrasladosProductos(Integer numTraslado) {
        this.numTraslado = numTraslado;
    }

    public TblTrasladosProductos(Integer numTraslado, Date fecDonacion) {
        this.numTraslado = numTraslado;
        this.fecDonacion = fecDonacion;
    }

    public Integer getNumTraslado() {
        return numTraslado;
    }

    public void setNumTraslado(Integer numTraslado) {
        this.numTraslado = numTraslado;
    }

    public Date getFecDonacion() {
        return fecDonacion;
    }

    public void setFecDonacion(Date fecDonacion) {
        this.fecDonacion = fecDonacion;
    }

    public String getMotTraslado() {
        return motTraslado;
    }

    public void setMotTraslado(String motTraslado) {
        this.motTraslado = motTraslado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numTraslado != null ? numTraslado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblTrasladosProductos)) {
            return false;
        }
        TblTrasladosProductos other = (TblTrasladosProductos) object;
        if ((this.numTraslado == null && other.numTraslado != null) || (this.numTraslado != null && !this.numTraslado.equals(other.numTraslado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblTrasladosProductos[ numTraslado=" + numTraslado + " ]";
    }
    
}
