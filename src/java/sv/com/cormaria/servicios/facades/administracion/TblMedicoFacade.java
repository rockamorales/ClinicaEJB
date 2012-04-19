/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.administracion;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.administracion.TblMedico;
import sv.com.cormaria.servicios.enums.Estado;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblMedicoFacade extends AbstractFacade<TblMedico> implements TblMedicoFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TblMedicoFacade() {
        super(TblMedico.class);
    }

    @Override
    public List<TblMedico> findAll() throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblMedico.findAll");
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public List<TblMedico> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void create(TblMedico entity) throws ClinicaModelexception{
        try{
            entity.setActMedico(Estado.ACTIVO);
            getEntityManager().persist(entity);
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    } 
    public void desactivar(TblMedico entity) throws ClinicaModelexception{
        try{
            entity.setActMedico(Estado.INACTIVO);
            this.edit(entity);
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }     
    
}
