/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.farmacia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import sv.com.cormaria.servicios.entidades.administracion.TblProducto;
import sv.com.cormaria.servicios.enums.Estado;
import sv.com.cormaria.servicios.enums.TipoAlertas;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_historial_alerta")
@NamedQueries({
    @NamedQuery(name = "TblHistorialAlerta.findAll", query = "SELECT t FROM TblHistorialAlerta t") ,
    @NamedQuery(name = "TblHistorialAlerta.findActive", query = "SELECT u FROM TblHistorialAlerta u where u.estAlerta = 1"),
    @NamedQuery(name = "TblHistorialAlerta.findInactive", query = "SELECT u FROM TblHistorialAlerta u where u.estAlerta = 0"),
    @NamedQuery(name = "TblHistorialAlerta.findbyProducto", query = "SELECT u FROM TblHistorialAlerta u where u.estAlerta =1"),
})

public class TblHistorialAlerta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUM_ALERTA")
    private Integer numAlerta;
    @NotNull(message = "Ingrese el tipo de alerta")
    @Size(min = 1, max = 50, message = "El tipo de alerta debe ser menor a 50 caracteres")
    @Enumerated(EnumType.STRING)
    @Column(name = "TIP_ALERTA")
    private TipoAlertas tipAlerta;
    @NotNull(message = "Inserte la fecha y hora de la alerta")
    @Column(name = "FEC_HOR_ALERTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecHorAlerta;
    @Column(name = "FEC_VENCIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecVencimiento;
    @Column(name = "MIN_EXISTENCIAS")
    private Integer minExistencias;
    @Column(name = "CAN_PRODUCTO")
    private Integer canProducto;
    @Column(name = "EST_ALERTA")
    private Estado estAlerta;
    @NotNull(message = "Ingrese el usuario alertado")
    @Size(min = 1, max = 30)
    @Column(name = "USU_ALERTADO")
    private String usuAlertado;

    @Column(name = "NUM_PRODUCTO")
    private Integer numProducto;

    @JoinColumn(name = "NUM_PRODUCTO", referencedColumnName = "NUM_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne
    private TblProducto tblProducto;
    
    //@ManyToOne
    //@JoinColumns({
    //    @JoinColumn(name = "NUM_PRODUCTO", referencedColumnName = "NUM_PRODUCTO", insertable = false, updatable = false),
    //    @JoinColumn(name = "NUM_INGRESO", referencedColumnName = "NUM_INGRESO", insertable = false, updatable = false)
    //})
    //private TblDetalleIngresoProducto tblDetalleIngresoProducto;

    //public TblDetalleIngresoProducto getTblDetalleIngresoProducto() {
    //    return tblDetalleIngresoProducto;
    //}

    //public void setTblDetalleIngresoProducto(TblDetalleIngresoProducto tblDetalleIngresoProducto) {
    //    this.tblDetalleIngresoProducto = tblDetalleIngresoProducto;
    //}
    
    public TblHistorialAlerta() {
    }

    public TblHistorialAlerta(Integer numAlerta) {
        this.numAlerta = numAlerta;
    }

    public TipoAlertas getTipAlerta() {
        return tipAlerta;
    }

    public void setTipAlerta(TipoAlertas tipAlerta) {
        this.tipAlerta = tipAlerta;
    }

    public Integer getNumAlerta() {
        return numAlerta;
    }

    public Integer getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(Integer numProducto) {
        this.numProducto = numProducto;
    }

    public void setNumAlerta(Integer numAlerta) {
        this.numAlerta = numAlerta;
    }

    public Date getFecVencimiento() {
        return fecVencimiento;
    }

    public void setFecVencimiento(Date fecVencimiento) {
        this.fecVencimiento = fecVencimiento;
    }

    public Integer getMinExistencias() {
        return minExistencias;
    }

    public void setMinExistencias(Integer minExistencias) {
        this.minExistencias = minExistencias;
    }

    public Integer getCanProducto() {
        return canProducto;
    }

    public void setCanProducto(Integer canProducto) {
        this.canProducto = canProducto;
    }

    public Estado getEstAlerta() {
        return estAlerta;
    }

    public void setEstAlerta(Estado estAlerta) {
        this.estAlerta = estAlerta;
    }


    public Date getFecHorAlerta() {
        return fecHorAlerta;
    }

    public void setFecHorAlerta(Date fecHorAlerta) {
        this.fecHorAlerta = fecHorAlerta;
    }

    public String getUsuAlertado() {
        return usuAlertado;
    }

    public void setUsuAlertado(String usuAlertado) {
        this.usuAlertado = usuAlertado;
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
        hash += (numAlerta != null ? numAlerta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblHistorialAlerta)) {
            return false;
        }
        TblHistorialAlerta other = (TblHistorialAlerta) object;
        if ((this.numAlerta == null && other.numAlerta != null) || (this.numAlerta != null && !this.numAlerta.equals(other.numAlerta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.farmacia.TblHistorialAlerta[ numAlerta=" + numAlerta + " ]";
    }
    
}
