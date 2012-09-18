/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.archivo;

import java.io.Serializable;
import java.util.Collection;
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
import sv.com.cormaria.servicios.entidades.catalogos.CatSexo;
import sv.com.cormaria.servicios.entidades.catalogos.CatUbicacionFisica;
import sv.com.cormaria.servicios.enums.Estado;

/**
 *
 * @author Claudia
 */
@Entity
@Table(name = "tbl_expediente_pacientes")
@NamedQueries({
    @NamedQuery(name = "TblExpedientePacientes.findAll", query = "SELECT t FROM TblExpedientePacientes t where t.estPaciente = 1")})

public class TblExpedientePacientes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic 
    @Column(name = "NUM_EXPEDIENTE")
    private Integer numExpediente;
    @Basic
    @Column(name = "COD_OCUPACION")
    private int codOcupacion;
    @Basic
    @Column(name = "COD_EST_CIVIL")
    private int codEstCivil;
    @Basic
    @Column(name = "COD_SEX_PACIENTE")
    private int codSexPaciente;
    @Basic
    @Column(name = "COD_PAR_RESPONSABLE")
    private int codParResponsable;
    @Basic
    @Column(name = "FEC_REG_EXPEDIENTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegExpediente;
    @Basic
    @Column(name = "NOM_PACIENTE")
    private String nomPaciente;
    @Basic
    @Column(name = "PRI_APE_PACIENTE")
    private String priApePaciente;
    @Basic
    @Column(name = "SEC_APE_PACIENTE")
    private String secApePaciente;
    @Basic
    @Column(name = "TER_APE_PACIENTE")
    private String terApePaciente;
    @Basic
    @Column(name = "FEC_NAC_PACIENTE")
    @Temporal(TemporalType.DATE)
    private Date fecNacPaciente;
    @Basic
    @Column(name = "EDA_PACIENTE")
    private short edaPaciente;
    @Basic
    @Column(name = "NUM_DUI")
    private String numDui;
    @Basic
    @Column(name = "LUG_PROC_PACIENTE")
    private String lugProcPaciente;
    @Basic
    @Column(name = "DIR_PACIENTE")
    private String dirPaciente;
    @Basic
    @Column(name = "TEL_PACIENTE")
    private Integer telPaciente;
    @Basic
    @Column(name = "NOM_PAD_PACIENTE")
    private String nomPadPaciente;
    @Basic
    @Column(name = "NOM_MAD_PACIENTE")
    private String nomMadPaciente;
    @Basic
    @Column(name = "NOM_CON_PACIENTE")
    private String nomConPaciente;
    @Basic
    @Column(name = "NOM_RES_PACIENTE")
    private String nomResPaciente;
    @Basic
    @Column(name = "DIR_RES_PACIENTE")
    private String dirResPaciente;
    @Basic
    @Column(name = "TEL_RES_PACIENTE")
    private Integer telResPaciente;
    @Basic
    @Column(name = "EST_PACIENTE")
    private Estado estPaciente;
    @JoinColumn(name = "COD_UBI_FISICA", referencedColumnName = "COD_UBI_FISICA", insertable=false, updatable=false)
    @ManyToOne
    private CatUbicacionFisica catUbicacionFisica;
    @Column(name = "COD_UBI_FISICA")
    private Integer codUbiFisica;
    @ManyToOne
    @JoinColumn(name="COD_SEX_PACIENTE",referencedColumnName="COD_SEX_PACIENTE",insertable=false, updatable=false)
    private CatSexo catSexo;
    
    @Column(name = "ENF_CRO_PACIENTE")
    private String enfCroPaciente;
    
    @Column(name = "ALE_PACIENTE")
    private String alePaciente;

    public TblExpedientePacientes() {
    }

    public CatSexo getCatSexo() {
        return catSexo;
    }

    public void setCatSexo(CatSexo catSexo) {
        this.catSexo = catSexo;
    }
    
    
    public Integer getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(Integer numExpediente) {
        this.numExpediente = numExpediente;
    }

    public int getCodOcupacion() {
        return codOcupacion;
    }

    public void setCodOcupacion(int codOcupacion) {
        this.codOcupacion = codOcupacion;
    }

    public int getCodEstCivil() {
        return codEstCivil;
    }

    public void setCodEstCivil(int codEstCivil) {
        this.codEstCivil = codEstCivil;
    }

    public int getCodSexPaciente() {
        return codSexPaciente;
    }

    public void setCodSexPaciente(int codSexPaciente) {
        this.codSexPaciente = codSexPaciente;
    }

    public int getCodParResponsable() {
        return codParResponsable;
    }

    public void setCodParResponsable(int codParResponsable) {
        this.codParResponsable = codParResponsable;
    }

    public Date getFecRegExpediente() {
        return fecRegExpediente;
    }

    public void setFecRegExpediente(Date fecRegExpediente) {
        this.fecRegExpediente = fecRegExpediente;
    }

    public String getNomPaciente() {
        return nomPaciente;
    }

    public void setNomPaciente(String nomPaciente) {
        this.nomPaciente = nomPaciente;
    }

    public String getPriApePaciente() {
        return priApePaciente;
    }

    public void setPriApePaciente(String priApePaciente) {
        this.priApePaciente = priApePaciente;
    }

    public String getSecApePaciente() {
        return secApePaciente;
    }

    public void setSecApePaciente(String secApePaciente) {
        this.secApePaciente = secApePaciente;
    }

    public String getTerApePaciente() {
        return terApePaciente;
    }

    public void setTerApePaciente(String terApePaciente) {
        this.terApePaciente = terApePaciente;
    }

    public Date getFecNacPaciente() {
        return fecNacPaciente;
    }

    public void setFecNacPaciente(Date fecNacPaciente) {
        this.fecNacPaciente = fecNacPaciente;
    }

    public short getEdaPaciente() {
        return edaPaciente;
    }

    public void setEdaPaciente(short edaPaciente) {
        this.edaPaciente = edaPaciente;
    }

    public String getNumDui() {
        return numDui;
    }

    public void setNumDui(String numDui) {
        this.numDui = numDui;
    }

    public String getLugProcPaciente() {
        return lugProcPaciente;
    }

    public void setLugProcPaciente(String lugProcPaciente) {
        this.lugProcPaciente = lugProcPaciente;
    }

    public String getDirPaciente() {
        return dirPaciente;
    }

    public void setDirPaciente(String dirPaciente) {
        this.dirPaciente = dirPaciente;
    }

    public Integer getTelPaciente() {
        return telPaciente;
    }

    public void setTelPaciente(Integer telPaciente) {
        this.telPaciente = telPaciente;
    }

    public String getNomPadPaciente() {
        return nomPadPaciente;
    }

    public void setNomPadPaciente(String nomPadPaciente) {
        this.nomPadPaciente = nomPadPaciente;
    }

    public String getNomMadPaciente() {
        return nomMadPaciente;
    }

    public void setNomMadPaciente(String nomMadPaciente) {
        this.nomMadPaciente = nomMadPaciente;
    }

    public String getNomConPaciente() {
        return nomConPaciente;
    }

    public void setNomConPaciente(String nomConPaciente) {
        this.nomConPaciente = nomConPaciente;
    }

    public String getNomResPaciente() {
        return nomResPaciente;
    }

    public void setNomResPaciente(String nomResPaciente) {
        this.nomResPaciente = nomResPaciente;
    }

    public String getDirResPaciente() {
        return dirResPaciente;
    }

    public void setDirResPaciente(String dirResPaciente) {
        this.dirResPaciente = dirResPaciente;
    }

    public Integer getTelResPaciente() {
        return telResPaciente;
    }

    public void setTelResPaciente(Integer telResPaciente) {
        this.telResPaciente = telResPaciente;
    }

    public Estado getEstPaciente() {
        return estPaciente;
    }

    public void setEstPaciente(Estado estPaciente) {
        this.estPaciente = estPaciente;
    }

    public CatUbicacionFisica getCatUbicacionFisica() {
        return catUbicacionFisica;
    }

    public void setCatUbicacionFisica(CatUbicacionFisica catUbicacionFisica) {
        this.catUbicacionFisica = catUbicacionFisica;
    }

    public Integer getCodUbiFisica() {
        return codUbiFisica;
    }

    public void setCodUbiFisica(Integer codUbiFisica) {
        this.codUbiFisica = codUbiFisica;
    }

    public String getEnfCroPaciente() {
        return enfCroPaciente;
    }

    public void setEnfCroPaciente(String enfCroPaciente) {
        this.enfCroPaciente = enfCroPaciente;
    }

    public String getAlePaciente() {
        return alePaciente;
    }

    public void setAlePaciente(String alePaciente) {
        this.alePaciente = alePaciente;
    }
    
    @PrePersist
    public void prePersist(){
      this.fecRegExpediente = new java.util.Date();
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numExpediente != null ? numExpediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblExpedientePacientes)) {
            return false;
        }
        TblExpedientePacientes other = (TblExpedientePacientes) object;
        if ((this.numExpediente == null && other.numExpediente != null) || (this.numExpediente != null && !this.numExpediente.equals(other.numExpediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.TblExpedientePacientes[ numExpediente=" + numExpediente + " ]";
    }
    
}
