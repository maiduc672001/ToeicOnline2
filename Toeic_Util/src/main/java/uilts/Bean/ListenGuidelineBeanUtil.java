package uilts.Bean;

import dto.ExerciseListenDTO;
import dto.ListenGuidelineDTO;
import dtoInterface.MotherDTO;
import entiryInterface.MotherEntity;
import persistence.entity.ExerciseListenEntity;
import persistence.entity.ListenGuidelineEntity;
import utilInterface.MotherUtils;

public class ListenGuidelineBeanUtil implements MotherUtils {
    ExerciseListenBeanUtil util=new ExerciseListenBeanUtil();
    @Override
    public MotherDTO entityToDTO(MotherEntity entity1) {
        ListenGuidelineDTO dto=null;
        if(entity1!=null){
            ListenGuidelineEntity entity=(ListenGuidelineEntity) entity1;
            dto.setContent(entity.getContent());
            dto.setCreatedDate(entity.getCreatedDate());
            dto.setExerciseListenDTO((ExerciseListenDTO) util.entityToDTO(entity.getExerciseListenEntity()));
            dto.setListenGuidelineId(entity.getListenGuidelineId());
        }
        return dto;
    }

    @Override
    public MotherEntity dtoToEntity(MotherDTO dto1) {
        ListenGuidelineEntity entity=null;
        if(dto1!=null){
            ListenGuidelineDTO dto=(ListenGuidelineDTO) dto1;
            entity.setContent(dto.getContent());
            entity.setCreatedDate(dto.getCreatedDate());
            entity.setExerciseListenEntity((ExerciseListenEntity) util.dtoToEntity(dto.getExerciseListenDTO()));
            entity.setListenGuidelineId(dto.getListenGuidelineId());
        }
        return entity;
    }
}
