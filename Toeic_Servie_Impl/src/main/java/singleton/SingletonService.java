package singleton;

import dao.ListenGuidelineDao;
import dao.QuestionListenExeDao;
import service.ListenExerciseService;
import service.ListenGuidelineService;
import service.QuestionListenExeService;
import service_impl.*;

public class SingletonService {
    private static RoleServiceImpl roleService;
    private static UserServiceImpl userService;
    private static CheckLoginImpl checkLogin;
    private static ListenExerciseService listenExerciseService;
    private static QuestionListenExeService questionListenExeService;
    private static ListenGuidelineService listenGuidelineService;
    public static ListenGuidelineService getListenGuidelineService(){
        if(listenGuidelineService==null){
            listenGuidelineService=new ListenGuidelineServiceImpl();
        }
        return listenGuidelineService;
    }
    public static ListenExerciseService getListenExerciseService(){
        if(listenExerciseService==null){
            listenExerciseService=new ListenExerciseServiceImpl();
        }
        return listenExerciseService;
    }
    public static QuestionListenExeService getQuestionListenExeService(){
        if(questionListenExeService==null){
            questionListenExeService=new QuestionListenExeServiceImpl();
        }
        return questionListenExeService;
    }
    public static RoleServiceImpl getRoleService(){
        if(roleService==null){
            roleService=new RoleServiceImpl();
        }
        return roleService;
    }
    public static UserServiceImpl getUserService(){
        if(userService==null){
            userService=new UserServiceImpl();
        }
        return userService;
    }
    public static CheckLoginImpl getCheckLogin(){
        if(checkLogin==null){
            checkLogin=new CheckLoginImpl();
        }
        return checkLogin;
    }
}
