/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.archivo;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.archivo.TblExpedientePacientes;
import sv.com.cormaria.servicios.entidades.archivo.TblTarjetaControlCitas;
import sv.com.cormaria.servicios.entidades.catalogos.CatEspecialidad;
import sv.com.cormaria.servicios.entidades.colecturia.TblComprobanteDonacion;
import sv.com.cormaria.servicios.entidades.colecturia.TblDetalleComprobanteDonacion;
import sv.com.cormaria.servicios.entidades.colecturia.TblDetalleComprobanteDonacionPK;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblConsultas;
import sv.com.cormaria.servicios.entidades.administracion.TblProducto;
import sv.com.cormaria.servicios.enums.Estado;
import sv.com.cormaria.servicios.enums.EstadoComprobanteDonacion;
import sv.com.cormaria.servicios.enums.EstadoConsultas;
import sv.com.cormaria.servicios.enums.TipoComprobanteDonacion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.catalogos.CatEspecialidadFacadeLocal;
import sv.com.cormaria.servicios.facades.colecturia.TblComprobanteDonacionFacadeLocal;
import sv.com.cormaria.servicios.facades.colecturia.TblDetalleComprobanteDonacionFacadeLocal;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;
import sv.com.cormaria.servicios.facades.consultasmedicas.TblConsultasFacadeLocal;
import sv.com.cormaria.servicios.facades.administracion.TblProductoFacadeLocal;
import sv.com.cormaria.servicios.helpers.DateUtils;
import sv.com.cormaria.servicios.helpers.NumToText;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblExpedientePacientesFacade extends AbstractFacade<TblExpedientePacientes> implements TblExpedientePacientesFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;
    @EJB
    private TblComprobanteDonacionFacadeLocal comprobanteFacade;
    @EJB
    private TblTarjetaControlCitasFacadeLocal tarjetaFacade;
    @EJB
    private CatEspecialidadFacadeLocal especialidadFacade;
    @EJB
    private TblProductoFacadeLocal productoFacade;

    @EJB
    private TblDetalleComprobanteDonacionFacadeLocal detalleComprobanteFacade;

    @EJB
    private TblConsultasFacadeLocal consultaFacade;

    
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblExpedientePacientesFacade() {
        super(TblExpedientePacientes.class);
    }

    @Override
    public List<TblExpedientePacientes> findAll() throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblExpedientePacientes.findAll");
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public List<TblExpedientePacientes> findRange(int[] range) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblExpedientePacientes.findAll");
            q.setMaxResults(range[1] - range[0]);
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public int count() throws ClinicaModelexception {
            try{
            Query q = em.createQuery("Select count(*) from TblExpedientePacientes");
            Long count = (Long)q.getSingleResult();
            if (count!=null){
                return count.intValue();
            }
            return 0;
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
   @Override
   public TblConsultas generarConsulta(TblConsultas consulta, TblExpedientePacientes expediente, Integer codEspecialidad) throws ClinicaModelexception{
       try{
           //creando la consulta
           consulta.setEdaConsulta((short)DateUtils.yearDateDiff(expediente.getFecNacPaciente(), new java.util.Date()));
           consulta.setFecConsulta(new java.util.Date());
           consulta.setCodEspecialidad(codEspecialidad);
           consulta.setEstConsulta(EstadoConsultas.EMITIDA);
           consultaFacade.create(consulta);
           //Generando el pago
           TblComprobanteDonacion tblComprobante = new TblComprobanteDonacion();
           tblComprobante.setCodCarisma(1);
           tblComprobante.setCodTipDonacion(2);
           tblComprobante.setCodTipDonante(2);
           tblComprobante.setEstComDonacion(EstadoComprobanteDonacion.EMITIDO);
           tblComprobante.setFecComDonacion(new java.util.Date());
           tblComprobante.setCanLetras("Cero");
           tblComprobante.setNumExpediente(expediente.getNumExpediente());
           tblComprobante.setNomComDonacion(expediente.getNomPaciente() + " " + expediente.getPriApePaciente() + " " + expediente.getSecApePaciente());
           tblComprobante.setTipComprobante(TipoComprobanteDonacion.COBRO);
           comprobanteFacade.create(tblComprobante);
           System.out.println("Numero de comprobante: "+tblComprobante.getNumComDonacion());
           //Agregando la consulta
           TblDetalleComprobanteDonacion detalleComprobante = new TblDetalleComprobanteDonacion();
           CatEspecialidad especialidad = especialidadFacade.find(codEspecialidad);
           detalleComprobante.setCanProComDonacion(1);
           detalleComprobante.setPreUniComDonacion(especialidad.getTblProducto().getPreFinProducto());
           TblDetalleComprobanteDonacionPK pk = new TblDetalleComprobanteDonacionPK();
           pk.setNumComDonacion(tblComprobante.getNumComDonacion());
           pk.setNumProducto(especialidad.getNumProducto());
           detalleComprobante.setNumConsulta(consulta.getNumConsulta());
           detalleComprobante.setTblDetalleComprobanteDonacionPK(pk);
           detalleComprobante.setTotIteComDonacion(especialidad.getTblProducto().getPreFinProducto());
           tblComprobante.setTotDonacion(especialidad.getTblProducto().getPreFinProducto());
           tblComprobante.setCanLetras(NumToText.convertirLetras(tblComprobante.getTotDonacion()));
           detalleComprobanteFacade.create(detalleComprobante);
           //Agregando la tarjeta
           List<TblTarjetaControlCitas> tarjetasNoPagadasList = tarjetaFacade.findNoPagadoByNumExpediente(expediente.getNumExpediente());
           if (!tarjetasNoPagadasList.isEmpty()){
               detalleComprobante = new TblDetalleComprobanteDonacion();
               List<TblProducto> tarjetasList = this.productoFacade.findTarjetaControl();
               if (!tarjetasList.isEmpty()){
                   TblProducto tarjeta = tarjetasList.get(0);
                   //if (tarjetasList.isEmpty()){
                   //    throw new ClinicaModelValidationException("No existe ningun producto para c")
                   //}
                   //CatEspecialidad especialidad = especialidadFacade.find(codEspecialidad);
                   detalleComprobante.setCanProComDonacion(1);
                   detalleComprobante.setPreUniComDonacion(tarjeta.getPreFinProducto());
                   pk = new TblDetalleComprobanteDonacionPK();
                   pk.setNumComDonacion(tblComprobante.getNumComDonacion());
                   pk.setNumProducto(tarjeta.getNumProducto());
                   detalleComprobante.setTblDetalleComprobanteDonacionPK(pk);
                   detalleComprobante.setTotIteComDonacion(tarjeta.getPreFinProducto());
                   tblComprobante.setTotDonacion(tblComprobante.getTotDonacion()+tarjeta.getPreFinProducto());
                   tblComprobante.setCanLetras(NumToText.convertirLetras(tblComprobante.getTotDonacion()));
                   detalleComprobanteFacade.create(detalleComprobante);
               }
           }
           return consulta;
       }catch(Exception ex){
           ex.printStackTrace();
           throw new ClinicaModelexception(ex.getMessage(), ex);
       }
   }
   
   @Override
   public void remove(TblExpedientePacientes expediente) throws ClinicaModelexception{
       try{
            TblExpedientePacientes expediente1 = em.find(TblExpedientePacientes.class, expediente.getNumExpediente());
            expediente1.setEstPaciente(Estado.INACTIVO);
       }catch(Exception ex){
           throw new ClinicaModelexception(ex.getMessage(), ex);
       }
   }
    
   public void remove(Long expedienteid) throws ClinicaModelexception{
       try{
            TblExpedientePacientes expediente1 = em.find(TblExpedientePacientes.class, expedienteid);
            expediente1.setEstPaciente(Estado.INACTIVO);
       }catch(Exception ex){
           throw new ClinicaModelexception(ex.getMessage(), ex);
       }
   }
   
   public TblExpedientePacientes create1(TblExpedientePacientes entity) throws ClinicaModelexception{
        try{
            getEntityManager().persist(entity);
            return entity;
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    public TblExpedientePacientes edit1(TblExpedientePacientes entity) throws ClinicaModelexception {
        try{
            return getEntityManager().merge(entity);
         }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
   }
    
    public List<TblExpedientePacientes> findByPrefix(String nombres) throws ClinicaModelexception{
        try{
            Query q = em.createNamedQuery("TblExpedientePacientes.findByNamePrefix");
            q.setParameter("nombres", "%"+nombres+"%");
            q.setMaxResults(10);
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

}
