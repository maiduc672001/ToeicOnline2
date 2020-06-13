package service_impl;

import dto.ListenGuidelineDTO;
import mother.MotherServiceImpl;
import persistence.entity.ListenGuidelineEntity;
import service.ListenGuidelineService;
import singleton.SingletonDao;
import uilts.Bean.ListenGuidelineBeanUtil;

public class ListenGuidelineServiceImpl extends MotherServiceImpl implements ListenGuidelineService {
    public ListenGuidelineServiceImpl(){
        this.generic_dao= SingletonDao.getListenGuidelineDao();
        this.motherDTO=new ListenGuidelineDTO();
        this.motherEntity=new ListenGuidelineEntity();
        this.motherUtils=new ListenGuidelineBeanUtil();
    }
}
