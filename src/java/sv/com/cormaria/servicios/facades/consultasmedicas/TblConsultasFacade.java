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
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblConsultas;
import sv.com.cormaria.servicios.enums.EstadoConsultas;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblConsultasFacade extends AbstractFacade<TblConsultas> implements TblConsultasFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

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
    }
    
}
