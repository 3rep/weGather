package com.gather.we.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gather.we.dto.NoticeBoardCriteria;
import com.gather.we.dto.NoticeBoardDTO;
import com.gather.we.dto.NoticeBoardPageDTO;
import com.gather.we.dto.RequestBoardCriteria;
import com.gather.we.dto.RequestBoardDTO;
import com.gather.we.dto.RequestBoardPageDTO;
import com.gather.we.service.NoticeBoardService;
import com.gather.we.service.RequestBoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	//공지사항
	@Autowired
	private NoticeBoardService noticeservice;
	
	@GetMapping("/noticeBoard")
	public String noticeBoard(Model model,NoticeBoardCriteria criteria){
		model.addAttribute("list", noticeservice.getList(criteria));
		int total = noticeservice.getTotalCount(criteria);
		model.addAttribute("pageMaker", new NoticeBoardPageDTO(criteria,total));
		return "user/board/noticeBoard";
	}
	
	@GetMapping("/noticeBoard/detail")
	public String noticeBoarddetail(@RequestParam("no") int no, Model model) {
		model.addAttribute("board",noticeservice.read(no));
		return "user/board/noticeBoardDetail";
	}
	
	
	@GetMapping("/modify")
	public String noticeBoardModify(@RequestParam("no") int no, Model model) {
		model.addAttribute("board",noticeservice.read(no));
		return "user/board/noticeBoardModify";
	}
	@PostMapping("/modify")
	public String noticeBoardModifyPost(NoticeBoardDTO dto) {
		noticeservice.modify(dto);
		return "redirect:/board/view?no=" + dto.getNo();
	}
	
	
	//건의사항
	@Autowired
	private RequestBoardService requestservice;
	//건의사항 목록(페이징적용)
	@GetMapping("/requestBoard")
	public String requestBoard(Model model, RequestBoardCriteria cri) {
		model.addAttribute("list", requestservice.getListPaging(cri));
		int total = requestservice.getTotal(cri);
		RequestBoardPageDTO page = new RequestBoardPageDTO(cri, total);
		model.addAttribute("pageMaker", page);
		return "user/board/requestBoard";
	}
	//건의사항 조회
	@GetMapping("/requestBoard/get")
	public String requestBoardGET(int no, Model model, HttpSession session) {
		
		boolean canEdit=false;
		if(session.getAttribute("logId") != null && requestservice.getPage(no).getUserid().equals(session.getAttribute("logId"))) {
			canEdit = true;
		}
		model.addAttribute("pageInfo", requestservice.getPage(no));
		model.addAttribute("canEdit", canEdit);
		return "user/board/requestBoardGet";
	}
	//건의사항 등록페이지
	@GetMapping("/requestBoard/enroll")
	public String requestBoardEnroll() {
		return "user/board/requestBoardEnroll";
	}
	//건의사항 등록
	@PostMapping("/requestBoard/enroll")
	public String requestBoardEnrollPOST(RequestBoardDTO dto, RedirectAttributes rttr, HttpSession session) {
		String logId = (String)session.getAttribute("logId");
		dto.setUserid(logId);
		requestservice.enroll(dto);
		rttr.addFlashAttribute("result", "enrol success");
		return "redirect:/board/requestBoard";
	}

	//건의사항 수정페이지 이동
	@GetMapping("/requestBoard/modify")
	public String requestBoardModifyGET(int no, Model model) {
		model.addAttribute("pageInfo", requestservice.getPage(no));
		return "user/board/requestBoardModify";
	}
	//건의사항 글 수정
	@PostMapping("requestBoard/modify")
	public String requestBoardModifyPOST(RequestBoardDTO dto, RedirectAttributes rttr, HttpSession session) {
		String logId = (String)session.getAttribute("logId");
		dto.setUserid(logId);
		requestservice.modify(dto);
		rttr.addFlashAttribute("result","modify success");
		return "redirect:/board/requestBoard";
	}
	
	//건의사항 글 삭제
	@PostMapping("/requestBoard/delete")
	public String requestBoardDeletePOST(int no, RedirectAttributes rttr) {
		requestservice.delete(no);
		rttr.addFlashAttribute("result","delete success");
		return "redirect:/board/requestBoard";
	}
}


