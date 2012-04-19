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
@Table(name = "cat_tipo_referencia")
@NamedQueries({
    @NamedQuery(name = "CatTipoReferencia.findAll", query = "SELECT c FROM CatTipoReferencia c")})
public class CatTipoReferencia implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_TIP_REFERENCIA")
    private Integer codTipReferencia;
    @Basic(optional = false)
    @NotNull(message="Ingrese el nombre del Tipo de Referencia")
    @Size(min = 1, max = 50)
    @Column(name = "NOM_TIP_REFERENCIA")
    private String nomTipReferencia;
    @Size(max = 100)
    @Column(name = "DES_TIP_REFERENCIA")
    private String desTipReferencia;
    @Basic(optional = false)
    @NotNull(message="Ingrese el estado del Tipo de Referencia")
    @Column(name = "ACT_TIP_REFERENCIA")
    private Estado actTipReferencia;

    public CatTipoReferencia() {
    }

    public CatTipoReferencia(Integer codTipReferencia) {
        this.codTipReferencia = codTipReferencia;
    }

    public CatTipoReferencia(Integer codTipReferencia, String nomTipReferencia, Estado actTipReferencia) {
        this.codTipReferencia = codTipReferencia;
        this.nomTipReferencia = nomTipReferencia;
        this.actTipReferencia = actTipReferencia;
    }

    public Integer getCodTipReferencia() {
        return codTipReferencia;
    }

    public void setCodTipReferencia(Integer codTipReferencia) {
        this.codTipReferencia = codTipReferencia;
    }

    public String getNomTipReferencia() {
        return nomTipReferencia;
    }

    public void setNomTipReferencia(String nomTipReferencia) {
        this.nomTipReferencia = nomTipReferencia;
    }

    public String getDesTipReferencia() {
        return desTipReferencia;
    }

    public void setDesTipReferencia(String desTipReferencia) {
        this.desTipReferencia = desTipReferencia;
    }

    public Estado getActTipReferencia() {
        return actTipReferencia;
    }

    public void setActTipReferencia(Estado actTipReferencia) {
        this.actTipReferencia = actTipReferencia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipReferencia != null ? codTipReferencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatTipoReferencia)) {
            return false;
        }
        CatTipoReferencia other = (CatTipoReferencia) object;
        if ((this.codTipReferencia == null && other.codTipReferencia != null) || (this.codTipReferencia != null && !this.codTipReferencia.equals(other.codTipReferencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatTipoReferencia[ codTipReferencia=" + codTipReferencia + " ]";
    }
    
}
