package sv.com.cormaria.servicios.entidades.security;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rolesmenu database table.
 * 
 */
@Entity
@Table(name="cat_roles_menu")
public class CatRolesMenu implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CatRolesMenuPK id;

    //uni-directional many-to-one association to CatRoles
    @ManyToOne
    @JoinColumn(name="cod_rol",updatable=false, insertable=false)
    private CatRoles catRole;

    @ManyToOne
    @JoinColumn(name="cod_menu", updatable=false, insertable=false)
    private CatMenu catMenu;

    public CatRolesMenu() {
    }

    public CatRolesMenuPK getId() {
            return this.id;
    }

    public void setId(CatRolesMenuPK id) {
            this.id = id;
    }

    public CatMenu getCatMenu() {
        return catMenu;
    }

    public void setCatMenu(CatMenu catMenu) {
        this.catMenu = catMenu;
    }

    public CatRoles getCatRole() {
        return catRole;
    }

    public void setCatRole(CatRoles catRole) {
        this.catRole = catRole;
    }
}