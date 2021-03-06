/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.administracion;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import sv.com.cormaria.servicios.entidades.catalogos.CatEspecialidad;
import sv.com.cormaria.servicios.entidades.catalogos.CatRubro;
import sv.com.cormaria.servicios.enums.Estado;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_institucion")
@NamedQueries({
    @NamedQuery(name = "TblInstitucion.findAll", query = "SELECT t FROM TblInstitucion t"),
    @NamedQuery(name = "TblInstitucion.findActive", query = "SELECT t FROM TblInstitucion t WHERE t.actInstitucion = 1")})
public class TblInstitucion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_INSTITUCION")
    private Integer numInstitucion;
    @Column(name = "FEC_REG_INSTITUTCION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecRegInstitutcion;
    @Column(name = "NOM_COM_INSTITUCION")
    private String nomComInstitucion;
    @Column(name = "RAZ_SOC_INSTITUCION")
    private String razSocInstitucion;
    @Column(name = "DIR_INSTITUCION")
    private String dirInstitucion;
    @Column(name = "TEL_INSTITUCION")
    private int telInstitucion;
    @Column(name = "NIT_INSTITUCION")
    private long nitInstitucion;
    @Column(name = "NRC_INSTITUCION")
    private Integer nrcInstitucion;
    @Column(name = "GIR_INSTITUCION")
    private String girInstitucion;
    @Column(name = "NOM_CON_INSTITUCION")
    private String nomConInstitucion;
    @Column(name = "COD_RUBRO")
    private Integer codRubro;
    @Column(name = "CEL_CON_INSTITUCION")
    private Integer celConInstitucion;
    @Column(name = "ES_DONANTE")
    private boolean esDonante;
    @Column(name = "ES_PROVEEDOR")
    private boolean esProveedor;
    @Column(name = "ACT_INSTITUCION")
    private Estado actInstitucion;
    @Column(name = "COR_CON_INSTITUCION")
    private String corConInstitucion; 
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numInstitucion")
    private Collection<TblOrdenCompra> tblOrdenCompraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numInstitucion")
    private Collection<TblSolicitudDonacion> tblSolicitudDonacionCollection;
    @ManyToOne
    @JoinColumn(name="COD_RUBRO",referencedColumnName="COD_RUBRO",insertable=false, updatable=false)
    private CatRubro catRubro;

    public CatRubro getCatRubro() {
        return catRubro;
    }

    public void setCatRubro(CatRubro catRubro) {
        this.catRubro = catRubro;
    }

    public String getCorConInstitucion() {
        return corConInstitucion;
    }

    public void setCorConInstitucion(String corConInstitucion) {
        this.corConInstitucion = corConInstitucion;
    }

    public TblInstitucion() {
    }

    public TblInstitucion(Integer numInstitucion) {
        this.numInstitucion = numInstitucion;
    }

    public TblInstitucion(Integer numInstitucion, Date fecRegInstitutcion, String nomComInstitucion, String razSocInstitucion, String dirInstitucion, int telInstitucion, long nitInstitucion, String girInstitucion, String nomConInstitucion, boolean esDonante, boolean esProveedor) {
        this.numInstitucion = numInstitucion;
        this.fecRegInstitutcion = fecRegInstitutcion;
        this.nomComInstitucion = nomComInstitucion;
        this.razSocInstitucion = razSocInstitucion;
        this.dirInstitucion = dirInstitucion;
        this.telInstitucion = telInstitucion;
        this.nitInstitucion = nitInstitucion;
        this.girInstitucion = girInstitucion;
        this.nomConInstitucion = nomConInstitucion;
        this.esDonante = esDonante;
        this.esProveedor = esProveedor;
    }

    public Estado getActInstitucion() {
        return actInstitucion;
    }

    public void setActInstitucion(Estado actInstitucion) {
        this.actInstitucion = actInstitucion;
    }

    public Integer getCodRubro() {
        return codRubro;
    }

    public void setCodRubro(Integer codRubro) {
        this.codRubro = codRubro;
    }
   
    
    public Integer getNumInstitucion() {
        return numInstitucion;
    }

    public void setNumInstitucion(Integer numInstitucion) {
        this.numInstitucion = numInstitucion;
    }

    public Date getFecRegInstitutcion() {
        return fecRegInstitutcion;
    }

    public void setFecRegInstitutcion(Date fecRegInstitutcion) {
        this.fecRegInstitutcion = fecRegInstitutcion;
    }

    public String getNomComInstitucion() {
        return nomComInstitucion;
    }

    public void setNomComInstitucion(String nomComInstitucion) {
        this.nomComInstitucion = nomComInstitucion;
    }

    public String getRazSocInstitucion() {
        return razSocInstitucion;
    }

    public void setRazSocInstitucion(String razSocInstitucion) {
        this.razSocInstitucion = razSocInstitucion;
    }

    public String getDirInstitucion() {
        return dirInstitucion;
    }

    public void setDirInstitucion(String dirInstitucion) {
        this.dirInstitucion = dirInstitucion;
    }

    public int getTelInstitucion() {
        return telInstitucion;
    }

    public void setTelInstitucion(int telInstitucion) {
        this.telInstitucion = telInstitucion;
    }

    public long getNitInstitucion() {
        return nitInstitucion;
    }

    public void setNitInstitucion(long nitInstitucion) {
        this.nitInstitucion = nitInstitucion;
    }

    public Integer getNrcInstitucion() {
        return nrcInstitucion;
    }

    public void setNrcInstitucion(Integer nrcInstitucion) {
        this.nrcInstitucion = nrcInstitucion;
    }

    public String getGirInstitucion() {
        return girInstitucion;
    }

    public void setGirInstitucion(String girInstitucion) {
        this.girInstitucion = girInstitucion;
    }

    public String getNomConInstitucion() {
        return nomConInstitucion;
    }

    public void setNomConInstitucion(String nomConInstitucion) {
        this.nomConInstitucion = nomConInstitucion;
    }

    public Integer getCelConInstitucion() {
        return celConInstitucion;
    }

    public void setCelConInstitucion(Integer celConInstitucion) {
        this.celConInstitucion = celConInstitucion;
    }

    public boolean getEsDonante() {
        return esDonante;
    }

    public void setEsDonante(boolean esDonante) {
        this.esDonante = esDonante;
    }

    public boolean getEsProveedor() {
        return esProveedor;
    }

    public void setEsProveedor(boolean esProveedor) {
        this.esProveedor = esProveedor;
    }

    public Collection<TblOrdenCompra> getTblOrdenCompraCollection() {
        return tblOrdenCompraCollection;
    }

    public void setTblOrdenCompraCollection(Collection<TblOrdenCompra> tblOrdenCompraCollection) {
        this.tblOrdenCompraCollection = tblOrdenCompraCollection;
    }

    public Collection<TblSolicitudDonacion> getTblSolicitudDonacionCollection() {
        return tblSolicitudDonacionCollection;
    }

    public void setTblSolicitudDonacionCollection(Collection<TblSolicitudDonacion> tblSolicitudDonacionCollection) {
        this.tblSolicitudDonacionCollection = tblSolicitudDonacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numInstitucion != null ? numInstitucion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblInstitucion)) {
            return false;
        }
        TblInstitucion other = (TblInstitucion) object;
        if ((this.numInstitucion == null && other.numInstitucion != null) || (this.numInstitucion != null && !this.numInstitucion.equals(other.numInstitucion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblInstitucion[ numInstitucion=" + numInstitucion + " ]";
    }
    
}
