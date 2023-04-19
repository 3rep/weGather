package com.gather.we.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.MypageApplyListDTO;
import com.gather.we.dto.MypageUserDTO;
import com.gather.we.service.MypageService;


@RestController
public class MypageController {
	
	@Autowired
	MypageService service;
	
	@GetMapping("/login")
	public ModelAndView main(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		MypageUserDTO dto = service.getUserinfo((String)session.getAttribute("logId")); 
		System.out.println(dto.toString());
		
		//session�� logName -> username���� �����Ѵ�.
		//session.setAttribute("logName", dto.getUsername());
		//session.setAttribute("logGender", dto.getGender());
		
		
		//���� DB�����ϰ� �־ DB�� �����Ͱ� �����ϱ� �׳� ���� ���� ������
		session.setAttribute("logName", dto.getUsername());
		session.setAttribute("logGender", dto.getGender());
		
		mav.addObject("logName", session.getAttribute("logName"));
		mav.addObject("logGender",session.getAttribute("logGender"));
		mav.setViewName("redirect:/");
		return mav;
	}
	
	@GetMapping("/mypage/applyList") //post�� �������°� �����ʳ�? -> {userid} �����ϴϱ�
	public ModelAndView applyList(HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		//�α��� Ȯ�� : userid �� logId �� ���� Ȯ��  >> �ϴ� ������ �Ѱɷ� test�Ϸ�.
		
		String logId = (String)session.getAttribute("logId");
		
		//��ũ��+�Ϲ����� ����+���� ��û����� ȭ�鿡 �Ѹ���. : �����, ��⳯¥, ��ⱸ��, ������
		// �ֽż����� �����ؼ� �信 �Ѹ���.
		List<MypageApplyListDTO> list = service.allgameList(logId);
		
		System.out.println("list->"+list);
		
		//List<MypageApplyListDTO> rlist = service.rankgameList(logId);		
		//List<MypageApplyListDTO> nlist = service.normgameList(logId);
	
		//���ο� list��ü ���� rlist�� DTO�� nlist�� DTO�� ��� ��´�.
		//List<MypageApplyListDTO> sumlist = new ArrayList<MypageApplyListDTO>();
		//sumlist.addAll(rlist);
		//sumlist.addAll(nlist);
	
		//System.out.println("sumlist->"+sumlist);
	
		
		mav.addObject("list", list);
		mav.setViewName("mypage/applyList");		
		return mav;
		
	}
	
	@GetMapping("/mypage/rank")
	public ModelAndView rank() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("mypage/rank");
		return mav;
	}
	
	@GetMapping("mypage/paymentList")
	public ModelAndView paymentList() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage/paymentList");
		return mav;
	}
	@GetMapping("mypage/info")
	public ModelAndView info() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mypage/info");
		return mav;
	}
}	