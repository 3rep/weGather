package com.gather.we.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.RankGameDTO;
import com.gather.we.dto.RankGameDetailDTO;
import com.gather.we.dto.RankGameListDTO;
import com.gather.we.dto.SportDTO;
import com.gather.we.service.RankGameService;
import com.gather.we.service.SportService;

@RestController
@RequestMapping("/rankgame")
public class RankGameController {
	@Autowired
	SportService sportService;
	@Autowired
	RankGameService rankGameService;
	

	// 종목 목록

	@GetMapping("/sportlist")
	public ModelAndView sportList() {
		ModelAndView mav = new ModelAndView();
		
		List<SportDTO> sportList = sportService.sportAllSelect();
		
		mav.addObject("sportList", sportList);
		mav.setViewName("user/rankGame/sportList");
		
		return mav;
	}
	
	// �옲�겕寃쎄린 紐⑸줉
	@GetMapping("/rankgamelist")
	public ModelAndView rankGameList(RankGameListDTO dto) { 
		ModelAndView mav = new ModelAndView();



		// 지역 필터링 시 DB에서 해당 지역의 경기만 선택하여 가져오기 위해 지역 카테고리를 세부 지역으로 나누어 리스트에 담는다.
		String region = dto.getRegion();// '대전/세종/충청'

		if(region!=null) {
			List<String> regionList = Arrays.asList(region.split("/"));// ['���쟾', '�꽭醫�', '異⑹껌']
			dto.setRegionList(regionList);
		}
		
		// DB�뿉�꽌 �옲�겕寃쎄린 紐⑸줉 諛쏆븘�삤湲�
		List<RankGameDTO> rankGameList = rankGameService.rankGameListSelect(dto);

		mav.addObject("s_no", dto.getS_no());
		mav.addObject("rankGameList", rankGameList);
		mav.setViewName("user/rankGame/rankGameList");
		
		return mav;
	}
	
	// �옲�겕寃쎄린 �꽭遺��젙蹂�
	@GetMapping("/detail")
	public ModelAndView rankGameDetail(int no) {
		ModelAndView mav = new ModelAndView();
		
		// DB�뿉�꽌 �옲�겕寃쎄린 �꽭遺��젙蹂� 諛쏆븘�삤湲�
		RankGameDetailDTO rankGameDetail = rankGameService.rankGameDetailSelect(no);


		mav.addObject("rankGameDetail", rankGameDetail);
		mav.setViewName("user/rankGame/rankGameDetail");
		
		return mav;
	}
}
