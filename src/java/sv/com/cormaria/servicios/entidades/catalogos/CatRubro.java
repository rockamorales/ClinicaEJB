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
@Table(name = "cat_rubro")
@NamedQueries({
    @NamedQuery(name = "CatRubro.findAll", query = "SELECT c FROM CatRubro c")})
public class CatRubro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_RUBRO")
    private Integer codRubro;
    @Basic(optional = false)
    @NotNull(message="Ingrese el nombre del nuevo Rubro")
    @Size(min = 1, max = 50)
    @Column(name = "NOM_RUBRO")
    private String nomRubro;
    @Size(max = 100)
    @Column(name = "DES_RUBRO")
    private String desRubro;
    @Basic(optional = false)
    @NotNull(message="Ingrese el estado del Rubro")
    @Column(name = "ACT_RUBRO")
    private Estado actRubro;

    public CatRubro() {
    }

    public CatRubro(Integer codRubro) {
        this.codRubro = codRubro;
    }

    public CatRubro(Integer codRubro, String nomRubro, Estado actRubro) {
        this.codRubro = codRubro;
        this.nomRubro = nomRubro;
        this.actRubro = actRubro;
    }

    public Integer getCodRubro() {
        return codRubro;
    }

    public void setCodRubro(Integer codRubro) {
        this.codRubro = codRubro;
    }

    public String getNomRubro() {
        return nomRubro;
    }

    public void setNomRubro(String nomRubro) {
        this.nomRubro = nomRubro;
    }

    public String getDesRubro() {
        return desRubro;
    }

    public void setDesRubro(String desRubro) {
        this.desRubro = desRubro;
    }

    public Estado getActRubro() {
        return actRubro;
    }

    public void setActRubro(Estado actRubro) {
        this.actRubro = actRubro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRubro != null ? codRubro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatRubro)) {
            return false;
        }
        CatRubro other = (CatRubro) object;
        if ((this.codRubro == null && other.codRubro != null) || (this.codRubro != null && !this.codRubro.equals(other.codRubro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatRubro[ codRubro=" + codRubro + " ]";
    }
    
}
