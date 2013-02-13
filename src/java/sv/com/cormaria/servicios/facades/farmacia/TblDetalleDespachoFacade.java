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
import sv.com.cormaria.servicios.entidades.farmacia.TblDespachos;
import sv.com.cormaria.servicios.entidades.farmacia.TblDetalleDespacho;
import sv.com.cormaria.servicios.exceptions.ClinicaModelValidationException;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblDetalleDespachoFacade extends AbstractFacade<TblDetalleDespacho> implements TblDetalleDespachoFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TblDetalleDespachoFacade() {
        super(TblDetalleDespacho.class);
    }

    @Override
    public List<TblDetalleDespacho> findAll() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TblDetalleDespacho> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<TblDetalleDespacho> findByDespachoProducto(Integer numDespacho) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblDetalleDespacho.findByDespachoProducto");
            q.setParameter("numDespacho", numDespacho);
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
        
    public float getTotalDespacho(Integer numDespacho) throws ClinicaModelexception {
        try{
            Query q = em.createQuery("Select sum(t.preUniDetDespacho*t.canDetDespacho)  from TblDetalleDespacho t where t.tblDetalleDespachoPK.numDespacho = :numDespacho");
            q.setParameter("numDespacho", numDespacho);
            Double total = (Double) q.getSingleResult();
            if ( total== null){
                total=0.0;
            }
            return total.floatValue();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    public void remove(TblDetalleDespacho entity) throws ClinicaModelexception {
        try{            
            getEntityManager().remove(this.find(entity.getTblDetalleDespachoPK()));
            getEntityManager().flush();
            TblDespachos tblDespachos = em.find(TblDespachos.class, entity.getTblDetalleDespachoPK().getNumDespacho());
            tblDespachos.setMonDespacho((float) this.getTotalDespacho(entity.getTblDetalleDespachoPK().getNumDespacho()));
            TblProducto producto = em.find(TblProducto.class, entity.getTblDetalleDespachoPK().getNumProducto());
            producto.setExiProducto(producto.getExiProducto()+entity.getCanDetDespacho());
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }        
    }
    
    @Override
    public TblDetalleDespacho create(TblDetalleDespacho entity) throws ClinicaModelexception{
        try{
            getEntityManager().persist(entity);
            getEntityManager().flush();
            TblDespachos tblDespachos = em.find(TblDespachos.class, entity.getTblDetalleDespachoPK().getNumDespacho());
            tblDespachos.setMonDespacho((float) this.getTotalDespacho(entity.getTblDetalleDespachoPK().getNumDespacho()));
            TblProducto producto = em.find(TblProducto.class, entity.getTblDetalleDespachoPK().getNumProducto());
            if(producto.getExiProducto() < entity.getCanDetDespacho()){
                throw new ClinicaModelValidationException("No hay Existencias Suficientes para la cantidad que desea despachar del producto: "+producto.getNomProducto() + "Cantidad en Existencia: "+producto.getExiProducto());
            }
            producto.setExiProducto(producto.getExiProducto()-entity.getCanDetDespacho());
            return entity;
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }   
}