/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.com.cormaria.servicios.entidades.administracion.TblRequisiciones;
import sv.com.cormaria.servicios.enums.EstadoRequisicion;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblRequisicionesFacade extends AbstractFacade<TblRequisiciones> implements TblRequisicionesFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TblRequisicionesFacade() {
        super(TblRequisiciones.class);
    }
    
    @Override
    public void remove(TblRequisiciones requisicion) throws ClinicaModelexception {
        try{
            TblRequisiciones requisicion1 = this.find(requisicion.getNumRequisicion());
            requisicion1.setEstRequisicion(EstadoRequisicion.ELIMINADA);
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }        
    }
    
    @Override
    public void aprobar(TblRequisiciones requisicion) throws ClinicaModelexception {
        try{
            TblRequisiciones requisicion1 = this.find(requisicion.getNumRequisicion());
            requisicion1.setEstRequisicion(EstadoRequisicion.APROBADA);
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }        
    }
    @Override
    public void denegar(TblRequisiciones requisicion) throws ClinicaModelexception {
        try{
            TblRequisiciones requisicion1 = this.find(requisicion.getNumRequisicion());
            requisicion1.setEstRequisicion(EstadoRequisicion.DENEGADA);
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }        
    }
    
    @Override
    public void entregada(TblRequisiciones requisicion) throws ClinicaModelexception {
        try{
            TblRequisiciones requisicion1 = this.find(requisicion.getNumRequisicion());
            requisicion1.setEstRequisicion(EstadoRequisicion.ENTREGADA);
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }        
    }


    @Override
    public List<TblRequisiciones> findAll() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TblRequisiciones> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
