package Command;

import command.AbstractCommand;
import dto.ListenGuidelineDTO;

public class ListenGuidelineCommand extends AbstractCommand<ListenGuidelineDTO> {
    public ListenGuidelineCommand(){
        this.pojo=new ListenGuidelineDTO();
    }
}
