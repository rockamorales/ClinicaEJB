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
@Table(name = "cat_consultorio")
@NamedQueries({
    @NamedQuery(name = "CatConsultorio.findAll", query = "SELECT c FROM CatConsultorio c")})
public class CatConsultorio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_CONSULTORIO")
    private Integer codConsultorio;
    @Column(name = "NOM_CONSULTORIO")
    private String nomConsultorio;
    @Column(name = "CON_GINECOLOGICO")
    private boolean conGinecologico;
    @Column(name = "DES_CONSULTORIO")
    private String desConsultorio;
    @Column(name = "ACT_CONSULTORIO")
    private Estado actConsultorio;

    public CatConsultorio() {
    }

    public CatConsultorio(Integer codConsultorio) {
        this.codConsultorio = codConsultorio;
    }

    public CatConsultorio(Integer codConsultorio, String nomConsultorio, boolean conGinecologico, Estado actConsultorio) {
        this.codConsultorio = codConsultorio;
        this.nomConsultorio = nomConsultorio;
        this.conGinecologico = conGinecologico;
        this.actConsultorio = actConsultorio;
    }

    public Integer getCodConsultorio() {
        return codConsultorio;
    }

    public void setCodConsultorio(Integer codConsultorio) {
        this.codConsultorio = codConsultorio;
    }

    public String getNomConsultorio() {
        return nomConsultorio;
    }

    public void setNomConsultorio(String nomConsultorio) {
        this.nomConsultorio = nomConsultorio;
    }

    public boolean getConGinecologico() {
        return conGinecologico;
    }

    public void setConGinecologico(boolean conGinecologico) {
        this.conGinecologico = conGinecologico;
    }

    public String getDesConsultorio() {
        return desConsultorio;
    }

    public void setDesConsultorio(String desConsultorio) {
        this.desConsultorio = desConsultorio;
    }

    public Estado getActConsultorio() {
        return actConsultorio;
    }

    public void setActConsultorio(Estado actConsultorio) {
        this.actConsultorio = actConsultorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codConsultorio != null ? codConsultorio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatConsultorio)) {
            return false;
        }
        CatConsultorio other = (CatConsultorio) object;
        if ((this.codConsultorio == null && other.codConsultorio != null) || (this.codConsultorio != null && !this.codConsultorio.equals(other.codConsultorio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatConsultorio[ codConsultorio=" + codConsultorio + " ]";
    }
    
}
