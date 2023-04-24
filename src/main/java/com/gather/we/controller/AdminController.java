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
	//�α�����
			@GetMapping("/loginAdmin")
			public String loginAdmin() {
				return "admin/loginAdmin";	//	/WEB-INF/views/register/loginForm.jsp
			}
			
			//�α���(DB)
			@PostMapping("/loginAdminOk")
			public ModelAndView loginAdminOk(String adminid, String password, HttpServletRequest request, HttpSession session) {
				// Session ��ü ������
				// �Ű������� HttpServletRequest request -> Session ���ϱ�
				// �Ű������� HttpSession session
				System.out.println("admin->"+adminid);
				AdminDTO dto = service.loginAdminOk(adminid, password);
				// dto->null�� ��� ���÷��ڵ尡 ����. -�α��ν���
				// 		null�� �ƴ� ��� ���÷��ڵ� �ִ�. - �α��� ����
				ModelAndView mav = new ModelAndView();
				if(dto!=null) {//�α��� ����
					session.setAttribute("logId", dto.getAdminid());
					session.setAttribute("logName", dto.getAdmin_name());
					session.setAttribute("logStatus", "Y");
					mav.setViewName("redirect:/");
				}else{//�α��� ����
					mav.setViewName("redirect:loginAdmin");
					System.out.println(adminid);
					System.out.println(password);
				}
				return mav;
			}
			
			//(������ ������)ȸ�� ����Ʈ
			@GetMapping("admin/userList")
			public ModelAndView loginList() {
				ModelAndView mav = new ModelAndView();
				
				List<RegisterDTO> list = regservice.dataAllSelect();
				
				mav.addObject("list", list);
				mav.setViewName("admin/userList");
				
				return mav;
			}
			//(������ ������)ȸ������ ������
			@GetMapping("admin/userEdit/{userid}")
			public ModelAndView loginEdit(@PathVariable("userid") String userid) {
				RegisterDTO dto = regservice.registerEdit(userid);
				ModelAndView mav = new ModelAndView();
				mav.addObject("dto", dto);
				mav.setViewName("admin/userEdit");
				return mav;
			}
}
