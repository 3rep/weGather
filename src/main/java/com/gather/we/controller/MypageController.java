package com.gather.we.controller;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@GetMapping("/mypage/applyList") 
	public ModelAndView applyList(HttpSession session, MypageApplyListDTO dto) {
		
		System.out.println("dto--->"+dto);
		ModelAndView mav = new ModelAndView();
		
		//userid가 logId인지 확인
		String logId = (String)session.getAttribute("logId");
		
		List<MypageApplyListDTO> list = service.allgameList(logId);
		Date now = new Date();
		
		mav.addObject("list", list);
		mav.addObject("now", now);
		mav.setViewName("user/mypage/applyList");		
			
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
		mav.setViewName("user/mypage/rankList");
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
		mav.setViewName("user/mypage/normList");
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
		mav.setViewName("user/mypage/rank");
		return mav;
	}
	
	@PostMapping(value="/mypage/rankMain", produces="application/text;charset=UTF-8") 
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
	
	@GetMapping("/mypage/paymentList")
	public ModelAndView paymentList(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String logName = (String)session.getAttribute("logName");
		//System.out.println(logName);
		
		List<MypagePaymentDTO> list = service.paymentList(logName);
		System.out.println("list: "+ list);
		
		
		// unix 타임스탬프를 2023-04-12 형태로 변환하기
		// 현재 Unix 타임스탬프 (밀리초) 가져오기
		//long unixTimestamp = System.currentTimeMillis();

		// Unix 타임스탬프를 Date 객체로 변환하기
		//Date date = new Date(unixTimestamp);

		// SimpleDateFormat을 사용하여 날짜와 시간 형식 지정하기
		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//String formattedDate = formatter.format(date);

		//System.out.println(formattedDate);
		
		
		
		
		mav.addObject("list", list);
		mav.setViewName("user/mypage/paymentList");
		return mav;
	}
	
	@GetMapping("/mypage/info")
	public ModelAndView info(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		String logId = (String)session.getAttribute("logId");
		MypageUserDTO dto = service.getUserinfo(logId);
		
		mav.addObject("dto", dto);
		mav.setViewName("user/mypage/info");
		return mav;
	}
	
	@PostMapping("mypage/infoEdit")
	public ResponseEntity<String> infoEdit(MypageUserDTO dto, HttpSession session) {
		
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=UTF-8");
		
		dto.setUserid((String)session.getAttribute("logId"));
		//System.out.println("여기다 "+dto.getUserid());

		try {
			int cnt = service.infoEdit(dto);
			//정보수정 성공
			String body = "<script>";
			body += "alert('회원정보 수정이 완료되었습니다.');";
			body += "location.href='info';";
			body += "</script>";
			entity = new ResponseEntity<String>(body, headers, HttpStatus.OK);
		}catch(Exception e) {
			//정보수정 실패
			e.printStackTrace();
			String body = "<script>";
			body += "alert('회원정보 수정이 실패하였습니다.');";
			body += "history.back();";
			body += "</script>";
			entity =  new ResponseEntity<String>(body, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	/*
	 * @PostMapping("mypage/infoEdit") public ModelAndView infoEdit(MypageUserDTO
	 * dto, HttpSession session) { ModelAndView mav = new ModelAndView();
	 * dto.setUserid((String)session.getAttribute("logId"));
	 * System.out.println("여기다 "+dto.getUserid());
	 * 
	 * int cnt = service.infoEdit(dto); mav.setViewName("redirect:info"); return
	 * mav; }
	 */
	
}	