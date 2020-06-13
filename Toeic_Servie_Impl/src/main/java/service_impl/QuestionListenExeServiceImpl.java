package service_impl;

import dto.QuestionListenExeDTO;
import mother.MotherServiceImpl;
import persistence.entity.QuestionListenExeEntity;
import service.QuestionListenExeService;
import singleton.SingletonDao;
import uilts.Bean.QuestionListenExeBeanUtil;

public class QuestionListenExeServiceImpl extends MotherServiceImpl implements QuestionListenExeService {
    public QuestionListenExeServiceImpl(){
        this.generic_dao= SingletonDao.getQuestionListenExeDao();
        this.motherDTO=new QuestionListenExeDTO();
        this.motherEntity=new QuestionListenExeEntity();
        this.motherUtils=new QuestionListenExeBeanUtil();
    }
}
