/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.criteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sv.com.cormaria.servicios.enums.EstadoRequisicion;

/**
 *
 * @author romorales
 */
public class RequisicionesSearchCriteria implements SearchCriteria {
    private static EstadoRequisicion ESTADO_ELIMINADO = EstadoRequisicion.ELIMINADA;
    private String nomEmpleado;
    private String priApeEmpleado;
    private String secApeEmpleado;
    private String terApeEmpleado;
    private Integer numRequisicion;
    private Integer codArea;
    private Date startDate;
    private Date endDate;
    private Integer codTipRequisicion;
    private Boolean showDeleted = false;
    private List<String> estados = new ArrayList<String>();

    public List<String> getEstados(){
        return estados;
    }

    public void setEstados(List<String> estados) {
        this.estados = estados;
    }

    public Boolean getShowDeleted() {
        return showDeleted;
    }

    public void setShowDeleted(Boolean showDeleted) {
        this.showDeleted = showDeleted;
    }
    
    public List<EstadoRequisicion> getEstadosEnum(){
        List<EstadoRequisicion> estadosEnum = new ArrayList<EstadoRequisicion>();
        for (String estado : estados) {
            estadosEnum.add(EstadoRequisicion.valueOf(estado));
        }
        return estadosEnum;
    }

    public String getNomEmpleado() {
        return nomEmpleado;
    }

    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }

    public String getPriApeEmpleado() {
        return priApeEmpleado;
    }

    public void setPriApeEmpleado(String priApeEmpleado) {
        this.priApeEmpleado = priApeEmpleado;
    }

    public String getSecApeEmpleado() {
        return secApeEmpleado;
    }

    public void setSecApeEmpleado(String secApeEmpleado) {
        this.secApeEmpleado = secApeEmpleado;
    }

    public String getTerApeEmpleado() {
        return terApeEmpleado;
    }

    public void setTerApeEmpleado(String terApeEmpleado) {
        this.terApeEmpleado = terApeEmpleado;
    }

    public Integer getNumRequisicion() {
        return numRequisicion;
    }

    public void setNumRequisicion(Integer numRequisicion) {
        this.numRequisicion = numRequisicion;
    }

    public Integer getCodArea() {
        return codArea;
    }

    public void setCodArea(Integer codArea) {
        this.codArea = codArea;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getCodTipRequisicion() {
        return codTipRequisicion;
    }

    public void setCodTipRequisicion(Integer codTipRequisicion) {
        this.codTipRequisicion = codTipRequisicion;
    }

    @Override
    public String createQuery() {
        StringBuffer strSelect = new StringBuffer("Select r from TblRequisiciones r ");
        StringBuffer strSort = new StringBuffer(" order by r.fecRequisicion ");
        String strWhere = createWhere();
        return strSelect + " " + strWhere + " " + strSort;
    }

    @Override
    public String createCountQuery() {
        StringBuffer strSelect = new StringBuffer("Select count(*) from TblRequisiciones r ");
        String strWhere = createWhere();
        return strSelect + " " + strWhere;
    }

    private String createWhere(){
        StringBuffer strWhere = new StringBuffer();
        if (this.getNumRequisicion()!=null && this.getNumRequisicion()>0){
           strWhere.append(" r.numRequisicion = :numRequisicion");
        }
        if (this.getCodArea()!=null && this.getCodArea()>0){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" r.codArea like :codArea");
        }
        if (this.getCodTipRequisicion()!=null && this.getCodTipRequisicion()>0){
            if (strWhere.length() > 0){
               strWhere.append(" and ");
            }
            strWhere.append(" r.codTipRequisicion like :codTipRequisicion");
        }
        if (this.getEndDate()!=null && this.getStartDate()!=null){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" r.fecRequisicion between :startDate and :endDate ");
        }else if (this.getEndDate()!=null){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" r.fecRequisicion <= :endDate");
        }else if(this.getStartDate()!=null){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" r.fecRequisicion >= :startDate");
        }
        if (this.getEstados()!=null && !this.getEstados().isEmpty()){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" r.estRequisicion in (:estados)");
        }
        if (this.getShowDeleted()!=null && !this.getShowDeleted()){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" r.estRequisicion not in (:eliminado)");
        }
        
        if (strWhere.length() > 0){
                return " where "+strWhere.toString();
        }
        return strWhere.toString();
    }    
    
    
    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        if (this.getNumRequisicion()!=null && this.getNumRequisicion()>0){
           parameters.put("numRequisicion", this.getNumRequisicion());
        }
        if (this.getCodArea()!=null && this.getCodArea()>0){
           parameters.put("codArea", this.getCodArea());
        }
        if (this.getCodTipRequisicion()!=null && this.getCodTipRequisicion()>0){
           parameters.put("codTipRequisicion", this.getCodTipRequisicion());
        }
        if (this.getEndDate()!=null && this.getStartDate()!=null){
           parameters.put("startDate", this.getStartDate());
           parameters.put("endDate", this.getEndDate());
        }else if (this.getEndDate()!=null){
           parameters.put("endDate", this.getEndDate());
        }else if(this.getStartDate()!=null){
           parameters.put("startDate", this.getStartDate());
        }
        if (this.getEstados()!=null && !this.getEstados().isEmpty()){
            parameters.put("estados", this.getEstadosEnum());
        }
        if (this.getShowDeleted()!=null && !this.getShowDeleted()){
            parameters.put("eliminado", ESTADO_ELIMINADO);
        }
        return parameters;
    }
}