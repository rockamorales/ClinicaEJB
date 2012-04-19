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
@Table(name = "cat_tipo_consulta")
@NamedQueries({
    @NamedQuery(name = "CatTipoConsulta.findAll", query = "SELECT c FROM CatTipoConsulta c"),
    @NamedQuery(name = "CatTipoConsulta.findActive", query = "SELECT c FROM CatTipoConsulta c where c.actTipConsulta = 1")
})
public class CatTipoConsulta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_TIP_CONSULTA")
    private Integer codTipConsulta;
    @Basic(optional = false)
    @NotNull(message="Ingrese el nombre del Tipo de Consulta")
    @Size(min = 1, max = 50)
    @Column(name = "NOM_TIP_CONSULTA")
    private String nomTipConsulta;
    @Size(max = 100)
    @Column(name = "DES_TIP_CONSULTA")
    private String desTipConsulta;
    @Basic(optional = false)
    @NotNull(message="Ingrese el estado del Tipo de Consulta")
    @Column(name = "ACT_TIP_CONSULTA")
    private Estado actTipConsulta;

    public CatTipoConsulta() {
    }

    public CatTipoConsulta(Integer codTipConsulta) {
        this.codTipConsulta = codTipConsulta;
    }

    public CatTipoConsulta(Integer codTipConsulta, String nomTipConsulta, Estado actTipConsulta) {
        this.codTipConsulta = codTipConsulta;
        this.nomTipConsulta = nomTipConsulta;
        this.actTipConsulta = actTipConsulta;
    }

    public Integer getCodTipConsulta() {
        return codTipConsulta;
    }

    public void setCodTipConsulta(Integer codTipConsulta) {
        this.codTipConsulta = codTipConsulta;
    }

    public String getNomTipConsulta() {
        return nomTipConsulta;
    }

    public void setNomTipConsulta(String nomTipConsulta) {
        this.nomTipConsulta = nomTipConsulta;
    }

    public String getDesTipConsulta() {
        return desTipConsulta;
    }

    public void setDesTipConsulta(String desTipConsulta) {
        this.desTipConsulta = desTipConsulta;
    }

    public Estado getActTipConsulta() {
        return actTipConsulta;
    }

    public void setActTipConsulta(Estado actTipConsulta) {
        this.actTipConsulta = actTipConsulta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipConsulta != null ? codTipConsulta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatTipoConsulta)) {
            return false;
        }
        CatTipoConsulta other = (CatTipoConsulta) object;
        if ((this.codTipConsulta == null && other.codTipConsulta != null) || (this.codTipConsulta != null && !this.codTipConsulta.equals(other.codTipConsulta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatTipoConsulta[ codTipConsulta=" + codTipConsulta + " ]";
    }
    
}
