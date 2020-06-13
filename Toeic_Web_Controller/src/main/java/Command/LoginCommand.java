package Command;

import command.AbstractCommand;
import dto.LoginDTO;

public class LoginCommand extends AbstractCommand<LoginDTO> {
public LoginCommand(){
    this.pojo=new LoginDTO();
}
}
