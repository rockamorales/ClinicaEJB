/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.consultasmedicas;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.colecturia.TblComprobanteDonacion;
import sv.com.cormaria.servicios.entidades.colecturia.TblDetalleComprobanteDonacion;
import sv.com.cormaria.servicios.entidades.colecturia.TblDetalleComprobanteDonacionPK;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblConsultas;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblDetalleReceta;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblRecetaMedica;
import sv.com.cormaria.servicios.entidades.farmacia.TblDespachos;
import sv.com.cormaria.servicios.entidades.farmacia.TblDetalleDespacho;
import sv.com.cormaria.servicios.entidades.farmacia.TblDetalleDespachoPK;
import sv.com.cormaria.servicios.entidades.security.TblUsuarios;
import sv.com.cormaria.servicios.enums.EstadoComprobanteDonacion;
import sv.com.cormaria.servicios.enums.EstadoConsultas;
import sv.com.cormaria.servicios.enums.EstadoDetalleDespacho;
import sv.com.cormaria.servicios.enums.OrigenDonacionEnum;
import sv.com.cormaria.servicios.enums.TipoComprobanteDonacion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.colecturia.TblComprobanteDonacionFacadeLocal;
import sv.com.cormaria.servicios.facades.colecturia.TblDetalleComprobanteDonacionFacadeLocal;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;
import sv.com.cormaria.servicios.facades.farmacia.TblDespachosFacadeLocal;
import sv.com.cormaria.servicios.facades.farmacia.TblDetalleDespachoFacadeLocal;
import sv.com.cormaria.servicios.facades.security.TblUsuariosSessionFacadeLocal;
import sv.com.cormaria.servicios.helpers.NumToText;
import sv.com.cormaria.servicios.helpers.NumUtils;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblConsultasFacade extends AbstractFacade<TblConsultas> implements TblConsultasFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;
    
    @Resource
    SessionContext sessionContext;

    @EJB
    private TblComprobanteDonacionFacadeLocal comprobanteFacade;

    @EJB
    private TblDetalleComprobanteDonacionFacadeLocal detalleComprobanteFacade;

    @EJB
    private TblRecetaMedicaFacadeLocal recetaFacade;

    @EJB
    private TblDespachosFacadeLocal despachoFacade;    

    @EJB
    private TblDetalleDespachoFacadeLocal detalleDespachoFacade;        
    
    @EJB
    private TblDetalleRecetaFacadeLocal detalleRecetaFacade;

    @EJB
    private TblUsuariosSessionFacadeLocal usuariosFacade;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TblConsultasFacade() {
        super(TblConsultas.class);
    }

    @Override
    public List<TblConsultas> findAll() throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblConsultas.findAll");
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public List<TblConsultas> findRange(int[] range) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblConsultas.findAll");
            q.setFirstResult(range[0]);
            q.setFirstResult(range[1] - range[0]);
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public int count() throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("Select count(*) from TblConsultas t");
            Long count = (Long)q.getSingleResult();
            if (count!=null){
                return count.intValue();
            }
            return 0;
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    public TblConsultas editSigVitalesInfo(TblConsultas consulta) throws ClinicaModelexception{
        try{
            System.out.println("Peso:"+consulta.getPesPaciente());
            System.out.println("Talla:"+consulta.getTalPaciente());
            System.out.println("Temp:"+consulta.getTemPaciente());
            System.out.println("pulso:"+consulta.getPulPaciente());
            System.out.println("Presion:"+consulta.getPreArterial());
            consulta.setEstConsulta(EstadoConsultas.SIGNOS_VITALES);
            return em.merge(consulta);
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    public void finalizarConsulta(Integer numConsulta) throws ClinicaModelexception{
        TblConsultas consulta = em.find(TblConsultas.class, numConsulta);
        consulta.setEstConsulta(EstadoConsultas.FINALIZADA);
        precargarCobroReceta(consulta);
        precargarDespacho(consulta);
    }
    
    public void precargarCobroReceta(TblConsultas consulta) throws ClinicaModelexception{
           TblRecetaMedica recetaMedica = recetaFacade.findByNumConsulta(consulta.getNumConsulta());
           List<TblDetalleReceta> detalleRecetaList = new ArrayList<TblDetalleReceta>();
           if (recetaMedica!=null){
               detalleRecetaList = detalleRecetaFacade.findByNumReceta(recetaMedica.getNumReceta());
           }
           if (!detalleRecetaList.isEmpty()){
                TblComprobanteDonacion tblComprobante = new TblComprobanteDonacion();
                tblComprobante.setCodCarisma(1);
                tblComprobante.setCodTipDonacion(2);
                tblComprobante.setCodTipDonante(2);
                tblComprobante.setEstComDonacion(EstadoComprobanteDonacion.EMITIDO);
                tblComprobante.setFecComDonacion(new java.util.Date());
                tblComprobante.setCanLetras("");
                tblComprobante.setOriDonacion(OrigenDonacionEnum.RECETA);
                tblComprobante.setNumExpediente(consulta.getNumExpediente());
                tblComprobante.setNomComDonacion(consulta.getTblExpediente().getNomPaciente() + " " + consulta.getTblExpediente().getPriApePaciente() + " " + consulta.getTblExpediente().getSecApePaciente());
                tblComprobante.setTipComprobante(TipoComprobanteDonacion.COBRO);
                comprobanteFacade.create(tblComprobante);
                System.out.println("Numero de comprobante: "+tblComprobante.getNumComDonacion());
                //Agregando la consulta
                TblDetalleComprobanteDonacion detalleComprobante = null;
                TblDetalleComprobanteDonacionPK pk = null;
                float total = 0.00F;
                for (TblDetalleReceta tblDetalleReceta : detalleRecetaList) {
                    //No deberiamos verificar si es contribuible o no
                    if (tblDetalleReceta.getNoContribuible()==null || !tblDetalleReceta.getNoContribuible()){
                        detalleComprobante = new TblDetalleComprobanteDonacion();
                        detalleComprobante.setCanProComDonacion(tblDetalleReceta.getCanDetReceta());
                        detalleComprobante.setPreUniComDonacion(tblDetalleReceta.getTblProducto().getPreFinProducto());
                        pk = new TblDetalleComprobanteDonacionPK();
                        pk.setNumComDonacion(tblComprobante.getNumComDonacion());
                        pk.setNumProducto(tblDetalleReceta.getTblProducto().getNumProducto());
                        detalleComprobante.setTblDetalleComprobanteDonacionPK(pk);
                        detalleComprobante.setTotIteComDonacion(tblDetalleReceta.getTblProducto().getPreFinProducto()*tblDetalleReceta.getCanDetReceta());
                        total = total+detalleComprobante.getTotIteComDonacion();
                        detalleComprobante.setNumReceta(recetaMedica.getNumReceta());
                        detalleComprobanteFacade.create(detalleComprobante);
                    }
                }
                tblComprobante.setTotDonacion(NumUtils.round(total, 4));
                tblComprobante.setCanLetras(NumToText.convertirLetras(tblComprobante.getTotDonacion()));
           }
    }

    private void precargarDespacho(TblConsultas consulta) throws ClinicaModelexception {
           TblRecetaMedica recetaMedica = recetaFacade.findByNumConsulta(consulta.getNumConsulta());
           List<TblDetalleReceta> detalleRecetaList = new ArrayList<TblDetalleReceta>();
           if (recetaMedica!=null){
               detalleRecetaList = detalleRecetaFacade.findNoContribuibleByNumReceta(recetaMedica.getNumReceta());
           }
           if (!detalleRecetaList.isEmpty()){
                TblDespachos tblDespacho = new TblDespachos();
                tblDespacho.setNumReceta(recetaMedica.getNumReceta());
                tblDespacho.setCodTipSalida(1);
                tblDespacho.setEstDespacho(EstadoDetalleDespacho.CREADO);
                tblDespacho.setFecDespacho(new java.util.Date());
                tblDespacho.setMonDespacho(0);
                TblUsuarios usuario = usuariosFacade.findByCodigoUsuario(sessionContext.getCallerPrincipal().getName());
                tblDespacho.setNumEmpleado(usuario.getNumEmpleado());
                tblDespacho.setObsDespacho("Despacho generado a partir de la receta #"+recetaMedica.getNumReceta());
                despachoFacade.create(tblDespacho);
                System.out.println("Numero despacho: "+tblDespacho.getNumDespacho());
                //Agregando la consulta
                TblDetalleDespacho detalleDespacho = null;
                TblDetalleDespachoPK pk = null;
                float total = 0.00F;
                for (TblDetalleReceta tblDetalleReceta : detalleRecetaList) {
                    //No deberiamos verificar si es contribuible o no
                    if (tblDetalleReceta.getNoContribuible()==null || tblDetalleReceta.getNoContribuible()){
                        detalleDespacho = new TblDetalleDespacho();
                        detalleDespacho.setCanDetDespacho(tblDetalleReceta.getCanDetReceta());
                        detalleDespacho.setEstDespacho(EstadoDetalleDespacho.RESERVADO);
                        pk = new TblDetalleDespachoPK();
                        pk.setNumDespacho(tblDespacho.getNumDespacho());
                        pk.setNumProducto(tblDetalleReceta.getTblProducto().getNumProducto());
                        detalleDespacho.setTblDetalleDespachoPK(pk);
                        detalleDespacho.setPreUniDetDespacho(0);
                        detalleDespachoFacade.create(detalleDespacho);
                    }
                }
           }
    }
}