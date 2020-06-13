package Controller.Abstact;

import Constant.WebConstant;
import Utils.RequestUtil;
import command.AbstractCommand;
import dto.UserDTO;
import dtoInterface.MotherDTO;
import mother.MotherService;
import org.codehaus.jackson.map.ObjectMapper;
import singleton.SingletonService;
import utils.AjaxUtil;
import utils.FormUtil;
import utils.MessageResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class AbstractMethod {
    public static void findByProperties(Map<String, Object> properties, String sortDirection, String sortExpression, Integer first, Integer end, HttpServletRequest req, AbstractCommand command, MotherService service){
        command.setMaxPageItems(3);
        RequestUtil.initSearchBean(req,command);
        Object[] objects=service.findByProperties(properties,sortDirection,sortExpression,first,end);
        List<MotherDTO> list= (List<MotherDTO>) objects[0];
        command.setListResult(list);
        command.setTotalItems(Integer.parseInt(objects[1].toString()));
        if(command.getCrudaction()!=null){
            MessageResponse.getMessageResponse(req,command.getCrudaction());
        }
        req.setAttribute(WebConstant.ITEMS,command);
    }
    public static Map<String,Object> createMap(AbstractCommand command){
        Map<String,Object> map=new HashMap<String, Object>();

        return map;
    }
    public static void updateData(HttpServletRequest req, HttpServletResponse resp,Class tClass) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ObjectMapper objectMapper=new ObjectMapper();
        MotherDTO dto= (MotherDTO) AjaxUtil.of(req.getReader()).model(tClass);
        SingletonService.getUserService().upDate(dto);
        objectMapper.writeValue(resp.getOutputStream(),dto);
    }
    public static void saveData(HttpServletRequest req, HttpServletResponse resp,Class tClass) throws ServletException, IOException{
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ObjectMapper objectMapper=new ObjectMapper();
        MotherDTO dto= (MotherDTO) AjaxUtil.of(req.getReader()).model(tClass);
        SingletonService.getUserService().save(dto);
        objectMapper.writeValue(resp.getOutputStream(),dto);
    }
    public static void deleteData(HttpServletRequest req,HttpServletResponse resp,Class tClass)throws ServletException,IOException{
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        ObjectMapper mapper=new ObjectMapper();
        UserDTO dto= (UserDTO) AjaxUtil.of(req.getReader()).model(tClass);
        SingletonService.getUserService().delete(dto.getIds());
        mapper.writeValue(resp.getOutputStream(),dto);
    }
}
