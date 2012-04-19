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
 * 
 */
@Entity
@Table(name = "cat_sexo")
@NamedQueries({
    @NamedQuery(name = "CatSexo.findAll", query = "SELECT c FROM CatSexo c"),
    @NamedQuery(name = "CatSexo.findActive", query = "SELECT c FROM CatSexo c where actSexPaciente=1 ")
})
public class CatSexo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_SEX_PACIENTE")
    private Integer codSexPaciente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "NOM_SEX_PACIENTE")
    private String nomSexPaciente;
    @Size(max = 40)
    @Column(name = "DES_SEX_PACIENTE")
    private String desSexPaciente;
    @Basic(optional = false)
    @NotNull(message="Ingrese el estado de Sexo")
    @Column(name = "ACT_SEX_PACIENTE")
    private Estado actSexPaciente;

    public CatSexo() {
    }

    public CatSexo(Integer codSexPaciente) {
        this.codSexPaciente = codSexPaciente;
    }

    public CatSexo(Integer codSexPaciente, String nomSexPaciente, Estado actSexPaciente) {
        this.codSexPaciente = codSexPaciente;
        this.nomSexPaciente = nomSexPaciente;
        this.actSexPaciente = actSexPaciente;
    }

    public Integer getCodSexPaciente() {
        return codSexPaciente;
    }

    public void setCodSexPaciente(Integer codSexPaciente) {
        this.codSexPaciente = codSexPaciente;
    }

    public String getNomSexPaciente() {
        return nomSexPaciente;
    }

    public void setNomSexPaciente(String nomSexPaciente) {
        this.nomSexPaciente = nomSexPaciente;
    }

    public String getDesSexPaciente() {
        return desSexPaciente;
    }

    public void setDesSexPaciente(String desSexPaciente) {
        this.desSexPaciente = desSexPaciente;
    }

    public Estado getActSexPaciente() {
        return actSexPaciente;
    }

    public void setActSexPaciente(Estado actSexPaciente) {
        this.actSexPaciente = actSexPaciente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSexPaciente != null ? codSexPaciente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatSexo)) {
            return false;
        }
        CatSexo other = (CatSexo) object;
        if ((this.codSexPaciente == null && other.codSexPaciente != null) || (this.codSexPaciente != null && !this.codSexPaciente.equals(other.codSexPaciente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatSexo[ codSexPaciente=" + codSexPaciente + " ]";
    }
    
}
