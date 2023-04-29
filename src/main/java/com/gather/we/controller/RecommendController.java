package com.gather.we.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RecommendController {
	
	@GetMapping("/recommend")
	public ModelAndView recommend() {
		ModelAndView mav = new ModelAndView();

		mav.setViewName("user/recommend/recommend");
		
		return mav;
	}
}
