package com.gather.we.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.NormGameDTO;
import com.gather.we.dto.NormGameDetailDTO;
import com.gather.we.dto.NormGameListDTO;
import com.gather.we.dto.SportDTO;
import com.gather.we.dto.StadiumInfoDTO;
import com.gather.we.service.NormalGameService;
import com.gather.we.service.SportService;
import com.gather.we.service.StadiumInfoService;

@RestController
@RequestMapping("/normgame")
public class NormalGameController {
	@Autowired
	SportService sportService;
	@Autowired
	NormalGameService normGameService;
	@Autowired
	StadiumInfoService stadiumService;
	
	// Á¾¸ñ¸ñ·Ï
	@GetMapping("/sportlist")
	public ModelAndView sportList() {
		ModelAndView mav = new ModelAndView();
		
		List<SportDTO> sportList = sportService.sportAllSelect();
		
		mav.addObject("sportList", sportList);
		mav.setViewName("user/normGame/sportList");
		
		return mav;
	}
	
	// ÀÏ¹İ°æ±â ¸ñ·Ï
	@GetMapping("/normgamelist")
	public ModelAndView normGameList(NormGameListDTO dto) { 
		ModelAndView mav = new ModelAndView();
		
		// Áö¿ª ÇÊÅÍ¸µ ½Ã db¿¡¼­ ÇØ´ç Áö¿ªÀÇ °æ±â¸¸ ¼±ÅÃÇÏ¿© °¡Á®¿À±â À§ÇØ Áö¿ª Ä«Å×°í¸®¸¦ ¼¼ºÎ Áö¿ªÀ¸·Î ³ª´©¾î ¸®½ºÆ®¿¡ ´ã´Â´Ù.
		String region = dto.getRegion();// '´ëÀü/¼¼Á¾/ÃæÃ»'
		if(region!=null) {
			List<String> regionList = Arrays.asList(region.split("/"));// ['´ëÀü', '¼¼Á¾', 'ÃæÃ»']
			dto.setRegionList(regionList);
		}
		
		// DB¿¡¼­ ÀÏ¹İ°æ±â ¸ñ·Ï ¹Ş¾Æ¿À±â
		List<NormGameDTO> normGameList = normGameService.normGameListSelect(dto);

		mav.addObject("s_no", dto.getS_no());
		mav.addObject("normGameList", normGameList);
		mav.setViewName("user/normGame/normGameList");
		
		return mav;
	}
	
	// ÀÏ¹İ°æ±â ¼¼ºÎÁ¤º¸
	@GetMapping("/detail")
	public ModelAndView normGameDetail(int no) {
		ModelAndView mav = new ModelAndView();
		
		// DB¿¡¼­ ÀÏ¹İ°æ±â ¼¼ºÎÁ¤º¸ ¹Ş¾Æ¿À±â
		NormGameDetailDTO normGameDetail = normGameService.normGameDetailSelect(no);

		mav.addObject("normGameDetail", normGameDetail);
		mav.setViewName("user/normGame/normGameDetail");
		
		return mav;
	}
	
	// ì¼ë°˜ê²½ê¸° ê°œì„¤ í˜ì´ì§€
	@GetMapping("/new")
	public ModelAndView normGameNew(int s_no, StadiumInfoDTO dto) {
		ModelAndView mav = new ModelAndView();
		
		int st_no = dto.getSt_no();
		
		if(dto.getRegion() == null || dto.getRegion().equals("")) {
			dto.setRegion("ì„œìš¸");
		} // ì´ˆê¸°ê°’ ì„œìš¸ë¡œ ì§€ì •
		
		if(st_no != 0) {
			
			// DBì—ì„œ ë¯¸ê°œì„¤ëœ ì¼ë°˜ê²½ê¸° ì •ë³´ ë°›ì•„ì˜¤ê¸°
			List<NormGameDetailDTO> newNormGameList = normGameService.newNormGameList(st_no);
			
			mav.addObject("newNormGameList", newNormGameList);
		}
		
		// ì¡´ì¬í•˜ëŠ” êµ¬ì¥ ì •ë³´ ë°›ì•„ì˜¤ê¸°
		List<StadiumInfoDTO> stadiumList = stadiumService.stadiumInfoAllSelect();
		
		// ìŠ¤í¬ì¸  ì¢…ëª© ì •ë³´ ë°›ì•„ì˜¤ê¸°
		SportDTO sportDTO =  sportService.sportOneSelect(s_no);
		
		mav.addObject("stadiumList", stadiumList);
		mav.addObject("sportDTO", sportDTO);
		mav.addObject("stadiumDTO", dto);
		mav.setViewName("user/normGame/normGameNew");
		
		return mav;
	}
	
	// ì¼ë°˜ê²½ê¸° ê°œì„¤ - ì‚¬ìš©ì ì…ë ¥ í˜ì´ì§€
	@GetMapping("/newdetail")
	public ModelAndView normGameNewDetail(int no, int s_no) {
		ModelAndView mav = new ModelAndView();
		
		NormGameDetailDTO normGameDTO = normGameService.normGameDetailSelect(no);
		SportDTO sportDTO = sportService.sportOneSelect(s_no);
		
		mav.addObject("normGameDTO", normGameDTO);
		mav.addObject("sportDTO", sportDTO);
		mav.setViewName("user/normGame/normGameNewDetail");
		return mav;
	}
	
	// ì¼ë°˜ê²½ê¸° ê°œì„¤ (DBë“±ë¡)
	@PostMapping("/newdetailOk")
	public ResponseEntity<String> normGameNewDetailOk(NormGameDTO dto, HttpServletRequest request){
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=utf-8");
		try {
			// ì‚¬ìš©ìê°€ ì‘ì„±í•œ ì •ë³´ë¥¼ DBì— ì €ì¥
			normGameService.normGameUpdate(dto);
			
			// ê²½ê¸° ì°¸ì—¬ì ìˆ˜ +1
			normGameService.normGameCountUp(dto.getNo());
			
			// ì¼ë°˜ê²½ê¸° ëª©ë¡ìœ¼ë¡œ ì´ë™
			String body = "<script> alert('ì¼ë°˜ê²½ê¸°ë¥¼ ê°œì„¤í•˜ì˜€ìŠµë‹ˆë‹¤.'); location.href='/normgame/normgamelist?s_no="+dto.getS_no()+"';</script>";
			entity = new ResponseEntity<String>(body, headers, HttpStatus.OK);
		}catch(Exception e) {
			// ì¼ë°˜ê²½ê¸° ë“±ë¡ ì‹¤íŒ¨
			e.printStackTrace();
			String body = "<script>";
			body += "alert('ì¼ë°˜ê²½ê¸° ê°œì„¤ì„ ì‹¤íŒ¨í•˜ì˜€ìŠµë‹ˆë‹¤.');";
			body += "history.go(-1);";
			body += "</script>";
			entity = new ResponseEntity<String>(body, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
