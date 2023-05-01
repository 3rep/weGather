package com.gather.we.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.RecommendDTO;
import com.gather.we.service.RecommendService;

@RestController
public class RecommendController {
	
	@Autowired
	RecommendService service;
	
	@GetMapping("/recommend/mbti")
	public ModelAndView recommendByMbti(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		String userid = (String)session.getAttribute("logId");
		
		if(userid!=null) {			
			String userMbti = service.userMbtiSelect(userid);
			mav.addObject("userMbti", userMbti);
		}
		
		String[] mbtiList = {"ISTP", "ISTJ", "ISFP", "ISFJ", "INTP", "INTJ", "INFP", "INFJ", 
				"ESTP", "ESTJ", "ESFP", "ESFJ", "ENTP", "ENTJ", "ENFP", "ENFJ"};

		HashMap<String, List<RecommendDTO>> mbtiStatistics = new HashMap<>();
		
		for(String mbtiType: mbtiList) {
			List<RecommendDTO> statisticsResult = service.sportStatisticsSelect(mbtiType);
			mbtiStatistics.put(mbtiType, statisticsResult);
		}
			
		mav.addObject("mbtiList", mbtiList);
		mav.addObject("mbtiStatistics", mbtiStatistics);
		mav.setViewName("user/recommend/recommendMbti");
		
		return mav;
	}
	
	@GetMapping("/recommend/userinfo")
	public ModelAndView recommendByGender() {
		ModelAndView mav = new ModelAndView();
		
		List<RecommendDTO> manStatistics = service.genderStatisticsSelect("남성");
		List<RecommendDTO> womanStatistics = service.genderStatisticsSelect("여성");
		
		mav.addObject("manStatistics", manStatistics);
		mav.addObject("womanStatistics", womanStatistics);
		mav.setViewName("user/recommend/recommendUserInfo");
		
		return mav;
	}
}
