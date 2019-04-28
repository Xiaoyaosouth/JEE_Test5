package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AuthorizationInterceptor implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterCompletion()");
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle()");
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle()");
		String servletPath = arg0.getServletPath();
		if(servletPath.contains("/mylogin")
				|| servletPath.contains("/loginForm")) {
			System.out.println("ServletPath contains [mylogin] or [loginForm]");
			return true;
		}
		if(servletPath.contains("/myupload")) {
			System.out.println("ServletPath contains [upload]");
			return true;
		}
		String username = (String)arg0.getSession().getAttribute("userName");
		if(username == null) {
			arg0.getRequestDispatcher("loginForm").forward(arg0, arg1);
			System.out.println("返回loginForm，参数[userName]为null");
			return false;
		}else {
			System.out.println("允许跳转，参数[userName]不为null");
			return true;
		}
		
	}

}
