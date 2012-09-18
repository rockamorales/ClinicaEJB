/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.consultasmedicas;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import sv.com.cormaria.servicios.entidades.administracion.TblMedico;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoConsulta;
import sv.com.cormaria.servicios.enums.EstadoConsultas;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_consultas")
@NamedQueries({
    @NamedQuery(name = "TblConsultas.findAll", query = "SELECT t FROM TblConsultas t")})
public class TblConsultas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_CONSULTA")
    private Integer numConsulta;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la fecha de la consulta")
    @Column(name = "FEC_CONSULTA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecConsulta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_EXPEDIENTE")
    private Integer numExpediente;
    @Basic
    @Column(name = "TEM_PACIENTE")
    private BigDecimal temPaciente;
    @Basic
    @Column(name = "PUL_PACIENTE")
    private short pulPaciente;
    @Basic
    @Column(name = "PRE_ARTERIAL")
    private String preArterial;
    @Basic
    @Column(name = "PES_PACIENTE")
    private Double pesPaciente;
    @Basic
    @Column(name = "TAL_PACIENTE")
    private Double talPaciente;
    @Basic
    @Column(name = "HIS_CLI_PACIENTE")
    private String hisCliPaciente;
    @Basic
    @Column(name = "ANA_PACIENTE")
    private String anaPaciente;
    @Basic
    @Column(name = "EXA_FIS_PACIENTE")
    private String exaFisPaciente;
    @Basic
    @Column(name = "DIA_PACIENTE")
    private String diaPaciente;
    @Size(max = 1000, message = "Las observaciones no deben ser mayor a 1000 caracteres")
    @Column(name = "OBS_CLI_PACIENTE")
    private String obsCliPaciente;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la edad del paciente")
    @Column(name = "EDA_CONSULTA")
    private short edaConsulta;
    @Basic
    @Column(name = "EST_CONSULTA")
    private EstadoConsultas estConsulta;
    @JoinColumn(name = "NUM_MEDICO", referencedColumnName = "NUM_MEDICO", insertable=false, updatable=false)
    @ManyToOne(optional = false)
    private TblMedico tblMedico;
    @Column(name="NUM_MEDICO")
    private Integer numMedico;
    @Column(name="COD_ESPECIALIDAD")
    private Integer codEspecialidad;
    @JoinColumn(name = "NUM_EXPEDIENTE", referencedColumnName = "NUM_EXPEDIENTE",insertable=false, updatable=false)
    @ManyToOne(optional = false)
    private sv.com.cormaria.servicios.entidades.archivo.TblExpedientePacientes tblExpediente;
    
    @ManyToOne
    @JoinColumn(name = "COD_TIP_CONSULTA", referencedColumnName = "COD_TIP_CONSULTA",insertable=false, updatable=false)
    private CatTipoConsulta catTipoConsulta;
    
    @Column(name="COD_TIP_CONSULTA")
    private Integer codTipConsulta;
    
    public TblConsultas() {
    }

    public TblConsultas(Integer numConsulta) {
        this.numConsulta = numConsulta;
    }

    public TblConsultas(Integer numConsulta, Date fecConsulta, BigDecimal temPaciente, short pulPaciente, String preArterial, Double pesPaciente, Double talPaciente, String hisCliPaciente, String anaPaciente, String exaFisPaciente, String diaPaciente, short edaConsulta, EstadoConsultas estConsulta) {
        this.numConsulta = numConsulta;
        this.fecConsulta = fecConsulta;
        this.temPaciente = temPaciente;
        this.pulPaciente = pulPaciente;
        this.preArterial = preArterial;
        this.pesPaciente = pesPaciente;
        this.talPaciente = talPaciente;
        this.hisCliPaciente = hisCliPaciente;
        this.anaPaciente = anaPaciente;
        this.exaFisPaciente = exaFisPaciente;
        this.diaPaciente = diaPaciente;
        this.edaConsulta = edaConsulta;
        this.estConsulta = estConsulta;
    }

    public Integer getCodEspecialidad() {
        return codEspecialidad;
    }

    public void setCodEspecialidad(Integer codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
    }

    public Integer getNumMedico() {
        return numMedico;
    }

    public void setNumMedico(Integer numMedico) {
        this.numMedico = numMedico;
    }

    public TblMedico getTblMedico() {
        return tblMedico;
    }

    public void setTblMedico(TblMedico tblMedico) {
        this.tblMedico = tblMedico;
    }

    public CatTipoConsulta getCatTipoConsulta() {
        return catTipoConsulta;
    }

    public void setCatTipoConsulta(CatTipoConsulta catTipoConsulta) {
        this.catTipoConsulta = catTipoConsulta;
    }

    public Integer getCodTipConsulta() {
        return codTipConsulta;
    }

    public void setCodTipConsulta(Integer codTipConsulta) {
        this.codTipConsulta = codTipConsulta;
    }

    public Integer getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(Integer numExpediente) {
        this.numExpediente = numExpediente;
    }

    public sv.com.cormaria.servicios.entidades.archivo.TblExpedientePacientes getTblExpediente() {
        return tblExpediente;
    }

    public void setTblExpediente(sv.com.cormaria.servicios.entidades.archivo.TblExpedientePacientes tblExpediente) {
        this.tblExpediente = tblExpediente;
    }

    public Integer getNumConsulta() {
        return numConsulta;
    }

    public void setNumConsulta(Integer numConsulta) {
        this.numConsulta = numConsulta;
    }

    public Date getFecConsulta() {
        return fecConsulta;
    }

    public void setFecConsulta(Date fecConsulta) {
        this.fecConsulta = fecConsulta;
    }

    public BigDecimal getTemPaciente() {
        return temPaciente;
    }

    public void setTemPaciente(BigDecimal temPaciente) {
        this.temPaciente = temPaciente;
    }

    public short getPulPaciente() {
        return pulPaciente;
    }

    public void setPulPaciente(short pulPaciente) {
        this.pulPaciente = pulPaciente;
    }

    public String getPreArterial() {
        return preArterial;
    }

    public void setPreArterial(String preArterial) {
        this.preArterial = preArterial;
    }

    public Double getPesPaciente() {
        return pesPaciente;
    }

    public void setPesPaciente(Double pesPaciente) {
        this.pesPaciente = pesPaciente;
    }

    public Double getTalPaciente() {
        return talPaciente;
    }

    public void setTalPaciente(Double talPaciente) {
        this.talPaciente = talPaciente;
    }

    public String getHisCliPaciente() {
        return hisCliPaciente;
    }

    public void setHisCliPaciente(String hisCliPaciente) {
        this.hisCliPaciente = hisCliPaciente;
    }

    public String getAnaPaciente() {
        return anaPaciente;
    }

    public void setAnaPaciente(String anaPaciente) {
        this.anaPaciente = anaPaciente;
    }

    public String getExaFisPaciente() {
        return exaFisPaciente;
    }

    public void setExaFisPaciente(String exaFisPaciente) {
        this.exaFisPaciente = exaFisPaciente;
    }

    public String getDiaPaciente() {
        return diaPaciente;
    }

    public void setDiaPaciente(String diaPaciente) {
        this.diaPaciente = diaPaciente;
    }

    public String getObsCliPaciente() {
        return obsCliPaciente;
    }

    public void setObsCliPaciente(String obsCliPaciente) {
        this.obsCliPaciente = obsCliPaciente;
    }

    public short getEdaConsulta() {
        return edaConsulta;
    }

    public void setEdaConsulta(short edaConsulta) {
        this.edaConsulta = edaConsulta;
    }

    public EstadoConsultas getEstConsulta() {
        return estConsulta;
    }

    public void setEstConsulta(EstadoConsultas estConsulta) {
        this.estConsulta = estConsulta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numConsulta != null ? numConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblConsultas)) {
            return false;
        }
        TblConsultas other = (TblConsultas) object;
        if ((this.numConsulta == null && other.numConsulta != null) || (this.numConsulta != null && !this.numConsulta.equals(other.numConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.consultasmedicas.TblConsultas[ numConsulta=" + numConsulta + " ]";
    }    
}
