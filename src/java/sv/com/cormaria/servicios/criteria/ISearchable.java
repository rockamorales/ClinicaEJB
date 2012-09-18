/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.com.cormaria.servicios.criteria;

import java.util.List;

/**
 *
 * @author romorales
 */
public interface ISearchable<T> {
    public List<T> find(SearchCriteria sc, int firstRow, int maxResults);
    public int count(SearchCriteria sc);
}
