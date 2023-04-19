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
	public ModelAndView applyListMap(HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		
		//�α��� Ȯ�� : userid �� logId �� ���� Ȯ��  >> �ϴ� ������ �Ѱɷ� test�Ϸ�.
		
		String logId = (String)session.getAttribute("logId");
		
		//��ũ��+�Ϲ����� ����+���� ��û����� ȭ�鿡 �Ѹ���. : �����, ��⳯¥, ��ⱸ��, ������
		// gametime �ֽż����� �����ص� ����
		
		//	�����
		List<MypageApplyListDTO> sName = service.getSportName(logId);
		System.out.println("sName->"+sName);
		//	��⳯¥, ��ũ������
		List<MypageApplyListDTO> rgInfo= service.getRankgameInfo(logId);
		System.out.println("rgInfo=>"+rgInfo);
		//��ⱸ���
		List<MypageApplyListDTO> stadium = service.getStadium(logId);
		System.out.println("stadium=>"+stadium);
		
		//map�� ��Ƽ� ��� ������
		HashMap map = new HashMap();
		Iterator iterator = sName.iterator();		
		
		try {
			if(iterator.hasNext()){//list�ȿ� dto�� ������ �ݺ�
				int i=0;
				while(i <= sName.size()) { //list�� ���� DTO��ü�� ���������� map�� ��´�
					// key, value
					map.put("sN"+i, sName.get(i).getSportname()); // sN : sportName
					map.put("gT"+i, rgInfo.get(i).getGametime()); //gT : gametime
					map.put("stN"+i, stadium.get(i).getStadium()); //stN : stadiumName
					map.put("gS"+i, rgInfo.get(i).getG_status()); //gS: g_status
					//System.out.println("�ֽ�"+i+"->"+map.get("sN"+i));
					
					i++;
				}
				//map�� ��� ��������
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