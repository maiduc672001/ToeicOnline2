package Generic;

import java.util.Map;

import java.io.Serializable;
import java.util.List;

public interface Generic_Dao<T,ID extends Serializable> {
    T findById(ID id);
    List<T> findAll();
    void upDate(T t);
    void save(T t);
    Object[] findByProperties(Map<String,Object> properties,String sortDirection,String sortExpression,Integer first,Integer end);
    Integer delete(List<Integer> ids);
    T findEqualUnique(String property,Object value);
    T getByName(String name);
}
