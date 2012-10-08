/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.consultasmedicas;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblDetalleOrdenLaboratorio;
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblOrdenLaboratorio;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblDetalleOrdenLaboratorioFacade extends AbstractFacade<TblDetalleOrdenLaboratorio> implements TblDetalleOrdenLaboratorioFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TblDetalleOrdenLaboratorioFacade() {
        super(TblDetalleOrdenLaboratorio.class);
    }

    public List<TblDetalleOrdenLaboratorio> findByNumOrdenLaboratorio(Integer numOrdLaboratorio) throws ClinicaModelexception{
        try{
            Query q = em.createNamedQuery("TblDetalleOrdenLaboratorio.findByNumOrdenLaboratorio");
            q.setParameter("numOrdLaboratorio", numOrdLaboratorio);
            return  q.getResultList();
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    @Override
    public List<TblDetalleOrdenLaboratorio> findAll() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TblDetalleOrdenLaboratorio> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
