/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.catalogos;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import sv.com.cormaria.servicios.enums.Estado;

/**
 *
 * @author Claudia
 */
@Entity
@Table(name = "cat_turnos")
@NamedQueries({
    @NamedQuery(name = "CatTurnos.findAll", query = "SELECT c FROM CatTurnos c")})
public class CatTurnos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_TUR_SEMANAL")
    private Integer codTurSemanal;
    @Basic(optional = false)
    @NotNull(message="Ingrese el nombre del Turno")
    @Size(min = 1, max = 10)
    @Column(name = "DIA_TURNO")
    private String diaTurno;
    @Basic(optional = false)
    @NotNull(message="Ingrese el horario del Turno")
    @Column(name = "HOR_TURNO")
    @Temporal(TemporalType.TIME)
    private Date horTurno;
    @Basic(optional = false)
    @NotNull(message="Ingrese la descripción del Turno")
    @Size(min = 1, max = 100)
    @Column(name = "DES_TURNO")
    private String desTurno;
    @Basic(optional = false)
    @NotNull(message="Ingrese el estado del Turno")
    @Column(name = "ACT_TURNO")
    private Estado actTurno;
    @Transient 
    private int horas;
    @Transient
    private int minutos;

    public CatTurnos() {
    }

    public CatTurnos(Integer codTurSemanal) {
        this.codTurSemanal = codTurSemanal;
    }

    public CatTurnos(Integer codTurSemanal, String diaTurno, Date horTurno, String desTurno, Estado  actTurno) {
        this.codTurSemanal = codTurSemanal;
        this.diaTurno = diaTurno;
        this.horTurno = horTurno;
        this.desTurno = desTurno;
        this.actTurno = actTurno;
    }

    public int getHoras() {
        if (horTurno!=null){
            Calendar cal = Calendar.getInstance();
            cal.setTime(horTurno);
            return cal.get(Calendar.HOUR_OF_DAY);
        }
        return 0;
    }

    
    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getMinutos() {
        if (horTurno!=null){
            Calendar cal = Calendar.getInstance();
            cal.setTime(horTurno);
            return cal.get(Calendar.MINUTE);
        }
        return 0;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    public Integer getCodTurSemanal() {
        return codTurSemanal;
    }

    public void setCodTurSemanal(Integer codTurSemanal) {
        this.codTurSemanal = codTurSemanal;
    }

    public String getDiaTurno() {
        return diaTurno;
    }

    public void setDiaTurno(String diaTurno) {
        this.diaTurno = diaTurno;
    }

    public Date getHorTurno() {
        return horTurno;
    }

    public void setHorTurno(Date horTurno) {
        this.horTurno = horTurno;
    }

    public String getDesTurno() {
        return desTurno;
    }

    public void setDesTurno(String desTurno) {
        this.desTurno = desTurno;
    }

    public Estado getActTurno() {
        return actTurno;
    }

    public void setActTurno(Estado actTurno) {
        this.actTurno = actTurno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTurSemanal != null ? codTurSemanal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatTurnos)) {
            return false;
        }
        CatTurnos other = (CatTurnos) object;
        if ((this.codTurSemanal == null && other.codTurSemanal != null) || (this.codTurSemanal != null && !this.codTurSemanal.equals(other.codTurSemanal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatTurnos[ codTurSemanal=" + codTurSemanal + " ]";
    }
    
}
