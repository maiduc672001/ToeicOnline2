package service_impl;

import dao.UserDao;
import dto.RoleDTO;
import dto.UserDTO;
import dtoInterface.MotherDTO;
import mother.MotherServiceImpl;
import persistence.entity.RoleEntity;
import persistence.entity.UserEntity;
import service.UserService;
import singleton.SingletonDao;
import singleton.SingletonService;
import uilts.Bean.UserBeanUtil;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserServiceImpl extends MotherServiceImpl implements UserService {
    public UserServiceImpl(){
        this.generic_dao=SingletonDao.getUserDao();
        this.motherDTO=new UserDTO();
        this.motherEntity=new UserEntity();
        this.motherUtils=new UserBeanUtil();
    }

    @Override
    public void save(MotherDTO motherDTO) {
        UserDTO userDTO=(UserDTO) motherDTO;
        RoleDTO roleDTO= (RoleDTO) SingletonService.getRoleService().findById(userDTO.getRoleId());
        userDTO.setRoleDTO(roleDTO);
        userDTO.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        UserEntity entity= (UserEntity) motherUtils.dtoToEntity(userDTO);
        generic_dao.save(entity);
    }

    @Override
    public void upDate(MotherDTO motherDTO) {
        UserDTO userDTO=(UserDTO) motherDTO;
        RoleDTO roleDTO= (RoleDTO) SingletonService.getRoleService().findById(userDTO.getRoleId());
        userDTO.setRoleDTO(roleDTO);
        userDTO.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        UserEntity entity= (UserEntity) motherUtils.dtoToEntity(userDTO);
        generic_dao.upDate(entity);
    }
    /*  @Override
    public UserDTO getUserByName(String name) {
        UserDao userDao= SingletonDao.getUserDao();
        UserEntity entity=userDao.getByName(name);
        return UserBeanUtil.entityToDTO(entity);
    }

    @Override
    public UserDTO findById(Integer id) {
        UserEntity entity=SingletonDao.getUserDao().findById(id);
        return UserBeanUtil.entityToDTO(entity);
    }

    @Override
    public List<UserDTO> findAll() {
        List<UserEntity> listUserEntity= SingletonDao.getUserDao().findAll();
        List<UserDTO> userDTOList=new ArrayList<UserDTO>();
        for (UserEntity item:listUserEntity) {
            UserDTO dto=UserBeanUtil.entityToDTO(item);
            userDTOList.add(dto);
        }
        return userDTOList;
    }

    @Override
    public void upDate(UserDTO userDTO) {
UserEntity entity=UserBeanUtil.dtoToEntity(userDTO);
SingletonDao.getUserDao().upDate(entity);
    }

    @Override
    public void save(UserDTO userDTO) {
        UserEntity entity=UserBeanUtil.dtoToEntity(userDTO);
        SingletonDao.getUserDao().save(entity);
    }

    @Override
    public Object[] findByProperties(Map<String, Object> properties, String sortDirection, String sortExpression, Integer first, Integer end) {
        Object[] objects=SingletonDao.getUserDao().findByProperties(properties,sortDirection,sortExpression,first,end);
        List<UserDTO> userDTOList=new ArrayList<UserDTO>();
        List<UserEntity> userEntities= (List<UserEntity>) objects[1];
        for (UserEntity item:userEntities){
            UserDTO dto=UserBeanUtil.entityToDTO(item);
            userDTOList.add(dto);
        }
        objects[1]=userDTOList;
        return objects;
    }

    @Override
    public Integer delete(List<Integer> ids) {
        return SingletonDao.getUserDao().delete(ids);
    }

    @Override
    public UserDTO findEqualUnique(String property, Object value) {
        UserDao userDao=SingletonDao.getUserDao();
       UserEntity userEntity=userDao.findEqualUnique(property,value);
       return UserBeanUtil.entityToDTO(userEntity);
    }*/
}
