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
import sv.com.cormaria.servicios.entidades.catalogos.CatAreas;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoRequisicion;
import sv.com.cormaria.servicios.enums.EstadoRequisicion;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_requisiciones")
@NamedQueries({
    @NamedQuery(name = "TblRequisiciones.findAll", query = "SELECT t FROM TblRequisiciones t"),
    @NamedQuery(name = "TblRequisiciones.findActive", query = "SELECT t FROM TblRequisiciones t where t.estRequisicion = 1")
})
public class TblRequisiciones implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull(message = "Ingrese el numero de requisicion")
    @Column(name = "NUM_REQUISICION")
    private Integer numRequisicion;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la fecha de la requisicion")
    @Column(name = "FEC_REQUISICION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRequisicion;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el estado de la requisicion")
    @Column(name = "EST_REQUISICION")
    private EstadoRequisicion estRequisicion;
    @Column (name = "NUM_EMPLEADO")
    private Integer numEmpleado;
    @JoinColumn(name = "NUM_EMPLEADO", referencedColumnName = "NUM_EMPLEADO", updatable=false, insertable=false)
    @ManyToOne
    private TblEmpleado tblEmpleado;
    @Column (name = "COD_AREA")
    private Integer codArea;
    @JoinColumn(name = "COD_AREA", referencedColumnName = "COD_AREA", updatable=false, insertable=false)
    @ManyToOne
    private CatAreas catArea;
    @Column (name = "COD_TIP_REQUISICION")
    private Integer codTipRequisicion;
    @JoinColumn(name = "COD_TIP_REQUISICION", referencedColumnName = "COD_TIP_REQUISICION", updatable=false, insertable=false)
    @ManyToOne(optional = false)
    private CatTipoRequisicion catTipoRequisicion;
    public TblRequisiciones() {
    }

    public TblRequisiciones(Integer numRequisicion) {
        this.numRequisicion = numRequisicion;
    }

    public TblRequisiciones(Integer numRequisicion, Date fecRequisicion, EstadoRequisicion estRequisicion) {
        this.numRequisicion = numRequisicion;
        this.fecRequisicion = fecRequisicion;
        this.estRequisicion = estRequisicion;
    }

    public Integer getCodTipRequisicion() {
        return codTipRequisicion;
    }

    public void setCodTipRequisicion(Integer codTipRequisicion) {
        this.codTipRequisicion = codTipRequisicion;
    }

    public CatTipoRequisicion getCatTipoRequisicion() {
        return catTipoRequisicion;
    }

    public void setCatTipoRequisicion(CatTipoRequisicion catTipoRequisicion) {
        this.catTipoRequisicion = catTipoRequisicion;
    }

    public Integer getNumRequisicion() {
        return numRequisicion;
    }

    public void setNumRequisicion(Integer numRequisicion) {
        this.numRequisicion = numRequisicion;
    }

    public CatAreas getCatArea() {
        return catArea;
    }

    public void setCatArea(CatAreas catArea) {
        this.catArea = catArea;
    }

    public Integer getCodArea() {
        return codArea;
    }

    public void setCodArea(Integer codArea) {
        this.codArea = codArea;
    }

    public Integer getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(Integer numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public TblEmpleado getTblEmpleado() {
        return tblEmpleado;
    }

    public void setTblEmpleado(TblEmpleado tblEmpleado) {
        this.tblEmpleado = tblEmpleado;
    }

    public Date getFecRequisicion() {
        return fecRequisicion;
    }

    public void setFecRequisicion(Date fecRequisicion) {
        this.fecRequisicion = fecRequisicion;
    }    

    public EstadoRequisicion getEstRequisicion() {
        return estRequisicion;
    }

    public void setEstRequisicion(EstadoRequisicion estRequisicion) {
        this.estRequisicion = estRequisicion;
    }
    
    @PrePersist
    public void prePersist(){
        this.fecRequisicion = new java.util.Date();
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numRequisicion != null ? numRequisicion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRequisiciones)) {
            return false;
        }
        TblRequisiciones other = (TblRequisiciones) object;
        if ((this.numRequisicion == null && other.numRequisicion != null) || (this.numRequisicion != null && !this.numRequisicion.equals(other.numRequisicion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblRequisiciones[ numRequisicion=" + numRequisicion + " ]";
    }
    
}
