package sv.com.cormaria.servicios.criteria;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author romorales
 */
public interface SearchCriteria extends Serializable {
	public String createQuery();
	public String createCountQuery();
	public Map<String, Object> getParameters();
}

