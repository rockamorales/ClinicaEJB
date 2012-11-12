/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import sv.com.cormaria.servicios.entidades.administracion.TblProducto;
import sv.com.cormaria.servicios.entidades.farmacia.TblHistorialAlerta;
import sv.com.cormaria.servicios.enums.Estado;
import sv.com.cormaria.servicios.enums.TipoAlertas;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;
import sv.com.cormaria.servicios.facades.farmacia.TblHistorialAlertaFacadeLocal;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblProductoFacade extends AbstractFacade<TblProducto> implements TblProductoFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;
    
    @Resource
    private SessionContext sessionContext;
    
    @EJB
    private TblHistorialAlertaFacadeLocal historialAlertaFacadeLocal;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TblProductoFacade() {
        super(TblProducto.class);
    }

    @Override
    public List<TblProducto> findAll() throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblProducto.findAll");
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    @Override
    public void desactivar(Integer numProducto) throws ClinicaModelexception{
        try{
            TblProducto benef = em.find(TblProducto.class, numProducto);
            benef.setEstProducto(numProducto=2);
        }catch(Exception x){
            x.printStackTrace();
            throw new ClinicaModelexception(x.getMessage(), x);
        }
    }

    @Override
    public List<TblProducto> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List<TblProducto> findByNombreProducto(String nomProducto, int firstRow, int maxResults) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblProdcuto.findByNombreProducto");
            q.setParameter("nomProducto", nomProducto);
            
            q.setFirstResult(firstRow);
            q.setMaxResults(maxResults);
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    public List<TblProducto> findActive() throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblProducto.findActive");
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }    
        
     public List<TblProducto> findAlertas() throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblProducto.findAlertas");
            q.setParameter("fecha", new java.util.Date(), TemporalType.DATE);
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
     
    public List<TblProducto> findActiveServices() throws ClinicaModelexception{
        try{
            Query q = em.createNamedQuery("TblProducto.findActiveServices");
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    public List<TblProducto> findTarjetaControl() throws ClinicaModelexception{
        try{
            Query q = em.createNamedQuery("TblProducto.findTarjetaControl");
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    public List<TblProducto> findMedicamentos() throws ClinicaModelexception{
        try{
            Query q = em.createNamedQuery("TblProducto.findMedicamentos");
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    public void generarAlertas() throws ClinicaModelexception{
        try{
            List<TblProducto> productosList = this.findAlertas();
            TblHistorialAlerta alerta;
            for (TblProducto tblProducto : productosList) {
                alerta = new TblHistorialAlerta();
                alerta.setCanProducto(tblProducto.getExiProducto());
                alerta.setEstAlerta(Estado.ACTIVO);
                alerta.setFecHorAlerta(new java.util.Date());
                alerta.setMinExistencias(tblProducto.getExiMinProducto());
                alerta.setNumProducto(tblProducto.getNumProducto());
                alerta.setTipAlerta(TipoAlertas.EXISTENCIA);
                alerta.setUsuAlertado(sessionContext.getCallerPrincipal().getName());
                alerta.setCanProducto(tblProducto.getExiProducto());
                historialAlertaFacadeLocal.create(alerta);
            }
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        } 
    }
}