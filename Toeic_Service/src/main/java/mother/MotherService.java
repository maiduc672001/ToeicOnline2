package mother;

import dtoInterface.MotherDTO;

import java.util.List;
import java.util.Map;

public interface MotherService {
    MotherDTO getByName(String name);
    MotherDTO findById(Integer id);
    List<MotherDTO> findAll();
    void upDate(MotherDTO userDTO);
    void save(MotherDTO userDTO);
    Object[] findByProperties(Map<String,Object> properties, String sortDirection, String sortExpression, Integer first, Integer end);
    Integer delete(List<Integer> ids);
    MotherDTO findEqualUnique(String property, Object value);
}
