/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.administracion;

import sv.com.cormaria.servicios.enums.CategoriasProducto;
import java.io.Serializable;
import java.util.Collection;
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
import sv.com.cormaria.servicios.enums.CategoriasProducto;
/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_producto")
@NamedQueries({
    @NamedQuery(name = "TblProducto.findAll", query = "SELECT t FROM TblProducto t"),
    @NamedQuery(name = "TblProdcuto.findByNombreProducto", query = "SELECT t FROM TblProducto t WHERE t.nomProducto LIKE :nomProducto"),
    @NamedQuery(name = "TblProducto.findActive", query = "SELECT t FROM TblProducto t WHERE t.estProducto = 1"),
    @NamedQuery(name = "TblProducto.findMedicamentos", query = "SELECT t FROM TblProducto t WHERE t.estProducto = 1 and t.codTipProducto = 1"),
    @NamedQuery(name = "TblProducto.findActiveServices", query = "SELECT t FROM TblProducto t WHERE t.estProducto = 1 and t.catProducto = 1"),
    @NamedQuery(name = "TblProducto.findTarjetaControl", query = "SELECT t FROM TblProducto t WHERE t.estProducto = 1 and t.catProducto = 2")
})
public class TblProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_PRODUCTO")
    private Integer numProducto;
    @Basic(optional = false)
    @NotNull(message = "Introduzca el nombre del producto")
    @Size(min = 1, max = 100, message = "El nombre del producto no debe ser mayor de 100 caracteres")
    @Column(name = "NOM_PRODUCTO")
    private String nomProducto;
    @Size(max = 100, message = "El nombre generico del producto no debe ser mayor de 100 caracteres")
    @Column(name = "NOM_GEN_PRODUCTO")
    private String nomGenProducto;
    @Size(max = 100, message = "La clasificacion del producto no deber ser mayor de 100 caracteres")
    @Column(name = "CLA_PRODUCTO")
    private String claProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese la presentacion del producto")
    @Size(min = 1, max = 50, message = "La presentacion no debe ser mayor de 50 caracteres")
    @Column(name = "PRE_PRODUCTO")
    private String preProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese si el producto es perecedero")
    @Column(name = "PER_PRODUCTO")
    private boolean perProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el contenido del producto")
    @Size(min = 1, max = 250, message = "El contenido del producto no debe ser mayor de 250 caracteres")
    @Column(name = "CON_PRODUCTO")
    private String conProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el fabricante del producto")
    @Size(min = 1, max = 100, message = "El nombre del fabricante no debe ser mayor de 100 caracteres")
    @Column(name = "FAB_PRODUCTO")
    private String fabProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el distribuidor del producto")
    @Size(min = 1, max = 100, message = "El nombre del distribuidor no debe ser mayor de 100 caracteres")
    @Column(name = "DIS_PRODUCTO")
    private String disProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese las existencias del producto")
    @Column(name = "EXI_PRODUCTO")
    private int exiProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese las existencias minimas del producto")
    @Column(name = "EXI_MIN_PRODUCTO")
    private int exiMinProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese si el producto esta en reserva")
    @Column(name = "RES_PRODUCTO")
    private int resProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese si el producto es de tipo contribuible")
    @Column(name = "TIP_CON_PRODUCTO")
    private boolean tipConProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el valor del producto")
    @Column(name = "VAL_PRODUCTO")
    private float valProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el precio final(venta) del producto")
    @Column(name = "PRE_FIN_PRODUCTO")
    private float preFinProducto;
    @Size(max = 500, message = "La descripción del producto no debe ser mayor de 500 careacteres")
    @Column(name = "DES_PRODUCTO")
    private String desProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el estado del producto")
    @Column(name = "EST_PRODUCTO")
    private int estProducto;
    
    @Basic(optional=false)
    @NotNull(message="Por especifique la categoria para el producto")
    @Column(name="CAT_PRODUCTO")
    @Enumerated(EnumType.ORDINAL)
    private CategoriasProducto catProducto;

    @Column(name="COD_TIP_PRODUCTO")
    private Integer codTipProducto;
    
    public TblProducto() {
    }

    public TblProducto(Integer numProducto) {
        this.numProducto = numProducto;
    }

    public TblProducto(Integer numProducto, String nomProducto, String preProducto, boolean perProducto, String conProducto, String fabProducto, String disProducto, int exiProducto, int exiMinProducto, int resProducto, boolean tipConProducto, float valProducto, float preFinProducto, int estProducto) {
        this.numProducto = numProducto;
        this.nomProducto = nomProducto;
        this.preProducto = preProducto;
        this.perProducto = perProducto;
        this.conProducto = conProducto;
        this.fabProducto = fabProducto;
        this.disProducto = disProducto;
        this.exiProducto = exiProducto;
        this.exiMinProducto = exiMinProducto;
        this.resProducto = resProducto;
        this.tipConProducto = tipConProducto;
        this.valProducto = valProducto;
        this.preFinProducto = preFinProducto;
        this.estProducto = estProducto;
    }

    public CategoriasProducto getCatProducto() {
        return catProducto;
    }

    public void setCatProducto(CategoriasProducto catProducto) {
        this.catProducto = catProducto;
    }

    public Integer getCodTipProducto() {
        return codTipProducto;
    }

    public void setCodTipProducto(Integer codTipProducto) {
        this.codTipProducto = codTipProducto;
    }

    public Integer getNumProducto() {
        return numProducto;
    }

    public void setNumProducto(Integer numProducto) {
        this.numProducto = numProducto;
    }

    public String getNomProducto() {
        return nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    public String getNomGenProducto() {
        return nomGenProducto;
    }

    public void setNomGenProducto(String nomGenProducto) {
        this.nomGenProducto = nomGenProducto;
    }

    public String getClaProducto() {
        return claProducto;
    }

    public void setClaProducto(String claProducto) {
        this.claProducto = claProducto;
    }

    public String getPreProducto() {
        return preProducto;
    }

    public void setPreProducto(String preProducto) {
        this.preProducto = preProducto;
    }

    public boolean getPerProducto() {
        return perProducto;
    }

    public void setPerProducto(boolean perProducto) {
        this.perProducto = perProducto;
    }

    public String getConProducto() {
        return conProducto;
    }

    public void setConProducto(String conProducto) {
        this.conProducto = conProducto;
    }

    public String getFabProducto() {
        return fabProducto;
    }

    public void setFabProducto(String fabProducto) {
        this.fabProducto = fabProducto;
    }

    public String getDisProducto() {
        return disProducto;
    }

    public void setDisProducto(String disProducto) {
        this.disProducto = disProducto;
    }

    public int getExiProducto() {
        return exiProducto;
    }

    public void setExiProducto(int exiProducto) {
        this.exiProducto = exiProducto;
    }

    public int getExiMinProducto() {
        return exiMinProducto;
    }

    public void setExiMinProducto(int exiMinProducto) {
        this.exiMinProducto = exiMinProducto;
    }

    public int getResProducto() {
        return resProducto;
    }

    public void setResProducto(int resProducto) {
        this.resProducto = resProducto;
    }

    public boolean getTipConProducto() {
        return tipConProducto;
    }

    public void setTipConProducto(boolean tipConProducto) {
        this.tipConProducto = tipConProducto;
    }

    public float getValProducto() {
        return valProducto;
    }

    public void setValProducto(float valProducto) {
        this.valProducto = valProducto;
    }

    public float getPreFinProducto() {
        return preFinProducto;
    }

    public void setPreFinProducto(float preFinProducto) {
        this.preFinProducto = preFinProducto;
    }

    public String getDesProducto() {
        return desProducto;
    }

    public void setDesProducto(String desProducto) {
        this.desProducto = desProducto;
    }

    public int getEstProducto() {
        return estProducto;
    }

    public void setEstProducto(int estProducto) {
        this.estProducto = estProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numProducto != null ? numProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblProducto)) {
            return false;
        }
        TblProducto other = (TblProducto) object;
        if ((this.numProducto == null && other.numProducto != null) || (this.numProducto != null && !this.numProducto.equals(other.numProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.farmacia.TblProducto[ numProducto=" + numProducto + " ]";
    }
    
}
