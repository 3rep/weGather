package com.gather.we;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";
	}
	//메인test
	/*
	 * @GetMapping("/home22") public String loginChoose() { return "/home22";
	 }*/
	
	//시작하기 누르면 입장하는 화면(비로그인 상태) 
	@GetMapping("/userHome_unlogin")
	public String userHome_unLogin() {
		return "/user/userHome_unlogin";
	}
	
	//로그인한 경우 로고 누를떄 뜨는 메인화면
	@GetMapping("/userHome")
	public ModelAndView userHome(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String logName = (String)session.getAttribute("logName");
		mav.addObject(logName);
		mav.setViewName("user/userHome");
		return mav;
	}
}
