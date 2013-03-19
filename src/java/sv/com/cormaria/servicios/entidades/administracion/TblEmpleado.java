/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.administracion;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import sv.com.cormaria.servicios.enums.Estado;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_empleado")
@NamedQueries({
    @NamedQuery(name = "TblEmpleado.findAll", query = "SELECT t FROM TblEmpleado t"),
    @NamedQuery(name = "TblEmpleado.findActive", query = "SELECT c FROM TblEmpleado c where actEmpleado=1 ")
})
public class TblEmpleado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_EMPLEADO")
    private Integer numEmpleado;
    @Column(name = "FEC_REG_EMPLEADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegEmpleado;
    @Column(name = "NOM_EMPLEADO")
    private String nomEmpleado;
    @Column(name = "PRI_APE_EMPLEADO")
    private String priApeEmpleado;
    @Column(name = "SEC_APE_EMPLEADO")
    private String secApeEmpleado;
    @Column(name = "TER_APE_EMPLEADO")
    private String terApeEmpleado;
    @Column(name = "DIR_EMPLEADO")
    private String dirEmpleado;
    @Column(name = "TEL_EMPLEADO")
    private Integer telEmpleado;
    @Column(name = "CEL_EMPLEADO")
    private Integer celEmpleado;
    @Column(name = "NIT_EMPLEADO")
    private long nitEmpleado;
    @Column(name = "DUI_EMPLEADO")
    private int duiEmpleado;
    @Column(name = "COD_PROFESION")
    private int codProfesion;
    @Column(name = "COD_TIP_SERVICIO")
    private int codTipServicio;
    @Column(name = "COD_AREA")
    private int codArea;
    @Column(name = "ACT_EMPLEADO")
    @Enumerated
    private Estado actEmpleado;

    public Estado getActEmpleado() {
        return actEmpleado;
    }

    public void setActEmpleado(Estado actEmpleado) {
        this.actEmpleado = actEmpleado;
    }

    
    public Integer getCodArea() {
        return codArea;
    }

    public void setCodArea(Integer codArea) {
        this.codArea = codArea;
    }

    public Integer getCodProfesion() {
        return codProfesion;
    }

    public void setCodProfesion(Integer codProfesion) {
        this.codProfesion = codProfesion;
    }

    public Integer getCodTipServicio() {
        return codTipServicio;
    }

    public void setCodTipServicio(Integer codTipServicio) {
        this.codTipServicio = codTipServicio;
    }


    public TblEmpleado() {
    }

    public TblEmpleado(Integer numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public TblEmpleado(Integer numEmpleado, Date fecRegEmpleado, String nomEmpleado, String priApeEmpleado, String dirEmpleado, long nitEmpleado, int duiEmpleado) {
        this.numEmpleado = numEmpleado;
        this.fecRegEmpleado = fecRegEmpleado;
        this.nomEmpleado = nomEmpleado;
        this.priApeEmpleado = priApeEmpleado;
        this.dirEmpleado = dirEmpleado;
        this.nitEmpleado = nitEmpleado;
        this.duiEmpleado = duiEmpleado;
    }

    public Integer getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(Integer numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public Date getFecRegEmpleado() {
        return fecRegEmpleado;
    }

    public void setFecRegEmpleado(Date fecRegEmpleado) {
        this.fecRegEmpleado = fecRegEmpleado;
    }

    public String getNomEmpleado() {
        return nomEmpleado;
    }

    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }

    public String getPriApeEmpleado() {
        return priApeEmpleado;
    }

    public void setPriApeEmpleado(String priApeEmpleado) {
        this.priApeEmpleado = priApeEmpleado;
    }

    public String getSecApeEmpleado() {
        return secApeEmpleado;
    }

    public void setSecApeEmpleado(String secApeEmpleado) {
        this.secApeEmpleado = secApeEmpleado;
    }

    public String getTerApeEmpleado() {
        return terApeEmpleado;
    }

    public void setTerApeEmpleado(String terApeEmpleado) {
        this.terApeEmpleado = terApeEmpleado;
    }

    public String getDirEmpleado() {
        return dirEmpleado;
    }

    public void setDirEmpleado(String dirEmpleado) {
        this.dirEmpleado = dirEmpleado;
    }

    public Integer getTelEmpleado() {
        return telEmpleado;
    }

    public void setTelEmpleado(Integer telEmpleado) {
        this.telEmpleado = telEmpleado;
    }

    public Integer getCelEmpleado() {
        return celEmpleado;
    }

    public void setCelEmpleado(Integer celEmpleado) {
        this.celEmpleado = celEmpleado;
    }

    public long getNitEmpleado() {
        return nitEmpleado;
    }

    public void setNitEmpleado(long nitEmpleado) {
        this.nitEmpleado = nitEmpleado;
    }

    public int getDuiEmpleado() {
        return duiEmpleado;
    }

    public void setDuiEmpleado(int duiEmpleado) {
        this.duiEmpleado = duiEmpleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numEmpleado != null ? numEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblEmpleado)) {
            return false;
        }
        TblEmpleado other = (TblEmpleado) object;
        if ((this.numEmpleado == null && other.numEmpleado != null) || (this.numEmpleado != null && !this.numEmpleado.equals(other.numEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblEmpleado[ numEmpleado=" + numEmpleado + " ]";
    }
    
}
