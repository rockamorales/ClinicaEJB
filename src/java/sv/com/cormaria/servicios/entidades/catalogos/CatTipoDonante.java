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
@Table(name = "cat_tipo_donante")
@NamedQueries({
    @NamedQuery(name = "CatTipoDonante.findAll", query = "SELECT c FROM CatTipoDonante c"),
    @NamedQuery(name = "CatTipoDonante.findActive", query = "SELECT c FROM CatTipoDonante c WHERE c.actTipDonante = 1")

})
public class CatTipoDonante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_TIP_DONANTE")
    private Integer codTipDonante;
    @Column(name = "NOM_TIP_DONANTE")
    private String nomTipDonante;
    @Column(name = "DES_TIP_DONANTE")
    private String desTipDonante;
    @Column(name = "ACT_TIP_DONANTE")
    private Estado actTipDonante;

    public CatTipoDonante() {
    }

    public CatTipoDonante(Integer codTipDonante) {
        this.codTipDonante = codTipDonante;
    }

    public CatTipoDonante(Integer codTipDonante, String nomTipDonante, Estado actTipDonante) {
        this.codTipDonante = codTipDonante;
        this.nomTipDonante = nomTipDonante;
        this.actTipDonante = actTipDonante;
    }

    public Integer getCodTipDonante() {
        return codTipDonante;
    }

    public void setCodTipDonante(Integer codTipDonante) {
        this.codTipDonante = codTipDonante;
    }

    public String getNomTipDonante() {
        return nomTipDonante;
    }

    public void setNomTipDonante(String nomTipDonante) {
        this.nomTipDonante = nomTipDonante;
    }

    public String getDesTipDonante() {
        return desTipDonante;
    }

    public void setDesTipDonante(String desTipDonante) {
        this.desTipDonante = desTipDonante;
    }

    public Estado getActTipDonante() {
        return actTipDonante;
    }

    public void setActTipDonante(Estado actTipDonante) {
        this.actTipDonante = actTipDonante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipDonante != null ? codTipDonante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatTipoDonante)) {
            return false;
        }
        CatTipoDonante other = (CatTipoDonante) object;
        if ((this.codTipDonante == null && other.codTipDonante != null) || (this.codTipDonante != null && !this.codTipDonante.equals(other.codTipDonante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatTipoDonante[ codTipDonante=" + codTipDonante + " ]";
    }
    
}
