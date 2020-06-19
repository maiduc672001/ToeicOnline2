package Controller.Admin;

import Command.UserCommand;
import Constant.WebConstant;
import Controller.Abstact.AbstractMethod;
import dto.RoleDTO;
import dto.UserDTO;
import dtoInterface.MotherDTO;
import mother.MotherService;
import org.codehaus.jackson.map.ObjectMapper;
import singleton.SingletonService;
import utils.AjaxUtil;
import utils.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@WebServlet(urlPatterns = {"/admin-list-user.html","/ajax-edit-user.html"})
public class User_Controller extends HttpServlet {
    private final String NAME_OF_USER="name";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserCommand command= FormUtil.populate(UserCommand.class,req);
        if(isUserList(command)) {
            detailList(command,req,resp);
        }else if(isUserEdit(command)){
            detailEdit(command,req,resp);
        }
    }




    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
AbstractMethod.updateData(req,resp,UserDTO.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AbstractMethod.saveData(req,resp,UserDTO.class);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
AbstractMethod.deleteData(req,resp,UserDTO.class);
    }

    private void detailEdit(UserCommand command, HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        if(command.getPojo().getUserId()!=null){
            update(command,req,resp);
        }else {
            save(command,req,resp);
        }
    }

    private void save(UserCommand command, HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        List<MotherDTO> list= SingletonService.getRoleService().findAll();
        command.setRoles(list);
        req.setAttribute(WebConstant.ITEM,command);
        RequestDispatcher rd=req.getRequestDispatcher("views/admin/user/edit.jsp");
        rd.forward(req,resp);
    }

    private void update(UserCommand command,HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        UserDTO dto= (UserDTO) SingletonService.getUserService().findById(command.getPojo().getUserId());
        command.setPojo(dto);
        List<MotherDTO> list= SingletonService.getRoleService().findAll();
        command.setRoles(list);
        req.setAttribute(WebConstant.ITEM,command);
        RequestDispatcher rd=req.getRequestDispatcher("views/admin/user/edit.jsp");
        rd.forward(req,resp);
    }


    private void detailList(UserCommand command, HttpServletRequest req,HttpServletResponse resp)throws ServletException, IOException {
        Map<String,Object>  properties=AbstractMethod.createMap(command);
        MotherService service= SingletonService.getUserService();
        AbstractMethod.findByProperties(properties,command.getSortDirection(),command.getSortExpression(),command.getFirstItem(),command.getMaxPageItems(),req,command,service);

        RequestDispatcher rd = req.getRequestDispatcher("views/admin/user/list.jsp");
        rd.forward(req,resp);
    }


    private boolean isUserEdit(UserCommand command) {
        return command.getUrlType()!=null&&command.getUrlType().equals(WebConstant.EDIT);

    }

    private boolean isUserList(UserCommand command) {
        return command.getUrlType()!=null&&command.getUrlType().equals(WebConstant.LIST);
    }
}
