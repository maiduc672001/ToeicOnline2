package persistence.entity;

import entiryInterface.MotherEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "exerciselisten")
public class ExerciseListenEntity implements MotherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer exerciseListenId;
    @Column(name = "name")
    private String name;
    @Column(name = "createddate")
    private Timestamp createdDate;
    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
    @OneToMany(mappedBy = "exerciseListenEntity", fetch = FetchType.LAZY)
    private List<QuestionListenExeEntity> questionListenExeEntityList;
    @OneToOne(mappedBy = "exerciseListenEntity")
    private ListenGuidelineEntity listenGuidelineEntity;

    public List<QuestionListenExeEntity> getQuestionListenExeEntityList() {
        return questionListenExeEntityList;
    }

    public void setQuestionListenExeEntityList(List<QuestionListenExeEntity> questionListenExeEntityList) {
        this.questionListenExeEntityList = questionListenExeEntityList;
    }

    public ListenGuidelineEntity getListenGuidelineEntity() {
        return listenGuidelineEntity;
    }

    public void setListenGuidelineEntity(ListenGuidelineEntity listenGuidelineEntity) {
        this.listenGuidelineEntity = listenGuidelineEntity;
    }

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
}
