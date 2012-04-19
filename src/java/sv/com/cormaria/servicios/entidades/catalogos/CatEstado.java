/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.catalogos;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import sv.com.cormaria.servicios.enums.Estado;

/**
 *
 * @author Administrador
 */
@Entity
@Table(name = "cat_estado")
@NamedQueries({
    @NamedQuery(name = "CatEstado.findAll", query = "SELECT c FROM CatEstado c")})
public class CatEstado implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "COD_ESTADO")
    private Short codEstado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOM_ESTADO")
    private String nomEstado;
    @Size(max = 100)
    @Column(name = "DES_ESTADO")
    private String desEstado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACT_ESTADO")
    private Estado actEstado;

    public CatEstado() {
    }

    public CatEstado(Short codEstado) {
        this.codEstado = codEstado;
    }

    public CatEstado(Short codEstado, String nomEstado, Estado actEstado) {
        this.codEstado = codEstado;
        this.nomEstado = nomEstado;
        this.actEstado = actEstado;
    }

    public Short getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(Short codEstado) {
        this.codEstado = codEstado;
    }

    public String getNomEstado() {
        return nomEstado;
    }

    public void setNomEstado(String nomEstado) {
        this.nomEstado = nomEstado;
    }

    public String getDesEstado() {
        return desEstado;
    }

    public void setDesEstado(String desEstado) {
        this.desEstado = desEstado;
    }

    public Estado getActEstado() {
        return actEstado;
    }

    public void setActEstado(Estado actEstado) {
        this.actEstado = actEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstado != null ? codEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof CatEstado)) {
            return false;
        }
        CatEstado other = (CatEstado) object;
        if ((this.codEstado == null && other.codEstado != null) || (this.codEstado != null && !this.codEstado.equals(other.codEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.CatEstado[ codEstado=" + codEstado + " ]";
    }
    
}
