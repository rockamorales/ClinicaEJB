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
@Table(name = "cat_Ubicacion_fisica")
@NamedQueries({
    @NamedQuery(name = "CatUbicacionFisica.findAll", query = "SELECT c FROM CatUbicacionFisica c"),
    @NamedQuery(name = "CatUbicacionFisica.findActive", query = "SELECT c FROM CatUbicacionFisica c where actUbiFisica=1 ")
})
public class CatUbicacionFisica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_UBI_FISICA")
    private Integer codUbiFisica;
    @Basic(optional = false)
    @NotNull(message="Ingrese el Estado de la Ubicación Física")
    @Size(min = 1, max = 15)
    @Column(name = "EST_UBI_FISICA")
    private String estUbiFisica;
    @Basic(optional = false)
    @NotNull(message="Ingrese el Nivel de la Ubicación Física")
    @Column(name = "NIV_UBI_FISICA")
    private Integer nivUbiFisica;
    @Basic(optional = false)
    @NotNull(message="Ingrese el Año de la Ubicación Física")
    @Column(name = "ANI_UBI_FISICA")
    private Integer aniUbiFisica;
    @Size(max = 500)
    @Column(name = "OBS_UBI_FISICA")
    private String obsUbiFisica;
    @Basic(optional = false)
    @NotNull(message="Ingrese el Estado Activo/Inactivo de la Ubicación Física")
    @Column(name = "ACT_UBI_FISICA")
    private Estado actUbiFisica;

    public CatUbicacionFisica() {
    }

    public CatUbicacionFisica(Integer codUbiFisica) {
        this.codUbiFisica = codUbiFisica;
    }

    public CatUbicacionFisica(Integer codUbiFisica, String estUbiFisica, Integer nivUbiFisica, Integer aniUbiFisica, Estado actUbiFisica) {
        this.codUbiFisica = codUbiFisica;
        this.estUbiFisica = estUbiFisica;
        this.nivUbiFisica = nivUbiFisica;
        this.aniUbiFisica = aniUbiFisica;
        this.actUbiFisica = actUbiFisica;
    }

    public Integer getCodUbiFisica() {
        return codUbiFisica;
    }

    public void setCodUbiFisica(Integer codUbiFisica) {
        this.codUbiFisica = codUbiFisica;
    }

    public String getEstUbiFisica() {
        return estUbiFisica;
    }

    public void setEstUbiFisica(String estUbiFisica) {
        this.estUbiFisica = estUbiFisica;
    }

    public Integer getNivUbiFisica() {
        return nivUbiFisica;
    }

    public void setNivUbiFisica(Integer nivUbiFisica) {
        this.nivUbiFisica = nivUbiFisica;
    }

    public Integer getAniUbiFisica() {
        return aniUbiFisica;
    }

    public void setAniUbiFisica(Integer aniUbiFisica) {
        this.aniUbiFisica = aniUbiFisica;
    }

    public String getObsUbiFisica() {
        return obsUbiFisica;
    }

    public void setObsUbiFisica(String obsUbiFisica) {
        this.obsUbiFisica = obsUbiFisica;
    }

    public Estado getActUbiFisica() {
        return actUbiFisica;
    }

    public void setActUbiFisica(Estado actUbiFisica) {
        this.actUbiFisica = actUbiFisica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUbiFisica != null ? codUbiFisica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatUbicacionFisica)) {
            return false;
        }
        CatUbicacionFisica other = (CatUbicacionFisica) object;
        if ((this.codUbiFisica == null && other.codUbiFisica != null) || (this.codUbiFisica != null && !this.codUbiFisica.equals(other.codUbiFisica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatUbicacionFisica[ codUbiFisica=" + codUbiFisica + " ]";
    }
    
}
