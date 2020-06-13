package service_impl;

import dto.RoleDTO;
import dtoInterface.MotherDTO;
import mother.MotherServiceImpl;
import persistence.entity.RoleEntity;
import service.RoleService;
import singleton.SingletonDao;
import uilts.Bean.RoleBeanUtil;

public class RoleServiceImpl extends MotherServiceImpl implements RoleService{
    public RoleServiceImpl(){
        this.generic_dao= SingletonDao.getRoleDao();
        this.motherDTO=new RoleDTO();
        this.motherEntity=new  RoleEntity();
        this.motherUtils=new RoleBeanUtil();
    }

}
