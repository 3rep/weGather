package com.gather.we.controller;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.ManagerDTO;
import com.gather.we.dto.SportDTO;
import com.gather.we.service.ManagerService;
import com.gather.we.service.SportService;

@Controller
public class ManagerController {
	@Autowired
	ManagerService service;
	
	@Autowired
	SportService sportservice;
	
	//회원가입 폼
	@GetMapping("/manager")
	public ModelAndView manager() {
		
		ModelAndView mav = new ModelAndView();
		List<SportDTO> sportList = sportservice.dataSelect();
		mav.addObject("sportList", sportList);
		mav.setViewName("manager/manager");
		System.out.println(sportList);
		return mav;
	}
	
	@PostMapping("/managerOk")
	public ModelAndView managerOk(HttpServletRequest request){
		ManagerDTO dto = new ManagerDTO();
		dto.setManagerid(request.getParameter("managerid"));
		dto.setType(request.getParameter("type"));
		dto.setPassword(request.getParameter("password"));
		dto.setM_name(request.getParameter("m_name"));
		dto.setAddress(request.getParameter("address"));
		dto.setEmail(request.getParameter("email"));
		dto.setGender(request.getParameter("gender"));
		dto.setM_account(request.getParameter("m_account"));
		
		String tel =request.getParameter("tel1") +"-"+ request.getParameter("tel2") +"-"+ request.getParameter("tel3");
		dto.setTel(tel);
		dto.setS_no(Integer.parseInt(request.getParameter("s_no")));
	//public ModelAndView managerOk(MultipartHttpServletRequest multi, ManagerDTO dto){
		System.out.println("qwer");
		// 파일 업로드 구현
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request;
		
		// mr에서 MultipartFile객체를 얻어오기
		MultipartFile file = mr.getFile("prooffile"); //form에 있는 name
		//MultipartFile file = multi.getFile("prooffile");
		
		// 파일을 서버에 업로드할 위치의 절대주소
		//String path = request.getSession().getServletContext().getRealPath("/uploadfile");
		String path = request.getSession().getServletContext().getRealPath("/uploadfile");
		System.out.println("path->" + path);
		
		if(file!=null) {//업로드 파일이 있을 경우			
			String orgFilename = file.getOriginalFilename();// 사용자가 업로드한 파일명
			if(orgFilename != null && !orgFilename.equals("")) {
				// 같은 파일명이 이미 존재하면 rename 수행
				File f = new File(path, orgFilename);
				if(f.exists()) {
					//	abc.gif -> abc (1).gif -> abc (2).gif -> abc (3).gif
					for(int renameNum=1;;renameNum++) {// 1,2,3,4....
						// 파일명, 확장자를 나눈다.
						int point = orgFilename.lastIndexOf(".");// 마지막 .의 위치구하기
						String orgFile = orgFilename.substring(0, point);// 확장자를 뺀 파일명
						String orgExt = orgFilename.substring(point+1);// 확장자
						
						String newFilename = orgFile+" ("+renameNum+")."+orgExt;//새로만들어진 파일명
						f = new File(path, newFilename);
						if(!f.exists()) {// 새로 만들 파일이 존재하지 않으면 반복문 중단
							orgFilename = newFilename;
							break;
						}
					}
				}
				
				// 파일 업로드 수행
				try {
					file.transferTo(new File(path, orgFilename));
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				// 파일명을 DB에 저장하기 위해 dto에 셋팅
				dto.setProoffile(orgFilename);
			}
		}

		ModelAndView mav = new ModelAndView();
		try {
			// 작성된 글 내용을 DB에 저장
			int result = service.managerInsert(dto);

			// 정상처리되면 종목 목록 페이지로 이동
			mav.setViewName("redirect:/loginMan");
			
		}catch(Exception e) {
			// 레코드 추가 에러
			e.printStackTrace();
			
			// 파일삭제 
			fileDelete(path, dto.getProoffile());
			
			// DB에 저장된 레코드 삭제
			service.dataDelete(dto.getManagerid());
			mav.addObject("msg", "종목 등록 실패하였습니다.");
			mav.setViewName("manager/managerOkResult");
		}
		return mav;
	}
		// 업로드된 파일 삭제
		public void fileDelete(String path, String filename) {
			File f = new File(path, filename);
			f.delete();
		}
		
		//로그인폼
		@GetMapping("/loginMan")
		public String loginMan() {
			return "manager/loginMan";	
		}
		
		//로그인(DB)
		@PostMapping("/loginManOk")
		public ModelAndView loginManOk(String managerid, String password, HttpServletRequest request, HttpSession session) {
			// Session 객체 얻어오기
			// 매개변수로 HttpServletRequest request -> Session 구하기
			// 매개변수로 HttpSession session
			System.out.println("managerid->"+managerid);
			ManagerDTO dto = service.loginManOk(managerid, password);
			// dto->null인 경우 선택레코드가 없다. -로그인실패
			// 		null이 아닌 경우 선택레코드 있다. - 로그인 성공
			ModelAndView mav = new ModelAndView();
			if(dto!=null) {//로그인 성공
				session.setAttribute("logId", dto.getManagerid());
				session.setAttribute("logName", dto.getM_name());
				session.setAttribute("logStatus", "Y");
				mav.setViewName("redirect:/");
			}else{//로그인 실패
				mav.setViewName("redirect:loginMan");
				System.out.println(managerid);
				System.out.println(password);
			}
			return mav;
		}
}
