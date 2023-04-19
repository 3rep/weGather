package com.gather.we.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.gather.we.service.Manager10Service;

import com.gather.we.dto.Manager10DTO;

@Controller
public class Manager10Controller {
	
	@Autowired
    Manager10Service service;
	
	 @GetMapping("/hobby/manager10")
	 public ModelAndView manager10Hobby() {
		    ModelAndView mav = new ModelAndView();
		    List<Manager10DTO> managerList = service.getAllManager10();
		    mav.addObject("managerList", managerList);
		    mav.setViewName("/hobby/manager10");
		    return mav;
		}
}
