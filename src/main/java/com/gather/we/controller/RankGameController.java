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
	
	//@Value("${google-map-key}")
	//private String goole_map_key;
	
	// 醫낅ぉ 紐⑸줉
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
		
		// 吏��뿭 �븘�꽣留� �떆 DB�뿉�꽌 �빐�떦 吏��뿭�쓽 寃쎄린留� �꽑�깮�븯�뿬 媛��졇�삤湲� �쐞�빐 吏��뿭 移댄뀒怨좊━瑜� �꽭遺� 吏��뿭�쑝濡� �굹�늻�뼱 由ъ뒪�듃�뿉 �떞�뒗�떎.
		String region = dto.getRegion();// '���쟾/�꽭醫�/異⑹껌'
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

		//mav.addObject("goole_map_key", goole_map_key);
		mav.addObject("rankGameDetail", rankGameDetail);
		mav.setViewName("user/rankGame/rankGameDetail");
		
		return mav;
	}
}
