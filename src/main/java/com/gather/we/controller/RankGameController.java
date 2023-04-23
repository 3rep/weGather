package com.gather.we.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	
	@Value("${google-map-key}")
	private String goole_map_key;
	
	// 종목 목록
	@GetMapping("/sportlist")
	public ModelAndView sportList() {
		ModelAndView mav = new ModelAndView();
		
		List<SportDTO> sportList = sportService.sportAllSelect();
		
		mav.addObject("sportList", sportList);
		mav.setViewName("user/rankGame/sportList");
		
		return mav;
	}
	
	// 랭크경기 목록
	@GetMapping("/rankgamelist")
	public ModelAndView rankGameList(RankGameListDTO dto) { 
		ModelAndView mav = new ModelAndView();
		
		// 지역 필터링 시 DB에서 해당 지역의 경기만 선택하여 가져오기 위해 지역 카테고리를 세부 지역으로 나누어 리스트에 담는다.
		String region = dto.getRegion();// '대전/세종/충청'
		if(region!=null) {
			List<String> regionList = Arrays.asList(region.split("/"));// ['대전', '세종', '충청']
			dto.setRegionList(regionList);
		}
		
		// DB에서 랭크경기 목록 받아오기
		List<RankGameDTO> rankGameList = rankGameService.rankGameListSelect(dto);

		mav.addObject("s_no", dto.getS_no());
		mav.addObject("rankGameList", rankGameList);
		mav.setViewName("user/rankGame/rankGameList");
		
		return mav;
	}
	
	// 랭크경기 세부정보
	@GetMapping("/detail")
	public ModelAndView rankGameDetail(int no) {
		ModelAndView mav = new ModelAndView();
		
		// DB에서 랭크경기 세부정보 받아오기
		RankGameDetailDTO rankGameDetail = rankGameService.rankGameDetailSelect(no);

		mav.addObject("goole_map_key", goole_map_key);
		mav.addObject("rankGameDetail", rankGameDetail);
		mav.setViewName("user/rankGame/rankGameDetail");
		
		return mav;
	}
}
