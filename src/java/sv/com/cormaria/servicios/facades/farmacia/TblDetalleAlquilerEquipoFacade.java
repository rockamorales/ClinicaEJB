/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.farmacia;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.farmacia.TblDetalleAlquilerEquipo;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblDetalleAlquilerEquipoFacade extends AbstractFacade<TblDetalleAlquilerEquipo> implements TblDetalleAlquilerEquipoFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TblDetalleAlquilerEquipoFacade() {
        super(TblDetalleAlquilerEquipo.class);
    }
    
    public List<TblDetalleAlquilerEquipo> findByNumSolAlquiler(Integer numSolAlquiler) throws ClinicaModelexception{
        try{
            Query q = em.createNamedQuery("TblDetalleAlquilerEquipo.findByNumSolAlquiler");
            q.setParameter("numSolAlquiler", numSolAlquiler);
            return q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public List<TblDetalleAlquilerEquipo> findAll() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TblDetalleAlquilerEquipo> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
