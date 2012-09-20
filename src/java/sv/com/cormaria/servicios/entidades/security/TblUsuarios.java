/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import sv.com.cormaria.servicios.entidades.administracion.TblEmpleado;
import sv.com.cormaria.servicios.enums.EstadoUsuario;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "tbl_usuarios")
@NamedQueries({
    @NamedQuery(name = "TblUsuarios.findAll", query = "SELECT t FROM TblUsuarios t"),
    @NamedQuery(name="TblUsuarios.findCodigoUsuario", query="Select u from TblUsuarios u where u.aliUsuario = :codigousuario"),
    @NamedQuery(name="TblUsuarios.findAllUsuariosByEstado", query="Select u from TblUsuarios u where u.estUsuario = :estado"),
    @NamedQuery(name="TblUsuarios.findAllUsuarios", query="Select u from TblUsuarios u"),
    @NamedQuery(name="TblUsuarios.findAllActiveUsers", query="Select u from TblUsuarios u where u.estUsuario = 1"),
    @NamedQuery(name="TblUsuarios.findAllActiveUsersNotInAgentes", query="Select u from TblUsuarios u where u.estUsuario = 1")
})
public class TblUsuarios implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "NUM_USUARIO")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long numUsuario;
    @Basic(optional = false)
    @NotNull(message="Por favor especifique el alias del usuario")
    @Size(min = 1, max = 100, message="El alias debe tener mas de un caracter y menos de 100")
    @Column(name = "ALI_USUARIO")
    private String aliUsuario;
    @Basic(optional = false)
    @NotNull(message="Por favor especifique la contrasena del usuario")
    @Size(min = 1, max = 25, message="La contrasena debe tener mas de un caracter y menos de 25")
    @Column(name = "CON_USUARIO")
    private String conUsuario;
    @Basic(optional = false)
    @NotNull(message="Por favor especifique los nombres del usuario")
    @Size(min = 1, max = 50, message="El nombre del usuario no puede tener mas de 50 caracteres")
    @Column(name = "NOM_USUARIO")
    private String nomUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CRE_POR")
    private String crePor;
    @Basic(optional = false)
    @NotNull(message="Por favor especifique la fecha de creacion")
    @Column(name = "FEC_CRECION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecCrecion;
    @Column(name = "NUM_EMPLEADO")
    private Integer numEmpleado;

    @Basic
    @Column(name = "FEC_DESACTIVACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecDesactivacion;
    
    @Basic
    @Column(name = "FEC_EXPIRACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecExpiracion;
    @Basic(optional = false)
    @NotNull(message="Por favor especifique la fecha de modificacion")
    @Column(name = "FEC_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecModificacion;
    @Basic
    @NotNull(message="Por favor especifique la ultima fecha de cambio de contrasena")
    @Column(name = "FEC_ULT_CAM_CONTRASENA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecUltCamContrasena;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MOD_POR")
    private String modPor;
    @Column(name = "ULT_FEC_FIN_SESION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultFecFinSesion;
    @Column(name = "ULT_FEC_INI_SESION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ultFecIniSesion;

    @Column(name = "NUM_MEDICO")
    private Integer numMedico;
    
    @ManyToOne
    @JoinColumn(name="NUM_EMPLEADO", referencedColumnName="NUM_EMPLEADO", insertable=false, updatable=false)
    private TblEmpleado empleado;
    
    @OneToMany(mappedBy="usuario",fetch= FetchType.EAGER)
    private Set<CatRolesUsuario> rolesusuario;

    @Basic(optional=false)
    @NotNull(message="Por favor especifique el estado del usuario")
    @Column(name="est_usuario")
    private EstadoUsuario estUsuario;
    
    @Transient
    private String passwordConfirmation;

    @Transient
    Set<CatMenu> subOptions = new HashSet<CatMenu>();

    @Transient
    Set<CatMenu> modulos = new HashSet<CatMenu>();

    @Transient
    CatMenu selectedModule;

    
    public TblUsuarios() {
    }

    public TblUsuarios(Long numUsuario) {
        this.numUsuario = numUsuario;
    }

    public TblUsuarios(Long numUsuario, String aliUsuario, String conUsuario, String nomUsuario, String crePor, Date fecCrecion, Date fecDesactivacion, Date fecExpiracion, Date fecModificacion, Date fecUltCamContrasena, String modPor) {
        this.numUsuario = numUsuario;
        this.aliUsuario = aliUsuario;
        this.conUsuario = conUsuario;
        this.nomUsuario = nomUsuario;
        this.crePor = crePor;
        this.fecCrecion = fecCrecion;
        this.fecDesactivacion = fecDesactivacion;
        this.fecExpiracion = fecExpiracion;
        this.fecModificacion = fecModificacion;
        this.fecUltCamContrasena = fecUltCamContrasena;
        this.modPor = modPor;
    }

    public Integer getNumMedico() {
        return numMedico;
    }

    public void setNumMedico(Integer numMedico) {
        this.numMedico = numMedico;
    }

    public TblEmpleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(TblEmpleado empleado) {
        this.empleado = empleado;
    }

    public Long getNumUsuario() {
        return numUsuario;
    }

    public void setNumUsuario(Long numUsuario) {
        this.numUsuario = numUsuario;
    }

    public String getAliUsuario() {
        return aliUsuario;
    }

    public void setAliUsuario(String aliUsuario) {
        this.aliUsuario = aliUsuario;
    }

    public String getConUsuario() {
        return conUsuario;
    }

    public void setConUsuario(String conUsuario) {
        this.conUsuario = conUsuario;
    }

    public String getNomUsuario() {
        return nomUsuario;
    }

    public void setNomUsuario(String nomUsuario) {
        this.nomUsuario = nomUsuario;
    }

    public String getCrePor() {
        return crePor;
    }

    public void setCrePor(String crePor) {
        this.crePor = crePor;
    }

    public Date getFecCrecion() {
        return fecCrecion;
    }

    public void setFecCrecion(Date fecCrecion) {
        this.fecCrecion = fecCrecion;
    }

    public Date getFecDesactivacion() {
        return fecDesactivacion;
    }

    public void setFecDesactivacion(Date fecDesactivacion) {
        this.fecDesactivacion = fecDesactivacion;
    }

    public Date getFecExpiracion() {
        return fecExpiracion;
    }

    public void setFecExpiracion(Date fecExpiracion) {
        this.fecExpiracion = fecExpiracion;
    }

    public Date getFecModificacion() {
        return fecModificacion;
    }

    public void setFecModificacion(Date fecModificacion) {
        this.fecModificacion = fecModificacion;
    }

    public Date getFecUltCamContrasena() {
        return fecUltCamContrasena;
    }

    public void setFecUltCamContrasena(Date fecUltCamContrasena) {
        this.fecUltCamContrasena = fecUltCamContrasena;
    }

    public String getModPor() {
        return modPor;
    }

    public void setModPor(String modPor) {
        this.modPor = modPor;
    }

    public Date getUltFecFinSesion() {
        return ultFecFinSesion;
    }

    public void setUltFecFinSesion(Date ultFecFinSesion) {
        this.ultFecFinSesion = ultFecFinSesion;
    }

    public Date getUltFecIniSesion() {
        return ultFecIniSesion;
    }

    public void setUltFecIniSesion(Date ultFecIniSesion) {
        this.ultFecIniSesion = ultFecIniSesion;
    }

    public EstadoUsuario getEstUsuario() {
        return estUsuario;
    }

    public void setEstUsuario(EstadoUsuario estUsuario) {
        this.estUsuario = estUsuario;
    }

    public Integer getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(Integer numEmpleado) {
        this.numEmpleado = numEmpleado;
    }
    
    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public Set<CatMenu> getAllOptions(){
        return new HashSet<CatMenu>();
    }

    public CatMenu getSelectedModule() {
        return selectedModule;
    }

    public void setSelectedModule(CatMenu selectedModule) {
        this.selectedModule = selectedModule;
    }
    
    public ArrayList<CatMenu> getModulos() {
        if (modulos.isEmpty()){
            this.getSubOptions();
        }
        return new ArrayList<CatMenu>(modulos);
    }

    public void setModulos(Set<CatMenu> modulos) {
        this.modulos = modulos;
    }
    
    public ArrayList<CatMenu> getSubOptions() {
         if (subOptions.isEmpty()){
            for (CatRolesUsuario roleusuario : this.rolesusuario){
                    for (CatRolesMenu rolesmenu : roleusuario.getCatRole().getRolesMenu()) {
                            if (rolesmenu.getCatMenu().getCodPadMenu() == null){
                                    subOptions.add(rolesmenu.getCatMenu());
                                    modulos.add(rolesmenu.getCatMenu());
                            }else{
                                    rolesmenu.getCatMenu().getMenu().getOptions().add(rolesmenu.getCatMenu());
                            }
                    }
            }
        }
        return new ArrayList<CatMenu>(subOptions);
   }

    public void setSubOptions(Set<CatMenu> subOptions) {
        this.subOptions = subOptions;
    }

    
    
    public Set<CatRolesUsuario> getRolesusuario() {
	return rolesusuario;
    }

    public void setRolesusuario(Set<CatRolesUsuario> rolesusuario) {
	this.rolesusuario = rolesusuario;
    }
    
    @PrePersist
    public void prePersist(){
        this.fecCrecion = new java.util.Date();
        this.fecModificacion = new java.util.Date();
        this.fecUltCamContrasena = new java.util.Date();
    }
    
    @PreUpdate
    public void preUpdate(){
        this.fecModificacion = new java.util.Date();
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numUsuario != null ? numUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TblUsuarios)) {
            return false;
        }
        TblUsuarios other = (TblUsuarios) object;
        if ((this.numUsuario == null && other.numUsuario != null) || (this.numUsuario != null && !this.numUsuario.equals(other.numUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.TblUsuarios[ numUsuario=" + numUsuario + " ]";
    }
    
}
