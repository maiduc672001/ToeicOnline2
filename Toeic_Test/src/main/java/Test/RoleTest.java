package Test;

import DaoImpl.ExerciseListenDaoImpl;
import DaoImpl.RoleDaoImpl;
import dao.ExerciseListenDao;
import dao.RoleDao;
import dto.RoleDTO;
import mother.MotherService;
import org.testng.annotations.Test;
import persistence.entity.ExerciseListenEntity;
import persistence.entity.RoleEntity;
import service.RoleService;
import service_impl.RoleServiceImpl;

public class RoleTest {
    @Test
    public void findByID(){
        RoleDao roleDao=new RoleDaoImpl();
        RoleEntity roleEntity=new RoleEntity();
        roleEntity=roleDao.findById(1);
    }
    @Test
    public void findByName() {
        MotherService motherService=new RoleServiceImpl();
        RoleDTO roleDTO= (RoleDTO) motherService.getByName("admin");
        String s="";
    }

}
