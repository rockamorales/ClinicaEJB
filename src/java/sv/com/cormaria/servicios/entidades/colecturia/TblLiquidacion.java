/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.colecturia;

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

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_liquidacion")
@NamedQueries({
    @NamedQuery(name = "TblLiquidacion.findAll", query = "SELECT t FROM TblLiquidacion t"),
    @NamedQuery(name = "TblLiquidacion.findByDate", query = "SELECT t FROM TblLiquidacion t where t.fecLiquidacion = :fecLiquidacion")
})
public class TblLiquidacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    @Column(name = "NUM_LIQUIDACION")
    private Integer numLiquidacion;
    @Basic
    @Column(name = "FEC_LIQUIDACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecLiquidacion;
    @Basic
    @Column(name = "CAN_BIL_100")
    private Integer canBil100;
    @Basic
    @Column(name = "CAN_BIL_50")
    private Integer canBil50;
    @Basic
    @Column(name = "CAN_BIL_20")
    private Integer canBil20;
    @Basic
    @Column(name = "CAN_BIL_10")
    private Integer canBil10;
    @Basic
    @Column(name = "CAN_BIL_5")
    private Integer canBil5;
    @Basic
    @Column(name = "CAN_BIL_1")
    private Integer canBil1;
    @Basic
    @Column(name = "MON_MONEDA")
    private Double monMoneda;
    @Basic
    @Column(name = "CAN_SOBRANTE")
    private Double canSobrante;
    @Basic
    @Column(name = "CAN_FALTANTE")
    private Double canFaltante;
    @Basic
    @Column(name = "TOT_EFECTIVO")
    private Double totEfectivo;
    @Basic
    @Column(name = "TOT_CHEQUES")
    private Double totCheques;
    @Basic
    @Column(name = "TOT_COR_EFECTIVO")
    private Double totCorEfectivo;
    @Basic
    @Column(name = "TOT_COR_CHEQUES")
    private Double totCorCheque;
    @Basic
    @Column(name = "TOT_CORTE")
    private Double totCorte;
    @Column(name = "OBS_LIQUIDACION")
    private String obsLiquidacion;
    
    @Column(name = "NUM_EMPLEADO")
    private Integer numEmpleado;

    public TblLiquidacion() {
    }

    public TblLiquidacion(Integer numLiquidacion) {
        this.numLiquidacion = numLiquidacion;
    }
        
    public Integer getNumLiquidacion() {
        return numLiquidacion;
    }

    public void setNumLiquidacion(Integer numLiquidacion) {
        this.numLiquidacion = numLiquidacion;
    }

    public Integer getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(Integer numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public Date getFecLiquidacion() {
        return fecLiquidacion;
    }

    public void setFecLiquidacion(Date fecLiquidacion) {
        this.fecLiquidacion = fecLiquidacion;
    }

    public String getObsLiquidacion() {
        return obsLiquidacion;
    }

    public void setObsLiquidacion(String obsLiquidacion) {
        this.obsLiquidacion = obsLiquidacion;
    }

    public Integer getCanBil100() {
        return canBil100;
    }

    public void setCanBil100(Integer canBil100) {
        this.canBil100 = canBil100;
    }

    public Integer getCanBil50() {
        return canBil50;
    }

    public void setCanBil50(Integer canBil50) {
        this.canBil50 = canBil50;
    }

    public Integer getCanBil20() {
        return canBil20;
    }

    public void setCanBil20(Integer canBil20) {
        this.canBil20 = canBil20;
    }

    public Integer getCanBil10() {
        return canBil10;
    }

    public void setCanBil10(Integer canBil10) {
        this.canBil10 = canBil10;
    }

    public Integer getCanBil5() {
        return canBil5;
    }

    public void setCanBil5(Integer canBil5) {
        this.canBil5 = canBil5;
    }

    public Integer getCanBil1() {
        return canBil1;
    }

    public void setCanBil1(Integer canBil1) {
        this.canBil1 = canBil1;
    }

    public Double getMonMoneda() {
        return monMoneda;
    }

    public void setMonMoneda(Double monMoneda) {
        this.monMoneda = monMoneda;
    }

    public Double getCanSobrante() {
        return canSobrante;
    }

    public void setCanSobrante(Double canSobrante) {
        this.canSobrante = canSobrante;
    }

    public Double getCanFaltante() {
        return canFaltante;
    }

    public void setCanFaltante(Double canFaltante) {
        this.canFaltante = canFaltante;
    }

    public Double getTotEfectivo() {
        return totEfectivo;
    }

    public void setTotEfectivo(Double totEfectivo) {
        this.totEfectivo = totEfectivo;
    }

    public Double getTotCheques() {
        return totCheques;
    }

    public void setTotCheques(Double totCheques) {
        this.totCheques = totCheques;
    }

    public Double getTotCorEfectivo() {
        return totCorEfectivo;
    }

    public void setTotCorEfectivo(Double totCorEfectivo) {
        this.totCorEfectivo = totCorEfectivo;
    }

    public Double getTotCorCheque() {
        return totCorCheque;
    }

    public void setTotCorCheque(Double totCorCheque) {
        this.totCorCheque = totCorCheque;
    }

    public Double getTotCorte() {
        return totCorte;
    }

    public void setTotCorte(Double totCorte) {
        this.totCorte = totCorte;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numLiquidacion != null ? numLiquidacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblLiquidacion)) {
            return false;
        }
        TblLiquidacion other = (TblLiquidacion) object;
        if ((this.numLiquidacion == null && other.numLiquidacion != null) || (this.numLiquidacion != null && !this.numLiquidacion.equals(other.numLiquidacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.colecturia.TblLiquidacion[ numLiquidacion=" + numLiquidacion + " ]";
    }
    
}
