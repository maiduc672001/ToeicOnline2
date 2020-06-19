package Controller.Admin;

import Command.UserCommand;
import Constant.WebConstant;
import utils.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = {"/admin-import-user.html"})
public class ImportUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserCommand command= FormUtil.populate(UserCommand.class,req);
        if(isImport(command)){
            detailImport(command,req,resp);
        }
    }
    private void detailImport(UserCommand command, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd=req.getRequestDispatcher("views/admin/user/import.jsp");
        rd.forward(req,resp);
    }

    private boolean isImport(UserCommand command) {
        return command.getUrlType()!=null&&command.getUrlType().equals(WebConstant.IMPORT);
    }
}
