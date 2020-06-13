package Command;

import command.AbstractCommand;
import dto.ExerciseListenDTO;

public class ExerciseCommand extends AbstractCommand<ExerciseListenDTO> {
    public ExerciseCommand(){
        this.pojo=new ExerciseListenDTO();
    }
}
