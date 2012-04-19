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

/**
 *
 * @author Mackk
 */
@Entity
@Table(name = "tbl_detalle_receta")
@NamedQueries({
    @NamedQuery(name = "TblDetalleReceta.findAll", query = "SELECT t FROM TblDetalleReceta t")})
public class TblDetalleReceta implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TblDetalleRecetaPK tblDetalleRecetaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "COR_DET_RECETA")
    private int corDetReceta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CAN_DET_RECETA")
    private short canDetReceta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DOS_DET_RECETA")
    private String dosDetReceta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FRE_DET_RECETA")
    private String freDetReceta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "DUR_TRATAMIENTO")
    private String durTratamiento;
    @JoinColumn(name = "NUM_RECETA", referencedColumnName = "NUM_RECETA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TblRecetaMedica tblRecetaMedica;

    public TblDetalleReceta() {
    }

    public TblDetalleReceta(TblDetalleRecetaPK tblDetalleRecetaPK) {
        this.tblDetalleRecetaPK = tblDetalleRecetaPK;
    }

    public TblDetalleReceta(TblDetalleRecetaPK tblDetalleRecetaPK, int corDetReceta, short canDetReceta, String dosDetReceta, String freDetReceta, String durTratamiento) {
        this.tblDetalleRecetaPK = tblDetalleRecetaPK;
        this.corDetReceta = corDetReceta;
        this.canDetReceta = canDetReceta;
        this.dosDetReceta = dosDetReceta;
        this.freDetReceta = freDetReceta;
        this.durTratamiento = durTratamiento;
    }

    public TblDetalleReceta(int numReceta, int numProducto) {
        this.tblDetalleRecetaPK = new TblDetalleRecetaPK(numReceta, numProducto);
    }

    public TblDetalleRecetaPK getTblDetalleRecetaPK() {
        return tblDetalleRecetaPK;
    }

    public void setTblDetalleRecetaPK(TblDetalleRecetaPK tblDetalleRecetaPK) {
        this.tblDetalleRecetaPK = tblDetalleRecetaPK;
    }

    public int getCorDetReceta() {
        return corDetReceta;
    }

    public void setCorDetReceta(int corDetReceta) {
        this.corDetReceta = corDetReceta;
    }

    public short getCanDetReceta() {
        return canDetReceta;
    }

    public void setCanDetReceta(short canDetReceta) {
        this.canDetReceta = canDetReceta;
    }

    public String getDosDetReceta() {
        return dosDetReceta;
    }

    public void setDosDetReceta(String dosDetReceta) {
        this.dosDetReceta = dosDetReceta;
    }

    public String getFreDetReceta() {
        return freDetReceta;
    }

    public void setFreDetReceta(String freDetReceta) {
        this.freDetReceta = freDetReceta;
    }

    public String getDurTratamiento() {
        return durTratamiento;
    }

    public void setDurTratamiento(String durTratamiento) {
        this.durTratamiento = durTratamiento;
    }

    public TblRecetaMedica getTblRecetaMedica() {
        return tblRecetaMedica;
    }

    public void setTblRecetaMedica(TblRecetaMedica tblRecetaMedica) {
        this.tblRecetaMedica = tblRecetaMedica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tblDetalleRecetaPK != null ? tblDetalleRecetaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblDetalleReceta)) {
            return false;
        }
        TblDetalleReceta other = (TblDetalleReceta) object;
        if ((this.tblDetalleRecetaPK == null && other.tblDetalleRecetaPK != null) || (this.tblDetalleRecetaPK != null && !this.tblDetalleRecetaPK.equals(other.tblDetalleRecetaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.com.cormaria.servicios.entidades.consultasmedicas.TblDetalleReceta[ tblDetalleRecetaPK=" + tblDetalleRecetaPK + " ]";
    }
    
}
