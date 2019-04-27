package controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Controller
public class LoginController {
	
	/** 只有登录拦截器时使用
	@RequestMapping(value="/{formName}", method=RequestMethod.GET)
	public ModelAndView initView(@PathVariable String formName, ModelAndView mv) {
		mv.setViewName(formName);
		return mv;
	}
	*/
	
	@RequestMapping(value="/{formName}", method=RequestMethod.GET)
	public ModelAndView initView(@PathVariable String formName,
			String request_locale, HttpServletRequest request,
			ModelAndView mv) {
		if(request_locale != null) {
			if(request_locale.equals("zh_CN")) {
				Locale locale = new Locale("zh", "CN");
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
			}else {
				Locale locale = new Locale("en", "US");
				request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
			}
		}
		mv.setViewName(formName);
		return mv;
	}
	
	@RequestMapping("/mylogin")
	public ModelAndView loginMethod(@RequestParam(value="userName") String userName, 
			@RequestParam(value="password") String password, ModelAndView mv) {
		if(userName.equals("admin")
				&& password.equals("1234")) {
			System.out.println("验证成功");
			mv.addObject("msg", userName);
			mv.setViewName("welcome");
			//System.out.println(mv.getViewName());
			return mv;
		}else {
			System.out.println("用户名或密码错误");
			mv.addObject("msg", "用户名或密码错误");
			mv.setViewName("loginForm");
			return mv;
		}
	}
}
