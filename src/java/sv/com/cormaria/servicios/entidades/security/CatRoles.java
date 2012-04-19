package sv.com.cormaria.servicios.entidades.security;

import java.io.Serializable;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;


/**
 * The persistent class for the roles database table.
 * 
 */

@NamedQueries({
	@NamedQuery(name="CatRoles.findAll", query="Select r from CatRoles r")
})

@Entity
@Table(name="CAT_ROLES")
public class CatRoles implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="cod_rol")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long codRol;

    @Column(name="nom_rol")
    private String nomRol;

    @Column(name="des_rol")
    private String desRol;

    @OneToMany(mappedBy="catRole", fetch=FetchType.EAGER)
    private Set<CatRolesMenu> rolesMenu;

    public CatRoles() {
    }

    public Set<CatRolesMenu> getRolesMenu() {
            return rolesMenu;
    }

    public void setRolesMenu(Set<CatRolesMenu> rolesMenu) {
            this.rolesMenu = rolesMenu;
    }


    public Set<CatMenu> getAllOptions(){
        Set<CatMenu> options = new HashSet<CatMenu>();
        for (CatRolesMenu rolesmenu : getRolesMenu()) {
            if (rolesmenu.getCatMenu().getCodMenu() == null){
                    options.add(rolesmenu.getCatMenu());
            }else{
                    rolesmenu.getCatMenu().getMenu().getOptions().add(rolesmenu.getCatMenu());
            }
        }
        return options;
    }
	

    public Long getCodRol() {
        return codRol;
    }

    public void setCodRol(Long codRol) {
        this.codRol = codRol;
    }

    public String getDesRol() {
        return desRol;
    }

    public void setDesRol(String desRol) {
        this.desRol = desRol;
    }

    public String getNomRol() {
        return nomRol;
    }

    public void setNomRol(String nomRol) {
        this.nomRol = nomRol;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CatRoles other = (CatRoles) obj;
        if (this.codRol != other.codRol && (this.codRol == null || !this.codRol.equals(other.codRol))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.codRol != null ? this.codRol.hashCode() : 0);
        return hash;
    }
    
}