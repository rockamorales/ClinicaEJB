/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sv.com.cormaria.servicios.entidades.consultasmedicas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import sv.com.cormaria.servicios.entidades.catalogos.CatExamenesMedicos;

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_detalle_orden_laboratorio")
@NamedQueries({
    @NamedQuery(name = "TblDetalleOrdenLaboratorio.findAll", query = "SELECT t FROM TblDetalleOrdenLaboratorio t"),
    @NamedQuery(name = "TblDetalleOrdenLaboratorio.findByNumOrdenLaboratorio", query = "SELECT t FROM TblDetalleOrdenLaboratorio t where t.tblDetalleOrdenLaboratorioPK.numOrdLaboratorio = :numOrdLaboratorio order by t.catExamenesMedicos.catCategoriaExamenes.nomExaCat, t.catExamenesMedicos.nomExaMedico")
})
public class TblDetalleOrdenLaboratorio implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblDetalleOrdenLaboratorioPK tblDetalleOrdenLaboratorioPK = new TblDetalleOrdenLaboratorioPK();
    @Basic
    @Column(name = "COR_DET_LABORATORIO")
    private int corDetLaboratorio;
    @Basic
    @Column(name = "OBS_DET_LABORATORIO")
    private String obsDetLaboratorio;
    @JoinColumn(name = "NUM_ORD_LABORATORIO", referencedColumnName = "NUM_ORD_LABORATORIO", insertable = false, updatable = false)
    @ManyToOne
    private TblOrdenLaboratorio tblOrdenLaboratorio;

    @JoinColumn(name = "COD_EXA_MEDICO", referencedColumnName = "COD_EXA_MEDICO", insertable = false, updatable = false)
    @ManyToOne
    private CatExamenesMedicos catExamenesMedicos;
    
    public TblDetalleOrdenLaboratorio() {
    }

    public TblDetalleOrdenLaboratorio(TblDetalleOrdenLaboratorioPK tblDetalleOrdenLaboratorioPK) {
        this.tblDetalleOrdenLaboratorioPK = tblDetalleOrdenLaboratorioPK;
    }

    public TblDetalleOrdenLaboratorio(TblDetalleOrdenLaboratorioPK tblDetalleOrdenLaboratorioPK, int corDetLaboratorio, String obsDetLaboratorio) {
        this.tblDetalleOrdenLaboratorioPK = tblDetalleOrdenLaboratorioPK;
        this.corDetLaboratorio = corDetLaboratorio;
        this.obsDetLaboratorio = obsDetLaboratorio;
    }

    public TblDetalleOrdenLaboratorio(int numOrdLaboratorio, int codExaMedico) {
        this.tblDetalleOrdenLaboratorioPK = new TblDetalleOrdenLaboratorioPK(numOrdLaboratorio, codExaMedico);
    }

    public TblDetalleOrdenLaboratorioPK getTblDetalleOrdenLaboratorioPK() {
        return tblDetalleOrdenLaboratorioPK;
    }

    public void setTblDetalleOrdenLaboratorioPK(TblDetalleOrdenLaboratorioPK tblDetalleOrdenLaboratorioPK) {
        this.tblDetalleOrdenLaboratorioPK = tblDetalleOrdenLaboratorioPK;
    }

    public CatExamenesMedicos getCatExamenesMedicos() {
        return catExamenesMedicos;
    }

    public void setCatExamenesMedicos(CatExamenesMedicos catExamenesMedicos) {
        this.catExamenesMedicos = catExamenesMedicos;
    }
    
    public int getCorDetLaboratorio() {
        return corDetLaboratorio;
    }

    public void setCorDetLaboratorio(int corDetLaboratorio) {
        this.corDetLaboratorio = corDetLaboratorio;
    }

    public String getObsDetLaboratorio() {
        return obsDetLaboratorio;
    }

    public void setObsDetLaboratorio(String obsDetLaboratorio) {
        this.obsDetLaboratorio = obsDetLaboratorio;
    }

    public TblOrdenLaboratorio getTblOrdenLaboratorio() {
        return tblOrdenLaboratorio;
    }

    public void setTblOrdenLaboratorio(TblOrdenLaboratorio tblOrdenLaboratorio) {
        this.tblOrdenLaboratorio = tblOrdenLaboratorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblDetalleOrdenLaboratorioPK != null ? tblDetalleOrdenLaboratorioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleOrdenLaboratorio)) {
            return false;
        }
        TblDetalleOrdenLaboratorio other = (TblDetalleOrdenLaboratorio) object;
        if ((this.tblDetalleOrdenLaboratorioPK == null && other.tblDetalleOrdenLaboratorioPK != null) || (this.tblDetalleOrdenLaboratorioPK != null && !this.tblDetalleOrdenLaboratorioPK.equals(other.tblDetalleOrdenLaboratorioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.consultasmedicas.TblDetalleOrdenLaboratorio[ tblDetalleOrdenLaboratorioPK=" + tblDetalleOrdenLaboratorioPK + " ]";
    }
    
}
