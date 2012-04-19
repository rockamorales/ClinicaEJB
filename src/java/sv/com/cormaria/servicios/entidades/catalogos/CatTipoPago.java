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
@Table(name = "cat_tipo_pago")
@NamedQueries({
    @NamedQuery(name = "CatTipoPago.findAll", query = "SELECT c FROM CatTipoPago c"),
    @NamedQuery(name = "CatTipoPago.findActive", query = "SELECT c FROM CatTipoPago c WHERE actTipPago = 1")
})
public class CatTipoPago implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "COD_TIP_PAGO")
    private Integer codTipPago;
    @Basic(optional = false)
    @NotNull(message="Ingrese el nombre del Tipo de Pago")
    @Size(min = 1, max = 8)
    @Column(name = "NOM_TIP_PAGO")
    private String nomTipPago;
    @Size(max = 100)
    @Column(name = "DES_TIP_PAGO")
    private String desTipPago;
    @Basic(optional = false)
    @NotNull(message="Ingrese el estado del Tipo de Pago")
    @Size(min = 1, max = 10)
    @Column(name = "ACT_TIP_PAGO")
    @Enumerated(EnumType.ORDINAL)
    private Estado actTipPago;

    public CatTipoPago() {
    }

    public CatTipoPago(Integer codTipPago) {
        this.codTipPago = codTipPago;
    }

    public CatTipoPago(Integer codTipPago, String nomTipPago, Estado actTipPago) {
        this.codTipPago = codTipPago;
        this.nomTipPago = nomTipPago;
        this.actTipPago = actTipPago;
    }

    public Integer getCodTipPago() {
        return codTipPago;
    }

    public void setCodTipPago(Integer codTipPago) {
        this.codTipPago = codTipPago;
    }

    public String getNomTipPago() {
        return nomTipPago;
    }

    public void setNomTipPago(String nomTipPago) {
        this.nomTipPago = nomTipPago;
    }

    public String getDesTipPago() {
        return desTipPago;
    }

    public void setDesTipPago(String desTipPago) {
        this.desTipPago = desTipPago;
    }

    public Estado getActTipPago() {
        return actTipPago;
    }

    public void setActTipPago(Estado actTipPago) {
        this.actTipPago = actTipPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipPago != null ? codTipPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatTipoPago)) {
            return false;
        }
        CatTipoPago other = (CatTipoPago) object;
        if ((this.codTipPago == null && other.codTipPago != null) || (this.codTipPago != null && !this.codTipPago.equals(other.codTipPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.catalogos.CatTipoPago[ codTipPago=" + codTipPago + " ]";
    }
    
}
