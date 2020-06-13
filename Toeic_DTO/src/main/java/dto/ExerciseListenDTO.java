package dto;

import dtoInterface.MotherDTO;

import java.sql.Timestamp;
import java.util.List;

public class ExerciseListenDTO implements MotherDTO {
    private Integer exerciseListenId;
    private String name;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private List<QuestionListenExeDTO> questionListenExeDTOList;
    private ListenGuidelineDTO listenGuidelineDTO;

    public Integer getExerciseListenId() {
        return exerciseListenId;
    }

    public void setExerciseListenId(Integer exerciseListenId) {
        this.exerciseListenId = exerciseListenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public List<QuestionListenExeDTO> getQuestionListenExeDTOList() {
        return questionListenExeDTOList;
    }

    public void setQuestionListenExeDTOList(List<QuestionListenExeDTO> questionListenExeDTOList) {
        this.questionListenExeDTOList = questionListenExeDTOList;
    }

    public ListenGuidelineDTO getListenGuidelineDTO() {
        return listenGuidelineDTO;
    }

    public void setListenGuidelineDTO(ListenGuidelineDTO listenGuidelineDTO) {
        this.listenGuidelineDTO = listenGuidelineDTO;
    }
}
