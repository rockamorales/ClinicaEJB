/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sv.com.cormaria.servicios.entidades.archivo.EstadoServiciosEnfermeria;

/**
 *
 * @author romorales
 */
public class ServiciosEnfermeriaSearchCriteria implements SearchCriteria {
    private static EstadoServiciosEnfermeria ESTADO_ELIMINADO = EstadoServiciosEnfermeria.ELIMINADO;
    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private String tercerApellido;
    private String dui;
    private Integer numExpediente;
    private Integer codTipoServicio;
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
    
    public List<EstadoServiciosEnfermeria> getEstadosEnum(){
        List<EstadoServiciosEnfermeria> estadosEnum = new ArrayList<EstadoServiciosEnfermeria>();
        for (String estado : estados) {
            estadosEnum.add(EstadoServiciosEnfermeria.valueOf(estado));
        }
        return estadosEnum;
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

    public Integer getNumExpediente() {
        return numExpediente;
    }

    public void setNumExpediente(Integer numExpediente) {
        this.numExpediente = numExpediente;
    }

    public Integer getCodTipoServicio() {
        return codTipoServicio;
    }

    public void setCodTipoServicio(Integer codTipoServicio) {
        this.codTipoServicio = codTipoServicio;
    }
    
    @Override
    public String createQuery() {
        StringBuffer strSelect = new StringBuffer("Select s from TblServiciosEnfermeria s ");
        StringBuffer strSort = new StringBuffer(" order by s.fecSerEnfermeria ");
        String strWhere = createWhere();
        return strSelect + " " + strWhere + " " + strSort;
    }

    @Override
    public String createCountQuery() {
        StringBuffer strSelect = new StringBuffer("Select count(*) from TblServiciosEnfermeria s ");
        String strWhere = createWhere();
        return strSelect + " " + strWhere;
    }

    private String createWhere(){
        StringBuffer strWhere = new StringBuffer();
        if (this.getNumExpediente()!=null){
           strWhere.append(" s.numExpediente = :numExpediente");
        }
        if (this.getNombres()!=null && !this.getNombres().trim().equals("")){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" s.expediente.nomPaciente like :nombres");
        }
        if (this.getPrimerApellido()!=null && !this.getPrimerApellido().trim().equals("")){
            if (strWhere.length() > 0){
               strWhere.append(" and ");
            }
            strWhere.append(" s.expediente.priApePaciente like :primerApellido");
        }
        if (this.getSegundoApellido()!=null && !this.getSegundoApellido().trim().equals("")){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" s.expediente.secApePaciente like :segundoApellido");
        }
        if (this.getTercerApellido()!=null && !this.getTercerApellido().trim().equals("")){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" s.expediente.terApePaciente like :tecerApellido");
        }
        
        if (this.getDui()!=null && !this.getDui().trim().equals("")){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" s.expediente.numDui = :dui");
        }

        if (this.getCodTipoServicio()!=null && this.getCodTipoServicio()>0){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" s.codServEnfermeria = :codTipoServicio");
        }

        if (this.getEstados()!=null && !this.getEstados().isEmpty()){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" s.estSerEnfermeria in (:estados)");
        }
        if (this.getShowDeleted()!=null && !this.getShowDeleted()){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" s.estSerEnfermeria not in (:eliminado)");
        }
        
        if (strWhere.length() > 0){
                return " where "+strWhere.toString();
        }
        return strWhere.toString();
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
        
        if (this.getCodTipoServicio()!=null && this.getCodTipoServicio()>0){
            parameters.put("codTipoServicio",this.getCodTipoServicio());
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