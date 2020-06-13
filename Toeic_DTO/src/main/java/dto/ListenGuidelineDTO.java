package dto;

import dtoInterface.MotherDTO;

import java.sql.Timestamp;

public class ListenGuidelineDTO implements MotherDTO {
    private Integer listenGuidelineId;
    private String content;

    public Integer getListenGuidelineId() {
        return listenGuidelineId;
    }

    public void setListenGuidelineId(Integer listenGuidelineId) {
        this.listenGuidelineId = listenGuidelineId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ExerciseListenDTO getExerciseListenDTO() {
        return exerciseListenDTO;
    }

    public void setExerciseListenDTO(ExerciseListenDTO exerciseListenDTO) {
        this.exerciseListenDTO = exerciseListenDTO;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    private ExerciseListenDTO exerciseListenDTO;
    private Timestamp createdDate;
}
