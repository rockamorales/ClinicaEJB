/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.consultasmedicas;

import sv.com.cormaria.servicios.entidades.administracion.TblMedico;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_referencia")
@NamedQueries({
    @NamedQuery(name = "TblReferencia.findAll", query = "SELECT t FROM TblReferencia t")})
public class TblReferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUM_REFERENCIA")
    private Integer numReferencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FEC_REFERENCIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecReferencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DIA_REFERENCIA")
    private String diaReferencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "REF_A")
    private String refA;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MOT_REFERENCIA")
    private String motReferencia;
    @JoinColumn(name = "NUM_MEDICO", referencedColumnName = "NUM_MEDICO")
    @ManyToOne(optional = false)
    private TblMedico numMedico;

    public TblReferencia() {
    }

    public TblReferencia(Integer numReferencia) {
        this.numReferencia = numReferencia;
    }

    public TblReferencia(Integer numReferencia, Date fecReferencia, String diaReferencia, String refA, String motReferencia) {
        this.numReferencia = numReferencia;
        this.fecReferencia = fecReferencia;
        this.diaReferencia = diaReferencia;
        this.refA = refA;
        this.motReferencia = motReferencia;
    }

    public Integer getNumReferencia() {
        return numReferencia;
    }

    public void setNumReferencia(Integer numReferencia) {
        this.numReferencia = numReferencia;
    }

    public Date getFecReferencia() {
        return fecReferencia;
    }

    public void setFecReferencia(Date fecReferencia) {
        this.fecReferencia = fecReferencia;
    }

    public String getDiaReferencia() {
        return diaReferencia;
    }

    public void setDiaReferencia(String diaReferencia) {
        this.diaReferencia = diaReferencia;
    }

    public String getRefA() {
        return refA;
    }

    public void setRefA(String refA) {
        this.refA = refA;
    }

    public String getMotReferencia() {
        return motReferencia;
    }

    public void setMotReferencia(String motReferencia) {
        this.motReferencia = motReferencia;
    }

    public TblMedico getNumMedico() {
        return numMedico;
    }

    public void setNumMedico(TblMedico numMedico) {
        this.numMedico = numMedico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numReferencia != null ? numReferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblReferencia)) {
            return false;
        }
        TblReferencia other = (TblReferencia) object;
        if ((this.numReferencia == null && other.numReferencia != null) || (this.numReferencia != null && !this.numReferencia.equals(other.numReferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.consultasmedicas.TblReferencia[ numReferencia=" + numReferencia + " ]";
    }
    
}
