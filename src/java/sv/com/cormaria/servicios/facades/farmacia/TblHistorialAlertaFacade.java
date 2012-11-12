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
import sv.com.cormaria.servicios.entidades.administracion.TblProducto;
import sv.com.cormaria.servicios.entidades.farmacia.TblHistorialAlerta;
import sv.com.cormaria.servicios.enums.Estado;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblHistorialAlertaFacade extends AbstractFacade<TblHistorialAlerta> implements TblHistorialAlertaFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TblHistorialAlertaFacade() {
        super(TblHistorialAlerta.class);
    }

    @Override
    public List<TblHistorialAlerta> findAll() throws ClinicaModelexception {
           	try{
	    	Query q = em.createNamedQuery("TblHistorialAlerta.findAll");
	    	return (List<TblHistorialAlerta>)q.getResultList();
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
    
     @Override
    public List<TblHistorialAlerta> findActive() throws ClinicaModelexception {
           	try{
	    	Query q = em.createNamedQuery("TblHistorialAlerta.findActive");
	    	return (List<TblHistorialAlerta>)q.getResultList();
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
     
    @Override
    public List<TblHistorialAlerta> findInactive() throws ClinicaModelexception {
           	try{
	    	Query q = em.createNamedQuery("TblHistorialAlerta.findInactive");
	    	return (List<TblHistorialAlerta>)q.getResultList();
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }

    @Override
    public List<TblHistorialAlerta> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public void deactive(TblHistorialAlerta alertas) throws ClinicaModelexception{
    	try{
    		TblHistorialAlerta oldAlerta = this.findAlertaFrmByPk(alertas.getNumAlerta());
    		oldAlerta.setEstAlerta(Estado.ACTIVO);
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}    
    }
    
    @Override
    public TblHistorialAlerta findAlertaFrmByPk(Integer alertasid) throws ClinicaModelexception{
    	try{
    		return em.find(TblHistorialAlerta.class, alertasid);
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
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
    
}
