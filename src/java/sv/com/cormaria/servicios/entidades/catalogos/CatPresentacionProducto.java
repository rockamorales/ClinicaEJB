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
@Table(name = "cat_Presentacion_Producto")
@NamedQueries({
    @NamedQuery(name = "CatPresentacionProducto.findAll", query = "SELECT c FROM CatPresentacionProducto c"),
    @NamedQuery(name = "CatPresentacionProducto.findActive", query = "SELECT c FROM CatPresentacionProducto c where c.actPreProducto = 1 ")
   })    
public class CatPresentacionProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_PRE_PRODUCTO")
    private Integer codPreProducto;
    @Column(name = "NOM_PRE_PRODUCTO")
    private String nomPreProducto;
    @Column(name = "DES_PRE_PRODUCTO")
    private String desPreProducto;
    @Column(name = "ACT_PRE_PRODUCTO")
    @Enumerated(EnumType.ORDINAL)
    private Estado actPreProducto;

    public CatPresentacionProducto() {
    }

    public CatPresentacionProducto(Integer codPreProducto) {
        this.codPreProducto = codPreProducto;
    }

    public CatPresentacionProducto(Integer codPreProducto, String nomPreProducto, Estado actPreProducto) {
        this.codPreProducto = codPreProducto;
        this.nomPreProducto = nomPreProducto;
        this.actPreProducto = actPreProducto;
    }

    public Integer getCodPreProducto() {
        return codPreProducto;
    }

    public void setCodPreProducto(Integer codPreProducto) {
        this.codPreProducto = codPreProducto;
    }

    public String getNomPreProducto() {
        return nomPreProducto;
    }

    public void setNomPreProducto(String nomPreProducto) {
        this.nomPreProducto = nomPreProducto;
    }

    public String getDesPreProducto() {
        return desPreProducto;
    }

    public void setDesPreProducto(String desPreProducto) {
        this.desPreProducto = desPreProducto;
    }

    public Estado getActPreProducto() {
        return actPreProducto;
    }

    public void setActPreProducto(Estado actPreProducto) {
        this.actPreProducto = actPreProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPreProducto != null ? codPreProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatPresentacionProducto)) {
            return false;
        }
        CatPresentacionProducto other = (CatPresentacionProducto) object;
        if ((this.codPreProducto == null && other.codPreProducto != null) || (this.codPreProducto != null && !this.codPreProducto.equals(other.codPreProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatPresentacionProducto[ codPreProducto=" + codPreProducto + " ]";
    }
    
}
