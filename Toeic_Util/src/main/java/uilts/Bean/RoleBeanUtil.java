package uilts.Bean;

import dto.RoleDTO;
import dtoInterface.MotherDTO;
import entiryInterface.MotherEntity;
import persistence.entity.RoleEntity;
import utilInterface.MotherUtils;

public class RoleBeanUtil implements MotherUtils {
    public MotherDTO entityToDTO(MotherEntity roleEntity1){
        RoleDTO roleDTO=null;
        if(roleEntity1!=null) {
            roleDTO=new RoleDTO();
            RoleEntity roleEntity = (RoleEntity) roleEntity1;
            roleDTO.setName(roleEntity.getName());
            roleDTO.setPassword(roleEntity.getPassword());
            roleDTO.setRoleId(roleEntity.getRoleId());
        }
        return roleDTO;
    }
    public  MotherEntity dtoToEntity(MotherDTO roleDTO1){
        RoleEntity roleEntity=null;
        if(roleDTO1!=null) {
            roleEntity=new RoleEntity();
            RoleDTO roleDTO= (RoleDTO) roleDTO1;
            roleEntity.setName(roleDTO.getName());
            roleEntity.setPassword(roleDTO.getPassword());
            roleEntity.setRoleId(roleDTO.getRoleId());
        }
        return roleEntity;
    }
}
