package com.gather.we.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.NormGameDTO;
import com.gather.we.dto.NormGameDetailDTO;
import com.gather.we.dto.NormGameListDTO;
import com.gather.we.dto.SportDTO;
import com.gather.we.service.NormalGameService;
import com.gather.we.service.SportService;

@RestController
@RequestMapping("/normgame")
public class NormalGameController {
	@Autowired
	SportService sportService;
	@Autowired
	NormalGameService normGameService;
	
	// ������
	@GetMapping("/sportlist")
	public ModelAndView sportList() {
		ModelAndView mav = new ModelAndView();
		
		List<SportDTO> sportList = sportService.sportAllSelect();
		
		mav.addObject("sportList", sportList);
		mav.setViewName("user/normGame/sportList");
		
		return mav;
	}
	
	// �Ϲݰ�� ���
	@GetMapping("/normgamelist")
	public ModelAndView normGameList(NormGameListDTO dto) { 
		ModelAndView mav = new ModelAndView();
		
		// ���� ���͸� �� db���� �ش� ������ ��⸸ �����Ͽ� �������� ���� ���� ī�װ��� ���� �������� ������ ����Ʈ�� ��´�.
		String region = dto.getRegion();// '����/����/��û'
		if(region!=null) {
			List<String> regionList = Arrays.asList(region.split("/"));// ['����', '����', '��û']
			dto.setRegionList(regionList);
		}
		
		// DB���� �Ϲݰ�� ��� �޾ƿ���
		List<NormGameDTO> normGameList = normGameService.normGameListSelect(dto);

		mav.addObject("s_no", dto.getS_no());
		mav.addObject("normGameList", normGameList);
		mav.setViewName("user/normGame/normGameList");
		
		return mav;
	}
	
	// �Ϲݰ�� ��������
	@GetMapping("/detail")
	public ModelAndView rankGameDetail(int no) {
		ModelAndView mav = new ModelAndView();
		
		// DB���� �Ϲݰ�� �������� �޾ƿ���
		NormGameDetailDTO normGameDetail = normGameService.normGameDetailSelect(no);

		mav.addObject("normGameDetail", normGameDetail);
		mav.setViewName("user/normGame/normGameDetail");
		
		return mav;
	}
}
