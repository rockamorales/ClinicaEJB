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
@Table(name = "cat_carisma")
@NamedQueries({
    @NamedQuery(name = "CatCarisma.findAll", query = "SELECT c FROM CatCarisma c"),
    @NamedQuery(name = "CatCarisma.findActive", query = "SELECT c FROM CatCarisma c WHERE c.actCarisma = 1")
})
public class CatCarisma implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_CARISMA")
    private Integer codCarisma;
    @Column(name = "NOM_CARISMA")
    private String nomCarisma;
    @Column(name = "DES_CARISMA")
    private String desCarisma;
    @Column(name = "ACT_CARISMA")
    private Estado actCarisma;

    public CatCarisma() {
    }

    public CatCarisma(Integer codCarisma) {
        this.codCarisma = codCarisma;
    }

    public CatCarisma(Integer codCarisma, String nomCarisma, Estado actCarisma) {
        this.codCarisma = codCarisma;
        this.nomCarisma = nomCarisma;
        this.actCarisma = actCarisma;
    }

    public Integer getCodCarisma() {
        return codCarisma;
    }

    public void setCodCarisma(Integer codCarisma) {
        this.codCarisma = codCarisma;
    }

    public String getNomCarisma() {
        return nomCarisma;
    }

    public void setNomCarisma(String nomCarisma) {
        this.nomCarisma = nomCarisma;
    }

    public String getDesCarisma() {
        return desCarisma;
    }

    public void setDesCarisma(String desCarisma) {
        this.desCarisma = desCarisma;
    }

    public Estado getActCarisma() {
        return actCarisma;
    }

    public void setActCarisma(Estado actCarisma) {
        this.actCarisma = actCarisma;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCarisma != null ? codCarisma.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatCarisma)) {
            return false;
        }
        CatCarisma other = (CatCarisma) object;
        if ((this.codCarisma == null && other.codCarisma != null) || (this.codCarisma != null && !this.codCarisma.equals(other.codCarisma))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatCarisma[ codCarisma=" + codCarisma + " ]";
    }
    
}
