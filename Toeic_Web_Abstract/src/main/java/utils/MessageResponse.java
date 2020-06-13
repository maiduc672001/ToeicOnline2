package utils;

import Constant.WebConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class MessageResponse {
    private static Map<String, String> setMap() {
        ResourceBundle bundle = ResourceBundle.getBundle("ResourceBundle");
        Map<String, String> map = new HashMap<String, String>();
        map.put(WebConstant.SAVE, bundle.getString("label.save.success"));
        map.put(WebConstant.DELETE, bundle.getString("label.delete.success"));
        map.put(WebConstant.UPDATE, bundle.getString("label.update.success"));
        map.put(WebConstant.ERROR, bundle.getString("label.error"));
        return map;
    }

    public static void getMessageResponse(HttpServletRequest req, String crudaction) {
        Map<String, String> map = MessageResponse.setMap();
        if (crudaction.equals(WebConstant.UPDATE)) {
            req.setAttribute(WebConstant.ALERT, WebConstant.SUCCESS);
            req.setAttribute(WebConstant.MESSAGE_RESPONSE, map.get(WebConstant.UPDATE));
        } else if (crudaction.equals(WebConstant.SAVE)) {
            req.setAttribute(WebConstant.ALERT, WebConstant.SUCCESS);
            req.setAttribute(WebConstant.MESSAGE_RESPONSE, map.get(WebConstant.SAVE));
        } else if (crudaction.equals(WebConstant.DELETE)) {
            req.setAttribute(WebConstant.ALERT, WebConstant.SUCCESS);
            req.setAttribute(WebConstant.MESSAGE_RESPONSE, map.get(WebConstant.DELETE));
        } else if (crudaction.equals(WebConstant.ERROR)) {
            req.setAttribute(WebConstant.ALERT, WebConstant.DANGER);
            req.setAttribute(WebConstant.MESSAGE_RESPONSE, map.get(WebConstant.ERROR));
        }
    }
}
