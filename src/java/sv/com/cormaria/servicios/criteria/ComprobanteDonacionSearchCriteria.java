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
import sv.com.cormaria.servicios.enums.EstadoComprobanteDonacion;
import sv.com.cormaria.servicios.enums.TipoComprobanteDonacion;

/**
 *
 * @author romorales
 */
public class ComprobanteDonacionSearchCriteria implements SearchCriteria {
    public static final EstadoComprobanteDonacion ESTADO_ELIMINADO = EstadoComprobanteDonacion.ELIMINADO;
    private String nomPaciente;
    private String priApePaciente;
    private String secApePaciente;
    private String terApePaciente;
    private String nomComDonacion;
    private Integer numInstitucion;
    private Integer codTipDonante;
    private Integer codCarisma;
    private Integer codTipDonacion;
    private Integer numExpediente;
    private Date startDate;
    private Date endDate;
    private String numFactura;
    private TipoComprobanteDonacion tipComprobanteDonacion;
    private Boolean showDeleted = false;
    private List<String> estados = new ArrayList<String>();

    public String getNumFactura() {
        return numFactura;
    }

    public TipoComprobanteDonacion getTipComprobanteDonacion() {
        return tipComprobanteDonacion;
    }

    public void setTipComprobanteDonacion(TipoComprobanteDonacion tipComprobanteDonacion) {
        this.tipComprobanteDonacion = tipComprobanteDonacion;
    }
    
    public void setNumFactura(String numFactura) {
        this.numFactura = numFactura;
    }
    
    public String getNomComDonacion() {
        return nomComDonacion;
    }

    public void setNomComDonacion(String nomComDonacion) {
        this.nomComDonacion = nomComDonacion;
    }

    public Integer getNumInstitucion() {
        return numInstitucion;
    }

    public void setNumInstitucion(Integer numInstitucion) {
        this.numInstitucion = numInstitucion;
    }

    public Integer getCodTipDonante() {
        return codTipDonante;
    }

    public void setCodTipDonante(Integer codTipDonante) {
        this.codTipDonante = codTipDonante;
    }

    public Integer getCodCarisma() {
        return codCarisma;
    }

    public void setCodCarisma(Integer codCarisma) {
        this.codCarisma = codCarisma;
    }

    public Integer getCodTipDonacion() {
        return codTipDonacion;
    }

    public void setCodTipDonacion(Integer codTipDonacion) {
        this.codTipDonacion = codTipDonacion;
    }
    
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
    
