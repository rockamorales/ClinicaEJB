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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_movimientos_expediente")
@NamedQueries({
    @NamedQuery(name = "TblMovimientosExpediente.findAll", query = "SELECT t FROM TblMovimientosExpediente t")})
public class TblMovimientosExpediente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull(message = "Ingrese el numbero de transccion")
    @Column(name = "NUM_TRANSACCION")
    private Integer numTransaccion;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la fecha de transaccion")
    @Column(name = "FEC_TRANSACCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecTransaccion;
    @JoinColumn(name = "NUM_EMPLEADO", referencedColumnName = "NUM_EMPLEADO")
    @ManyToOne(optional = false)
    private TblEmpleado numEmpleado;

    public TblMovimientosExpediente() {
    }

    public TblMovimientosExpediente(Integer numTransaccion) {
        this.numTransaccion = numTransaccion;
    }

    public TblMovimientosExpediente(Integer numTransaccion, Date fecTransaccion) {
        this.numTransaccion = numTransaccion;
        this.fecTransaccion = fecTransaccion;
    }

    public Integer getNumTransaccion() {
        return numTransaccion;
    }

    public void setNumTransaccion(Integer numTransaccion) {
        this.numTransaccion = numTransaccion;
    }

    public Date getFecTransaccion() {
        return fecTransaccion;
    }

    public void setFecTransaccion(Date fecTransaccion) {
        this.fecTransaccion = fecTransaccion;
    }

    public TblEmpleado getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(TblEmpleado numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numTransaccion != null ? numTransaccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMovimientosExpediente)) {
            return false;
        }
        TblMovimientosExpediente other = (TblMovimientosExpediente) object;
        if ((this.numTransaccion == null && other.numTransaccion != null) || (this.numTransaccion != null && !this.numTransaccion.equals(other.numTransaccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblMovimientosExpediente[ numTransaccion=" + numTransaccion + " ]";
    }
    
}
