package uilts.Bean;

import dto.ExerciseListenDTO;
import dtoInterface.MotherDTO;
import entiryInterface.MotherEntity;
import persistence.entity.ExerciseListenEntity;
import persistence.entity.RoleEntity;
import utilInterface.MotherUtils;

public class ExerciseListenBeanUtil implements MotherUtils {
    @Override
    public MotherDTO entityToDTO(MotherEntity entity1) {
        ExerciseListenDTO dto=null;
        if(entity1!=null){
            dto=new ExerciseListenDTO();
            ExerciseListenEntity entity=(ExerciseListenEntity) entity1;
            dto.setName(entity.getName());
            dto.setCreatedDate(entity.getCreatedDate());
            dto.setModifiedDate(entity.getModifiedDate());
            dto.setExerciseListenId(entity.getExerciseListenId());
        }
        return dto;
    }

    @Override
    public MotherEntity dtoToEntity(MotherDTO dto1) {
        ExerciseListenEntity entity=null;
        if(dto1!=null){
            entity=new ExerciseListenEntity();
            ExerciseListenDTO dto=(ExerciseListenDTO) dto1;
            entity.setCreatedDate(dto.getCreatedDate());
            entity.setModifiedDate(dto.getModifiedDate());
            entity.setName(dto.getName());
            entity.setExerciseListenId(dto.getExerciseListenId());
        }
        return entity;
    }
}
