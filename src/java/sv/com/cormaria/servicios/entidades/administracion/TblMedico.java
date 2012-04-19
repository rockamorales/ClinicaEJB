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
import javax.validation.constraints.Size;
import sv.com.cormaria.servicios.entidades.catalogos.CatEspecialidad;
import sv.com.cormaria.servicios.enums.Estado;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_medico")
@NamedQueries({
    @NamedQuery(name = "TblMedico.findAll", query = "SELECT t FROM TblMedico t")
})
public class TblMedico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name = "NUM_MEDICO")
    private Integer numMedico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_ING_MEDICO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecIngMedico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOM_MEDICO")
    private String nomMedico;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "PRI_APE_MEDICO")
    private String priApeMedico;
    @Size(max = 15)
    @Column(name = "SEC_APE_MEDICO")
    private String secApeMedico;
    @Size(max = 15)
    @Column(name = "TER_APE_MEDICO")
    private String terApeMedico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_JUNTA")
    private int numJunta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "DIR_PER_MEDICO")
    private String dirPerMedico;
    @Size(max = 250)
    @Column(name = "DIR_CLI_MEDICO")
    private String dirCliMedico;
    @Column(name = "TEL_PER_MEDICO")
    private Integer telPerMedico;
    @Column(name = "TEL_CLI_MEDICO")
    private Integer telCliMedico;
    @Column(name = "TEL_CEL_MEDICO")
    private Integer telCelMedico;
    @Size(max = 100)
    @Column(name = "COR_MEDICO")
    private String corMedico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DUI_MEDICO")
    private int duiMedico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NIT_MEDICO")
    private long nitMedico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VAL_CON_MEDICO")
    private float valConMedico;
    @NotNull
    @Column(name = "ACT_MEDICO")
    private Estado actMedico;
    @NotNull
    @Column(name = "COD_ESPECIALIDAD")
    private Integer codEspecialidad;
    @NotNull
    @Column(name = "COD_TIP_SERVICIO")
    private Integer codTipServicio;

    @ManyToOne
    @JoinColumn(name="COD_ESPECIALIDAD", referencedColumnName="COD_ESPECIALIDAD", insertable=false, updatable=false)
    private CatEspecialidad catEspecialidad;    
    public TblMedico() {
    }

    public TblMedico(Integer numMedico) {
        this.numMedico = numMedico;
    }

    public TblMedico(Integer numMedico, Date fecIngMedico, String nomMedico, String priApeMedico, int numJunta, String dirPerMedico, int duiMedico, long nitMedico, float valConMedico) {
        this.numMedico = numMedico;
        this.fecIngMedico = fecIngMedico;
        this.nomMedico = nomMedico;
        this.priApeMedico = priApeMedico;
        this.numJunta = numJunta;
        this.dirPerMedico = dirPerMedico;
        this.duiMedico = duiMedico;
        this.nitMedico = nitMedico;
        this.valConMedico = valConMedico;
    }

    public Integer getNumMedico() {
        return numMedico;
    }

    public void setNumMedico(Integer numMedico) {
        this.numMedico = numMedico;
    }

    public Date getFecIngMedico() {
        return fecIngMedico;
    }

    public void setFecIngMedico(Date fecIngMedico) {
        this.fecIngMedico = fecIngMedico;
    }

    public String getNomMedico() {
        return nomMedico;
    }

    public void setNomMedico(String nomMedico) {
        this.nomMedico = nomMedico;
    }

    public String getPriApeMedico() {
        return priApeMedico;
    }

    public void setPriApeMedico(String priApeMedico) {
        this.priApeMedico = priApeMedico;
    }

    public String getSecApeMedico() {
        return secApeMedico;
    }

    public void setSecApeMedico(String secApeMedico) {
        this.secApeMedico = secApeMedico;
    }

    public String getTerApeMedico() {
        return terApeMedico;
    }

    public void setTerApeMedico(String terApeMedico) {
        this.terApeMedico = terApeMedico;
    }

    public int getNumJunta() {
        return numJunta;
    }

    public void setNumJunta(int numJunta) {
        this.numJunta = numJunta;
    }

    public String getDirPerMedico() {
        return dirPerMedico;
    }

    public void setDirPerMedico(String dirPerMedico) {
        this.dirPerMedico = dirPerMedico;
    }

    public String getDirCliMedico() {
        return dirCliMedico;
    }

    public void setDirCliMedico(String dirCliMedico) {
        this.dirCliMedico = dirCliMedico;
    }

    public Integer getTelPerMedico() {
        return telPerMedico;
    }

    public void setTelPerMedico(Integer telPerMedico) {
        this.telPerMedico = telPerMedico;
    }

    public Integer getTelCliMedico() {
        return telCliMedico;
    }

    public void setTelCliMedico(Integer telCliMedico) {
        this.telCliMedico = telCliMedico;
    }

    public Integer getTelCelMedico() {
        return telCelMedico;
    }

    public void setTelCelMedico(Integer telCelMedico) {
        this.telCelMedico = telCelMedico;
    }

    public String getCorMedico() {
        return corMedico;
    }

    public void setCorMedico(String corMedico) {
        this.corMedico = corMedico;
    }

    public int getDuiMedico() {
        return duiMedico;
    }

    public void setDuiMedico(int duiMedico) {
        this.duiMedico = duiMedico;
    }

    public long getNitMedico() {
        return nitMedico;
    }

    public void setNitMedico(long nitMedico) {
        this.nitMedico = nitMedico;
    }

    public float getValConMedico() {
        return valConMedico;
    }

    public void setValConMedico(float valConMedico) {
        this.valConMedico = valConMedico;
    }

    public Estado getActMedico() {
        return actMedico;
    }

    public void setActMedico(Estado actMedico) {
        this.actMedico = actMedico;
    }

    public CatEspecialidad getCatEspecialidad() {
        return catEspecialidad;
    }

    public void setCatEspecialidad(CatEspecialidad catEspecialidad) {
        this.catEspecialidad = catEspecialidad;
    }

    public Integer getCodEspecialidad() {
        return codEspecialidad;
    }

    public void setCodEspecialidad(Integer codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
    }

    public Integer getCodTipServicio() {
        return codTipServicio;
    }

    public void setCodTipServicio(Integer codTipServicio) {
        this.codTipServicio = codTipServicio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numMedico != null ? numMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMedico)) {
            return false;
        }
        TblMedico other = (TblMedico) object;
        if ((this.numMedico == null && other.numMedico != null) || (this.numMedico != null && !this.numMedico.equals(other.numMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.consultasmedicas.TblMedico[ numMedico=" + numMedico + " ]";
    }
    
}
