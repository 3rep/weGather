package com.gather.we.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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


@Controller
@RequestMapping("/manager/*")
public class ManagerPageController{
	@Autowired
	ManagerRankGameListService rankGameListService;
	
	@Autowired
	ManagerSettlementService mSettlementService;
	
	//매니저 랭크 경기 목록
	@GetMapping("/rankgamelist")
	public String list(HttpServletResponse res, HttpSession session, MRankGameListCriteria criteria, Model model) throws IOException {
		if (session == null || session.getAttribute("logS_no") == null) return "redirect:/loginMan";
		//DB에서 가져오기 - criteria 데이터만 필요
		model.addAttribute("gamelist", rankGameListService.rankGameListAllSelect(criteria,(Integer) session.getAttribute("logS_no") ));
		//화면에 필요한 정보 가져오기, 계산하기(생성자에서 처리)
		int total = rankGameListService.getTotalCount((Integer) session.getAttribute("logS_no"));
		model.addAttribute("pageMaker", new PageDTO(criteria, total));
		return "manager/rankgamelist";
	}
	
	
	//매니저 랭크 경기 신청 모달
	@PostMapping("/apply")
	public ResponseEntity<?> apply(ManagerRankGameDTO rankGameDTO, HttpSession session) {
		try {
			
			String userId = (String)session.getAttribute("logId");
			rankGameDTO.setManagerid(userId);
			
			if (rankGameListService.updateApply(rankGameDTO) > 2) {		// update, insert 시 리턴 값이 2보다 클 경우 2개모두 성공하여야함
				// 성공
				return ResponseEntity.ok().body(rankGameDTO);
			} else {
				// 실패
				// 둘중 하나가 실패할경우 Rollback이 필요할 수도
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
	public void settlement(HttpSession session, Model model, MSettlementCriteria mscriteria){
		
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
		session.setAttribute("logId", null);
		session.setAttribute("logName", null);
		session.setAttribute("logStatus", "N");
		session.setAttribute("logS_no", null);
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
		    
		    System.out.println("mav: "+ mav);
		    return mav;
		}
/*	@PostMapping("/manager10")
	@ResponseBody
	public ResponseEntity<String> deleteRankGame(@RequestBody List<Manager10DTO> managerList) {
	    try {
	        if (manager.getManagerid() == null) {
	            return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	        }
	        service.deleteRankGame(manager.getManagerid(), manager.getNo());
	        return new ResponseEntity<String>("ok", HttpStatus.OK);
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        // Exception 처리
	    }
	    return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}*/
	
	@PostMapping("/manager10")
	@ResponseBody
	public ResponseEntity<String> updateRankGame(@RequestBody List<Manager10DTO> managerList) {		    
	    try {
	        for (Manager10DTO manager : managerList) {
	            Integer no = Integer.valueOf(manager.getNo());
	            String managerid = manager.getManagerid();
	            if (managerid != null && no != null) {
	                // rank_game 테이블에서 managerid를 null로 업데이트
	            	service.deleteMSettlement(managerid, no);
	            	service.updateRankGame(managerid, no);
	                // m_settlement 테이블에서 해당 정보 삭제
	                System.out.println("managerid=" + managerid + ", no=" + no);
	            }
	        }
	        return new ResponseEntity<String>("ok", HttpStatus.OK);
	    } catch (Exception e) {
	        e.printStackTrace();
	        System.out.println("manager delete fail");
	        return new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
		
	
//	fileDelete(path, dto.getFilename());
	
	// DB에 저장된 레코드 삭제
//	sportService.sportDelete(dto.getS_no());	
	

//	@DeleteMapping("/manager10")
//	@ResponseBody
//	public ResponseEntity<String> deleteRankGame(@PathVariable String managerid) {
//	    try {
//	        service.deleteRankGame(managerid);
//	        System.out.println("Deleted manager with ID: " + managerid);
//	        return ResponseEntity.ok("ok");
//	    } catch (Exception e) {
////	        System.out.println(e.getMessage());
//	        e.printStackTrace();
//	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
//	    }
//	}
	
	
/*	@PostMapping("/manager10")
	@ResponseBody
	public ResponseEntity<String> deleteRankGame(@RequestBody List<Manager10DTO> manager10List) {
		    try {
	        for (Manager10DTO manager10 : manager10List) {
	            if((manager10.getManagerid() == null || manager10.getManagerid().isEmpty())){
	                manager10.setManagerid(""); //초기화
	            }
	            service.deleteRankGame(manager10.getManagerid());
	            System.out.println("manager10"+manager10);
	        }
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	        // Exception 처리
	    }
	    return new ResponseEntity<String>("ok", HttpStatus.OK);
	}*/
	
	
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

		
	/*	 @GetMapping("/managerInput")
		 public ModelAndView managerInputManager2(@RequestParam(value = "rank", required = false) String rank,
				 								 @RequestParam(value = "no", required = false) Integer  p_no,
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
		 }*/	
		
		 @GetMapping("/managerInput")
		 public ModelAndView getAllManagerInput(@RequestParam(name = "no", defaultValue = "0") Integer no) {
		     ModelAndView mav = new ModelAndView();

		     // 1. 해당 경기에 참여한 회원 정보를 가져옵니다.
		     List<Manager10DTO> managerInputList = service.getAllManagerInput(no);
		 //    System.out.println("managerInputList" + managerInputList);
		 
		     if (managerInputList.isEmpty()) { // 데이터베이스 조회 결과가 비어있을 경우
		         mav.addObject("error", "데이터가 없습니다.");
		     } else { // 조회된 데이터가 있는 경우
		         mav.addObject("managerInputList", managerInputList);
		     }
		     
		     mav.addObject("managerInputList", managerInputList);
		     mav.addObject("no", no);
		     mav.setViewName("/manager/managerInput");

		     return mav;
		 }
		 
		
		 @PostMapping("/managerInput")
		 @ResponseBody
		 public ResponseEntity<String> updateRank(@RequestBody List<Manager10DTO> managerInputList) {		    
		     try {
		         for (Manager10DTO managerInput : managerInputList) {
		        	 Integer no = Integer.valueOf(managerInput.getNo());
		             service.updateRank(managerInput.getUserid(), managerInput.getRank(), managerInput.getNo());
		         }
		         return new ResponseEntity<String>("ok", HttpStatus.OK);
		     }  catch (Exception e) {
		    	 e.printStackTrace();
		    	 System.out.println("manager rank input fail");
		     }
		     return new ResponseEntity<String>("ok", HttpStatus.OK);
		 }
		
		 
		 @GetMapping("/entry")
		 public ModelAndView getAllEntry(@RequestParam(name = "no", defaultValue = "0") Integer no) {
		     ModelAndView mav = new ModelAndView();
		     System.out.println("no: "+ no);
		     
		     // 1. 해당 경기에 참여한 회원 정보를 가져옵니다.
		     List<Manager10DTO> entryList = service.getAllEntry(no);
		     System.out.println("entryList: " + entryList);
		     
		     if (entryList.isEmpty()) { // 데이터베이스 조회 결과가 비어있을 경우
		         mav.addObject("error", "데이터가 없습니다.");
		     } else { // 조회된 데이터가 있는 경우
		         mav.addObject("entryList", entryList);
		     }
		     
		     // 반복문, session 에 있는 s_no 정보를 entryList 의 s_no 에 저장
		     
		     
		     mav.addObject("entryList", entryList);
		     mav.addObject("no", no);
		     mav.setViewName("/manager/entry");

		     return mav;
		 }
		 }
