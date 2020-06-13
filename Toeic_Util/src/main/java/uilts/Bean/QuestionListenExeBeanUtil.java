package uilts.Bean;

import dto.ExerciseListenDTO;
import dto.QuestionListenExeDTO;
import dtoInterface.MotherDTO;
import entiryInterface.MotherEntity;
import persistence.entity.ExerciseListenEntity;
import persistence.entity.QuestionListenExeEntity;
import utilInterface.MotherUtils;

public class QuestionListenExeBeanUtil implements MotherUtils {
    ExerciseListenBeanUtil util=new ExerciseListenBeanUtil();
    @Override
    public MotherDTO entityToDTO(MotherEntity entity1) {
        QuestionListenExeDTO dto=null;
        if(entity1!=null){
            dto=new QuestionListenExeDTO();
            QuestionListenExeEntity entity=(QuestionListenExeEntity) entity1;
            dto.setAudio(entity.getAudio());
            dto.setCorrectAnswer(entity.getCorrectAnswer());
            dto.setExerciseListenDTO((ExerciseListenDTO) util.entityToDTO(entity.getExerciseListenEntity()));
            dto.setOption1(entity.getOption1());
            dto.setOption2(entity.getOption2());
            dto.setOption3(entity.getOption3());
            dto.setOption4(entity.getOption4());
            dto.setImage(entity.getImage());
            dto.setQuestionListenExeId(entity.getQuestionListenExeId());
            dto.setName(entity.getName());
            dto.setQuestion(entity.getQuestion());
            dto.setCreatedDate(entity.getCreatedDate());
            dto.setModifiedDate(entity.getModifiedDate());
        }
        return dto;
    }

    @Override
    public MotherEntity dtoToEntity(MotherDTO dto1) {
        QuestionListenExeEntity entity=null;
        if(dto1!=null){
            entity=new QuestionListenExeEntity();
            QuestionListenExeDTO dto=(QuestionListenExeDTO) dto1;
            entity.setAudio(dto.getAudio());
            entity.setCorrectAnswer(dto.getCorrectAnswer());
            entity.setExerciseListenEntity((ExerciseListenEntity) util.dtoToEntity(dto.getExerciseListenDTO()));
            entity.setOption1(dto.getOption1());
            entity.setOption2(dto.getOption2());
            entity.setOption3(dto.getOption3());
            entity.setOption4(dto.getOption4());
            entity.setImage(dto.getImage());
            entity.setQuestionListenExeId(dto.getQuestionListenExeId());
            entity.setName(dto.getName());
            entity.setQuestion(dto.getQuestion());
            entity.setCreatedDate(dto.getCreatedDate());
            entity.setModifiedDate(dto.getModifiedDate());
        }
        return entity;
    }
}
