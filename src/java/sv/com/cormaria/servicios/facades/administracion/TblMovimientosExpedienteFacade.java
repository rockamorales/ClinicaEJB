/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.administracion.TblMovimientosExpediente;
import sv.com.cormaria.servicios.entidades.archivo.TblExpedientePacientes;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblMovimientosExpedienteFacade extends AbstractFacade<TblMovimientosExpediente> implements TblMovimientosExpedienteFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TblMovimientosExpedienteFacade() {
        super(TblMovimientosExpediente.class);
    }
    
    public TblMovimientosExpediente findLastRegistry(Integer numExpediente) throws ClinicaModelexception{
        try{
            Query q = em.createNamedQuery("TblMovimientosExpediente.findLastRecord");
            q.setParameter("numExpediente", numExpediente);
            return (TblMovimientosExpediente) q.getSingleResult();
        }catch(NoResultException ex){
            return null;
        }catch(EntityNotFoundException ex){
            return null;
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    public TblMovimientosExpediente generarMovimiento(TblExpedientePacientes tblExpediente, TblMovimientosExpediente movimientoExp, Integer numEmpleado) throws ClinicaModelexception{
        try{
            TblMovimientosExpediente lastMove = this.findLastRegistry(tblExpediente.getNumExpediente());
            movimientoExp.setNumEmpleado(numEmpleado);
            movimientoExp.setNumExpediente(tblExpediente.getNumExpediente());
            if (lastMove != null){
                movimientoExp.setCodArea(lastMove.getCatCodArea());
            }else{
                movimientoExp.setCodArea(1);
            }
            this.create(movimientoExp);
            return movimientoExp;
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    public List<TblMovimientosExpediente> findByNumExpediente(Integer numExpediente) throws ClinicaModelexception{
        try{
            Query q = em.createNamedQuery("TblMovimientosExpediente.findByNumExpediente");
            q.setParameter("numExpediente", numExpediente);
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public List<TblMovimientosExpediente> findAll() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TblMovimientosExpediente> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
