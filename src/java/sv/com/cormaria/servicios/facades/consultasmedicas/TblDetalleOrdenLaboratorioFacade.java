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
import sv.com.cormaria.servicios.entidades.consultasmedicas.TblDetalleOrdenLaboratorioPK;
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
    
    public void addDetalleOrdenLab(List<Integer> ids, Integer ordenLabId) throws ClinicaModelexception{
        Query q = em.createQuery("delete from TblDetalleOrdenLaboratorio t where t.tblDetalleOrdenLaboratorioPK.numOrdLaboratorio = :numOrdLaboratorio");
        q.setParameter("numOrdLaboratorio", ordenLabId);
        q.executeUpdate();
        TblDetalleOrdenLaboratorio detalleLab = null;
        TblDetalleOrdenLaboratorioPK pk = null;
        for (Integer integer : ids) {
            detalleLab = new TblDetalleOrdenLaboratorio();
            pk = new TblDetalleOrdenLaboratorioPK();
            pk.setCodExaMedico(integer);
            pk.setNumOrdLaboratorio(ordenLabId);
            detalleLab.setTblDetalleOrdenLaboratorioPK(pk);
            detalleLab.setObsDetLaboratorio("N/A");
            this.create(detalleLab);
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
