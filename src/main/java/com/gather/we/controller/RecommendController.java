package com.gather.we.controller;


import com.gather.we.dto.RecommendDTO;
import com.gather.we.service.RecommendService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecommendController {
    @Autowired
    RecommendService service;
    
    @GetMapping("/manager2/recommend")
    public ModelAndView recommendHobby() {
    	ModelAndView mav = new ModelAndView();
    	List<RecommendDTO> rl = service.getAllRecommend();
    	mav.addObject("rl", rl);
    	mav.setViewName("/manager/recommend");
    	return mav;
    	
    }
   
    
}
    