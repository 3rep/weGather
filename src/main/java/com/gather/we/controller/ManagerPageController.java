package com.gather.we.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.MRankGameListCriteria;
import com.gather.we.dto.MSettlementCriteria;
import com.gather.we.dto.MSettlementPageDTO;
import com.gather.we.dto.Manager10DTO;
import com.gather.we.dto.ManagerPagingVO;
import com.gather.we.dto.ManagerRankGameDTO;
import com.gather.we.dto.PageDTO;
import com.gather.we.service.Manager10Service;
import com.gather.we.service.ManagerRankGameListService;
import com.gather.we.service.ManagerSettlementService;
import com.google.gson.JsonSyntaxException;


@Controller
@RequestMapping("/manager/*")
public class ManagerPageController{
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
	public ResponseEntity<?> apply(ManagerRankGameDTO rankGameDTO, HttpSession session) {
		try {
			String userId=(String)session.getAttribute("logId");
			rankGameDTO.setManagerid(userId);
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
	public void settlement(HttpSession session, Model model, MSettlementCriteria mscriteria) {
		String logId = (String)session.getAttribute("logId");
		model.addAttribute("settlement", mSettlementService.mSettlementAllSelect(mscriteria,logId));
		int total = mSettlementService.getTotalCount(mscriteria,logId);
		model.addAttribute("pageMaker", new MSettlementPageDTO(mscriteria, total));
		model.addAttribute("completedamount", mSettlementService.getTotalCompletedAmount(logId));
		model.addAttribute("inprogressamount", mSettlementService.getTotalInprogressAmount(logId));
	}
	
	//매니저 로그아웃
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		return "redirect:/loginMan";
	}
	
	
	//여기부터 지훈님꺼
	@Autowired
	Manager10Service service;
	
	@GetMapping("/manager10")
	public ModelAndView getManager10(ManagerPagingVO vo, HttpSession session) {
		   
			ModelAndView mav = new ModelAndView();
			
			String managerid = String.valueOf(session.getAttribute("logId"));
		    vo.setTotalRecord(service.getTotalRecordByManagerid(managerid));
		  	vo.setManagerid(managerid);
		    mav.addObject("managerList", service.pageSelect(vo));
		    System.out.println("list size : "+ service.pageSelect(vo).size());
		    mav.addObject("vo", vo);
		    mav.setViewName("/manager/manager10");
		    return mav;
		}
	
	

	@PostMapping("/manager10")
	@ResponseBody
	public  ResponseEntity<String> deleteRankGame(@RequestParam("_method") String method, @RequestParam("managerid") String managerid) {
		System.out.println("managerid의 값은 " + managerid + "입니다.");
		if (!method.equals("POST")) {
	        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body("Invalid method");
		}
		try {
	        service.deleteRankGame(managerid);
	        System.out.println("Deleted manager with ID: " + managerid);
	        return ResponseEntity.ok("ok");
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        // Exception 처리
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
	    // 삭제 후 리다이렉트
	}
	//	 return new  ResponseEntity<String>("success", HttpStatus.OK);
		}
//	@PostMapping("/manager10")
//	@ResponseBody
//	public ResponseEntity<String> deleteManager(@RequestBody List<Manager10DTO> manager10List) {
//		    try {
//	        for (Manager10DTO manager10 : manager10List) {
//	 //           if((manager10.getManagerid() == null || manager10.getManagerid().isEmpty())){
	    //            manager10.setManagerid(""); //초기화
	    //        }
//	            service.deleteRankGame(manager10.getManagerid());
//	            System.out.println("manager10"+manager10);
//	        }
//	    } catch (Exception e) {
//	        System.out.println(e.getMessage());
//	        // Exception 처리
//	    }
//	    return new ResponseEntity<String>("ok", HttpStatus.OK);
//	}
	
	
		@GetMapping("/managerPast")
		public ModelAndView getManagerPast(ManagerPagingVO vo, HttpSession session) {
			ModelAndView mav = new ModelAndView();
			String managerid = String.valueOf(session.getAttribute("logId"));
			vo.setTotalRecord(service.getTotalRecordByManagerid(managerid));
			vo.setManagerid(managerid);
		    mav.addObject("managerList", service.pageSelect(vo));
		    mav.addObject("vo", vo);
		    mav.setViewName("/manager/managerPast");
	    return mav;
	}

		
		 @GetMapping("/managerInput")
		 public ModelAndView managerInputManager2(@RequestParam(value = "rank", required = false) String rank,
				 								 @RequestParam(value = "p_no", required = false) Integer p_no,
				 								 HttpSession session) {
		     ModelAndView mav = new ModelAndView();
		     String managerid = String.valueOf(session.getAttribute("logId"));
							   
		     List<Manager10DTO> managerInputList;
		     if (rank != null) {
		         managerInputList = service.getAllManagerInputByManagerid(rank, p_no);
		     } else {
		         managerInputList = service.getAllManagerInput();
		     }
		     mav.addObject("managerInputList", managerInputList);
		     mav.setViewName("/manager/managerInput");
		     return mav;
		 }
		
		 @PostMapping("/managerInput")
		 @ResponseBody
		 public ResponseEntity<String> submitRank(@RequestBody List<Manager10DTO> managerInputList) {		    
		     try {
		         for (Manager10DTO managerInput : managerInputList) {
		             service.updateRank(managerInput.getUserid(), managerInput.getRank(), managerInput.getP_no());
		         }
		     }  catch (Exception e) {
//		    	 System.out.println(e.getMessage());
//		         System.out.println("manager rank input fail");
		     }
		     return new ResponseEntity<String>("ok", HttpStatus.OK);
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
