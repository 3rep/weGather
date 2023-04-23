package com.gather.we.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;
import com.gather.we.service.Manager10Service;

import com.gather.we.dto.Manager10DTO;
import com.gather.we.dto.PagingVO;

@Controller

public class Manager10Controller {
	
	@Autowired
    Manager10Service service;
	
	 @GetMapping("/manager2/manager10")
	 public ModelAndView manager10Manager2() {
		    ModelAndView mav = new ModelAndView();
		    List<Manager10DTO> managerList = service.getAllManager10();
		    mav.addObject("managerList", managerList);
		    mav.setViewName("/manager2/manager10");
		    return mav;
		}
	 
	 @GetMapping("/static/style/managerNav")
	 public String getManagerNav() {
	     return "/static/style/manager/managerNav";
	 }
	 
	 
	 
	 
	 @GetMapping("manager2/manager10/list")
		public ModelAndView manager10List(PagingVO vo) {
			
			ModelAndView mav = new ModelAndView();
			System.out.println(1111);
			//�ѷ��ڵ� ���� ���ϱ�
			vo.setTotalRecord(service.totalRecord(vo));
			
			System.out.println("-"+vo.toString());
			//DB��ȸ
			//�ش� ������ ���ڵ� �����ϱ� 
			mav.addObject("list" , service.pageSelect(vo));
			System.out.println(2222);
			mav.addObject("vo", vo);
			mav.setViewName("manager2/manager10");
			return mav;
		}
	 
}
