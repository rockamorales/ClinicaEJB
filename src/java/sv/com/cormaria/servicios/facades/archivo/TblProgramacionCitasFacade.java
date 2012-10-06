/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.archivo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.com.cormaria.servicios.entidades.archivo.TblProgramacionCitas;
import sv.com.cormaria.servicios.entidades.security.TblUsuarios;
import sv.com.cormaria.servicios.enums.EstadoProgramacionCitas;
import sv.com.cormaria.servicios.exceptions.ClinicaModelValidationException;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import sv.com.cormaria.servicios.facades.common.AbstractFacade;
import sv.com.cormaria.servicios.facades.security.TblUsuariosSessionFacade;
import sv.com.cormaria.servicios.facades.security.TblUsuariosSessionFacadeLocal;
import sv.com.cormaria.servicios.helpers.MonthDay;
import sv.com.cormaria.servicios.helpers.MonthWeek;

/**
 *
 * @author Mackk
 */
@Stateless
public class TblProgramacionCitasFacade extends AbstractFacade<TblProgramacionCitas> implements TblProgramacionCitasFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;

    @Resource
    SessionContext sessionContext;
    
    @EJB
    private TblUsuariosSessionFacadeLocal usuarioFacade;
    
    protected EntityManager getEntityManager() {
        return em;
    }

    public TblProgramacionCitasFacade() {
        super(TblProgramacionCitas.class);
    }
    
    @Override
    public TblProgramacionCitas create(TblProgramacionCitas entity) throws ClinicaModelexception{
        try{
            TblUsuarios usuario = usuarioFacade.findByCodigoUsuario(sessionContext.getCallerPrincipal().getName());
            if (usuario==null){
                throw new ClinicaModelValidationException("No se encontro informacion para la session actual del usuario: "+sessionContext.getCallerPrincipal().getName());
            }
            if (usuario.getNumEmpleado()==null && usuario.getNumEmpleado()<=0){
                throw new ClinicaModelValidationException("La informacion del usuario no tiene un codigo de empleado asociado: "+sessionContext.getCallerPrincipal().getName());                
            }
            entity.setNumEmpleado(usuario.getNumEmpleado());
            entity.setEstCita(EstadoProgramacionCitas.PROGRAMADA);
            getEntityManager().persist(entity);
            return entity;
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
    }

    @Override
    public TblProgramacionCitas edit(TblProgramacionCitas entity) throws ClinicaModelexception {
        try{
            return getEntityManager().merge(entity);
         }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }
   }

    @Override
    public void remove(TblProgramacionCitas entity) throws ClinicaModelexception {
        try{
            TblProgramacionCitas entity1 = em.find(TblProgramacionCitas.class, entity.getNumCita());
            entity1.setEstCita(EstadoProgramacionCitas.CANCELADA);
        }catch(Exception ex){
            throw new ClinicaModelexception(ex.getMessage(), ex);
        }        
    }    

    @Override
    public List<TblProgramacionCitas> findAll() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<TblProgramacionCitas> findRange(int[] range) throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int count() throws ClinicaModelexception {
        throw new UnsupportedOperationException("Not supported yet.");
    }    
    
    public Map<Date, MonthDay> findScheduleByRange(Date startDate, Date endDate) throws ClinicaModelexception{
        Map<Date, MonthDay> scheduleMap = new HashMap<Date, MonthDay>();
        Query q = em.createNamedQuery("TblProgramacionCitas.findByRange");
        q.setParameter("startDate", startDate);
        q.setParameter("endDate", endDate);
        List<TblProgramacionCitas> citasList = q.getResultList();
        //List<TblProgramacionCitas> daySchedule = new ArrayList<TblProgramacionCitas>();
        //Date oldDate = null;
        Calendar date;
        MonthDay current;
        int scheduleCount = 0;
        for (TblProgramacionCitas tblProgramacionCitas : citasList) {
            System.out.println("Num cita: "+tblProgramacionCitas.getNumCita());
            System.out.println("Nombres: "+tblProgramacionCitas.getExpediente().getNomPaciente());
            System.out.println("Fecha: "+tblProgramacionCitas.getFecCita());
            System.out.println("Hora: "+tblProgramacionCitas.getHorCita());
            date = Calendar.getInstance();
            date.setTime(tblProgramacionCitas.getFecCita());
            date.set(Calendar.HOUR, 0);
            date.set(Calendar.MINUTE, 0);
            date.set(Calendar.SECOND, 0);
            date.set(Calendar.MILLISECOND, 0);
            System.out.println("Fecha 1: "+date.getTime());
            //System.out.println("Old Date:"+oldDate);
            if (scheduleMap.containsKey(date.getTime())){
                current = scheduleMap.get(date.getTime());
                current.addCount();
                if (current.getScheduleCount() <= MonthDay.MAX_SCHEDULE_SHOW){
                    current.getCitas().add(tblProgramacionCitas);
                }
            }else{
                current = new MonthDay(new ArrayList<TblProgramacionCitas>(), 0);
                scheduleMap.put(date.getTime(), current);
                current.getCitas().add(tblProgramacionCitas);
                current.addCount();
            }
            //System.out.println("Count: "+scheduleCount);
            //if (oldDate == null || oldDate.compareTo(date.getTime())==0){
            //    if (scheduleCount<MonthDay.MAX_SCHEDULE_SHOW){
            //        daySchedule.add(tblProgramacionCitas);
            //    }
            //}else{
            //    scheduleMap.put(oldDate, new MonthDay(daySchedule, scheduleCount));
            //    daySchedule = new ArrayList<TblProgramacionCitas>();
            //    daySchedule.add(tblProgramacionCitas);
            //    scheduleCount = 1;
            //}
            //oldDate = date.getTime();
        }
        //scheduleMap.put(oldDate, new MonthDay(daySchedule, scheduleCount));
        return scheduleMap;
    }
}
