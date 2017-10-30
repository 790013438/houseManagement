package snippets.jee.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle (HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        Integer userId = (Integer)httpServletRequest.getSession().getAttribute("userId");
        //Check if the current request is for /login. In that case 
        //do nothing, else we will execute the request in loop 
        //Intercept only if request is not /login
        String contextString = httpServletRequest.getContextPath();
        if (!(contextString + "/login").equals(httpServletRequest.getRequestURI()) 
                && !(contextString + "/home").equals(httpServletRequest.getRequestURI())
                && userId == null) {
            //User is not logged in. Redirect to /login
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/toLogin");
            //do not process this request further
            return false;
        }
        return true;
    }

}
