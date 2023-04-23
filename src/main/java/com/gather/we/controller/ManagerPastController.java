package com.gather.we.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.ManagerPastDTO;
import com.gather.we.dto.PagingVO;
import com.gather.we.service.ManagerPastService;

@Controller
public class ManagerPastController {

	@Autowired
    ManagerPastService service;
	
	 @GetMapping("/manager2/managerPast")
	 public ModelAndView managerPastManager2() {
		    ModelAndView mav = new ModelAndView();
		    List<ManagerPastDTO> managerList = service.getAllManagerPast();
		    mav.addObject("managerList", managerList);
		    mav.setViewName("/manager2/managerPast");
		    return mav;
		}
	 @GetMapping("manager2/managerPast/list")
		public ModelAndView managerPastList(PagingVO vo) {
			
			ModelAndView mav = new ModelAndView();
			System.out.println(1111);
			//�ѷ��ڵ� ���� ���ϱ�
			vo.setTotalRecord(service.totalRecord(vo));
			
			System.out.println("-"+vo.toString());
			//DB��ȸ
			//�ش� ������ ���ڵ� �����ϱ� 
			mav.addObject("list" , service.pageSelect(vo));
			System.out.println(2222);
			mav.addObject("vo", vo);
			mav.setViewName("manager2/manager10");
			return mav;
		}
}
