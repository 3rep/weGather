package com.gather.we.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.gather.we.service.Manager10Service;

import com.gather.we.dto.Manager10DTO;


import com.gather.we.dto.PagingVO;

@Controller
//@RequestMapping("/manager2")
public class Manager10Controller {
	
@Autowired
   Manager10Service service;
@GetMapping("/manager2/manager10")
public ModelAndView getManager10(PagingVO vo) {
	   
		ModelAndView mav = new ModelAndView();
		System.out.println(vo.getStartPageNum());
				
	    vo.setTotalRecord(service.totalRecord(vo));
	  	    
	    mav.addObject("managerList", service.pageSelect(vo));
	    mav.addObject("vo", vo);
	    
	    mav.setViewName("/manager2/manager10");
	    return mav;
	}
	@GetMapping("/manager2/managerPast")
	public ModelAndView getManagerPast(PagingVO vo) {
		ModelAndView mav = new ModelAndView();
		vo.setTotalRecord(service.totalRecord(vo));
	  
	    mav.addObject("managerList", service.pageSelect(vo));
	    mav.addObject("vo", vo);
	    mav.setViewName("/manager2/managerPast");
    return mav;
}


	 
	 @GetMapping("/static/style/managerNav")
	 public String getManagerNav() {
	     return "/static/style/manager/managerNav";
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
	 

	
	 
	 
	 @GetMapping("/manager2/entry")
	 public ModelAndView EntryManager2() {
		    ModelAndView mav = new ModelAndView();
		    List<Manager10DTO> entryList = service.getAllEntry();
		    mav.addObject("entryList", entryList);
		    mav.setViewName("/manager2/entry");
		    return mav;
		}
	 
}
