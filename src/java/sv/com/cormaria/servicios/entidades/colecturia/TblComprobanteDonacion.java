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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import sv.com.cormaria.servicios.entidades.administracion.TblInstitucion;
import sv.com.cormaria.servicios.entidades.archivo.TblExpedientePacientes;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoDonacion;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoDonante;
import sv.com.cormaria.servicios.enums.EstadoComprobanteDonacion;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_comprobante_donacion")
@NamedQueries({
    @NamedQuery(name = "TblComprobanteDonacion.findAll", query = "SELECT t FROM TblComprobanteDonacion t")})
public class TblComprobanteDonacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_COM_DONACION")
    private Integer numComDonacion;
    @Basic
    @Column(name = "COD_BANCO")
    private Integer codBanco;
    @NotNull(message = "Ingrese el codigo de Carisma")
    @Column(name = "COD_CARISMA")
    private Integer codCarisma;    
    @NotNull(message = "Ingrese el codigo del tipo donante")
    @Column(name = "COD_TIP_DONANTE")
    private Integer codTipDonante;    
    @NotNull(message = "Ingrese el numero del empleado")
    @Column(name = "NUM_EMPLEADO")
    private Integer numEmpleado;
    @Column(name = "COD_TIP_PAGO")
    private Integer codTipPago;
    @NotNull(message ="Ingrese el codigo del tipo de donacion")
    @Column(name = "COD_TIP_DONACION")
    private Integer codTipDonacion;    
    @Basic(optional = false)
    @NotNull (message = "Ingrese la fecha del comprobante de donacion")
    @Column(name = "FEC_COM_DONACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecComDonacion;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la cantidad en letras")
    @Size(min = 1, max = 100, message = "La cantodad en letras no debe ser mayor de 100 caracteres")
    @Column(name = "CAN_LETRAS")
    private String canLetras;
    @Basic
    @Column(name = "TOT_DONACION")
    private float totDonacion;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el estado de la donacion")
    @Column(name = "EST_COM_DONACION")
    private EstadoComprobanteDonacion estComDonacion;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el nombre de la persona que realizara el pago")
    @Size(min = 1, max = 100)
    @Column(name = "NOM_COM_DONACION")
    private String nomComDonacion;
    @Column(name = "NIT_COM_DONACION")
    private Integer nitComDonacion;
    @NotNull(message = "Ingrese el numero de expediente")
    @Column(name = "NUM_EXPEDIENTE")
    private Integer numExpediente;    
    @NotNull(message = "Ingrese el numero de institucion")
    @Column(name = "NUM_INSTITUCION")
    private Integer numInstitucion;
    @Transient
    private float montoRecibido;
    @Transient
    private float cambio;
    
    @ManyToOne
    @JoinColumn(name="COD_TIP_DONANTE", referencedColumnName="COD_TIP_DONANTE", insertable=false, updatable=false)
    private CatTipoDonante catTipoDonante;
    
    @ManyToOne
    @JoinColumn(name="NUM_EXPEDIENTE", referencedColumnName="NUM_EXPEDIENTE", insertable=false, updatable=false)
    private TblExpedientePacientes tblExpedientePacientes;    

    @ManyToOne
    @JoinColumn(name="NUM_INSTITUCION", referencedColumnName="NUM_INSTITUCION", insertable=false, updatable=false)
    private TblInstitucion tblInstitucion;
   
    public TblExpedientePacientes getTblExpedientePacientes() {
        return tblExpedientePacientes;
    }

    public void setTblExpedientePacientes(TblExpedientePacientes tblExpedientePacientes) {
        this.tblExpedientePacientes = tblExpedientePacientes;
    }

    public TblInstitucion getTblInstitucion() {
        return tblInstitucion;
    }

    public void setTblInstitucion(TblInstitucion tblInstitucion) {
        this.tblInstitucion = tblInstitucion;
    }

    public float getCambio() {
        return this.montoRecibido - this.totDonacion;
    }

    public void setCambio(float cambio) {
        this.cambio = cambio;
    }
   
    public CatTipoDonante getCatTipoDonante() {
        return catTipoDonante;
    }

    public void setCatTipoDonante(CatTipoDonante catTipoDonante) {
        this.catTipoDonante = catTipoDonante;
    }

    public float getMontoRecibido() {
        return montoRecibido;
    }

    public void setMontoRecibido(float montoRecibido) {
        this.montoRecibido = montoRecibido;
    }
    
    public TblComprobanteDonacion() {
    }

    public TblComprobanteDonacion(Integer numComDonacion) {
        this.numComDonacion = numComDonacion;
    }

    public TblComprobanteDonacion(Integer numComDonacion, Date fecComDonacion, String canLetras, float totDonacion, EstadoComprobanteDonacion estComDonacion, String nomComDonacion) {
        this.numComDonacion = numComDonacion;
        this.fecComDonacion = fecComDonacion;
        this.canLetras = canLetras;
        this.totDonacion = totDonacion;
        this.estComDonacion = estComDonacion;
        this.nomComDonacion = nomComDonacion;
    }

    public Integer getNumComDonacion() {
        return numComDonacion;
    }

    public void setNumComDonacion(Integer numComDonacion) {
        this.numComDonacion = numComDonacion;
    }

    public Date getFecComDonacion() {
        return fecComDonacion;
    }

    public void setFecComDonacion(Date fecComDonacion) {
        this.fecComDonacion = fecComDonacion;
    }

    public String getCanLetras() {
        return canLetras;
    }

    public void setCanLetras(String canLetras) {
        this.canLetras = canLetras;
    }

    public float getTotDonacion() {
        return totDonacion;
    }

    public void setTotDonacion(float totDonacion) {
        this.totDonacion = totDonacion;
    }

    public EstadoComprobanteDonacion getEstComDonacion() {
        return estComDonacion;
    }

    public void setEstComDonacion(EstadoComprobanteDonacion estComDonacion) {
        this.estComDonacion = estComDonacion;
    }

    public Integer getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(Integer codBanco) {
        this.codBanco = codBanco;
    }

    public Integer getCodCarisma() {
        return codCarisma;
    }

    public void setCodCarisma(Integer codCarisma) {
        this.codCarisma = codCarisma;
    }

    public Integer getCodTipDonacion() {
        return codTipDonacion;
    }

    public void setCodTipDonacion(Integer codTipDonacion) {
        this.codTipDonacion = codTipDonacion;
    }

    public Integer getCodTipDonante() {
        return codTipDonante;
    }

    public void setCodTipDonante(Integer codTipDonante) {
        this.codTipDonante = codTipDonante;
    }

    public Integer getCodTipPago() {
        return codTipPago;
    }

    public void setCodTipPago(Integer codTipPago) {
        this.codTipPago = codTipPago;
    }

    public Integer getNitComDonacion() {
        return nitComDonacion;
    }

    public void setNitComDonacion(Integer nitComDonacion) {
        this.nitComDonacion = nitComDonacion;
    }

    public String getNomComDonacion() {
        return nomComDonacion;
    }

    public void setNomComDonacion(String nomComDonacion) {
        this.nomComDonacion = nomComDonacion;
    }

    public Integer getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(Integer numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public Integer getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(Integer numExpediente) {
        this.numExpediente = numExpediente;
    }

    public Integer getNumInstitucion() {
        return numInstitucion;
    }

    public void setNumInstitucion(Integer numInstitucion) {
        this.numInstitucion = numInstitucion;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TblComprobanteDonacion other = (TblComprobanteDonacion) obj;
        if (this.numComDonacion != other.numComDonacion && (this.numComDonacion == null || !this.numComDonacion.equals(other.numComDonacion))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (this.numComDonacion != null ? this.numComDonacion.hashCode() : 0);
        return hash;
    }

    
    
   

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.colecturia.TblComprobanteDonacion[ numComDonacion=" + numComDonacion + " ]";
    }
    
}
