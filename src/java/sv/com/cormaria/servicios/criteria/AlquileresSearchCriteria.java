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
import sv.com.cormaria.servicios.enums.EstadoAlquiler;

/**
 *
 * @author romorales
 */
public class AlquileresSearchCriteria implements SearchCriteria {
    public static final EstadoAlquiler ESTADO_ELIMINADO = EstadoAlquiler.ELIMINADO;
    private String nomPaciente;
    private String priApePaciente;
    private String secApePaciente;
    private String terApePaciente;
    private Integer numAlquiler;
    private Integer numExpediente;
    private Date startDate;
    private Date endDate;
    private Boolean showDeleted = false;
    private List<String> estados = new ArrayList<String>();

    public List<String> getEstados(){
        return estados;
    }

    public void setEstados(List<String> estados) {
        this.estados = estados;
    }

    public Integer getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(Integer numExpediente) {
        this.numExpediente = numExpediente;
    }
    
    public Boolean getShowDeleted() {
        return showDeleted;
    }

    public void setShowDeleted(Boolean showDeleted) {
        this.showDeleted = showDeleted;
    }
    
    public List<EstadoAlquiler> getEstadosEnum(){
        List<EstadoAlquiler> estadosEnum = new ArrayList<EstadoAlquiler>();
        for (String estado : estados) {
            estadosEnum.add(EstadoAlquiler.valueOf(estado));
        }
        return estadosEnum;
    }

    public String getNomPaciente() {
        return nomPaciente;
    }

    public void setNomPaciente(String nomPaciente) {
        this.nomPaciente = nomPaciente;
    }

    public String getPriApePaciente() {
        return priApePaciente;
    }

    public void setPriApePaciente(String priApePaciente) {
        this.priApePaciente = priApePaciente;
    }

    public String getSecApePaciente() {
        return secApePaciente;
    }

    public void setSecApePaciente(String secApePaciente) {
        this.secApePaciente = secApePaciente;
    }

    public String getTerApePaciente() {
        return terApePaciente;
    }

    public void setTerApePaciente(String terApePaciente) {
        this.terApePaciente = terApePaciente;
    }
    
    public Integer getNumAlquiler() {
        return numAlquiler;
    }

    public void setNumAlquiler(Integer numAlquiler) {
        this.numAlquiler = numAlquiler;
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

    @Override
    public String createQuery() {
        StringBuffer strSelect = new StringBuffer("Select r from TblAlquilerEquipo r ");
        StringBuffer strSort = new StringBuffer(" order by r.fecRegAlquiler ");
        String strWhere = createWhere();
        return strSelect + " " + strWhere + " " + strSort;
    }

    @Override
    public String createCountQuery() {
        StringBuffer strSelect = new StringBuffer("Select count(*) from TblAlquilerEquipo r ");
        String strWhere = createWhere();
        return strSelect + " " + strWhere;
    }

    private String createWhere(){
        StringBuffer strWhere = new StringBuffer();
        if (this.getNumAlquiler()!=null && this.getNumAlquiler()>0){
           strWhere.append(" r.numSolAlquiler = :numSolAlquiler");
        }
        if (this.getNumExpediente()!=null && this.getNumExpediente()>0){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
           strWhere.append(" r.numExpediente = :numExpediente");
        }
        if (this.getEndDate()!=null && this.getStartDate()!=null){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" r.fecRegAlquiler between :startDate and :endDate ");
        }else if (this.getEndDate()!=null){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" r.fecRegAlquiler <= :endDate");
        }else if(this.getStartDate()!=null){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" r.fecRegAlquiler >= :startDate");
        }
        if (this.getEstados()!=null && !this.getEstados().isEmpty()){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" r.estAlquiler in (:estados)");
        }
        if (this.getShowDeleted()!=null && !this.getShowDeleted()){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" r.estAlquiler not in (:eliminado)");
        }
        
        if (strWhere.length() > 0){
                return " where "+strWhere.toString();
        }
        return strWhere.toString();
    }    
    
    
    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        if (this.getNumAlquiler()!=null && this.getNumAlquiler()>0){
           parameters.put("numSolAlquiler", this.getNumAlquiler());
        }
        if (this.getNumExpediente()!=null && this.getNumExpediente()>0){
           parameters.put("numExpediente", this.getNumExpediente());
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