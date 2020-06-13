package session;

import javax.servlet.http.HttpServletRequest;

public class SessionUtil {
    public static void setSession(HttpServletRequest req,String name,Object object){
        req.getSession().setAttribute(name,object);
    }
    public static void removeSession(HttpServletRequest req,String name){
        req.getSession().removeAttribute(name);
    }
    public static Object  getSession(HttpServletRequest req,String name){
        return req.getSession().getAttribute(name);
    }
}
