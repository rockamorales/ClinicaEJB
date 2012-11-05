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
import sv.com.cormaria.servicios.entidades.administracion.TblInstitucion;
import sv.com.cormaria.servicios.entidades.archivo.TblExpedientePacientes;
import sv.com.cormaria.servicios.entidades.catalogos.CatBancos;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoDonante;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoPago;
import sv.com.cormaria.servicios.enums.EstadoComprobanteDonacion;
import sv.com.cormaria.servicios.enums.TipoComprobanteDonacion;

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
    
    @Column(name = "COD_CARISMA")
    private Integer codCarisma;
    
    @Column(name = "COD_TIP_DONANTE")
    private Integer codTipDonante;    
    
    @Column(name = "NUM_EMPLEADO")
    private Integer numEmpleado;
    
    @Column(name = "COD_TIP_PAGO")
    private Integer codTipPago;
    
    @Column(name = "COD_TIP_DONACION")
    private Integer codTipDonacion;    
    
    @Basic
    @Column(name = "FEC_COM_DONACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecComDonacion;
    
    @Basic
    @Column(name = "CAN_LETRAS")
    private String canLetras;
    
    @Basic
    @Column(name = "TOT_DONACION")
    private float totDonacion;
    
    @Basic
    @Column(name = "EST_COM_DONACION")
    private EstadoComprobanteDonacion estComDonacion;
    
    @Basic
    @Column(name = "NOM_COM_DONACION")
    private String nomComDonacion;
    
    @Column(name = "NIT_COM_DONACION")
    private Integer nitComDonacion;
    
    @Column(name = "NUM_EXPEDIENTE")
    private Integer numExpediente;    

    @Column(name = "NUM_INSTITUCION")
    private Integer numInstitucion;

    @Column(name = "TIP_COMPROBANTE")
    private TipoComprobanteDonacion tipComprobante;
    
    @Column(name="NUM_FAC_DONACION")
    private String numFacDonacion;
        
    @Transient
    private float montoRecibido;
    
    @Transient
    private float cambio;
    
    @ManyToOne
    @JoinColumn(name="COD_TIP_DONANTE", referencedColumnName="COD_TIP_DONANTE", insertable=false, updatable=false)
    private CatTipoDonante catTipoDonante;

    @ManyToOne
    @JoinColumn(name="COD_TIP_PAGO", referencedColumnName="COD_TIP_PAGO", insertable=false, updatable=false)
    private CatTipoPago catTipoPago;

    @ManyToOne
    @JoinColumn(name="COD_BANCO", referencedColumnName="COD_BANCO", insertable=false, updatable=false)
    private CatBancos catBanco;
        
    @ManyToOne
    @JoinColumn(name="NUM_EXPEDIENTE", referencedColumnName="NUM_EXPEDIENTE", insertable=false, updatable=false)
    private TblExpedientePacientes tblExpedientePacientes;

    @ManyToOne
    @JoinColumn(name="NUM_INSTITUCION", referencedColumnName="NUM_INSTITUCION", insertable=false, updatable=false)
    private TblInstitucion tblInstitucion;

    public TipoComprobanteDonacion getTipComprobante() {
        return tipComprobante;
    }

    public void setTipComprobante(TipoComprobanteDonacion tipComprobante) {
        this.tipComprobante = tipComprobante;
    }

    public String getNumFacDonacion() {
        return numFacDonacion;
    }

    public void setNumFacDonacion(String numFacDonacion) {
        this.numFacDonacion = numFacDonacion;
    }
    
    public CatTipoPago getCatTipoPago() {
        return catTipoPago;
    }

    public void setCatTipoPago(CatTipoPago catTipoPago) {
        this.catTipoPago = catTipoPago;
    }

    public CatBancos getCatBanco() {
        return catBanco;
    }

    public void setCatBanco(CatBancos catBanco) {
        this.catBanco = catBanco;
    }

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
