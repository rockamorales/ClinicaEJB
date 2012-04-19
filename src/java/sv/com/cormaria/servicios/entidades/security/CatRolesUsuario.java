package sv.com.cormaria.servicios.entidades.security;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the rolesusuario database table.
 * 
 */

@NamedQueries({
	@NamedQuery(name="rolesusuario.findAllRolesByUser", query="Select r from CatRolesUsuario r where r.id.numUsuario = :usuariosid")
})
@Entity
@Table(name="cat_roles_usuarios")
public class CatRolesUsuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private CatRolesUsuarioPK id;

	//bi-directional many-to-one association to CatRoles
    @ManyToOne
    @JoinColumn(name="cod_rol",insertable=false, updatable=false)
    private CatRoles catRole;

    @ManyToOne
    @JoinColumn(name="num_usuario",insertable=false, updatable=false)
    private TblUsuarios usuario;

    public CatRolesUsuario() {
    }

    public CatRolesUsuarioPK getId() {
            return this.id;
    }

    public void setId(CatRolesUsuarioPK id) {
            this.id = id;
    }

    public CatRoles getCatRole() {
        return catRole;
    }

    public void setCatRole(CatRoles catRole) {
        this.catRole = catRole;
    }

    public TblUsuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(TblUsuarios usuario) {
        this.usuario = usuario;
    }	
}