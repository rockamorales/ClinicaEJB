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
import sv.com.cormaria.servicios.entidades.farmacia.TblDetalleIngresoProducto;
import sv.com.cormaria.servicios.entidades.farmacia.TblDetalleIngresoProductoPK;
import sv.com.cormaria.servicios.entidades.farmacia.TblIngresosProducto;
import sv.com.cormaria.servicios.exceptions.ClinicaModelValidationException;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblDetalleIngresoProductoFacade extends AbstractFacade<TblDetalleIngresoProducto> implements TblDetalleIngresoProductoFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TblDetalleIngresoProductoFacade() {
        super(TblDetalleIngresoProducto.class);
    }
    
   @Override
    public TblDetalleIngresoProducto create(TblDetalleIngresoProducto entity) throws ClinicaModelexception{
        try{
            getEntityManager().persist(entity);
            getEntityManager().flush();
            TblIngresosProducto tblIngresosProducto = em.find(TblIngresosProducto.class, entity.getTblDetalleIngresoProductoPK().getNumIngreso());
            tblIngresosProducto.setMonIngreso((float) this.getTotalIngreso(entity.getTblDetalleIngresoProductoPK().getNumIngreso()));
            TblProducto producto = em.find(TblProducto.class, entity.getTblDetalleIngresoProductoPK().getNumProducto());
            producto.setExiProducto(producto.getExiProducto()+entity.getCanDetIngreso());
            return entity;
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }


    @Override
    public List<TblDetalleIngresoProducto> findAll() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TblDetalleIngresoProducto> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    @Override
    public List<TblDetalleIngresoProducto> findByIngresoProducto(Integer numIngreso) throws ClinicaModelexception {
        try{
            Query q = em.createNamedQuery("TblDetalleIngresoProducto.findByIngresoProducto");
            q.setParameter("numIngreso", numIngreso);
            return q.getResultList();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    public Integer getMaxCorrelativo(TblDetalleIngresoProductoPK pk) throws ClinicaModelexception {
        try{
            Query q = em.createQuery("Select MAX(COR_DET_INGRESO) from TblDetalleIngresoProducto t where t.tblDetalleIngresoProductoPK = :pk");
            q.setParameter("pk", pk);
            return (Integer) q.getSingleResult();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    public float getTotalIngreso(Integer numIngreso) throws ClinicaModelexception {
        try{
            Query q = em.createQuery("Select sum(t.cosUniDetIngreso*t.canDetIngreso)  from TblDetalleIngresoProducto t where t.tblDetalleIngresoProductoPK.numIngreso = :numIngreso");
            q.setParameter("numIngreso", numIngreso);
            Double total = (Double) q.getSingleResult();
            if ( total== null){
                total=0.0;
            }
            return total.floatValue();
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }
    
    public void remove(TblDetalleIngresoProducto entity) throws ClinicaModelexception {
        try{
            
            getEntityManager().remove(this.find(entity.getTblDetalleIngresoProductoPK()));
            getEntityManager().flush();
            TblIngresosProducto tblIngresosProducto = em.find(TblIngresosProducto.class, entity.getTblDetalleIngresoProductoPK().getNumIngreso());
            tblIngresosProducto.setMonIngreso((float) this.getTotalIngreso(entity.getTblDetalleIngresoProductoPK().getNumIngreso()));
            TblProducto producto = em.find(TblProducto.class, entity.getTblDetalleIngresoProductoPK().getNumProducto());
            if(producto.getExiProducto() < entity.getCanDetIngreso()){
                throw new ClinicaModelValidationException("No se puede eliminar el ingreso debido a que ya se despacho producto: "+producto.getNomProducto());
            }
            producto.setExiProducto(producto.getExiProducto()-entity.getCanDetIngreso());
        }catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }        
    }
    
    
}
