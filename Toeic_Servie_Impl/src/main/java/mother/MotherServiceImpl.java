package mother;

import Generic.Generic_Dao;
import dtoInterface.MotherDTO;
import entiryInterface.MotherEntity;
import utilInterface.MotherUtils;

import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MotherServiceImpl implements MotherService {
protected MotherDTO motherDTO;
protected MotherUtils motherUtils;
protected Generic_Dao generic_dao;
protected MotherEntity motherEntity;
    @Override
    public MotherDTO getByName(String name) {
        Object object=generic_dao.getByName(name);
        if(object!=null){
            motherEntity= (MotherEntity) object;
            motherDTO=motherUtils.entityToDTO(motherEntity);
            return motherDTO;
        }
        return null;
    }

    @Override
    public MotherDTO findById(Integer id) {
        Object object=generic_dao.findById(id);
        if(object!=null){
            MotherEntity entity=(MotherEntity) object;
            MotherDTO dto=motherUtils.entityToDTO(entity);
            return dto;
        }
        return null;
    }

    @Override
    public List<MotherDTO> findAll() {
        List<MotherDTO> motherDTOS=generic_dao.findAll();
        return motherDTOS;

    }

    @Override
    public void upDate(MotherDTO userDTO) {
        MotherEntity entity=motherUtils.dtoToEntity(userDTO);
generic_dao.upDate(entity);
    }

    @Override
    public void save(MotherDTO userDTO) {
        MotherEntity entity=motherUtils.dtoToEntity(userDTO);
        generic_dao.save(entity);
    }

    @Override
    public Object[] findByProperties(Map<String, Object> properties, String sortDirection, String sortExpression, Integer first, Integer end) {
        Object[] objects=generic_dao.findByProperties(properties,sortDirection,sortExpression,first,end);
        List<MotherEntity> entityList= (List<MotherEntity>) objects[0];
        List<MotherDTO> dtoList=new ArrayList<MotherDTO>();
        for (MotherEntity entity:entityList) {
            MotherDTO dto=motherUtils.entityToDTO(entity);
            dtoList.add(dto);
        }
        objects[0]=dtoList;
        return objects;
    }

    @Override
    public Integer delete(List<Integer> ids) {
        return generic_dao.delete(ids);
    }

    @Override
    public MotherDTO findEqualUnique(String property, Object value) {
        return null;
    }
}
