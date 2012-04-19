/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.colecturia;

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

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_liquidacion")
@NamedQueries({
    @NamedQuery(name = "TblLiquidacion.findAll", query = "SELECT t FROM TblLiquidacion t")})
public class TblLiquidacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_LIQUIDACION")
    private Integer numLiquidacion;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la fecha de liquifación")
    @Column(name = "FEC_LIQUIDACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecLiquidacion;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la cantidad de billetes de $100")
    @Column(name = "CAN_BIL_100")
    private short canBil100;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la cantidad de billetes de $50")
    @Column(name = "CAN_BIL_50")
    private short canBil50;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la cantidad de billetes de $20")
    @Column(name = "CAN_BIL_20")
    private short canBil20;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la cantidad de billetes de $10")
    @Column(name = "CAN_BIL_10")
    private short canBil10;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la cantidad de billetes de $5")
    @Column(name = "CAN_BIL_5")
    private short canBil5;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la cantidad de billetes de $1")
    @Column(name = "CAN_BIL_1")
    private short canBil1;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el monto en monedas")
    @Column(name = "MON_MONEDA")
    private float monMoneda;
    @Basic(optional = false)
    @NotNull(message ="Ingrese la cantidad sobrante")
    @Column(name = "CAN_SOBRANTE")
    private float canSobrante;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la cantidad faltante")
    @Column(name = "CAN_FALTANTE")
    private float canFaltante;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el total de efectivo")
    @Column(name = "TOT_EFECTIVO")
    private float totEfectivo;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el total en cheques")
    @Column(name = "TOT_CHEQUES")
    private float totCheques;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el total del corte")
    @Column(name = "TOT_CORTE")
    private float totCorte;
    @Size(max = 500, message = "La observación no debe ser mayor de 500 caracteres")
    @Column(name = "OBS_LIQUIDACION")
    private String obsLiquidacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tblLiquidacion")
    private Collection<TblDetalleCheques> tblDetalleChequesCollection;

    public TblLiquidacion() {
    }

    public TblLiquidacion(Integer numLiquidacion) {
        this.numLiquidacion = numLiquidacion;
    }

    public TblLiquidacion(Integer numLiquidacion, Date fecLiquidacion, short canBil100, short canBil50, short canBil20, short canBil10, short canBil5, short canBil1, float monMoneda, float canSobrante, float canFaltante, float totEfectivo, float totCheques, float totCorte) {
        this.numLiquidacion = numLiquidacion;
        this.fecLiquidacion = fecLiquidacion;
        this.canBil100 = canBil100;
        this.canBil50 = canBil50;
        this.canBil20 = canBil20;
        this.canBil10 = canBil10;
        this.canBil5 = canBil5;
        this.canBil1 = canBil1;
        this.monMoneda = monMoneda;
        this.canSobrante = canSobrante;
        this.canFaltante = canFaltante;
        this.totEfectivo = totEfectivo;
        this.totCheques = totCheques;
        this.totCorte = totCorte;
    }

    public Integer getNumLiquidacion() {
        return numLiquidacion;
    }

    public void setNumLiquidacion(Integer numLiquidacion) {
        this.numLiquidacion = numLiquidacion;
    }

    public Date getFecLiquidacion() {
        return fecLiquidacion;
    }

    public void setFecLiquidacion(Date fecLiquidacion) {
        this.fecLiquidacion = fecLiquidacion;
    }

    public short getCanBil100() {
        return canBil100;
    }

    public void setCanBil100(short canBil100) {
        this.canBil100 = canBil100;
    }

    public short getCanBil50() {
        return canBil50;
    }

    public void setCanBil50(short canBil50) {
        this.canBil50 = canBil50;
    }

    public short getCanBil20() {
        return canBil20;
    }

    public void setCanBil20(short canBil20) {
        this.canBil20 = canBil20;
    }

    public short getCanBil10() {
        return canBil10;
    }

    public void setCanBil10(short canBil10) {
        this.canBil10 = canBil10;
    }

    public short getCanBil5() {
        return canBil5;
    }

    public void setCanBil5(short canBil5) {
        this.canBil5 = canBil5;
    }

    public short getCanBil1() {
        return canBil1;
    }

    public void setCanBil1(short canBil1) {
        this.canBil1 = canBil1;
    }

    public float getMonMoneda() {
        return monMoneda;
    }

    public void setMonMoneda(float monMoneda) {
        this.monMoneda = monMoneda;
    }

    public float getCanSobrante() {
        return canSobrante;
    }

    public void setCanSobrante(float canSobrante) {
        this.canSobrante = canSobrante;
    }

    public float getCanFaltante() {
        return canFaltante;
    }

    public void setCanFaltante(float canFaltante) {
        this.canFaltante = canFaltante;
    }

    public float getTotEfectivo() {
        return totEfectivo;
    }

    public void setTotEfectivo(float totEfectivo) {
        this.totEfectivo = totEfectivo;
    }

    public float getTotCheques() {
        return totCheques;
    }

    public void setTotCheques(float totCheques) {
        this.totCheques = totCheques;
    }

    public float getTotCorte() {
        return totCorte;
    }

    public void setTotCorte(float totCorte) {
        this.totCorte = totCorte;
    }

    public String getObsLiquidacion() {
        return obsLiquidacion;
    }

    public void setObsLiquidacion(String obsLiquidacion) {
        this.obsLiquidacion = obsLiquidacion;
    }

    public Collection<TblDetalleCheques> getTblDetalleChequesCollection() {
        return tblDetalleChequesCollection;
    }

    public void setTblDetalleChequesCollection(Collection<TblDetalleCheques> tblDetalleChequesCollection) {
        this.tblDetalleChequesCollection = tblDetalleChequesCollection;
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
