/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.criteria;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sv.com.cormaria.servicios.enums.EstadoConsultas;

/**
 *
 * @author romorales
 */
public class ConsultasSearchCriteria implements SearchCriteria {

    private String nombres;
    private String primerApellido;
    private String segundoApellido;
    private String tercerApellido;
    private String dui;
    private Integer numExpediente;
    private Integer numMedico;
    private Integer codEspecialidad;
    private Integer jvpm;
    private Date fechaConsulta;
    
    private List<String> estadoConsultas = new ArrayList<String>();

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Integer getCodEspecialidad() {
        return codEspecialidad;
    }

    public void setCodEspecialidad(Integer codEspecialidad) {
        this.codEspecialidad = codEspecialidad;
    }

    public Integer getJvpm() {
        return jvpm;
    }

    public void setJvpm(Integer jvpm) {
        this.jvpm = jvpm;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
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

    public Integer getNumMedico() {
        return numMedico;
    }

    public void setNumMedico(Integer numMedico) {
        this.numMedico = numMedico;
    }

    public List<String> getEstadoConsultas() {
        return estadoConsultas;
    }

    public void setEstadoConsultas(List<String> estadoConsultas) {
        this.estadoConsultas = estadoConsultas;
    }
    
    public List<EstadoConsultas> getEstadoConsultasEnum(){
        List<EstadoConsultas> estados = new ArrayList<EstadoConsultas>();
        for (String string : estadoConsultas) {
            estados.add(EstadoConsultas.valueOf(string));
        }
        return estados;
    }
    
    @Override
    public String createQuery() {
        StringBuffer strSelect = new StringBuffer("Select c from TblConsultas c ");
        StringBuffer strSort = new StringBuffer(" order by c.fecConsulta ");
        String strWhere = createWhere();
        return strSelect + " " + strWhere + " " + strSort;
    }

    @Override
    public String createCountQuery() {
        StringBuffer strSelect = new StringBuffer("Select count(*) from TblConsultas c ");
        StringBuffer strSort = new StringBuffer(" order by c.numConsulta desc ");
        String strWhere = createWhere();
        return strSelect + " " + strWhere + " " + strSort;
    }

    private String createWhere(){
        System.out.println("Creando el where: ");
        if (this.getEstadoConsultas().isEmpty()){
            System.out.println("Estado: "+getEstadoConsultas().get(0));
        }
        System.out.println("Num medico: "+getNumMedico());
        StringBuffer strWhere = new StringBuffer();
        if (this.getNumExpediente()!=null){
           strWhere.append(" c.numExpediente = :numExpediente");
        }
        if (this.getNombres()!=null && !this.getNombres().trim().equals("")){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" c.tblExpediente.nomPaciente like :nombres");
        }
        if (this.getPrimerApellido()!=null && !this.getPrimerApellido().trim().equals("")){
            if (strWhere.length() > 0){
               strWhere.append(" and ");
            }
            strWhere.append(" c.tblExpediente.priApePaciente like :primerApellido");
        }
        if (this.getSegundoApellido()!=null && !this.getSegundoApellido().trim().equals("")){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" c.tblExpediente.secApePaciente like :segundoApellido");
        }
        if (this.getTercerApellido()!=null && !this.getTercerApellido().trim().equals("")){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" c.tblExpediente.terApePaciente like :tecerApellido");
        }
        
        if (this.getDui()!=null && !this.getDui().trim().equals("")){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" c.tblExpediente.numDui = :dui");
        }

        if (this.getNumMedico()!=null && this.getNumMedico()>0){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" c.numMedico = :numMedico");
        }

        if (this.getCodEspecialidad()!=null && this.getCodEspecialidad()>0){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" c.codEspecialidad = :codEspecialidad");
        }

        if (this.getFechaConsulta()!=null){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" c.fecConsulta between :fecInicio and :fecFin");
        }        

        if (this.getJvpm()!=null && this.getJvpm()>0){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" c.tblMedico.numJunta = :jvpm");
        }        
        
        if (this.getEstadoConsultas()!=null && !this.getEstadoConsultas().isEmpty()){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" c.estConsulta in (:estados)");
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
        if (this.getEstadoConsultas()!=null && !this.getEstadoConsultas().isEmpty()){
            parameters.put("estados",this.getEstadoConsultasEnum());
        }
        if (this.getNumMedico()!=null && this.getNumMedico() > 0){
            parameters.put("numMedico",this.getNumMedico());
        }        
        if (this.getCodEspecialidad()!=null && this.getCodEspecialidad()>0){
            parameters.put("codEspecialidad",this.getCodEspecialidad());        
        }
        if (this.getFechaConsulta()!=null){
            Calendar calStart = Calendar.getInstance();
            calStart.setTime(fechaConsulta);
            calStart.set(Calendar.HOUR, 0);
            calStart.set(Calendar.MINUTE, 0);
            calStart.set(Calendar.SECOND, 0);
            calStart.set(Calendar.MILLISECOND, 0);
            Calendar calEnd = Calendar.getInstance();
            calEnd.setTime(fechaConsulta);
            calEnd.set(Calendar.HOUR, 23);
            calEnd.set(Calendar.MINUTE, 59);
            calEnd.set(Calendar.SECOND, 59);
            calEnd.set(Calendar.MILLISECOND, 999);
            parameters.put("fecInicio",calStart.getTime());        
            parameters.put("fecFin",calEnd.getTime());
        }
        if (this.getJvpm()!=null && this.getJvpm()>0){
            parameters.put("jvpm",this.getJvpm());    
        }
        return parameters;
    }
}
