package com.gather.we.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.RegisterDTO;
import com.gather.we.service.RegisterService;


@Controller
public class RegisterController {
	@Autowired
	RegisterService service;
	//�α��� ���� â
	@GetMapping("/loginChoose")
	public String loginChoose() {
		return "user/register/loginChoose";	
	}
	
	//�α�����
	@GetMapping("/login")
	public String login() {
		return "user/register/login";	//	/WEB-INF/views/register/loginForm.jsp
	}
	
	//�α���(DB)
		@PostMapping("/loginOk")
		public ModelAndView loginOk(String userid, String password, HttpServletRequest request, HttpSession session) {
			// Session ��ü ������
			// �Ű������� HttpServletRequest request -> Session ���ϱ�
			// �Ű������� HttpSession session
			System.out.println("userid->"+userid);
			RegisterDTO dto = service.loginOk(userid, password);
			// dto->null�� ��� ���÷��ڵ尡 ����. -�α��ν���
			// 		null�� �ƴ� ��� ���÷��ڵ� �ִ�. - �α��� ����
			ModelAndView mav = new ModelAndView();
			if(dto!=null) {//�α��� ����
				session.setAttribute("logId", dto.getUserid());
				session.setAttribute("logName", dto.getUsername());
				session.setAttribute("logStatus", "Y");
				mav.setViewName("redirect:/");
			}else{//�α��� ����
				mav.setViewName("redirect:login");	
			}
			return mav;
		}
	
	//ȸ������ ���� â
	@GetMapping("/registerChoose")
	public String registerChoose() {
		return "user/register/registerChoose";	
	}
	//ȸ������ ��
	@GetMapping("/register")
	public String register() {
		return "user/register/register";
	}
	
	@RequestMapping(value="/registerOk", method=RequestMethod.POST)
	public ModelAndView registerOk(RegisterDTO dto) {
		System.out.println(dto.toString());
		
		ModelAndView mav = new ModelAndView();
		//ȸ������
		int result = service.registerInsert(dto);
		
		if(result>0) {//ȸ������ ������ - �α����� �̵�
			mav.setViewName("redirect:login");
		}else {//ȸ������ ���н�
			mav.addObject("msg", "ȸ����Ͻ����Ͽ����ϴ�.");
			mav.setViewName("user/register/registerOkResult");
		}
		return mav;		
	}
	//���̵� �ߺ��˻� ��
		@GetMapping("/idCheck")
		public String idCheck(String userid, Model model) {
			//��ȸ
			//���̵��� ���� ���ϱ� - 0,1
			int result = service.idCheckCount(userid);
			
			//�信�� ����ϱ� ���ؼ� �𵨿� ����
			model.addAttribute("userid", userid);
			model.addAttribute("result", result);
			
			return "user/register/idCheck";
		}
	
	//ȸ������ ����(db)
	@PostMapping("/userEditOk")
	public ModelAndView loginEditOk(RegisterDTO dto) {
		System.out.println(dto.toString());
		int cnt = service.registerEditOk(dto);
		ModelAndView mav = new ModelAndView();
		if(cnt>0) {
			mav.setViewName("redirect:admin/userList");
		}else {
			mav.addObject("msg", "ȸ���������� �����Ͽ����ϴ�.");
			mav.setViewName("user/register/registerOkResult");
		}
		return mav;
	}
	
	//�α׾ƿ� - ��������
		@RequestMapping("/logout")
		public ModelAndView logout(HttpSession session) {
			session.invalidate();
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/");
			return mav;
		}
}
