package com.gather.we.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.AdminDTO;
import com.gather.we.dto.RegisterDTO;
import com.gather.we.service.AdminService;
import com.gather.we.service.RegisterService;

@Controller
public class AdminController {
	@Autowired
	AdminService service;
	
	@Autowired
	RegisterService regservice;
	//로그인폼
			@GetMapping("/loginAdmin")
			public String loginAdmin() {
				return "admin/loginAdmin";	//	/WEB-INF/views/register/loginForm.jsp
			}
			
			//로그인(DB)
			@PostMapping("/loginAdminOk")
			public ModelAndView loginAdminOk(String adminid, String password, HttpServletRequest request, HttpSession session) {
				// Session 객체 얻어오기
				// 매개변수로 HttpServletRequest request -> Session 구하기
				// 매개변수로 HttpSession session
				System.out.println("admin->"+adminid);
				AdminDTO dto = service.loginAdminOk(adminid, password);
				// dto->null인 경우 선택레코드가 없다. -로그인실패
				// 		null이 아닌 경우 선택레코드 있다. - 로그인 성공
				ModelAndView mav = new ModelAndView();
				if(dto!=null) {//로그인 성공
					session.setAttribute("logId", dto.getAdminid());
					session.setAttribute("logName", dto.getAdmin_name());
					session.setAttribute("logStatus", "Y");
					mav.setViewName("redirect:/");
				}else{//로그인 실패
					mav.setViewName("redirect:loginAdmin");
					System.out.println(adminid);
					System.out.println(password);
				}
				return mav;
			}
			
			//(관리자 페이지)회원 리스트
			@GetMapping("admin/userList")
			public ModelAndView loginList() {
				ModelAndView mav = new ModelAndView();
				
				List<RegisterDTO> list = regservice.dataAllSelect();
				
				mav.addObject("list", list);
				mav.setViewName("admin/userList");
				
				return mav;
			}
			//(관리자 페이지)회원정보 수정폼
			@GetMapping("admin/userEdit/{userid}")
			public ModelAndView loginEdit(@PathVariable("userid") String userid) {
				RegisterDTO dto = regservice.registerEdit(userid);
				ModelAndView mav = new ModelAndView();
				mav.addObject("dto", dto);
				mav.setViewName("admin/userEdit");
				return mav;
			}
}
