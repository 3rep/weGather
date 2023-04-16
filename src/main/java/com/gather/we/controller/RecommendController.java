package com.gather.we.controller;

import com.gather.we.dao.RecommendDAO;
import com.gather.we.dto.RecommendDTO;
import com.gather.we.service.RecommendService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RecommendController {
    @Autowired
    RecommendService service;
    
    @GetMapping("/hobby/recommend")
    public ModelAndView recommendHobby() {
    	ModelAndView mav = new ModelAndView();
    	List<RecommendDTO> rl = service.getAllRecommend();
    	mav.addObject("rl", rl);
    	mav.setViewName("/hobby/recommend");
    	return mav;
    	
    }
    @GetMapping("/hobby/manager10")
    public ModelAndView manager10Hobby() {
    	ModelAndView = new ModelAndView();
    	List<Manager10DTO> ml = service.getAllManager10();
    	mav.addObject("ml", ml);
    	mav.setViewName("/hobby/manager10");
    	return mav;
    }
    
}
    