package Command;

import command.AbstractCommand;
import dto.RoleDTO;
import dto.UserDTO;
import dtoInterface.MotherDTO;

import java.util.List;

public class UserCommand extends AbstractCommand<UserDTO> {
    private List<MotherDTO> roles;

    public List<MotherDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<MotherDTO> roles) {
        this.roles = roles;
    }

    public UserCommand(){
        this.pojo=new UserDTO();
    }
}
