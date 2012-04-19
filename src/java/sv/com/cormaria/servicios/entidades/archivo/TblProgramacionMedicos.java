/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.archivo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_programacion_medicos")
@NamedQueries({
    @NamedQuery(name = "TblProgramacionMedicos.findAll", query = "SELECT t FROM TblProgramacionMedicos t")})
public class TblProgramacionMedicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_PRO_MEDICO")
    private Integer numProMedico;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el cupo del turno del médico")
    @Column(name = "CUP_TUR_MEDICO")
    private short cupTurMedico;
    @Basic(optional = false)
    @NotNull(message = "Ingrese los cupos disponible en el turno del médico")
    @Column(name = "CUP_DIS_TUR_MEDICO")
    private short cupDisTurMedico;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la fecha del turno del médico")
    @Column(name = "FEC_TUR_MEDICO")
    @Temporal(TemporalType.DATE)
    private Date fecTurMedico;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el estado de la programación del médico")
    @Column(name = "EST_PRO_MEDICO")
    private int estProMedico;

    public TblProgramacionMedicos() {
    }

    public TblProgramacionMedicos(Integer numProMedico) {
        this.numProMedico = numProMedico;
    }

    public TblProgramacionMedicos(Integer numProMedico, short cupTurMedico, short cupDisTurMedico, Date fecTurMedico, int estProMedico) {
        this.numProMedico = numProMedico;
        this.cupTurMedico = cupTurMedico;
        this.cupDisTurMedico = cupDisTurMedico;
        this.fecTurMedico = fecTurMedico;
        this.estProMedico = estProMedico;
    }

    public Integer getNumProMedico() {
        return numProMedico;
    }

    public void setNumProMedico(Integer numProMedico) {
        this.numProMedico = numProMedico;
    }

    public short getCupTurMedico() {
        return cupTurMedico;
    }

    public void setCupTurMedico(short cupTurMedico) {
        this.cupTurMedico = cupTurMedico;
    }

    public short getCupDisTurMedico() {
        return cupDisTurMedico;
    }

    public void setCupDisTurMedico(short cupDisTurMedico) {
        this.cupDisTurMedico = cupDisTurMedico;
    }

    public Date getFecTurMedico() {
        return fecTurMedico;
    }

    public void setFecTurMedico(Date fecTurMedico) {
        this.fecTurMedico = fecTurMedico;
    }

    public int getEstProMedico() {
        return estProMedico;
    }

    public void setEstProMedico(int estProMedico) {
        this.estProMedico = estProMedico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numProMedico != null ? numProMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProgramacionMedicos)) {
            return false;
        }
        TblProgramacionMedicos other = (TblProgramacionMedicos) object;
        if ((this.numProMedico == null && other.numProMedico != null) || (this.numProMedico != null && !this.numProMedico.equals(other.numProMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.archivo.TblProgramacionMedicos[ numProMedico=" + numProMedico + " ]";
    }
    
}
