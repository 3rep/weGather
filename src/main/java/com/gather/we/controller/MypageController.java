package com.gather.we.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gather.we.dto.MypageApplyListDTO;
import com.gather.we.dto.MypagePaymentDTO;
import com.gather.we.dto.MypageRankDTO;
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
		
		//session.setAttribute("logName", dto.getUsername());
		//session.setAttribute("logGender", dto.getGender());
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
		
		//userid가 logId인지 확인
		String logId = (String)session.getAttribute("logId");

		List<MypageApplyListDTO> list = service.allgameList(logId);
		//System.out.println("list->"+list);
		
		Date now = new Date();
		//System.out.println(now);
		
		mav.addObject("list", list);
		mav.addObject("now", now);
		mav.setViewName("mypage/applyList");		
		return mav;
	}
	
	@GetMapping("/mypage/rankList")
	public ModelAndView rankList(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		String logId = (String)session.getAttribute("logId");
		
		List<MypageApplyListDTO> list = service.rankgameList(logId);
		Date now = new Date();

		mav.addObject("list", list);
		mav.addObject("now", now);
		mav.setViewName("mypage/rankList");
		return mav;
	}
	
	@GetMapping("/mypage/normList")
	public ModelAndView normList(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		String logId = (String)session.getAttribute("logId");
		
		List<MypageApplyListDTO> list = service.normgameList(logId);
		Date now = new Date();

		mav.addObject("list", list);
		mav.addObject("now", now);
		mav.setViewName("mypage/normList");
		return mav;
	}
	
	@GetMapping("/mypage/rank")
	public ModelAndView rank(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String logId = (String)session.getAttribute("logId");
		
		List<MypageRankDTO> list = service.rankResult(logId);
		
		MypageRankDTO dto = new MypageRankDTO();
		dto.setAvg_all(list.get(0).getAvg_all());
			
		//System.out.println("list--->: "+ list);
		//System.out.println("alll: "+dto.getAvg_all());
		mav.addObject("list", list);
		mav.addObject("dto", dto);
		mav.setViewName("mypage/rank");
		return mav;
	}
	
	@PostMapping(value="mypage/rankMain", produces="application/text;charset=UTF-8") 
	public String rankMain(HttpSession session, String sportname) {
		
		System.out.println(sportname);
		String logId = (String)session.getAttribute("logId");

		List<MypageRankDTO> list = service.rank(logId, sportname);
		//System.out.println("list111-> "+list );
		
		Collections.reverse(list);
		System.out.println("list222:: "+list);
		
		int n = list.size();
		//System.out.println("n->"+n);
		
		//json타입으로 변환
		ObjectMapper mapper = new ObjectMapper(); 
		String json ="";
		
		try { 
			json = mapper.writeValueAsString(list); 
		}catch(Exception e) {
			e.printStackTrace(); } 
		
		return json;
	}
	
	@GetMapping("mypage/paymentList")
	public ModelAndView paymentList(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String logName = (String)session.getAttribute("logName");
		System.out.println(logName);
		
		List<MypagePaymentDTO> list = service.paymentList(logName);
		System.out.println("list: "+ list);
		mav.addObject("list", list);
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