package com.gather.we.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.ManagerPastDTO;
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
	 
}
