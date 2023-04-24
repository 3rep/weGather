package com.gather.we.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import com.gather.we.service.Manager10Service;
import com.gather.we.dto.Criteria;
import com.gather.we.dto.Manager10DTO;

import com.gather.we.dto.PageDTO;

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
	 
	 @GetMapping("/manager2/manager10/{managerid}")
	 public ModelAndView getManagerPastByManagerId(@PathVariable("managerid") String managerid) {
	     ModelAndView mav = new ModelAndView();
	     List<Manager10DTO> managerList = service.selectManager10ByManagerid(managerid);
	     mav.addObject("managerList", managerList);
	     mav.setViewName("/manager2/manager10");
	     return mav;
	 }
	 
	 
	 @GetMapping("/static/style/managerNav")
	 public String getManagerNav() {
	     return "/static/style/manager/managerNav";
	 }
	 
	 
	 
	 
	 @GetMapping("manager2/manager10/list")
		public void manager10List(Criteria cri, Model model) {
		 Logger log = LoggerFactory.getLogger(getClass());
		 log.info("list: " +cri);
		 model.addAttribute("list", service.getList(cri));
		 model.addAttribute("pageMaker", new PageDTO(cri, 123));
	 }
	 
	 /*
			ModelAndView mav = new ModelAndView();
			System.out.println(1111);
			//총레코드 수를 구하기
			dto.setTotalRecord(service.totalRecord(dto));
			
			System.out.println("-"+dto.toString());
			//DB조회
			//해당 페이지 레코드 선택하기 
			mav.addObject("list" , service.pageSelect(dto));
			System.out.println(2222);
			mav.addObject("dto", dto);
			mav.setViewName("manager2/manager10");
			return mav;
		}
	 */
}
