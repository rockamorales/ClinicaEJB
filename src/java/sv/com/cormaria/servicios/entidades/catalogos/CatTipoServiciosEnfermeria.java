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
@Table(name = "cat_tipo_servicios_enfermeria")
@NamedQueries({
    @NamedQuery(name = "CatTipoServiciosEnfermeria.findAll", query = "SELECT c FROM CatTipoServiciosEnfermeria c")})
public class CatTipoServiciosEnfermeria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_SER_ENFERMERIA")
    private Integer codSerEnfermeria;
    @Column(name = "NOM_SER_ENFERMERIA")
    private String nomSerEnfermeria;
    @Column(name = "DES_SER_ENFERMERIA")
    private String desSerEnfermeria;
    @Column(name = "ACT_SER_ENFERMERIA")
    private Estado actSerEnfermeria;

    @Column(name = "NUM_PRODUCTO")
    private Integer numProducto;
    
    @ManyToOne
    @JoinColumn(name="NUM_PRODUCTO", referencedColumnName="NUM_PRODUCTO", insertable=false, updatable=false)
    private TblProducto producto;

    public CatTipoServiciosEnfermeria() {
    }

    public CatTipoServiciosEnfermeria(Integer codSerEnfermeria) {
        this.codSerEnfermeria = codSerEnfermeria;
    }

    public CatTipoServiciosEnfermeria(Integer codSerEnfermeria, String nomSerEnfermeria, Estado actSerEnfermeria) {
        this.codSerEnfermeria = codSerEnfermeria;
        this.nomSerEnfermeria = nomSerEnfermeria;
        this.actSerEnfermeria = actSerEnfermeria;
    }

    public Integer getCodSerEnfermeria() {
        return codSerEnfermeria;
    }

    public void setCodSerEnfermeria(Integer codSerEnfermeria) {
        this.codSerEnfermeria = codSerEnfermeria;
    }

    public Integer getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(Integer numProducto) {
        this.numProducto = numProducto;
    }

    public TblProducto getProducto() {
        return producto;
    }

    public void setProducto(TblProducto producto) {
        this.producto = producto;
    }

    public String getNomSerEnfermeria() {
        return nomSerEnfermeria;
    }

    public void setNomSerEnfermeria(String nomSerEnfermeria) {
        this.nomSerEnfermeria = nomSerEnfermeria;
    }

    public String getDesSerEnfermeria() {
        return desSerEnfermeria;
    }

    public void setDesSerEnfermeria(String desSerEnfermeria) {
        this.desSerEnfermeria = desSerEnfermeria;
    }

    public Estado getActSerEnfermeria() {
        return actSerEnfermeria;
    }

    public void setActSerEnfermeria(Estado actSerEnfermeria) {
        this.actSerEnfermeria = actSerEnfermeria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSerEnfermeria != null ? codSerEnfermeria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatTipoServiciosEnfermeria)) {
            return false;
        }
        CatTipoServiciosEnfermeria other = (CatTipoServiciosEnfermeria) object;
        if ((this.codSerEnfermeria == null && other.codSerEnfermeria != null) || (this.codSerEnfermeria != null && !this.codSerEnfermeria.equals(other.codSerEnfermeria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatTipoServiciosEnfermeria[ codSerEnfermeria=" + codSerEnfermeria + " ]";
    }
    
}
