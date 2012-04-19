package sv.com.cormaria.servicios.facades.security;
import java.util.List;

import javax.ejb.Local;
import sv.com.cormaria.servicios.entidades.security.CatUrlMenu;
import sv.com.cormaria.servicios.exceptions.ClinicaModelexception;


@Local
public interface UrlsmenuSessionFacadeLocal {
    public CatUrlMenu insert(CatUrlMenu u) throws ClinicaModelexception;
    public CatUrlMenu update(CatUrlMenu u) throws ClinicaModelexception;
    public CatUrlMenu findByPk(Long urlsmenuid) throws ClinicaModelexception;
    public void delete(Long urlsmenuid) throws ClinicaModelexception;
    public List<CatUrlMenu> findByCodigomenu(Long codigomenu) throws ClinicaModelexception;
}
