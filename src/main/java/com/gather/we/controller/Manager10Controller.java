package com.gather.we.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
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
	 //�ƾƾ�
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
	 @GetMapping("/manager2/managerInput")
	 public ModelAndView managerInputManager2(@RequestParam(value = "rank", required = false) String rank) {
	     ModelAndView mav = new ModelAndView();
	     List<Manager10DTO> managerInputList;
	     if (rank != null) {
	         managerInputList = service.getAllManagerInputByRank(rank);
	     } else {
	         managerInputList = service.getAllManagerInput();
	     }
	     mav.addObject("managerInputList", managerInputList);
	     mav.setViewName("/manager2/managerInput");
	     return mav;
	 }
	 
	 @GetMapping("/manager2/managerPast")
	 public ModelAndView managerPastManager2() {
		    ModelAndView mav = new ModelAndView();
		    List<Manager10DTO> managerList = service.getAllManagerPast();
		    mav.addObject("managerList", managerList);
		    mav.setViewName("/manager2/managerPast");
		    return mav;
		}
	 @GetMapping("/manager2/managerPast/{managerid}")
	 public ModelAndView getManagerPastByManagerid(@PathVariable("managerid") String managerid) {
	     ModelAndView mav = new ModelAndView();
	     List<Manager10DTO> managerList = service.selectManagerPastByManagerid(managerid);
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
	 
	 @GetMapping("/manager2/entry")
	 public ModelAndView EntryManager2() {
		    ModelAndView mav = new ModelAndView();
		    List<Manager10DTO> entryList = service.getAllEntry();
		    mav.addObject("entryList", entryList);
		    mav.setViewName("/manager2/entry");
		    return mav;
		}
	 
}
