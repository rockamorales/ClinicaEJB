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
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ManyToAny;
import sv.com.cormaria.servicios.entidades.catalogos.CatAreas;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoTransaccion;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_movimientos_expediente")
@NamedQueries({
    @NamedQuery(name = "TblMovimientosExpediente.findAll", query = "SELECT t FROM TblMovimientosExpediente t"),
    @NamedQuery(name = "TblMovimientosExpediente.findLastRecord", query = "SELECT t FROM TblMovimientosExpediente t where t.numTransaccion = (select max(t1.numTransaccion) from TblMovimientosExpediente t1 where t1.numExpediente = :numExpediente)"),
    @NamedQuery(name = "TblMovimientosExpediente.findByNumExpediente", query = "SELECT t FROM TblMovimientosExpediente t where t.numExpediente = :numExpediente order by t.fecTransaccion desc")
})
public class TblMovimientosExpediente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull(message = "Ingrese el numero de transaccion")
    @Column(name = "NUM_TRANSACCION")
    private Integer numTransaccion;

    @Basic(optional = false)
    @Column(name = "FEC_TRANSACCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecTransaccion;

    @Column(name = "NUM_EMPLEADO")
    private Integer numEmpleado;

    @Column(name = "COD_AREA")
    private Integer codArea;

    @Column(name = "NUM_EXPEDIENTE")
    private Integer numExpediente;

    @Column(name = "COD_TIP_TRANSACCION")
    private Integer codTipTransaccion;

    @Column(name = "CAT_COD_AREA")
    private Integer catCodArea;
   
    @ManyToOne
    @JoinColumn(name="COD_AREA",referencedColumnName="COD_AREA", insertable=false, updatable=false)
    private CatAreas catAreaOrigen;

    @ManyToOne
    @JoinColumn(name="CAT_COD_AREA",referencedColumnName="COD_AREA", insertable=false, updatable=false)
    private CatAreas catAreaDestino;
    
    @ManyToOne
    @JoinColumn(name="NUM_EMPLEADO",referencedColumnName="NUM_EMPLEADO", insertable=false, updatable=false)
    private TblEmpleado registradoPor;

    @ManyToOne
    @JoinColumn(name="COD_TIP_TRANSACCION",referencedColumnName="COD_TIP_TRANSACCION", insertable=false, updatable=false)
    private CatTipoTransaccion tipTransaccion;
    
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

    public TblEmpleado getRegistradoPor() {
        return registradoPor;
    }

    public void setRegistradoPor(TblEmpleado registradoPor) {
        this.registradoPor = registradoPor;
    }

    public CatTipoTransaccion getTipTransaccion() {
        return tipTransaccion;
    }

    public void setTipTransaccion(CatTipoTransaccion tipTransaccion) {
        this.tipTransaccion = tipTransaccion;
    }
    
    public CatAreas getCatAreaOrigen() {
        return catAreaOrigen;
    }

    public void setCatAreaOrigen(CatAreas catAreaOrigen) {
        this.catAreaOrigen = catAreaOrigen;
    }

    public CatAreas getCatAreaDestino() {
        return catAreaDestino;
    }

    public void setCatAreaDestino(CatAreas catAreaDestino) {
        this.catAreaDestino = catAreaDestino;
    }

    public Date getFecTransaccion() {
        return fecTransaccion;
    }

    public void setFecTransaccion(Date fecTransaccion) {
        this.fecTransaccion = fecTransaccion;
    }

    public Integer getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(Integer numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public Integer getCodArea() {
        return codArea;
    }

    public void setCodArea(Integer codArea) {
        this.codArea = codArea;
    }

    public Integer getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(Integer numExpediente) {
        this.numExpediente = numExpediente;
    }

    public Integer getCodTipTransaccion() {
        return codTipTransaccion;
    }

    public void setCodTipTransaccion(Integer codTipTransaccion) {
        this.codTipTransaccion = codTipTransaccion;
    }

    public Integer getCatCodArea() {
        return catCodArea;
    }

    public void setCatCodArea(Integer catCodArea) {
        this.catCodArea = catCodArea;
    }
    
    @PrePersist
    public void prePersist(){
        this.fecTransaccion = new java.util.Date();
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
