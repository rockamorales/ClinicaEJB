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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import sv.com.cormaria.servicios.entidades.administracion.TblProducto;
import sv.com.cormaria.servicios.enums.Estado;

/**
 *
 * @author Claudia
 */
@Entity
@Table(name = "cat_especialidad")
@NamedQueries({
    @NamedQuery(name = "CatEspecialidad.findAll", query = "SELECT c FROM CatEspecialidad c"),
    @NamedQuery(name = "CatEspecialidad.findActive", query = "SELECT c FROM CatEspecialidad c where c.actEspecialidad = 1")
})

public class CatEspecialidad implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_ESPECIALIDAD")
    private Integer codEspecialidad;

    @Basic(optional = false)
    @NotNull(message="Ingrese el nombre de la Especialidad")
    @Size(min = 1, max = 30)
    @Column(name = "NOM_ESPECIALIDAD")
    private String nomEspecialidad;

    @Size(max = 100)
    @Column(name = "DES_ESPECIALIDAD")
    private String desEspecialidad;

    @Basic(optional = false)
    @NotNull(message="Ingrese el estado de la Especialidad")
    @Column(name = "ACT_ESPECIALIDAD")
    private Estado actEspecialidad;

    @Basic(optional = false)
    @NotNull(message="Por favor especifique el servicio asociado a esta especialidad")
    @Column(name = "NUM_PRODUCTO")
    private Integer numProducto;

    @Basic(optional = false)
    @NotNull(message="Por favor especifique el servicio asociado a esta especialidad")
    @ManyToOne
    @JoinColumn(name = "NUM_PRODUCTO", referencedColumnName="NUM_PRODUCTO", insertable=false, updatable=false)
    private TblProducto tblProducto;

    public CatEspecialidad() {
    }

    public CatEspecialidad(Integer codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
    }

    public CatEspecialidad(Integer codEspecialidad, String nomEspecialidad, Estado actEspecialidad) {
        this.codEspecialidad = codEspecialidad;
        this.nomEspecialidad = nomEspecialidad;
        this.actEspecialidad = actEspecialidad;
    }    
    
    public Integer getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(Integer numProducto) {
        this.numProducto = numProducto;
    }

    public TblProducto getTblProducto() {
        return tblProducto;
    }

    public void setTblProducto(TblProducto tblProducto) {
        this.tblProducto = tblProducto;
    }
    
    public Integer getCodEspecialidad() {
        return codEspecialidad;
    }

    public void setCodEspecialidad(Integer codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
    }

    public String getNomEspecialidad() {
        return nomEspecialidad;
    }

    public void setNomEspecialidad(String nomEspecialidad) {
        this.nomEspecialidad = nomEspecialidad;
    }

    public String getDesEspecialidad() {
        return desEspecialidad;
    }

    public void setDesEspecialidad(String desEspecialidad) {
        this.desEspecialidad = desEspecialidad;
    }

    public Estado getActEspecialidad() {
        return actEspecialidad;
    }

    public void setActEspecialidad(Estado actEspecialidad) {
        this.actEspecialidad = actEspecialidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEspecialidad != null ? codEspecialidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatEspecialidad)) {
            return false;
        }
        CatEspecialidad other = (CatEspecialidad) object;
        if ((this.codEspecialidad == null && other.codEspecialidad != null) || (this.codEspecialidad != null && !this.codEspecialidad.equals(other.codEspecialidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatEspecialidad[ codEspecialidad=" + codEspecialidad + " ]";
    }
    
}