    public List<EstadoComprobanteDonacion> getEstadosEnum(){
        List<EstadoComprobanteDonacion> estadosEnum = new ArrayList<EstadoComprobanteDonacion>();
        for (String estado : estados) {
            estadosEnum.add(EstadoComprobanteDonacion.valueOf(estado));
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
        StringBuffer strSelect = new StringBuffer("Select c from TblComprobanteDonacion c ");
        StringBuffer strSort = new StringBuffer(" order by c.fecComDonacion ");
        String strWhere = createWhere();
        return strSelect + " " + strWhere + " " + strSort;
    }

    @Override
    public String createCountQuery() {
        StringBuffer strSelect = new StringBuffer("Select count(*) from TblComprobanteDonacion c ");
        String strWhere = createWhere();
        return strSelect + " " + strWhere;
    }

    private String createWhere(){
        StringBuilder strWhere = new StringBuilder();
        if (this.getNumFactura()!=null && !this.getNumFactura().trim().equals("")){
           strWhere.append(" c.numFacDonacion = :numFacDonacion");
        }
        
        if (this.getNumExpediente()!=null && this.getNumExpediente()>0){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
           strWhere.append(" c.numExpediente = :numExpediente");
        }

        if (this.getCodCarisma()!=null && this.getCodCarisma()>0){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
           strWhere.append(" c.codCarisma = :codCarisma");
        }

        if (this.getCodTipDonacion()!=null && this.getCodTipDonacion()>0){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
           strWhere.append(" c.codTipDonacion = :codTipDonacion");
        }

        if (this.getCodTipDonante()!=null && this.getCodTipDonante()>0){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
           strWhere.append(" c.codTipDonante = :codTipDonante");
        }

        if (this.getNomComDonacion()!=null && !this.getNomComDonacion().trim().equals("")){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
           strWhere.append(" c.nomComDonacion like :nomComDonacion");
        }

        if (this.getNomPaciente()!=null && !this.getNomPaciente().trim().equals("")){
           if (strWhere.length() > 0){
               strWhere.append(" and ");
           }
           strWhere.append(" c.tblExpedientePacientes.nomPaciente like :nomPaciente");
        }        

        if (this.getPriApePaciente()!=null && !this.getPriApePaciente().trim().equals("")){
           if (strWhere.length() > 0){
               strWhere.append(" and ");
           }
           strWhere.append(" c.tblExpedientePacientes.priApePaciente like :priApePaciente");
        }        

        if (this.getSecApePaciente()!=null && !this.getSecApePaciente().trim().equals("")){
           if (strWhere.length() > 0){
               strWhere.append(" and ");
           }
           strWhere.append(" c.tblExpedientePacientes.secApePaciente like :secApePaciente");
        }        

        if (this.getTerApePaciente()!=null && !this.getTerApePaciente().trim().equals("")){
           if (strWhere.length() > 0){
               strWhere.append(" and ");
           }
           strWhere.append(" c.tblExpedientePacientes.terApePaciente like :terApePaciente");
        }        

        if (this.getNumInstitucion()!=null && this.getNumInstitucion() > 0){
           if (strWhere.length() > 0){
               strWhere.append(" and ");
           }
           strWhere.append(" c.numInstitucion = :numInstitucion");
        }

        if (this.getEndDate()!=null && this.getStartDate()!=null){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" c.fecComDonacion between :startDate and :endDate ");
        }else if (this.getEndDate()!=null){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" c.fecComDonacion <= :endDate");
        }else if(this.getStartDate()!=null){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" c.fecComDonacion >= :startDate");
        }
        
        if (this.getEstados()!=null && !this.getEstados().isEmpty()){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" c.estComDonacion in (:estados)");
        }
        
        if (this.getShowDeleted()!=null && !this.getShowDeleted()){
            if (strWhere.length() > 0){
                    strWhere.append(" and ");
            }
            strWhere.append(" c.estComDonacion not in (:eliminado)");
        }
        if (this.getTipComprobanteDonacion()!=null){
            if (strWhere.length() > 0){
                strWhere.append(" and ");
            }
            strWhere.append(" c.tipComprobante = :tipComprobante");
        }
        
        if (strWhere.length() > 0){
            return " where "+strWhere.toString();
        }
        return strWhere.toString();
        
    }
    
    @Override
    public Map<String, Object> getParameters() {
        Map<String, Object> parameters = new HashMap<String, Object>();
        if (this.getNumFactura()!=null && !this.getNumFactura().trim().equals("")){
           parameters.put("numFacDonacion", this.getNumFactura());
        }
        if (this.getNumExpediente()!=null && this.getNumExpediente()>0){
           parameters.put("numExpediente", this.getNumExpediente());
        }
        if (this.getCodCarisma()!=null && this.getCodCarisma()>0){
           parameters.put("codCarisma", this.getCodCarisma());
        }

        if (this.getCodTipDonacion()!=null && this.getCodTipDonacion()>0){
           parameters.put("codTipDonacion", this.getCodTipDonacion());
        }

        if (this.getCodTipDonante()!=null && this.getCodTipDonante()>0){
           parameters.put("codTipDonante", this.getCodTipDonante());
        }

        if (this.getNomComDonacion()!=null && !this.getNomComDonacion().trim().equals("")){
           parameters.put("nomComDonacion", this.getNomComDonacion());
        }

        if (this.getNomPaciente()!=null && !this.getNomPaciente().trim().equals("")){
           parameters.put("nomPaciente", this.getNomPaciente());
        }

        if (this.getPriApePaciente()!=null && !this.getPriApePaciente().trim().equals("")){
           parameters.put("priApePaciente", this.getPriApePaciente());
        }

        if (this.getSecApePaciente()!=null && !this.getSecApePaciente().trim().equals("")){
           parameters.put("secApePaciente", this.getSecApePaciente());
        }

        if (this.getTerApePaciente()!=null && !this.getTerApePaciente().trim().equals("")){
           parameters.put("terApePaciente", this.getTerApePaciente());
        }

        if (this.getNumInstitucion()!=null && this.getNumInstitucion() > 0){
           parameters.put("numInstitucion", this.getNumInstitucion());
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
        if (this.getTipComprobanteDonacion()!=null){
            parameters.put("tipComprobante", this.getTipComprobanteDonacion());
        }
        return parameters;
    }
}