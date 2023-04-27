package com.gather.we.controller;


import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.MRankGameListCriteria;
import com.gather.we.dto.MSettlementCriteria;
import com.gather.we.dto.MSettlementPageDTO;
import com.gather.we.dto.Manager10DTO;
import com.gather.we.dto.ManagerRankGameDTO;
import com.gather.we.dto.PageDTO;
import com.gather.we.dto.PagingVO;
import com.gather.we.service.Manager10Service;
import com.gather.we.service.ManagerRankGameListService;
import com.gather.we.service.ManagerSettlementService;
import com.google.gson.JsonSyntaxException;


@Controller
@RequestMapping("/manager/*")
public class ManagerController{
	@Autowired
	ManagerRankGameListService rankGameListService;
	
	@Autowired
	ManagerSettlementService mSettlementService;
	
	//매니저 랭크 경기 목록
	@GetMapping("/rankgamelist")
	public void list(MRankGameListCriteria criteria, Model model) {
		//DB에서 가져오기 - criteria 데이터만 필요
		model.addAttribute("gamelist",rankGameListService.rankGameListAllSelect(criteria));
		//화면에 필요한 정보 가져오기, 계산하기(생성자에서 처리)
		int total = rankGameListService.getTotalCount(criteria);
		model.addAttribute("pageMaker", new PageDTO(criteria, total));
	}
	
	
	 //매니저 랭크 경기 신청 모달
	 //@param RankGameListDTO, Principal
	 // @return	ResponseEntity<?>
	@PostMapping("/apply")
	public ResponseEntity<?> apply(ManagerRankGameDTO rankGameDTO, Principal principal) {
		try {
			// 현재는 managerid 파라미터로 사용 중 추후 로그인 개발 시 Principal에서 파라미터 사용예정
			// rankGameListDTO.setManagerid(principal.getName());	//	로그인 사용자 id 가져오기
			if (rankGameListService.updateApply(rankGameDTO) > 0) {		// update 시 리턴 값이 0보다 클 경우
				// 성공
				return ResponseEntity.ok().body(rankGameDTO);
			} else {
				// 실패
				return new ResponseEntity<>("99", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			// 예외처리
			e.printStackTrace();
			return new ResponseEntity<>("99", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//매니저 정산 내역
	@GetMapping("/settlement")
	public void settlement(Model model, MSettlementCriteria mscriteria) {
		model.addAttribute("settlement", mSettlementService.mSettlementAllSelect(mscriteria));
		int total = mSettlementService.getTotalCount(mscriteria);
		model.addAttribute("pageMaker", new MSettlementPageDTO(mscriteria, total));
		model.addAttribute("completedamount", mSettlementService.getTotalCompletedAmount());
		model.addAttribute("inprogressamount", mSettlementService.getTotalInprogressAmount());
	}
	
	
	
	//여기부터 지훈님꺼
	@Autowired
	Manager10Service service;
	
	@GetMapping("/manager10")
	public ModelAndView getManager10(PagingVO vo) {
		   
			ModelAndView mav = new ModelAndView();
					
		    vo.setTotalRecord(service.totalRecord(vo));
		  	    
		    mav.addObject("managerList", service.pageSelect(vo));
		    mav.addObject("vo", vo);
		    
		    mav.setViewName("/manager/manager10");
		    return mav;
		}
		@GetMapping("/managerPast")
		public ModelAndView getManagerPast(PagingVO vo) {
			ModelAndView mav = new ModelAndView();
			vo.setTotalRecord(service.totalRecord(vo));
		  
		    mav.addObject("managerList", service.pageSelect(vo));
		    mav.addObject("vo", vo);
		    mav.setViewName("/manager/managerPast");
	    return mav;
	}

		
		 @GetMapping("/managerInput")
		 public ModelAndView managerInputManager2(@RequestParam(value = "rank", required = false) String rank) {
		     ModelAndView mav = new ModelAndView();
		     List<Manager10DTO> managerInputList;
		     if (rank != null) {
		         managerInputList = service.getAllManagerInputByRank(rank);
		     } else {
		         managerInputList = service.getAllManagerInput();
		     }
		     mav.addObject("managerInputList", managerInputList);
		     mav.setViewName("/manager/managerInput");
		     return mav;
		 }
		
		 @PostMapping("/managerInput")
		 public ModelAndView submitRank(@RequestBody List<Manager10DTO> managerInputList) {
		     ModelAndView mav = new ModelAndView();
		     try {
		         for (Manager10DTO managerInput : managerInputList) {
		             service.updateRank(managerInput.getUserid(), managerInput.getRank());
		         }
		         mav.setViewName("redirect:/managerPast");
		     } catch (NumberFormatException | JsonSyntaxException e) {
		         mav.addObject("error", "Invalid input format");
		         mav.setViewName("errorPage");
		     } catch (Exception e) {
		         mav.addObject("error", "An error occurred while processing your request");
		         mav.setViewName("errorPage");
		     }
		     return mav;
		 }
		
		 
		 @GetMapping("/entry")
		 public ModelAndView EntryManager2() {
			    ModelAndView mav = new ModelAndView();
			    List<Manager10DTO> entryList = service.getAllEntry();
			    mav.addObject("entryList", entryList);
			    mav.setViewName("/manager/entry");
			    return mav;
			}
}
