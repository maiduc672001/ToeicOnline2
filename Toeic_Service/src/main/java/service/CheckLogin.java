package service;

import dto.LoginDTO;
import mother.MotherService;

public interface CheckLogin  {
    LoginDTO checkLogin(String name, String password);
}
