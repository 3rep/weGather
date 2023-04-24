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

import com.gather.we.dto.Criteria;
import com.gather.we.dto.ManagerPastDTO;
import com.gather.we.dto.PageDTO;

import com.gather.we.service.ManagerPastService;

@Controller
public class ManagerPastController {

	@Autowired
    ManagerPastService service;
	
	 @GetMapping("/manager2/managerPast")
	 public ModelAndView managerPastManager2() {
		    ModelAndView mav = new ModelAndView();
		    List<ManagerPastDTO> managerList = service.getAllManagerPast();
		    mav.addObject("managerList", managerList);
		    mav.setViewName("/manager2/managerPast");
		    return mav;
		}
	 @GetMapping("/manager2/managerPast/{managerid}")
	 public ModelAndView getManagerPastByManagerId(@PathVariable("managerid") String managerid) {
	     ModelAndView mav = new ModelAndView();
	     List<ManagerPastDTO> managerList = service.selectManagerPastByManagerid(managerid);
	     mav.addObject("managerList", managerList);
	     mav.setViewName("/manager2/managerPast");
	     return mav;
	 }
	 
	 @GetMapping("manager2/managerPast/list")
		public void managerPastList(Criteria cri, Model model) {
		 Logger log = LoggerFactory.getLogger(getClass());
		 log.info("list: " +cri);
		 model.addAttribute("list", service.getList(cri));
		 model.addAttribute("pageMaker", new PageDTO(cri, 123));
	 
		}
}
