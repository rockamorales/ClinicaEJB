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

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_orden_compra")
@NamedQueries({
    @NamedQuery(name = "TblOrdenCompra.findAll", query = "SELECT t FROM TblOrdenCompra t")})
public class TblOrdenCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull(message = "Ingrese el numbero de orden de compra")
    @Column(name = "NUM_ORD_COMPRA")
    private Integer numOrdCompra;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la fecha de registro de la orden de compra")
    @Column(name = "FEC_REG_ORD_COMPRA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegOrdCompra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblOrdenCompra")
    private Collection<TblDetalleOrdenCompra> tblDetalleOrdenCompraCollection;
    @JoinColumn(name = "NUM_INSTITUCION", referencedColumnName = "NUM_INSTITUCION")
    @ManyToOne(optional = false)
    private TblInstitucion numInstitucion;

    public TblOrdenCompra() {
    }

    public TblOrdenCompra(Integer numOrdCompra) {
        this.numOrdCompra = numOrdCompra;
    }

    public TblOrdenCompra(Integer numOrdCompra, Date fecRegOrdCompra) {
        this.numOrdCompra = numOrdCompra;
        this.fecRegOrdCompra = fecRegOrdCompra;
    }

    public Integer getNumOrdCompra() {
        return numOrdCompra;
    }

    public void setNumOrdCompra(Integer numOrdCompra) {
        this.numOrdCompra = numOrdCompra;
    }

    public Date getFecRegOrdCompra() {
        return fecRegOrdCompra;
    }

    public void setFecRegOrdCompra(Date fecRegOrdCompra) {
        this.fecRegOrdCompra = fecRegOrdCompra;
    }

    public Collection<TblDetalleOrdenCompra> getTblDetalleOrdenCompraCollection() {
        return tblDetalleOrdenCompraCollection;
    }

    public void setTblDetalleOrdenCompraCollection(Collection<TblDetalleOrdenCompra> tblDetalleOrdenCompraCollection) {
        this.tblDetalleOrdenCompraCollection = tblDetalleOrdenCompraCollection;
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
        hash += (numOrdCompra != null ? numOrdCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblOrdenCompra)) {
            return false;
        }
        TblOrdenCompra other = (TblOrdenCompra) object;
        if ((this.numOrdCompra == null && other.numOrdCompra != null) || (this.numOrdCompra != null && !this.numOrdCompra.equals(other.numOrdCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblOrdenCompra[ numOrdCompra=" + numOrdCompra + " ]";
    }
    
}
