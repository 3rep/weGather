package com.gather.we.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class MypageController {
	
	@GetMapping("/mypage/applyList") //post�� �������°� �����ʳ�?
	public ModelAndView applyList() {
		//�α��ε� �������� Ȯ��
		//userid �޾ƿ;���
		
		ModelAndView mav = new ModelAndView(); 
		mav.setViewName("mypage/applyList");
		return mav;
	}

}
