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
@Table(name = "cat_areas")
@NamedQueries({
    @NamedQuery(name = "CatAreas.findAll", query = "SELECT c FROM CatAreas c"),
    @NamedQuery(name = "CatAreas.findActive", query = "SELECT c FROM CatAreas c where actArea=1 ")
   })    
public class CatAreas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_AREA")
    private Integer codArea;
    @Column(name = "NOM_AREA")
    private String nomArea;
    @Column(name = "DES_AREA")
    private String desArea;
    @Column(name = "ACT_AREA")
    @Enumerated(EnumType.ORDINAL)
    private Estado actArea;

    public CatAreas() {
    }

    public CatAreas(Integer codArea) {
        this.codArea = codArea;
    }

    public CatAreas(Integer codArea, String nomArea, Estado actArea) {
        this.codArea = codArea;
        this.nomArea = nomArea;
        this.actArea = actArea;
    }

    public Integer getCodArea() {
        return codArea;
    }

    public void setCodArea(Integer codArea) {
        this.codArea = codArea;
    }

    public String getNomArea() {
        return nomArea;
    }

    public void setNomArea(String nomArea) {
        this.nomArea = nomArea;
    }

    public String getDesArea() {
        return desArea;
    }

    public void setDesArea(String desArea) {
        this.desArea = desArea;
    }

    public Estado getActArea() {
        return actArea;
    }

    public void setActArea(Estado actArea) {
        this.actArea = actArea;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codArea != null ? codArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatAreas)) {
            return false;
        }
        CatAreas other = (CatAreas) object;
        if ((this.codArea == null && other.codArea != null) || (this.codArea != null && !this.codArea.equals(other.codArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatAreas[ codArea=" + codArea + " ]";
    }
    
}
