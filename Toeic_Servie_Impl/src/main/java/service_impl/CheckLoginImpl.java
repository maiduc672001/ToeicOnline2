package service_impl;

import dto.LoginDTO;
import dto.UserDTO;
import mother.MotherServiceImpl;
import service.CheckLogin;
import service.UserService;
import singleton.SingletonDao;
import singleton.SingletonService;
import uilts.Bean.UserBeanUtil;

public class CheckLoginImpl  implements CheckLogin{

    @Override
    public LoginDTO checkLogin(String name, String password) {
UserService userService= SingletonService.getUserService();
        Object object=  userService.getByName(name);
        LoginDTO dto = new LoginDTO();
        if(object!=null) {
            UserDTO userDTO= (UserDTO) object;
            if (equalsPassword(userDTO, password)) {
                dto.setUserExist(true);
                dto.setUserName(name);
                dto.setRoleName(userDTO.getRoleDTO().getName());
            } else {
                dto.setUserExist(false);
            }
        }else {
            dto.setUserExist(false);
        }
        return dto;
    }

    private boolean equalsPassword(UserDTO userDTO, String password) {
        return userDTO!=null&&userDTO.getPassword().equals(password);
    }
}
