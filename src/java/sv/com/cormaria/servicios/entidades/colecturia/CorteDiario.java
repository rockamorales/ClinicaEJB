/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.entidades.colecturia;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import sv.com.cormaria.servicios.entidades.catalogos.CatBancos;
import sv.com.cormaria.servicios.entidades.catalogos.CatTipoPago;

/**
 *
 * @author romorales
 */
@NamedQueries({
    @NamedQuery(name="CorteDiario.findByDate", query="Select new sv.com.cormaria.servicios.entidades.colecturia.CorteDiario(max(t.numComDonacion), t.fecComDonacion, t.codTipPago, sum(t.totDonacion), t.catTipoPago) from TblComprobanteDonacion t where t.fecComDonacion = :fecComDonacion and t.estComDonacion in (1) group by t.fecComDonacion, t.codTipPago, t.catTipoPago"),
    @NamedQuery(name="CorteDiario.findByDateGroupByCodTipPagoAndCodBanco", query="Select new sv.com.cormaria.servicios.entidades.colecturia.CorteDiario(max(t.numComDonacion), t.fecComDonacion, t.codTipPago, sum(t.totDonacion), t.catTipoPago, t.codBanco, b) from TblComprobanteDonacion t left outer join t.catBanco b where t.fecComDonacion = :fecComDonacion and t.estComDonacion in (1) group by t.fecComDonacion, t.codTipPago, t.catTipoPago, t.codBanco, t.catBanco")
})

@Entity
public class CorteDiario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private int correlativo;
    @Temporal(TemporalType.DATE)
    private Date fecCorte;
    private Integer codTipPago;

    private Integer codBanco;

    private Double total;
    
    @ManyToOne
    private CatTipoPago catTipPago;

    @ManyToOne
    private CatBancos catBanco;

    public CorteDiario() {
    }
    
    public CorteDiario(Integer correlativo, Date fecCorte, Integer codTipPago, Double total, CatTipoPago catTipPago) {
        this.correlativo = correlativo;
        this.fecCorte = fecCorte;
        this.codTipPago = codTipPago;
        this.total = total!=null?total.doubleValue():0;
        this.catTipPago = catTipPago;
    }
    public CorteDiario(Integer correlativo, Date fecCorte, Integer codTipPago, Double total, CatTipoPago catTipPago, Integer codBanco, CatBancos catBanco){
        this.correlativo = correlativo;
        this.fecCorte = fecCorte;
        this.codTipPago = codTipPago;
        this.total = total!=null?total:0;
        this.catTipPago = catTipPago;
        if (codTipPago == 1){
            this.codBanco = 1;
        }else{
            this.codBanco = codBanco;
        }
            this.catBanco = catBanco;
    }
    
    public Date getFecCorte() {
        return fecCorte;
    }

    public void setFecCorte(Date fecCorte) {
        this.fecCorte = fecCorte;
    }

    public Integer getCodTipPago() {
        return codTipPago;
    }

    public void setCodTipPago(Integer codTipPago) {
        this.codTipPago = codTipPago;
    }

    public CatTipoPago getCatTipPago() {
        return catTipPago;
    }

    public void setCatTipPago(CatTipoPago catTipPago) {
        this.catTipPago = catTipPago;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Integer getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(Integer codBanco) {
        this.codBanco = codBanco;
    }

    public CatBancos getCatBanco() {
        return catBanco;
    }

    public void setCatBanco(CatBancos catBanco) {
        this.catBanco = catBanco;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.correlativo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CorteDiario other = (CorteDiario) obj;
        if (this.correlativo != other.correlativo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.colecturia.CorteDiario[ fecCorte=" + fecCorte + ", codTipPago="+codTipPago+" ]";
    }
}
