/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.catalogos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
@Table(name = "cat_categoria_producto")
@NamedQueries({
    @NamedQuery(name = "CatCategoriaProducto.findAll", query = "SELECT c FROM CatCategoriaProducto c"),
    @NamedQuery(name = "CatCategoriaProducto.findActive", query = "SELECT c FROM CatCategoriaProducto c where c.actCatProducto=1 ")
   })    
public class CatCategoriaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    public static final Integer TARJETA_CONTROL=5;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_CAT_PRODUCTO")
    private Integer codCatProducto;
    @Column(name = "NOM_CAT_PRODUCTO")
    private String nomCatProducto;
    @Column(name = "DES_CAT_PRODUCTO")
    private String desCatProducto;
    @Column(name = "ACT_CAT_PRODUCTO")
    @Enumerated(EnumType.ORDINAL)
    private Estado actCatProducto;

    public CatCategoriaProducto() {
    }

    public CatCategoriaProducto(Integer codCatProducto) {
        this.codCatProducto = codCatProducto;
    }

    public CatCategoriaProducto(Integer codCatProducto, String nomCatProducto, Estado actCatProducto) {
        this.codCatProducto = codCatProducto;
        this.nomCatProducto = nomCatProducto;
        this.actCatProducto = actCatProducto;
    }

    public Integer getCodCatProducto() {
        return codCatProducto;
    }

    public void setCodCatProducto(Integer codCatProducto) {
        this.codCatProducto = codCatProducto;
    }

    public String getNomCatProducto() {
        return nomCatProducto;
    }

    public void setNomCatProducto(String nomCatProducto) {
        this.nomCatProducto = nomCatProducto;
    }

    public String getDesCatProductoCatProducto() {
        return desCatProducto;
    }

    public void setDesCatProductoCatProducto(String desCatProducto) {
        this.desCatProducto = desCatProducto;
    }

    public Estado getActCatProducto() {
        return actCatProducto;
    }

    public void setActCatProducto(Estado actCatProducto) {
        this.actCatProducto = actCatProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCatProducto != null ? codCatProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatCategoriaProducto)) {
            return false;
        }
        CatCategoriaProducto other = (CatCategoriaProducto) object;
        if ((this.codCatProducto == null && other.codCatProducto != null) || (this.codCatProducto != null && !this.codCatProducto.equals(other.codCatProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatCategoriaProducto[ codCatProducto=" + codCatProducto + " ]";
    }
    
}
