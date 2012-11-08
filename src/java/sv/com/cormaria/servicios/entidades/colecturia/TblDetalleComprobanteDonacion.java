/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.colecturia;

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
import javax.persistence.Transient;
import sv.com.cormaria.servicios.entidades.administracion.TblProducto;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_detalle_comprobante_donacion")
@NamedQueries({
    @NamedQuery(name = "TblDetalleComprobanteDonacion.findAll", query = "SELECT t FROM TblDetalleComprobanteDonacion t"),
    @NamedQuery(name = "TblDetalleComprobanteDonacion.findByComprobanteDonacion", query = "SELECT t FROM TblDetalleComprobanteDonacion t WHERE t.tblDetalleComprobanteDonacionPK.numComDonacion = :numComDonacion")
    //@NamedQuery(name = "TblComprobanteDonacion.findByNumFacDonacion", query = "SELECT t FROM TblComprobanteDonacion t where  = :numFacDonacion")    
})
public class TblDetalleComprobanteDonacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblDetalleComprobanteDonacionPK tblDetalleComprobanteDonacionPK = new TblDetalleComprobanteDonacionPK();
    @Basic
    @Column(name = "COR_DET_COM_DONACION")
    private int corDetComDonacion;
    @Basic
    @Column(name = "PRE_UNI_COM_DONACION")
    private float preUniComDonacion;
    @Basic
    @Column(name = "CAN_PRO_COM_DONACION")
    private int canProComDonacion;
    @Basic
    @Column(name = "TOT_ITE_COM_DONACION")
    private float totIteComDonacion;
    @Basic
    @Column(name = "NUM_CONSULTA")
    private Integer numConsulta;
    
    @Basic
    @Column(name = "NUM_SER_ENFERMERIA")
    private Integer numSerEnfermeria;

    @Basic
    @Column(name = "NUM_RECETA")
    private Integer numReceta;
    
    @ManyToOne    
    @JoinColumn(name = "NUM_PRODUCTO", referencedColumnName = "NUM_PRODUCTO", insertable = false, updatable = false)
    private TblProducto tblProducto;
    
    @JoinColumn(name = "NUM_COM_DONACION", referencedColumnName = "NUM_COM_DONACION", insertable = false, updatable = false)
    @ManyToOne
    private TblComprobanteDonacion tblComprobanteDonacion;

    @Transient
    private String presentacion;

    public TblDetalleComprobanteDonacion() {
    }

    public TblDetalleComprobanteDonacion(TblDetalleComprobanteDonacionPK tblDetalleComprobanteDonacionPK) {
        this.tblDetalleComprobanteDonacionPK = tblDetalleComprobanteDonacionPK;
    }

    public TblDetalleComprobanteDonacion(TblDetalleComprobanteDonacionPK tblDetalleComprobanteDonacionPK, int corDetComDonacion, float preUniComDonacion, int canProComDonacion, float totIteComDonacion) {
        this.tblDetalleComprobanteDonacionPK = tblDetalleComprobanteDonacionPK;
        this.corDetComDonacion = corDetComDonacion;
        this.preUniComDonacion = preUniComDonacion;
        this.canProComDonacion = canProComDonacion;
        this.totIteComDonacion = totIteComDonacion;
    }

    public TblDetalleComprobanteDonacion(int numComDonacion, int numProducto) {
        this.tblDetalleComprobanteDonacionPK = new TblDetalleComprobanteDonacionPK(numComDonacion, numProducto);
    }

    public Integer getNumReceta() {
        return numReceta;
    }

    public void setNumReceta(Integer numReceta) {
        this.numReceta = numReceta;
    }
    
    public Integer getNumConsulta() {
        return numConsulta;
    }

    public void setNumConsulta(Integer numConsulta) {
        this.numConsulta = numConsulta;
    }

    public Integer getNumSerEnfermeria() {
        return numSerEnfermeria;
    }

    public void setNumSerEnfermeria(Integer numSerEnfermeria) {
        this.numSerEnfermeria = numSerEnfermeria;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public TblProducto getTblProducto() {
        return tblProducto;
    }

    public void setTblProducto(TblProducto tblProducto) {
        this.tblProducto = tblProducto;
    }


    public TblDetalleComprobanteDonacionPK getTblDetalleComprobanteDonacionPK() {
        return tblDetalleComprobanteDonacionPK;
    }

    public void setTblDetalleComprobanteDonacionPK(TblDetalleComprobanteDonacionPK tblDetalleComprobanteDonacionPK) {
        this.tblDetalleComprobanteDonacionPK = tblDetalleComprobanteDonacionPK;
    }

    public int getCorDetComDonacion() {
        return corDetComDonacion;
    }

    public void setCorDetComDonacion(int corDetComDonacion) {
        this.corDetComDonacion = corDetComDonacion;
    }

    public float getPreUniComDonacion() {
        return preUniComDonacion;
    }

    public void setPreUniComDonacion(float preUniComDonacion) {
        this.preUniComDonacion = preUniComDonacion;
    }

    public int getCanProComDonacion() {
        return canProComDonacion;
    }

    public void setCanProComDonacion(int canProComDonacion) {
        this.canProComDonacion = canProComDonacion;
    }

    public float getTotIteComDonacion() {
        return totIteComDonacion;
    }

    public void setTotIteComDonacion(float totIteComDonacion) {
        this.totIteComDonacion = totIteComDonacion;
    }

    public TblComprobanteDonacion getTblComprobanteDonacion() {
        return tblComprobanteDonacion;
    }

    public void setTblComprobanteDonacion(TblComprobanteDonacion tblComprobanteDonacion) {
        this.tblComprobanteDonacion = tblComprobanteDonacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblDetalleComprobanteDonacionPK != null ? tblDetalleComprobanteDonacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleComprobanteDonacion)) {
            return false;
        }
        TblDetalleComprobanteDonacion other = (TblDetalleComprobanteDonacion) object;
        if ((this.tblDetalleComprobanteDonacionPK == null && other.tblDetalleComprobanteDonacionPK != null) || (this.tblDetalleComprobanteDonacionPK != null && !this.tblDetalleComprobanteDonacionPK.equals(other.tblDetalleComprobanteDonacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.colecturia.TblDetalleComprobanteDonacion[ tblDetalleComprobanteDonacionPK=" + tblDetalleComprobanteDonacionPK + " ]";
    }
    
}
