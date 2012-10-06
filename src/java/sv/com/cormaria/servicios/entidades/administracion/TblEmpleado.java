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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @Basic(optional = false)
    @NotNull(message = "Ingrese la fecha de registro del empleado")
    @Column(name = "FEC_REG_EMPLEADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegEmpleado;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el nombre del empleado")
    @Size(min = 1, max = 30, message = "El nombre del empleado no debe ser mayor de 30 caracteres")
    @Column(name = "NOM_EMPLEADO")
    private String nomEmpleado;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el primer apellido del empleado")
    @Size(min = 1, max = 15, message = "El primer apellido del empleado no debe ser mayor de 15 caracteres")
    @Column(name = "PRI_APE_EMPLEADO")
    private String priApeEmpleado;
    @Size(max = 15, message = "El segundo apellido del empleado no debe ser mayor de 15 caracteres")
    @Column(name = "SEC_APE_EMPLEADO")
    private String secApeEmpleado;
    @Size(max = 15, message = "El tercer apellido del empleado no debe ser mayor de 15 caracteres")
    @Column(name = "TER_APE_EMPLEADO")
    private String terApeEmpleado;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la direccion del empleado")
    @Size(min = 1, max = 250, message = "La direccion del empleado no debe ser mayor de 250 caracteres")
    @Column(name = "DIR_EMPLEADO")
    private String dirEmpleado;
    @Column(name = "TEL_EMPLEADO")
    private Integer telEmpleado;
    @Column(name = "CEL_EMPLEADO")
    private Integer celEmpleado;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el NIT del empleado")
    @Column(name = "NIT_EMPLEADO")
    private long nitEmpleado;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el DUI del empleado")
    @Column(name = "DUI_EMPLEADO")
    private int duiEmpleado;
    @Basic(optional = false)
    @NotNull(message="Ingrese el codigo de Profesion de Empleado")
    @Column(name = "COD_PROFESION")
    private int codProfesion;
    @Basic(optional = false)
    @NotNull(message="Ingrese el codigo de tipo de Servicio")
    @Column(name = "COD_TIP_SERVICIO")
    private int codTipServicio;
    @Basic(optional = false)
    @NotNull(message="Ingrese el codigo del area")
    @Column(name = "COD_AREA")
    private int codArea;
    @Column(name = "ACT_EMPLEADO")
    private int actEmpleado;

    public int getActEmpleado() {
        return actEmpleado;
    }

    public void setActEmpleado(int actEmpleado) {
        this.actEmpleado = actEmpleado;
    }

    public int getCodArea() {
        return codArea;
    }

    public void setCodArea(int codArea) {
        this.codArea = codArea;
    }

    public int getCodProfesion() {
        return codProfesion;
    }

    public void setCodProfesion(int codProfesion) {
        this.codProfesion = codProfesion;
    }

    public int getCodTipServicio() {
        return codTipServicio;
    }

    public void setCodTipServicio(int codTipServicio) {
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
