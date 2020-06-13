package Controller.Web;

import Command.UserCommand;
import Constant.WebConstant;
import dto.LoginDTO;
import dto.UserDTO;
import session.SessionUtil;
import singleton.SingletonService;
import utils.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/login.html","/logout.html"})
public class Authentication_Controller extends HttpServlet {
    private final String LOGIN_LOGOUT="action";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action=req.getParameter(LOGIN_LOGOUT);
        if(action.equals(WebConstant.LOGIN)){
            RequestDispatcher rd=req.getRequestDispatcher("views/login.jsp");
            rd.forward(req,resp);
        }else if(action.equals(WebConstant.LOGOUT)){
            SessionUtil.removeSession(req,WebConstant.LOGIN_NAME);
            RequestDispatcher rd=req.getRequestDispatcher("views/web/home.jsp");
            rd.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserCommand command=FormUtil.populate(UserCommand.class,req);
        UserDTO dto=command.getPojo();
        if(dto!=null){
            String name=dto.getName();
            String password=dto.getPassword();
            LoginDTO loginDTO=SingletonService.getCheckLogin().checkLogin(name,password);
            if(loginDTO.isUserExist()){
                String roleName=loginDTO.getRoleName();
                SessionUtil.setSession(req,WebConstant.LOGIN_NAME,name);
                if(roleName.equals(WebConstant.ADMIN)) {
                    resp.sendRedirect("/admin-home.html");
                }else if(roleName.equals(WebConstant.USER)){
                    resp.sendRedirect("/home.html");
                }
            }else {
                req.setAttribute(WebConstant.ALERT,WebConstant.DANGER);
                req.setAttribute(WebConstant.MESSAGE_RESPONSE,WebConstant.ERROR);
                RequestDispatcher rd=req.getRequestDispatcher("views/login.jsp");
                rd.forward(req,resp);
            }
        }
    }
}
