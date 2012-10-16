/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.administracion;


import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import sv.com.cormaria.servicios.enums.Estado;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_beneficiarios")
@NamedQueries({
    @NamedQuery(name = "TblBeneficiarios.findAll", query = "SELECT t FROM TblBeneficiarios t where t.actBeneficiario=1")})
public class TblBeneficiarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_BENEFICIARIO")
    private Integer numBeneficiario;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el nombre del beneficiario")
    @Size(min = 1, max = 100, message = "El nombre del beneficiario no debe ser mayor de 100 caracteres")
    @Column(name = "NOM_BENEFICIARIO")
    private String nomBeneficiario;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la dirección del beneficiario")
    @Size(min = 1, max = 250, message = "la dirección no debe ser mayor de 250  caracteres")
    @Column(name = "DIR_BENEFICIARIO")
    private String dirBeneficiario;
    @Column(name = "TEL_BENEFICIARIO")
    private Integer telBeneficiario;
    @Column(name = "NIT_BENEFICIARIO")
    private String nitBeneficiario;
    @Column(name = "NRC_BENEFICIARIO")
    private Integer nrcBeneficiario;
    @Size(max = 100, message = "El giro no debe ser mayor de 100 caracteres")
    @Column(name = "GIR_BENEFICIARIO")
    private String girBeneficiario;
    @Column(name = "COD_RUBRO")
    private Integer codRubro;
    @Column(name = "CEL_BENEFICIARIO")
    private Integer celConBeneficiario;
    @Column(name = "ACT_BENEFICIARIO")
    private Estado actBeneficiario;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el nombre del contacto del benenficiario")
    @Size(min = 1, max = 100, message = "El nombre de contacto del beneficiario no debe ser mayor de 100 caracteres")
    @Column(name = "NOM_CON_BENEFICIARIO")
    private String nomConBeneficiario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "numBeneficiario")
    private Collection<TblDonacionEmitida> tblDonacionEmitidaCollection;

    public TblBeneficiarios() {
    }

    public TblBeneficiarios(Integer numBeneficiario) {
        this.numBeneficiario = numBeneficiario;
    }

    public TblBeneficiarios(Integer numBeneficiario, String nomBeneficiario, String dirBeneficiario, String nomConBeneficiario) {
        this.numBeneficiario = numBeneficiario;
        this.nomBeneficiario = nomBeneficiario;
        this.dirBeneficiario = dirBeneficiario;
        this.nomConBeneficiario = nomConBeneficiario;
    }

    public Estado getActBeneficiario() {
        return actBeneficiario;
    }

    public void setActBeneficiario(Estado actBeneficiario) {
        this.actBeneficiario = actBeneficiario;
    }

    public Integer getCelConBeneficiario() {
        return celConBeneficiario;
    }

    public void setCelConBeneficiario(Integer celConBeneficiario) {
        this.celConBeneficiario = celConBeneficiario;
    }
    

    public Integer getNumBeneficiario() {
        return numBeneficiario;
    }

    public void setNumBeneficiario(Integer numBeneficiario) {
        this.numBeneficiario = numBeneficiario;
    }

    public Integer getCodRubro() {
        return codRubro;
    }

    public void setCodRubro(Integer codRubro) {
        this.codRubro = codRubro;
    }

    
    public String getNomBeneficiario() {
        return nomBeneficiario;
    }

    public void setNomBeneficiario(String nomBeneficiario) {
        this.nomBeneficiario = nomBeneficiario;
    }

    public String getDirBeneficiario() {
        return dirBeneficiario;
    }

    public void setDirBeneficiario(String dirBeneficiario) {
        this.dirBeneficiario = dirBeneficiario;
    }

    public Integer getTelBeneficiario() {
        return telBeneficiario;
    }

    public void setTelBeneficiario(Integer telBeneficiario) {
        this.telBeneficiario = telBeneficiario;
    }

    public String getNitBeneficiario() {
        return nitBeneficiario;
    }

    public void setNitBeneficiario(String nitBeneficiario) {
        this.nitBeneficiario = nitBeneficiario;
    }

    public Integer getNrcBeneficiario() {
        return nrcBeneficiario;
    }

    public void setNrcBeneficiario(Integer nrcBeneficiario) {
        this.nrcBeneficiario = nrcBeneficiario;
    }

    public String getGirBeneficiario() {
        return girBeneficiario;
    }

    public void setGirBeneficiario(String girBeneficiario) {
        this.girBeneficiario = girBeneficiario;
    }

    public String getNomConBeneficiario() {
        return nomConBeneficiario;
    }

    public void setNomConBeneficiario(String nomConBeneficiario) {
        this.nomConBeneficiario = nomConBeneficiario;
    }

    public Collection<TblDonacionEmitida> getTblDonacionEmitidaCollection() {
        return tblDonacionEmitidaCollection;
    }

    public void setTblDonacionEmitidaCollection(Collection<TblDonacionEmitida> tblDonacionEmitidaCollection) {
        this.tblDonacionEmitidaCollection = tblDonacionEmitidaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numBeneficiario != null ? numBeneficiario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblBeneficiarios)) {
            return false;
        }
        TblBeneficiarios other = (TblBeneficiarios) object;
        if ((this.numBeneficiario == null && other.numBeneficiario != null) || (this.numBeneficiario != null && !this.numBeneficiario.equals(other.numBeneficiario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.administracion.TblBeneficiarios[ numBeneficiario=" + numBeneficiario + " ]";
    }
    
}
