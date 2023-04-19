package com.gather.we.controller;

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
	public ModelAndView applyListMap(HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		//로그인 확인 : userid 가 logId 랑 같냐 확인  >> 일단 위에서 한걸로 test완료.
		
		String logId = (String)session.getAttribute("logId");
		
		//랭크전+일반전의 지난+현재 신청목록을 화면에 뿌린다. : 종목명, 경기날짜, 경기구장, 경기상태
		// gametime 최신순으로 정렬해둔 상태
		
		//	종목명
		List<MypageApplyListDTO> sName = service.getSportName(logId);
		System.out.println("sName->"+sName);
		//	경기날짜, 랭크경기상태
		List<MypageApplyListDTO> rgInfo= service.getRankgameInfo(logId);
		System.out.println("rgInfo=>"+rgInfo);
		//경기구장명
		List<MypageApplyListDTO> stadium = service.getStadium(logId);
		System.out.println("stadium=>"+stadium);
		
		//map에 담아서 뷰로 보낸다
		HashMap map = new HashMap();
		Iterator iterator = sName.iterator();		
		
		try {
			if(iterator.hasNext()){//list안에 dto가 있으면 반복
				int i=0;
				while(i <= sName.size()) { //list에 다음 DTO객체가 없을때까지 map에 담는다
					// key, value
					map.put("sN"+i, sName.get(i).getSportname()); // sN : sportName
					map.put("gT"+i, rgInfo.get(i).getGametime()); //gT : gametime
					map.put("stN"+i, stadium.get(i).getStadium()); //stN : stadiumName
					map.put("gS"+i, rgInfo.get(i).getG_status()); //gS: g_status
					//System.out.println("최신"+i+"->"+map.get("sN"+i));
					
					i++;
				}
				//map을 뷰로 보내야해
				mav.addObject("map", map);
				mav.setViewName("mypage/applyList");
			}
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		
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