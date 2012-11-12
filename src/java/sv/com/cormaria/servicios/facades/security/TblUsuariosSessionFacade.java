/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.facades.security;

import sv.com.cormaria.servicios.exceptions.ClinicaModelValidationException;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.NoSuchEntityException;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Encoder;
import sv.com.cormaria.servicios.entidades.security.TblUsuarios;
import sv.com.cormaria.servicios.enums.EstadoUsuario;

/**
 *
 * @author Administrador
 */
@Stateless
public class TblUsuariosSessionFacade implements TblUsuariosSessionFacadeLocal {
    @PersistenceContext(unitName = "ClinicaEJBPU")
    private EntityManager em;
    
    @Resource
    private SessionContext sessionContext;

   /**
     * 
     * @param usuario
     * @return
     * @throws ClinicaModelexception 
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public TblUsuarios findByCodigoUsuarioWithMenu(String usuario) throws ClinicaModelexception{
    	try{
            Query q = em.createNamedQuery("TblUsuarios.findCodigoUsuario");
            q.setParameter("codigousuario", usuario);
            return (TblUsuarios) q.getSingleResult();
    	}catch (NoResultException e) {
            return null;
    	}catch(Exception ex){
            ex.printStackTrace();
            throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
    
    /**
     * 
     * @param usuario
     * @return
     * @throws ClinicaModelexception 
     */
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public TblUsuarios findByCodigoUsuario(String usuario) throws ClinicaModelexception{
    	try{
	    	Query q = em.createNamedQuery("TblUsuarios.findCodigoUsuario");
	    	q.setParameter("codigousuario", usuario);
	    	return (TblUsuarios) q.getSingleResult();
    	}catch(NoSuchEntityException ex){
            ex.printStackTrace();
            return null;
    	}catch(NoResultException ex){
            ex.printStackTrace();
            return null;
        }catch(EntityNotFoundException ex){
            ex.printStackTrace();
            return null;        
    	}catch(Exception ex){
    		ex.printStackTrace();
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public TblUsuarios cambiarContrasena(String codigoUsuario, String contrasenaAnt, String nuevaContrasena, String confContrasena) throws ClinicaModelexception{
    	try{
	    	TblUsuarios usuario = this.findByCodigoUsuario(codigoUsuario);
	    	if (((usuario.getConUsuario() == null) && (contrasenaAnt == null || contrasenaAnt.trim().equals("")))
	    			|| new BASE64Encoder().encode(Crypto.encrypt(contrasenaAnt)).equals(usuario.getConUsuario())){
	    		if (confContrasena.equals(nuevaContrasena)){
			    	usuario.setConUsuario(new BASE64Encoder().encode(Crypto.encrypt(nuevaContrasena)));
			    	usuario.setFecUltCamContrasena(new java.util.Date());
			    	return this.updateAll(usuario);
	    		}else{
	    			throw new ClinicaModelValidationException("La confirmacion de la contrasena no es igual a la contrasena ingresada");
	    		}
	    	}else{
    			throw new ClinicaModelValidationException("La contrasena anterior no es valida");
	    	}
    	}catch(ClinicaModelexception ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public TblUsuarios restablecerContrasena(String codigousuario, String contrasena, String confirmacion) throws ClinicaModelexception{
    	try{
	    	TblUsuarios usuario = this.findByCodigoUsuario(codigousuario);
    		if (confirmacion.equals(contrasena)){
		    	usuario.setConUsuario(new BASE64Encoder().encode(Crypto.encrypt(contrasena)));
		    	usuario.setFecUltCamContrasena(new java.util.Date());
		    	return this.updateAll(usuario);
    		}else{
    			throw new ClinicaModelValidationException("La confirmacion de la contrasena no es igual a la contrasena ingresada");
    		}
    	}catch(ClinicaModelexception ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public TblUsuarios create(TblUsuarios usuario) throws ClinicaModelexception{
    	try{
    		usuario.setCrePor(sessionContext.getCallerPrincipal().getName());
	    	usuario.setModPor(sessionContext.getCallerPrincipal().getName());
                usuario.setEstUsuario(EstadoUsuario.ACTIVO);
	    	if (usuario.getPasswordConfirmation()!=null && usuario.getConUsuario()!=null){
	    		if (usuario.getPasswordConfirmation().equals(usuario.getConUsuario())){
                                System.out.println("Tamanio de la contrasena: "+new BASE64Encoder().encode(Crypto.encrypt(usuario.getConUsuario())).length());
			    	usuario.setConUsuario(new BASE64Encoder().encode(Crypto.encrypt(usuario.getConUsuario())));
			    	usuario.setFecUltCamContrasena(new java.util.Date());
	    		}else{
	    			throw new ClinicaModelValidationException("La confirmacion de la contrasena no es igual a la contrasena ingresada");
	    		}
	    	}else{
	    		throw new ClinicaModelValidationException("Por favor ingrese la contrasena y su confirmacion");
	    	}
    		em.persist(usuario);
    		return usuario;
    	}catch(ClinicaModelValidationException ex){
    		throw ex;
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
    
    /**
     * 
     * @param usuario
     * @return
     * @throws ClinicaModelexception 
     */
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public TblUsuarios update(TblUsuarios usuario) throws ClinicaModelexception{
    	try{
	    	TblUsuarios oldUser = em.find(TblUsuarios.class, usuario.getNumUsuario());
	    	oldUser.setNomUsuario(usuario.getNomUsuario());
	    	oldUser.setAliUsuario(usuario.getAliUsuario());
	    	oldUser.setModPor(sessionContext.getCallerPrincipal().getName());
	    	oldUser.setFecExpiracion(usuario.getFecExpiracion());
	    	oldUser.setEstUsuario(usuario.getEstUsuario());
	    	return em.merge(oldUser);
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public TblUsuarios updateAll(TblUsuarios usuario) throws ClinicaModelexception{
    	try{
    		usuario.setModPor(sessionContext.getCallerPrincipal().getName());
	    	return em.merge(usuario);
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public TblUsuarios findUsuarioFrmByPk(Long usuariosid) throws ClinicaModelexception{
    	try{
    		return em.find(TblUsuarios.class, usuariosid);
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public TblUsuarios findUsuarioByPk(Long usuariosid) throws ClinicaModelexception{
    	try{
    		return em.find(TblUsuarios.class, usuariosid);
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
    
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void delete(TblUsuarios usuarios) throws ClinicaModelexception{
    	try{
    		em.remove(this.findUsuarioFrmByPk(usuarios.getNumUsuario()));
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void deactive(TblUsuarios usuarios) throws ClinicaModelexception{
    	try{
    		TblUsuarios oldUser = this.findUsuarioFrmByPk(usuarios.getNumUsuario());
    		oldUser.setEstUsuario(EstadoUsuario.INACTIVO);
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
    
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<TblUsuarios> findAllUsuariosByEstado(Integer estado) throws ClinicaModelexception{
    	try{
	    	Query q = em.createNamedQuery("TblUsuarios.findAllUsuariosByEstado");
	    	q.setParameter("estado", estado);
	    	return (List<TblUsuarios>)q.getResultList();
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<TblUsuarios> findAllUsuarios() throws ClinicaModelexception{
    	try{
	    	Query q = em.createNamedQuery("TblUsuarios.findAllUsuarios");
	    	return (List<TblUsuarios>)q.getResultList();
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
    
    @SuppressWarnings("unchecked")
    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<TblUsuarios> findAllActiveUsers() throws ClinicaModelexception{
    	try{
	    	Query q = em.createNamedQuery("TblUsuarios.findAllActiveUsers");
	    	return (List<TblUsuarios>)q.getResultList();
    	}catch(Exception ex){
    		throw new ClinicaModelexception(ex.getMessage(), ex);
    	}
    }
}
