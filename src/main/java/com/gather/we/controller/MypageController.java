package com.gather.we.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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
	public ModelAndView applyList(HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		//로그인 확인 : userid 가 logId 랑 같냐 확인  >> 일단 위에서 한걸로 test완료.
		
		String logId = (String)session.getAttribute("logId");
		
		//랭크전+일반전의 지난+현재 신청목록을 화면에 뿌린다. : 종목명, 경기날짜, 경기구장, 경기상태
		// 최신순으로 정렬해서 뷰에 뿌린다.
		List<MypageApplyListDTO> list = service.allgameList(logId);
		
		System.out.println("list->"+list);
		
		for(int i=0; i<list.size(); i++) {
			try {
				System.out.println("orgDate: "+ list.get(i).getGametime());
				
				//gametime 날짜형식 바꾸기
					MypageApplyListDTO dto = new MypageApplyListDTO();
				
				SimpleDateFormat sdf = new SimpleDateFormat();
				sdf.applyPattern("yyyy-MM-dd HH:mm");
				String newDate = sdf.format(list.get(i).getGametime());
				System.out.println("newDate: "+ newDate);
				
				//dto안에 있는 기존gametime을 newDate로 바꿔야해	
				//기존gametime은 date타입이고, newDate는 string이야
				// string을 date로 바꿔서 setGametime하면?
				
					Date finaldate = sdf.parse(newDate);
					list.get(i).setGametime(finaldate);
					System.out.println("newlist: "+ list );
					
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			gametime date 타입 이틀전
			뷰에 넘기는건 ok
			
			뷰에서 이틀전 계산이 어렵다
			
			DB에서 date로 받아서
			컨트롤러에서 형식을 안바꾸고
			뷰로 넘겨서 -2를 하고
			마지막에 형식 바꾼다
			> ajax
			그 다음에 형식을 바꾼다
			
			컨트롤러에서 형식을 바꾸고 -> string
			
			뷰에서는 데이트로 받아
			
			DB에서 스트링으로 받아서
			컨트롤러에서 date + 형식을 맞춘다.
			
			
			
			
		}
		
		
		
		//날짜형식 바꾸기 
		
		//Date now = new Date();
		//System.out.println("now: "+ now);
				
		//Calendar cal = Calendar.getInstance();
		//cal.setTime(now);
		//cal.add(Calendar.DATE, -2);
		//System.out.println("cal: "+ cal.getTime());
				
		//SimpleDateFormat sdt = new SimpleDateFormat();
		//sdt.applyPattern("yyyy-MM-dd hh:mm:ss");
		//String newDate = sdt.format(cal.getTime());
		//System.out.println("newDate: "+ newDate);




		// 원하는 날짜 형식 
		//SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		//String strdate = formatdate.format(list.get(3));
		//System.out.println("strdate->"+strdate);
		//System.out.println("datelist->"+list);
		
		
		//List<MypageApplyListDTO> rlist = service.rankgameList(logId);		
		//List<MypageApplyListDTO> nlist = service.normgameList(logId);
	
		//새로운 list객체 만들어서 rlist의 DTO와 nlist의 DTO를 모두 담는다.
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