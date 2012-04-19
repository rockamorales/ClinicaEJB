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
@Table(name = "cat_examenes_medicos")
@NamedQueries({
    @NamedQuery(name = "CatExamenesMedicos.findAll", query = "SELECT c FROM CatExamenesMedicos c")})
public class CatExamenesMedicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_EXA_MEDICO")
    private Integer codExaMedico;
    @Basic(optional = false)
    @NotNull(message="Ingrese el nombre del Examen Médico")
    @Size(min = 1, max = 100)
    @Column(name = "NOM_EXA_MEDICO")
    private String nomExaMedico;
    @Size(max = 100)
    @Column(name = "DES_EXA_MEDICO")
    private String desExaMedico;
    @Basic(optional = false)
    @NotNull(message="Ingrese el estado del Examen Médico")
    @Column(name = "ACT_EXA_MEDICO")
    private Estado actExaMedico;

    public CatExamenesMedicos() {
    }

    public CatExamenesMedicos(Integer codExaMedico) {
        this.codExaMedico = codExaMedico;
    }

    public CatExamenesMedicos(Integer codExaMedico, String nomExaMedico, Estado actExaMedico) {
        this.codExaMedico = codExaMedico;
        this.nomExaMedico = nomExaMedico;
        this.actExaMedico = actExaMedico;
    }

    public Integer getCodExaMedico() {
        return codExaMedico;
    }

    public void setCodExaMedico(Integer codExaMedico) {
        this.codExaMedico = codExaMedico;
    }

    public String getNomExaMedico() {
        return nomExaMedico;
    }

    public void setNomExaMedico(String nomExaMedico) {
        this.nomExaMedico = nomExaMedico;
    }

    public String getDesExaMedico() {
        return desExaMedico;
    }

    public void setDesExaMedico(String desExaMedico) {
        this.desExaMedico = desExaMedico;
    }

    public Estado getActExaMedico() {
        return actExaMedico;
    }

    public void setActExaMedico(Estado actExaMedico) {
        this.actExaMedico = actExaMedico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codExaMedico != null ? codExaMedico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatExamenesMedicos)) {
            return false;
        }
        CatExamenesMedicos other = (CatExamenesMedicos) object;
        if ((this.codExaMedico == null && other.codExaMedico != null) || (this.codExaMedico != null && !this.codExaMedico.equals(other.codExaMedico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatExamenesMedicos[ codExaMedico=" + codExaMedico + " ]";
    }
    
}
