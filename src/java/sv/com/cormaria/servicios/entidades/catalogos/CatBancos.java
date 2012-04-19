/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.catalogos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import sv.com.cormaria.servicios.enums.Estado;

/**
 *
 * @author Claudia
 */
@Entity
@Table(name = "cat_bancos")
@NamedQueries({
    @NamedQuery(name = "CatBancos.findAll", query = "SELECT c FROM CatBancos c"),
    @NamedQuery(name = "CatBancos.findActive", query = "SELECT c FROM CatBancos c WHERE c.actBanco = 1")
})
public class CatBancos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_BANCO")
    private Integer codBanco;
    @Basic(optional = false)
    @NotNull(message="Ingrese el nombre del Banco")
    @Size(min = 1, max = 100)
    @Column(name = "NOM_BANCO")
    private String nomBanco;
    @Basic(optional = false)
    @NotNull(message="Ingrese una descripción general del Banco")
    @Size(min = 1, max = 100)
    @Column(name = "DES_BANCO")
    private String desBanco;
    @Basic(optional = false)
    @NotNull(message="Ingrese el estado del Banco")
    @Column(name = "ACT_BANCO")
    private Estado actBanco;

    public CatBancos() {
    }

    public CatBancos(Integer codBanco) {
        this.codBanco = codBanco;
    }

    public CatBancos(Integer codBanco, String nomBanco, String desBanco, Estado actBanco) {
        this.codBanco = codBanco;
        this.nomBanco = nomBanco;
        this.desBanco = desBanco;
        this.actBanco = actBanco;
    }

    public Integer getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(Integer codBanco) {
        this.codBanco = codBanco;
    }

    public String getNomBanco() {
        return nomBanco;
    }

    public void setNomBanco(String nomBanco) {
        this.nomBanco = nomBanco;
    }

    public String getDesBanco() {
        return desBanco;
    }

    public void setDesBanco(String desBanco) {
        this.desBanco = desBanco;
    }

    public Estado getActBanco() {
        return actBanco;
    }

    public void setActBanco(Estado actBanco) {
        this.actBanco = actBanco;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBanco != null ? codBanco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatBancos)) {
            return false;
        }
        CatBancos other = (CatBancos) object;
        if ((this.codBanco == null && other.codBanco != null) || (this.codBanco != null && !this.codBanco.equals(other.codBanco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatBancos[ codBanco=" + codBanco + " ]";
    }
    
}
