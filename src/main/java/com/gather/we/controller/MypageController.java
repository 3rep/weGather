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
		
		for(int i=0; i<list.size(); i++) {
			try {
				System.out.println("orgDate: "+ list.get(i).getGametime());
				
				//gametime ��¥���� �ٲٱ�
					MypageApplyListDTO dto = new MypageApplyListDTO();
				
				SimpleDateFormat sdf = new SimpleDateFormat();
				sdf.applyPattern("yyyy-MM-dd HH:mm");
				String newDate = sdf.format(list.get(i).getGametime());
				System.out.println("newDate: "+ newDate);
				
				//dto�ȿ� �ִ� ����gametime�� newDate�� �ٲ����	
				//����gametime�� dateŸ���̰�, newDate�� string�̾�
				// string�� date�� �ٲ㼭 setGametime�ϸ�?
				
					Date finaldate = sdf.parse(newDate);
					list.get(i).setGametime(finaldate);
					System.out.println("newlist: "+ list );
					
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
			gametime date Ÿ�� ��Ʋ��
			�信 �ѱ�°� ok
			
			�信�� ��Ʋ�� ����� ��ƴ�
			
			DB���� date�� �޾Ƽ�
			��Ʈ�ѷ����� ������ �ȹٲٰ�
			��� �Ѱܼ� -2�� �ϰ�
			�������� ���� �ٲ۴�
			> ajax
			�� ������ ������ �ٲ۴�
			
			��Ʈ�ѷ����� ������ �ٲٰ� -> string
			
			�信���� ����Ʈ�� �޾�
			
			DB���� ��Ʈ������ �޾Ƽ�
			��Ʈ�ѷ����� date + ������ �����.
			
			
			
			
		}
		
		
		
		//��¥���� �ٲٱ� 
		
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




		// ���ϴ� ��¥ ���� 
		//SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		//String strdate = formatdate.format(list.get(3));
		//System.out.println("strdate->"+strdate);
		//System.out.println("datelist->"+list);
		
		
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