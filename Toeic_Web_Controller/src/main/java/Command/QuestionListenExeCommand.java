package Command;

import command.AbstractCommand;
import dto.QuestionListenExeDTO;

public class QuestionListenExeCommand extends AbstractCommand<QuestionListenExeDTO> {
    public QuestionListenExeCommand(){
        this.pojo=new QuestionListenExeDTO();
    }
}
