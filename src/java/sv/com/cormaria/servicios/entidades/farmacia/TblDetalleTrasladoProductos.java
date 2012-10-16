/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.farmacia;

import sv.com.cormaria.servicios.entidades.administracion.TblProducto;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_detalle_traslado_productos")
@NamedQueries({
    @NamedQuery(name = "TblDetalleTrasladoProductos.findAll", query = "SELECT t FROM TblDetalleTrasladoProductos t")})
public class TblDetalleTrasladoProductos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblDetalleTrasladoProductosPK tblDetalleTrasladoProductosPK;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el correlativo del detalle de traslado")
    @Column(name = "COR_DET_TRASLADO")
    private int corDetTraslado;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la cantidad del detalla de traslado")
    @Column(name = "CAN_DET_TRASLADO")
    private int canDetTraslado;
    @Size(max = 500, message = "Las observacion deben ser menores a 500 caracteres")
    @Column(name = "OBS_DET_TRASLADO")
    private String obsDetTraslado;
    @JoinColumn(name = "NUM_PRODUCTO", referencedColumnName = "NUM_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblProducto tblProducto;

    public TblDetalleTrasladoProductos() {
    }

    public TblDetalleTrasladoProductos(TblDetalleTrasladoProductosPK tblDetalleTrasladoProductosPK) {
        this.tblDetalleTrasladoProductosPK = tblDetalleTrasladoProductosPK;
    }

    public TblDetalleTrasladoProductos(TblDetalleTrasladoProductosPK tblDetalleTrasladoProductosPK, int corDetTraslado, int canDetTraslado) {
        this.tblDetalleTrasladoProductosPK = tblDetalleTrasladoProductosPK;
        this.corDetTraslado = corDetTraslado;
        this.canDetTraslado = canDetTraslado;
    }

    public TblDetalleTrasladoProductos(int numProducto, int numTraslado) {
        this.tblDetalleTrasladoProductosPK = new TblDetalleTrasladoProductosPK(numProducto, numTraslado);
    }

    public TblDetalleTrasladoProductosPK getTblDetalleTrasladoProductosPK() {
        return tblDetalleTrasladoProductosPK;
    }

    public void setTblDetalleTrasladoProductosPK(TblDetalleTrasladoProductosPK tblDetalleTrasladoProductosPK) {
        this.tblDetalleTrasladoProductosPK = tblDetalleTrasladoProductosPK;
    }

    public int getCorDetTraslado() {
        return corDetTraslado;
    }

    public void setCorDetTraslado(int corDetTraslado) {
        this.corDetTraslado = corDetTraslado;
    }

    public int getCanDetTraslado() {
        return canDetTraslado;
    }

    public void setCanDetTraslado(int canDetTraslado) {
        this.canDetTraslado = canDetTraslado;
    }

    public String getObsDetTraslado() {
        return obsDetTraslado;
    }

    public void setObsDetTraslado(String obsDetTraslado) {
        this.obsDetTraslado = obsDetTraslado;
    }

    public TblProducto getTblProducto() {
        return tblProducto;
    }

    public void setTblProducto(TblProducto tblProducto) {
        this.tblProducto = tblProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblDetalleTrasladoProductosPK != null ? tblDetalleTrasladoProductosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleTrasladoProductos)) {
            return false;
        }
        TblDetalleTrasladoProductos other = (TblDetalleTrasladoProductos) object;
        if ((this.tblDetalleTrasladoProductosPK == null && other.tblDetalleTrasladoProductosPK != null) || (this.tblDetalleTrasladoProductosPK != null && !this.tblDetalleTrasladoProductosPK.equals(other.tblDetalleTrasladoProductosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.farmacia.TblDetalleTrasladoProductos[ tblDetalleTrasladoProductosPK=" + tblDetalleTrasladoProductosPK + " ]";
    }
    
}
