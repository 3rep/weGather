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
	
	// 종목 목록
	@GetMapping("/sportlist")
	public ModelAndView sportList() {
		ModelAndView mav = new ModelAndView();
		
		List<SportDTO> sportList = sportService.sportAllSelect();
		
		mav.addObject("sportList", sportList);
		mav.setViewName("user/normGame/sportList");
		
		return mav;
	}
	
	// 일반경기 목록
	@GetMapping("/normgamelist")
	public ModelAndView normGameList(NormGameListDTO dto) { 
		ModelAndView mav = new ModelAndView();
		
		// 지역 필터링 시 DB에서 해당 지역의 경기만 선택하여 가져오기 위해 지역 카테고리를 세부 지역으로 나누어 리스트에 담는다.
		String region = dto.getRegion();// '대전/세종/충청'
		if(region!=null) {
			List<String> regionList = Arrays.asList(region.split("/"));// ['대전', '세종', '충청']
			dto.setRegionList(regionList);
		}
		
		// DB에서 일반경기 목록 받아오기
		List<NormGameDTO> normGameList = normGameService.normGameListSelect(dto);

		mav.addObject("s_no", dto.getS_no());
		mav.addObject("normGameList", normGameList);
		mav.setViewName("user/normGame/normGameList");
		
		return mav;
	}
	
	// 일반경기 세부정보
	@GetMapping("/detail")
	public ModelAndView normGameDetail(int no) {
		ModelAndView mav = new ModelAndView();
		
		// DB에서 일반경기 세부정보 받아오기
		NormGameDetailDTO normGameDetail = normGameService.normGameDetailSelect(no);

		mav.addObject("normGameDetail", normGameDetail);
		mav.setViewName("user/normGame/normGameDetail");
		
		return mav;
	}
	
	// 일반경기 개설 페이지
	@GetMapping("/new")
	public ModelAndView normGameNew(int s_no, StadiumInfoDTO dto) {
		ModelAndView mav = new ModelAndView();
		
		int st_no = dto.getSt_no();
		
		if(dto.getRegion() == null || dto.getRegion().equals("")) {
			dto.setRegion("서울");
		} // 초기값 서울로 지정
		
		if(st_no != 0) {
			
			// DB에서 미개설된 일반경기 정보 받아오기
			List<NormGameDetailDTO> newNormGameList = normGameService.newNormGameList(st_no);
			
			mav.addObject("newNormGameList", newNormGameList);
		}
		
		// 존재하는 구장 정보 받아오기
		List<StadiumInfoDTO> stadiumList = stadiumService.stadiumInfoAllSelect();
		
		// 스포츠 종목 정보 받아오기
		SportDTO sportDTO =  sportService.sportOneSelect(s_no);
		
		mav.addObject("stadiumList", stadiumList);
		mav.addObject("sportDTO", sportDTO);
		mav.addObject("stadiumDTO", dto);
		mav.setViewName("user/normGame/normGameNew");
		
		return mav;
	}
	
	// 일반경기 개설 - 사용자 입력 페이지
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
	
	// 일반경기 개설 (DB등록)
	@PostMapping("/newdetailOk")
	public ResponseEntity<String> normGameNewDetailOk(NormGameDTO dto, HttpServletRequest request){
		ResponseEntity<String> entity = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "text/html; charset=utf-8");
		try {
			// 사용자가 작성한 정보를 DB에 저장
			normGameService.normGameUpdate(dto);
			
			// 경기 참여자 수 +1
			normGameService.normGameCountUp(dto.getNo());
			
			// 일반경기 목록으로 이동
			String body = "<script> alert('일반경기를 개설하였습니다.'); location.href='/normgame/normgamelist?s_no="+dto.getS_no()+"';</script>";
			entity = new ResponseEntity<String>(body, headers, HttpStatus.OK);
		}catch(Exception e) {
			// 일반경기 등록 실패
			e.printStackTrace();
			String body = "<script>";
			body += "alert('일반경기 개설을 실패하였습니다.');";
			body += "history.go(-1);";
			body += "</script>";
			entity = new ResponseEntity<String>(body, headers, HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
}
