package com.gather.we.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gather.we.dto.RankBoardCriteria;
import com.gather.we.dto.RankBoardPageDTO;
import com.gather.we.service.RankBoardService;

@Controller
@RequestMapping("/user/rankBoard/*")
public class RankBoardController {
	
	@Autowired
	private RankBoardService service;
	
	@GetMapping("/rankBoard")
	public void rankBoard(RankBoardCriteria criteria,Model model) {
		model.addAttribute("ranklist", service.getUserRankList(criteria));
		int total = service.getTotalCount(criteria);
		model.addAttribute("pageMaker", new RankBoardPageDTO(criteria,total));
	}
	
}
