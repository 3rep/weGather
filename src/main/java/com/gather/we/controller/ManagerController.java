package com.gather.we.controller;


import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gather.we.dto.Criteria;
import com.gather.we.dto.PageDTO;
import com.gather.we.dto.RankGameDTO;
import com.gather.we.service.RankGameListService;


@Controller
@RequestMapping("/manager/*")
public class ManagerController{
	@Autowired
	RankGameListService rankGameListService;
	
	@GetMapping("/main")
	public void list(Criteria criteria, Model model) {
		
		//DB에서 가져오기 - criteria 데이터만 필요
		model.addAttribute("gamelist",rankGameListService.rankGameListAllSelect(criteria));
		//화면에 필요한 정보 가져오기, 계산하기(생성자에서 처리)
		int total = rankGameListService.getTotalCount(criteria);
		model.addAttribute("pageMaker", new PageDTO(criteria, total));
	}
	
	/**
	 * 랭크 경기 신청 Controller
	 * @param 	RankGameListDTO, Principal
	 * @return	ResponseEntity<?>
	 */
	@PostMapping("/apply")
	public ResponseEntity<?> apply(RankGameDTO rankGameDTO, Principal principal) {
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
}
