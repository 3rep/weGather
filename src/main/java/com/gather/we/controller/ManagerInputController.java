package com.gather.we.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.gather.we.dto.ManagerInputDTO;
import com.gather.we.service.ManagerInputService;

@Controller
public class ManagerInputController {

	@Autowired
    ManagerInputService service;
		

@GetMapping("/manager2/managerInput")
public ModelAndView managerInputManager2(@RequestParam(value = "rank", required = false) String rank) {
    ModelAndView mav = new ModelAndView();
    List<ManagerInputDTO> managerInputList;
    if (rank != null) {
        managerInputList = service.getAllManagerInputByRank(rank);
    } else {
        managerInputList = service.getAllManagerInput();
    }
    mav.addObject("managerInputList", managerInputList);
    mav.setViewName("/manager2/managerInput");
    return mav;
}

}