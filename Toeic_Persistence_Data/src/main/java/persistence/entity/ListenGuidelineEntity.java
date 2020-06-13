package persistence.entity;

import entiryInterface.MotherEntity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "listenguideline")
public class ListenGuidelineEntity implements MotherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer listenGuidelineId;
    @Column(name = "content")
    private String content;
    @OneToOne
    @JoinColumn(name = "exerciselistenid")
    private ExerciseListenEntity exerciseListenEntity;
    @Column(name = "createddate")
    private Timestamp createdDate;

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

    public ExerciseListenEntity getExerciseListenEntity() {
        return exerciseListenEntity;
    }

    public void setExerciseListenEntity(ExerciseListenEntity exerciseListenEntity) {
        this.exerciseListenEntity = exerciseListenEntity;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }
}
