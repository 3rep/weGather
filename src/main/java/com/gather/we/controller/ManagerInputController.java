package com.gather.we.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


import com.gather.we.dto.ManagerInputDTO;
import com.gather.we.service.ManagerInputService;

@Controller
public class ManagerInputController {

	@Autowired
    ManagerInputService service;
	
	 @GetMapping("/hobby/managerInput")
	 public ModelAndView managerInputHobby() {
		    ModelAndView mav = new ModelAndView();
		    List<ManagerInputDTO> managerInputList = service.getAllManagerInput();
		    mav.addObject("managerInputList", managerInputList);
		    mav.setViewName("/hobby/managerInput");
		    return mav;
		}
}
