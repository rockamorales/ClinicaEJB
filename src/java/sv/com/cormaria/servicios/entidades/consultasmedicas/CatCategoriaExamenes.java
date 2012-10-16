/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.consultasmedicas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.OrderBy;
import org.hibernate.annotations.WhereJoinTable;
import sv.com.cormaria.servicios.entidades.catalogos.CatExamenesMedicos;

/**
 *
 * @author romorales
 */
@Entity
@Table(name = "cat_categoria_examenes")
@NamedQueries({
           @NamedQuery(name = "CatCategoriaExamenes.findAll", query = "SELECT c FROM CatCategoriaExamenes c order by c.nomExaCat")
      })
public class CatCategoriaExamenes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic
    @Column(name = "COD_EXA_CAT")
    private Integer codExaCat;
    @Column(name = "NOM_EXA_CAT")
    private String nomExaCat;
    
    @OneToMany(mappedBy="catCategoriaExamenes",fetch= FetchType.EAGER)
    @OrderBy(clause="NOM_EXA_MEDICO")
    private Collection<CatExamenesMedicos> catExamenesMedicos;

    public CatCategoriaExamenes() {
    }

    public CatCategoriaExamenes(Integer codExaCat) {
        this.codExaCat = codExaCat;
    }

    public Collection<CatExamenesMedicos> getCatExamenesMedicos() {
        return catExamenesMedicos;
    }

    public void setCatExamenesMedicos(Collection<CatExamenesMedicos> catExamenesMedicos) {
        this.catExamenesMedicos = catExamenesMedicos;
    }
    
    public Integer getCodExaCat() {
        return codExaCat;
    }

    public void setCodExaCat(Integer codExaCat) {
        this.codExaCat = codExaCat;
    }

    public String getNomExaCat() {
        return nomExaCat;
    }

    public void setNomExaCat(String nomExaCat) {
        this.nomExaCat = nomExaCat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codExaCat != null ? codExaCat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatCategoriaExamenes)) {
            return false;
        }
        CatCategoriaExamenes other = (CatCategoriaExamenes) object;
        if ((this.codExaCat == null && other.codExaCat != null) || (this.codExaCat != null && !this.codExaCat.equals(other.codExaCat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.consultasmedicas.CatCategoriaExamenes[ codExaCat=" + codExaCat + " ]";
    }   
}