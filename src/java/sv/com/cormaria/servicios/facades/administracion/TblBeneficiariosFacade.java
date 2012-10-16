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
import sv.com.cormaria.servicios.entidades.administracion.TblBeneficiarios;
import sv.com.cormaria.servicios.enums.Estado;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblBeneficiariosFacade extends AbstractFacade<TblBeneficiarios> implements TblBeneficiariosFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TblBeneficiariosFacade() {
        super(TblBeneficiarios.class);
    }
    
    @Override
    public TblBeneficiarios create(TblBeneficiarios entity) throws ClinicaModelexception{
        try{
            entity.setActBeneficiario(Estado.ACTIVO);
            getEntityManager().persist(entity);
            return entity;
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    } 

    @Override
    public List<TblBeneficiarios> findActive() throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblBeneficiarios.findActive");
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    @Override
    public List<TblBeneficiarios> findAll() throws ClinicaModelexception {
                try{
            Query q = em.createNamedQuery("TblBeneficiarios.findAll");
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public List<TblBeneficiarios> findRange(int[] range) throws ClinicaModelexception {
            try{
            Query q = em.createNamedQuery("TblBeneficiarios.findAll");
            q.setMaxResults(range[1] - range[0]);
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void desactivar(Integer numBeneficiario) throws ClinicaModelexception{
        try{
            TblBeneficiarios benef = em.find(TblBeneficiarios.class, numBeneficiario);
            benef.setActBeneficiario(Estado.INACTIVO);
        }catch(Exception x){
            x.printStackTrace();
            throw new ClinicaModelexception(x.getMessage(), x);
        }
    }
    }
    

