package singleton;

import DaoImpl.*;
import dao.*;

public class SingletonDao {
    private static UserDao userDao;
    private static RoleDao roleDao;
    private static ListenGuidelineDao listenGuidelineDao;
    private static ExerciseListenDao exerciseListenDao;
    private static QuestionListenExeDao questionListenExeDao;
    public static ListenGuidelineDao getListenGuidelineDao(){
        if(listenGuidelineDao==null){
            listenGuidelineDao=new ListenGuidelineDaoImpl();
        }
        return listenGuidelineDao;
    }
    public static QuestionListenExeDao getQuestionListenExeDao(){
        if(questionListenExeDao==null){
            questionListenExeDao=new QuestionListenExeDaoImpl();
        }
        return questionListenExeDao;
    }
    public static ExerciseListenDao getExerciseListenDao(){
        if(exerciseListenDao==null){
            exerciseListenDao=new ExerciseListenDaoImpl();
        }
        return exerciseListenDao;
    }
    public static UserDao getUserDao(){
        if(userDao==null){
            userDao=new UserDaoImpl();
        }
        return userDao;
    }
    public static RoleDao getRoleDao(){
        if(roleDao==null){
            roleDao=new RoleDaoImpl();
        }
        return roleDao;
    }
}
