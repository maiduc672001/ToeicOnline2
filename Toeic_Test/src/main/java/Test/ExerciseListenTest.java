package Test;

import DaoImpl.ExerciseListenDaoImpl;
import dao.ExerciseListenDao;
import org.testng.annotations.Test;
import persistence.entity.ExerciseListenEntity;

public class ExerciseListenTest {
    @Test
    public void findById(){
        ExerciseListenDao dao=new ExerciseListenDaoImpl();
        ExerciseListenEntity exerciseListenEntity=new ExerciseListenEntity();
        exerciseListenEntity=dao.findById(1);
    }
}
