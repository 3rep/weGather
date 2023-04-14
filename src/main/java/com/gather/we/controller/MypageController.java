package com.gather.we.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.service.MypageService;


@RestController
public class MypageController {
	
	@Autowired
	MypageService service;
	
	@GetMapping("/mypage/applyList") //post로 가져오는게 맞지않나?
	public ModelAndView applyList() {
		//로그인된 상태인지 확인
		//userid 받아와야해
		
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("mypage/applyList");
		return mav;
	}
	
	@GetMapping("/mypage/info") //	mypage/${userid}/info  POST로 가져오기
	public ____ joinEdit() {
		
	}

}
