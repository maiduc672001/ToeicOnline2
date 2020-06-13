package uilts.Bean;

import dto.RoleDTO;
import dto.UserDTO;
import dtoInterface.MotherDTO;
import entiryInterface.MotherEntity;
import persistence.entity.RoleEntity;
import persistence.entity.UserEntity;
import utilInterface.MotherUtils;

public class UserBeanUtil implements MotherUtils {
RoleBeanUtil roleBeanUtil=new RoleBeanUtil();
    public MotherDTO entityToDTO(MotherEntity userEntity1){
        UserEntity userEntity= (UserEntity) userEntity1;
        UserDTO userDTO=new UserDTO();
        if(userEntity!=null) {
            userDTO=new UserDTO();
            userDTO.setFullName(userEntity.getFullName());
            userDTO.setCreatedDate(userEntity.getCreatedDate());
            userDTO.setName(userEntity.getName());
            userDTO.setPassword(userEntity.getPassword());
            userDTO.setUserId(userEntity.getUserId());
            RoleDTO roleDTO = (RoleDTO) roleBeanUtil.entityToDTO(userEntity.getRoleEntity());
            userDTO.setRoleDTO(roleDTO);
        }
        return userDTO;
    }
    public  MotherEntity dtoToEntity(MotherDTO userDTO1){
        UserDTO userDTO= (UserDTO) userDTO1;
        UserEntity userEntity=null;
        if(userDTO!=null) {
            userEntity=new UserEntity();
            userEntity.setName(userDTO.getName());
            userEntity.setCreatedDate(userDTO.getCreatedDate());
            userEntity.setPassword(userDTO.getPassword());
            userEntity.setFullName(userDTO.getFullName());
            userEntity.setUserId(userDTO.getUserId());
            userEntity.setRoleEntity((RoleEntity) roleBeanUtil.dtoToEntity(userDTO.getRoleDTO()));
        }
        return userEntity;
    }
}
