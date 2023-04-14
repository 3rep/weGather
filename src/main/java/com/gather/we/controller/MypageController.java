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
	
	@GetMapping("/mypage/applyList") //post�� �������°� �����ʳ�?
	public ModelAndView applyList() {
		//�α��ε� �������� Ȯ��
		//userid �޾ƿ;���
		
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("mypage/applyList");
		return mav;
	}
	
	@GetMapping("/mypage/info") //	mypage/${userid}/info  POST�� ��������
	public ____ joinEdit() {
		
	}

}
