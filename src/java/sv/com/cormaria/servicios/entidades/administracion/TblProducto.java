/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.administracion;


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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import sv.com.cormaria.servicios.entidades.catalogos.CatCategoriaProducto;
import sv.com.cormaria.servicios.entidades.catalogos.CatClasificacionProducto;
import sv.com.cormaria.servicios.entidades.catalogos.CatPresentacionProducto;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoProducto;
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
    @NamedQuery(name = "TblProducto.findMedicamentos", query = "SELECT t FROM TblProducto t WHERE t.estProducto = 1 and t.codTipProducto = 1 "),
    @NamedQuery(name = "TblProducto.findActiveServices", query = "SELECT t FROM TblProducto t WHERE t.estProducto = 1 and t.codCatProducto = 1 "),
    @NamedQuery(name = "TblProducto.findTarjetaControl", query = "SELECT t FROM TblProducto t WHERE t.estProducto = 1 and t.codTipProducto = 5"),
    @NamedQuery(name = "TblProducto.findProductoAlquiler", query = "SELECT t FROM TblProducto t WHERE t.estProducto = 1 and t.codTipProducto = 3"),
    @NamedQuery(name = "TblProducto.findAlertas", query = "SELECT t FROM TblProducto t WHERE t.estProducto = 1 and t.exiMinProducto > t.exiProducto and not exists (select h.canProducto from TblHistorialAlerta h where t.numProducto=h.numProducto and fec_hor_alerta = :fecha) and not exists (Select h.canProducto from TblHistorialAlerta h where t.numProducto=h.numProducto and h.estAlerta=1)")
})
public class TblProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NUM_PRODUCTO")
    private Integer numProducto;
    @Column(name = "NOM_PRODUCTO")
    private String nomProducto;
    @Column(name = "NOM_GEN_PRODUCTO")
    private String nomGenProducto;
    @Column(name = "COD_CLA_PRODUCTO")
    private Integer codClaProducto;
    @Column(name = "COD_PRE_PRODUCTO")
    private Integer codPreProducto;
    @Column(name = "PER_PRODUCTO")
    private boolean perProducto;
    @Column(name = "CON_PRODUCTO")
    private String conProducto;
    @Column(name = "FAB_PRODUCTO")
    private String fabProducto;
    @Column(name = "DIS_PRODUCTO")
    private String disProducto;
    @Column(name = "EXI_PRODUCTO")
    private int exiProducto;
    @Column(name = "EXI_MIN_PRODUCTO")
    private int exiMinProducto;
    @Column(name = "RES_PRODUCTO")
    private int resProducto;
    @Column(name = "TIP_CON_PRODUCTO")
    private boolean tipConProducto;
    @Column(name = "VAL_PRODUCTO")
    private float valProducto;
    @Column(name = "PRE_FIN_PRODUCTO")
    private float preFinProducto;
    @Column(name = "DES_PRODUCTO")
    private String desProducto;
    @Basic(optional = false)
    @NotNull(message = "Ingrese el estado del producto")
    @Column(name = "EST_PRODUCTO")
    private int estProducto;
    
    @Basic(optional=false)
    @NotNull(message="Por especifique la categoria para el producto")
    @Column(name="COD_CAT_PRODUCTO")
    private Integer codCatProducto;

    @Column(name="COD_TIP_PRODUCTO")
    private Integer codTipProducto;

    @ManyToOne
    @JoinColumn(name="COD_TIP_PRODUCTO", referencedColumnName="COD_TIP_PRODUCTO", insertable=false, updatable=false)
    private CatTipoProducto catTipoProducto;
    
    @ManyToOne
    @JoinColumn(name="COD_CAT_PRODUCTO", referencedColumnName="COD_CAT_PRODUCTO", insertable=false, updatable=false)
    private CatCategoriaProducto catCategoriaProducto;
    
    @ManyToOne
    @JoinColumn(name="COD_CLA_PRODUCTO", referencedColumnName="COD_CLA_PRODUCTO", insertable=false, updatable=false)
    private CatClasificacionProducto catClasificacionProducto;
    @ManyToOne
    @JoinColumn(name="COD_PRE_PRODUCTO", referencedColumnName="COD_PRE_PRODUCTO", insertable=false, updatable=false)
    private CatPresentacionProducto catPresentacionProducto;
    
    
    public TblProducto() {
    }

    public TblProducto(Integer numProducto) {
        this.numProducto = numProducto;
    }

    public Integer getCodClaProducto() {
        return codClaProducto;
    }

    public void setCodClaProducto(Integer codClaProducto) {
        this.codClaProducto = codClaProducto;
    }

    public Integer getCodCatProducto() {
        return codCatProducto;
    }

    public Integer getCodPreProducto() {
        return codPreProducto;
    }

    public void setCodPreProducto(Integer codPreProducto) {
        this.codPreProducto = codPreProducto;
    }
    

    public void setCodCatProducto(Integer codCatProducto) {
        this.codCatProducto = codCatProducto;
    }

    public CatCategoriaProducto getCatCategoriaProducto() {
        return catCategoriaProducto;
    }

    public void setCatCategoriaProducto(CatCategoriaProducto catCategoriaProducto) {
        this.catCategoriaProducto = catCategoriaProducto;
    }

    public CatClasificacionProducto getCatClasificacionProducto() {
        return catClasificacionProducto;
    }

    public CatTipoProducto getCatTipoProducto() {
        return catTipoProducto;
    }

    public void setCatTipoProducto(CatTipoProducto catTipoProducto) {
        this.catTipoProducto = catTipoProducto;
    }

    public void setCatClasificacionProducto(CatClasificacionProducto catClasificacionProducto) {
        this.catClasificacionProducto = catClasificacionProducto;
    }

    public CatPresentacionProducto getCatPresentacionProducto() {
        return catPresentacionProducto;
    }

    public void setCatPresentacionProducto(CatPresentacionProducto catPresentacionProducto) {
        this.catPresentacionProducto = catPresentacionProducto;
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
