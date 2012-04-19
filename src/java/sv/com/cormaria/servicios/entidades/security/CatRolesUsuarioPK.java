package sv.com.cormaria.servicios.entidades.security;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the rolesusuario database table.
 * 
 */
@Embeddable
public class CatRolesUsuarioPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name="num_usuario")
    private Long numUsuario;

    @Column(name="cod_rol")
    private Long codRol;

    public CatRolesUsuarioPK() {
    }

    public Long getCodRol() {
        return codRol;
    }

    public void setCodRol(Long codRol) {
        this.codRol = codRol;
    }

    public Long getNumUsuario() {
        return numUsuario;
    }

    public void setNumUsuario(Long numUsuario) {
        this.numUsuario = numUsuario;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CatRolesUsuarioPK other = (CatRolesUsuarioPK) obj;
        if (this.numUsuario != other.numUsuario && (this.numUsuario == null || !this.numUsuario.equals(other.numUsuario))) {
            return false;
        }
        if (this.codRol != other.codRol && (this.codRol == null || !this.codRol.equals(other.codRol))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (this.numUsuario != null ? this.numUsuario.hashCode() : 0);
        hash = 47 * hash + (this.codRol != null ? this.codRol.hashCode() : 0);
        return hash;
    }
}