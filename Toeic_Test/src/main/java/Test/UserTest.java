package Test;

import DaoImpl.RoleDaoImpl;
import DaoImpl.UserDaoImpl;
import dao.RoleDao;
import dao.UserDao;
import dto.UserDTO;
import mother.MotherDao;
import mother.MotherService;
import org.testng.annotations.Test;
import persistence.entity.RoleEntity;
import persistence.entity.UserEntity;
import service_impl.UserServiceImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.*;

public class UserTest {
    UserDao userDao=new UserDaoImpl();
    @Test
    public void testFindByID(){

        UserEntity entity=userDao.findById(1);
    }
    @Test
    public void testFindAll(){
        List<UserEntity> list=userDao.findAll();
    }
    @Test
    public void testSave(){
        UserEntity entity=new UserEntity();
        entity.setFullName("nguyennhatvy");
        entity.setPassword("123456");
        entity.setName("vy");
        RoleDao roleDao=new RoleDaoImpl();
        RoleEntity roleEntity=roleDao.findById(1);
        entity.setRoleEntity(roleEntity);
        Timestamp timestamp=new Timestamp(System.currentTimeMillis());
        entity.setCreatedDate(timestamp);
        userDao.save(entity);
    }
    @Test
    public void testUpdate(){
        UserEntity entity=userDao.findById(3);
        entity.setName("ducmaivy");
        userDao.upDate(entity);
    }
    @Test
    public void testDelete(){
        List<Integer> ids=new ArrayList<Integer>();
        ids.add(3);
        ids.add(4);
        int count=userDao.delete(ids);
    }
@Test
    public void testFindByProperties(){
        Map<String,Object> properties=new HashMap<String, Object>();
        properties.put("name","mai");
        Object[] objects=userDao.findByProperties(properties,null,null,null,null);
}
@Test
    public void testFindByName(){
    MotherService motherService=new UserServiceImpl();
    Object ob=motherService.getByName("duc");
UserDTO dto= (UserDTO) ob;
String a="";
}

}
