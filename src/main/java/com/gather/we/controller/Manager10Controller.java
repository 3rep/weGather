package com.gather.we.controller;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.gather.we.service.Manager10Service;
import com.google.gson.JsonSyntaxException;
import com.gather.we.dto.Manager10DTO;


import com.gather.we.dto.PagingVO;

@Controller

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
		
	 /* @PostMapping("/manager2/managerInput")
	 public ModelAndView submitRank(@RequestBody List<Manager10DTO> managerList) {
	     ModelAndView mav = new ModelAndView();
	     try {
	         for (Manager10DTO managerInput : managerList) {
	             String userid = managerInput.getUserid();
	             int rank = Integer.parseInt(managerInput.getRank());
	             service.updateRank(userid, rank);
	            
	         }
	         mav.setViewName("redirect:/manager2/managerPast");
	     } catch (NumberFormatException | JsonSyntaxException e) {
	         mav.addObject("error", "Invalid input format");
	         mav.setViewName("errorPage");
	     } catch (Exception e) {
	         mav.addObject("error", "에러가 났습니다");
	         mav.setViewName("errorPage");
	     }
	     return mav;
	 }*/
	
	 @PostMapping("/manager2/managerInput")
	 public ModelAndView submitRank(@RequestBody List<Manager10DTO> managerList) {
	     ModelAndView mav = new ModelAndView();
	     try {
	         for (Manager10DTO managerInput : managerList) {
	             if (managerInput.getUserid() == null || managerInput.getUserid().trim().isEmpty()) {
	                 throw new IllegalArgumentException("Userid cannot be empty");
	             }
	             if (managerInput.getRank() == null) {
	                 throw new IllegalArgumentException("Rank cannot be null");
	             }
	             if (managerInput.isValid()) {
	                 managerInput.initialize(); // null 대응 코드 실행
	                 service.updateRank(managerInput.getUserid(), managerInput.getRank());
	             }
	         }
	         mav.setViewName("redirect:/manager2/managerPast");
	     } catch (IllegalArgumentException e) {
	         mav.addObject("error", e.getMessage());
	         mav.setViewName("errorPage");
	     } catch (Exception e) {
	         mav.addObject("error", "에러발생");
	         mav.setViewName("errorPage");
	     }
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
