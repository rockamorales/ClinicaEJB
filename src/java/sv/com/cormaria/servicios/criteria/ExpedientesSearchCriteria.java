/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sv.com.cormaria.servicios.enums.Estado;

/**
 *
 * @author romorales
 */
public class ExpedientesSearchCriteria implements SearchCriteria{

    public Integer numExpediente;
    public String nombres;
    public String primerApellido;
    public String segundoApellido;
    public String tercerApellido;
    public String dui;
    public List<String> estado = new ArrayList<String>();

    public ExpedientesSearchCriteria() {
        estado.add("ACTIVO");
    }

    
    public Integer getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(Integer numExpediente) {
        this.numExpediente = numExpediente;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getTercerApellido() {
        return tercerApellido;
    }

    public void setTercerApellido(String tercerApellido) {
        this.tercerApellido = tercerApellido;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public List<Estado> getEstados() {
        ArrayList<Estado> estados = new ArrayList<Estado>();
        for (String estado1 : estado) {
            estados.add(Estado.valueOf(estado1));
        }
        return estados;
    }

    public List<String> getEstado() {
        return estado;
    }
    
    public void setEstado(List<String> estado) {
        this.estado = estado;
    }
    
    @Override
    public String createQuery() {
        StringBuffer strSelect = new StringBuffer("Select e from TblExpedientePacientes e ");
        StringBuffer strSort = new StringBuffer("Order by e.numExpediente desc ");
        String strWhere = createWhere();
        return strSelect + " " + strWhere + " " + strSort;        
    }

    @Override
    public String createCountQuery() {
        StringBuffer strSelect = new StringBuffer("Select count(*) from TblExpedientePacientes e ");
        String strWhere = createWhere();
        return strSelect + " " + strWhere;
    }

    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        if (this.getNumExpediente()!=null){
            parameters.put("numExpediente",this.getNumExpediente());
        }
        if (this.getNombres()!=null && !this.getNombres().trim().equals("")){
            parameters.put("nombres",this.getNombres());
        }
        if (this.getPrimerApellido()!=null && !this.getPrimerApellido().trim().equals("")){
            parameters.put("primerApellido",this.getPrimerApellido());
        }
        if (this.getSegundoApellido()!=null && !this.getSegundoApellido().trim().equals("")){
            parameters.put("segundoApellido",this.getSegundoApellido());
        }
        if (this.getTercerApellido()!=null && !this.getTercerApellido().trim().equals("")){
            parameters.put("tercerApellido",this.getTercerApellido());
                            
        }
        
        if (this.getDui()!=null && !this.getDui().trim().equals("")){
            parameters.put("dui",this.getDui());
        }
        if (this.getEstado()!=null && !this.getEstado().isEmpty()){
            parameters.put("estado",this.getEstados());
        }        
        return parameters;
    }

    private String createWhere(){
        StringBuffer strWhere = new StringBuffer();
        if (this.getNumExpediente()!=null){
           strWhere.append(" e.numExpediente = :numExpediente");
        }
        if (this.getNombres()!=null && !this.getNombres().trim().equals("")){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" e.nomPaciente like :nombres");
        }
        if (this.getPrimerApellido()!=null && !this.getPrimerApellido().trim().equals("")){
            if (strWhere.length() > 0){
               strWhere.append(" and ");
            }
            strWhere.append(" e.priApePaciente like :primerApellido");
        }
        if (this.getSegundoApellido()!=null && !this.getSegundoApellido().trim().equals("")){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" e.secApePaciente like :segundoApellido");
        }
        if (this.getTercerApellido()!=null && !this.getTercerApellido().trim().equals("")){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" e.terApePaciente like :tercerApellido");
        }
        
        if (this.getDui()!=null && !this.getDui().trim().equals("")){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" e.numDui = :dui");
        }
        if (this.getEstado()!=null && !this.getEstado().isEmpty()){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" e.estPaciente in (:estado)");
        }
        if (strWhere.length() > 0){
                return " where "+strWhere.toString();
        }
        return strWhere.toString();
    }    
}
