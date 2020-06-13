package service_impl;

import dto.ExerciseListenDTO;
import dto.ListenGuidelineDTO;
import mother.MotherServiceImpl;
import persistence.entity.ExerciseListenEntity;
import service.ListenExerciseService;
import singleton.SingletonDao;
import singleton.SingletonService;
import uilts.Bean.ExerciseListenBeanUtil;

public class ListenExerciseServiceImpl extends MotherServiceImpl implements ListenExerciseService {
    public ListenExerciseServiceImpl(){
        generic_dao=SingletonDao.getExerciseListenDao();
        this.motherDTO=new ExerciseListenDTO();
        this.motherEntity=new ExerciseListenEntity();
        this.motherUtils=new ExerciseListenBeanUtil();
    }
}
