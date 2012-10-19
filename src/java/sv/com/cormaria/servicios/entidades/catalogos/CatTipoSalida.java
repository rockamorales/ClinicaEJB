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
@Table(name = "cat_tipo_salida")
@NamedQueries({
    @NamedQuery(name = "CatTipoSalida.findAll", query = "SELECT c FROM CatTipoSalida c")})
public class CatTipoSalida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_TIP_SALIDA")
    private Integer codTipSalida;
    @Column(name = "NOM_TIP_SALIDA")
    private String nomTipSalida;
    @Column(name = "DES_TIP_SALIDA")
    private String desTipSalida;
    @Column(name = "ACT_TIP_SALIDA")
    private Estado actTipSalida;

    public CatTipoSalida() {
    }

    public CatTipoSalida(Integer codTipSalida) {
        this.codTipSalida = codTipSalida;
    }

    public CatTipoSalida(Integer codTipSalida, String nomTipSalida, Estado actTipSalida) {
        this.codTipSalida = codTipSalida;
        this.nomTipSalida = nomTipSalida;
        this.actTipSalida = actTipSalida;
    }

    public Integer getCodTipSalida() {
        return codTipSalida;
    }

    public void setCodTipSalida(Integer codTipSalida) {
        this.codTipSalida = codTipSalida;
    }

    public String getNomTipSalida() {
        return nomTipSalida;
    }

    public void setNomTipSalida(String nomTipSalida) {
        this.nomTipSalida = nomTipSalida;
    }

    public String getDesTipSalida() {
        return desTipSalida;
    }

    public void setDesTipSalida(String desTipSalida) {
        this.desTipSalida = desTipSalida;
    }

    public Estado getActTipSalida() {
        return actTipSalida;
    }

    public void setActTipSalida(Estado actTipSalida) {
        this.actTipSalida = actTipSalida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipSalida != null ? codTipSalida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatTipoSalida)) {
            return false;
        }
        CatTipoSalida other = (CatTipoSalida) object;
        if ((this.codTipSalida == null && other.codTipSalida != null) || (this.codTipSalida != null && !this.codTipSalida.equals(other.codTipSalida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatTipoSalida[ codTipSalida=" + codTipSalida + " ]";
    }
    
}
