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
import sv.com.cormaria.servicios.entidades.administracion.TblInstitucion;
import sv.com.cormaria.servicios.enums.Estado;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblInstitucionFacade extends AbstractFacade<TblInstitucion> implements TblInstitucionFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TblInstitucionFacade() {
        super(TblInstitucion.class);
    }

    @Override
    public List<TblInstitucion> findAll() throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblInstitucion.findAll");
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public List<TblInstitucion> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public TblInstitucion create(TblInstitucion entity) throws ClinicaModelexception{
        try{
            entity.setActInstitucion(Estado.ACTIVO);
            getEntityManager().persist(entity);
            return entity;
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    } 
    @Override
    public void desactivar(TblInstitucion entity) throws ClinicaModelexception{
        try{
            entity.setActInstitucion(Estado.INACTIVO);
            this.edit(entity);
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    } 
    @Override
    public List<TblInstitucion> findActive() throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblInstitucion.findActive");
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }     
}
