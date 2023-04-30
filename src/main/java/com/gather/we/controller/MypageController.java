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
	public ModelAndView applyList(HttpSession session) {
		
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
		//System.out.println("listtt:"+list);
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

		//no Rank�씤 寃쎌슦, list�뿉 �떞湲� 媛믪씠 �뾾�뼱 list.get(0)�븯硫� �뿉�윭諛쒖깮
		//	-> try-catch臾� �벐�옄
		try { //rank媛� �엳�뒗 寃쎌슦
		
			MypageRankDTO dto = new MypageRankDTO();
			//System.out.println("dto->"+dto);
			dto.setAvg_all(list.get(0).getAvg_all());
			
			//System.out.println("list--->: "+ list);
			//System.out.println("alll: "+dto.getAvg_all());
			
			mav.addObject("list", list);
			mav.addObject("dto", dto);
			mav.setViewName("user/mypage/rank");
			
		}catch(Exception e){ //rank媛� �뾾�뒗 寃쎌슦
			MypageRankDTO dto = new MypageRankDTO();
			
			mav.addObject("list",list);
			mav.addObject("dto", dto);
			mav.setViewName("user/mypage/rank");
		}
		
		return mav;
	}
	
	@PostMapping(value="/mypage/rankMain", produces="application/text;charset=UTF-8") 
	public String rankMain(HttpSession session, String sportname) {
		
		//System.out.println(sportname);
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
		//System.out.println("list: "+ list);
		
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
		//System.out.println("�뿬湲곕떎 "+dto.getUserid());

		try {
			int cnt = service.infoEdit(dto);
			//�젙蹂댁닔�젙 �꽦怨�
			String body = "<script>";
			body += "alert('�쉶�썝�젙蹂� �닔�젙�씠 �셿猷뚮릺�뿀�뒿�땲�떎.');";
			body += "location.href='info';";
			body += "</script>";
			entity = new ResponseEntity<String>(body, headers, HttpStatus.OK);
		}catch(Exception e) {
			//�젙蹂댁닔�젙 �떎�뙣
			e.printStackTrace();
			String body = "<script>";
			body += "alert('�쉶�썝�젙蹂� �닔�젙�씠 �떎�뙣�븯����뒿�땲�떎.');";
			body += "history.back();";
			body += "</script>";
			entity =  new ResponseEntity<String>(body, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
}	