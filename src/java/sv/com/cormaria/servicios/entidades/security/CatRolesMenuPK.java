package sv.com.cormaria.servicios.entidades.security;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rolesmenu database table.
 * 
 */
@Embeddable
public class CatRolesMenuPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name="cod_rol")
    private long codRol;

    @Column(name="cod_menu")
    private long codMenu;

    public CatRolesMenuPK() {
    }

    public long getCodMenu() {
        return codMenu;
    }

    public void setCodMenu(long codMenu) {
        this.codMenu = codMenu;
    }

    public long getCodRol() {
        return codRol;
    }

    public void setCodRol(long codRol) {
        this.codRol = codRol;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CatRolesMenuPK other = (CatRolesMenuPK) obj;
        if (this.codRol != other.codRol) {
            return false;
        }
        if (this.codMenu != other.codMenu) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (this.codRol ^ (this.codRol >>> 32));
        hash = 67 * hash + (int) (this.codMenu ^ (this.codMenu >>> 32));
        return hash;
    }

}