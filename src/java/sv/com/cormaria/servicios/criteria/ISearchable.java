/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.criteria;

import java.util.List;
import java.util.Map;
import javax.persistence.Query;

/**
 *
 * @author romorales
 */
public interface ISearchable<T> {
    public List<T> find(SearchCriteria sc, int firstRow, int maxResults);
    public int count(SearchCriteria sc);
}
