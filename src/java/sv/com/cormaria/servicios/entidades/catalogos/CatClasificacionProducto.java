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

/**
 *
 * @author Schumy
 */
@Entity
@Table(name = "cat_clasificacion_producto")
@NamedQueries({
    @NamedQuery(name = "CatClasificacionProducto.findAll", query = "SELECT c FROM CatClasificacionProducto c")})
public class CatClasificacionProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_CLA_PRODUCTO")
    private Integer codClaProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOM_CLA_PRODUCTO")
    private String nomClaProducto;
    @Size(max = 100)
    @Column(name = "DES_CLA_PRODUCTO")
    private String desClaProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACT_CLA_PRODUCTO")
    private int actClaProducto;
    @Column(name = "COD_TIP_PRODUCTO")
    private Integer codTipProducto;

    public CatClasificacionProducto() {
    }

    public CatClasificacionProducto(Integer codClaProducto) {
        this.codClaProducto = codClaProducto;
    }

    public CatClasificacionProducto(Integer codClaProducto, String nomClaProducto, int actClaProducto) {
        this.codClaProducto = codClaProducto;
        this.nomClaProducto = nomClaProducto;
        this.actClaProducto = actClaProducto;
    }

    public Integer getCodClaProducto() {
        return codClaProducto;
    }

    public void setCodClaProducto(Integer codClaProducto) {
        this.codClaProducto = codClaProducto;
    }

    public String getNomClaProducto() {
        return nomClaProducto;
    }

    public void setNomClaProducto(String nomClaProducto) {
        this.nomClaProducto = nomClaProducto;
    }

    public String getDesClaProducto() {
        return desClaProducto;
    }

    public void setDesClaProducto(String desClaProducto) {
        this.desClaProducto = desClaProducto;
    }

    public int getActClaProducto() {
        return actClaProducto;
    }

    public void setActClaProducto(int actClaProducto) {
        this.actClaProducto = actClaProducto;
    }

    public Integer getCodTipProducto() {
        return codTipProducto;
    }

    public void setCodTipProducto(Integer codTipProducto) {
        this.codTipProducto = codTipProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codClaProducto != null ? codClaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatClasificacionProducto)) {
            return false;
        }
        CatClasificacionProducto other = (CatClasificacionProducto) object;
        if ((this.codClaProducto == null && other.codClaProducto != null) || (this.codClaProducto != null && !this.codClaProducto.equals(other.codClaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatClasificacionProducto[ codClaProducto=" + codClaProducto + " ]";
    }
    
}
