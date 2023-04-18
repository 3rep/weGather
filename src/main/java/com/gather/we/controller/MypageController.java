package com.gather.we.controller;

import java.util.List;

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
		
		//session에 logName -> username으로 설정한다.
		//session.setAttribute("logName", dto.getUsername());
		//session.setAttribute("logGender", dto.getGender());
		
		
		//지금 DB수정하고 있어서 DB에 데이터가 없으니까 그냥 내가 만들어서 넣을게
		session.setAttribute("logName", dto.getUsername());
		session.setAttribute("logGender", dto.getGender());
		
		mav.addObject("logName", session.getAttribute("logName"));
		mav.addObject("logGender",session.getAttribute("logGender"));
		mav.setViewName("redirect:/");
		return mav;
	}
	
	@GetMapping("/mypage/applyList") //post로 가져오는게 맞지않나? -> {userid} 포함하니까
	public ModelAndView applyList(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		//로그인 확인 : userid 가 logId 랑 같냐 확인  >> 일단 위에서 한걸로 test완료.
		
		String logId = (String)session.getAttribute("logId");
		
		//지난+현재 신청목록을 화면에 뿌린다.
		//	종목명
		List<MypageApplyListDTO> list = service.getSportName(logId);
		System.out.println("list->"+list);
		//	경기날짜, 랭크경기상태
		List<MypageApplyListDTO> rginfo= service.getRankgameInfo(logId);
		System.out.println("rginfo=>"+rginfo);
		//경기구장명
		List<MypageApplyListDTO> stadium = service.getStadium(logId);
		System.out.println("stadium=>"+stadium);
		
		
		
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