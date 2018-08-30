package by.chmut.catalog.bean.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criteria<E> {

    private Class<E> groupSearchName;

    private Map<E, Object> criteria = new HashMap<E, Object>();

    public Criteria(Class<E> groupSearchName) {
        this.groupSearchName = groupSearchName;
    }

    public Class<E> getGroupSearchName(){
        return groupSearchName;
    }

    public void add(E searchCriteria, Object value) {
        criteria.put(searchCriteria, value);
    }

    public Map<E, Object> getCriteria() {
        return criteria;
    }
}
