/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.colecturia;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.colecturia.TblComprobanteDonacion;
import sv.com.cormaria.servicios.entidades.colecturia.TblDetalleComprobanteDonacion;
import sv.com.cormaria.servicios.entidades.colecturia.TblDetalleComprobanteDonacionPK;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;
import sv.com.cormaria.servicios.helpers.NumToText;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblDetalleComprobanteDonacionFacade extends AbstractFacade<TblDetalleComprobanteDonacion> implements TblDetalleComprobanteDonacionFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;
    @EJB
    TblComprobanteDonacionFacadeLocal  comprobanteFacade;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TblDetalleComprobanteDonacionFacade() {
        super(TblDetalleComprobanteDonacion.class);
    }

    @Override
    public List<TblDetalleComprobanteDonacion> findAll() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TblDetalleComprobanteDonacion> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    
    public List<TblDetalleComprobanteDonacion> findByNumFacDonacion(String numFacDonacion) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblDetalleComprobanteDonacion.findByNumFacDonacion");
            q.setParameter("numFacDonacion", numFacDonacion);
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    } 
    
    public List<TblDetalleComprobanteDonacion> findByComprobanteDonacion(Integer numComprobanteDonacion) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblDetalleComprobanteDonacion.findByComprobanteDonacion");
            q.setParameter("numComDonacion", numComprobanteDonacion);
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    } 

    public double calcularTotal(Integer numComprobanteDonacion) throws ClinicaModelexception {
        try{
            System.out.println("numComprobanteDonacion:"+numComprobanteDonacion);
            Query q = em.createQuery("SELECT SUM(t.totIteComDonacion) FROM TblDetalleComprobanteDonacion t WHERE t.tblDetalleComprobanteDonacionPK.numComDonacion = :numComDonacion");
            q.setParameter("numComDonacion", numComprobanteDonacion);
            System.out.println("Resultado:"+q.getSingleResult());
            Double total = (Double)q.getSingleResult();
            if(total != null){
                return total;
            }
            return 0D;
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }    
    
    @Override
    public TblDetalleComprobanteDonacion create(TblDetalleComprobanteDonacion entity) throws ClinicaModelexception{
        try{
            //entity.setCorDetComDonacion(this.getMaxCorrelativo(entity.getTblDetalleComprobanteDonacionPK())+1);
            getEntityManager().persist(entity);
            em.flush();
            double total = this.calcularTotal(entity.getTblDetalleComprobanteDonacionPK().getNumComDonacion());
            TblComprobanteDonacion comprobante = comprobanteFacade.find(entity.getTblDetalleComprobanteDonacionPK().getNumComDonacion());
            comprobante.setCanLetras(NumToText.convertirLetras(total));
            comprobante.setTotDonacion((float)total);
            return entity;
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    } 
    @Override
    public void remove(TblDetalleComprobanteDonacion entity) throws ClinicaModelexception {
        try{
            getEntityManager().remove(getEntityManager().merge(entity));
            em.flush();
            double total = this.calcularTotal(entity.getTblDetalleComprobanteDonacionPK().getNumComDonacion());
            TblComprobanteDonacion comprobante = comprobanteFacade.find(entity.getTblDetalleComprobanteDonacionPK().getNumComDonacion());
            comprobante.setTotDonacion((float)total);
            comprobante.setCanLetras(NumToText.convertirLetras(total));
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }        
    }
    public Integer getMaxCorrelativo(TblDetalleComprobanteDonacionPK pk) throws ClinicaModelexception{
        try{
            Query q = em.createQuery("Select MAX(corDetComDonacion) from TblDetalleComprobanteDonacion t where t.tblDetalleComprobanteDonacionPK = :pk");
            q.setParameter("pk", pk);
            Integer max = (Integer) q.getSingleResult();
            System.out.println("Max: "+max);
            return max;
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
}
