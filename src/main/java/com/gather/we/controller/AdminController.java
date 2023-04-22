package com.gather.we.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.ManagerDTO;
import com.gather.we.dto.RankGameDTO;
import com.gather.we.dto.SportDTO;
import com.gather.we.dto.StadiumInfoDTO;
import com.gather.we.service.AdminManagerService;
import com.gather.we.service.RankGameService;
import com.gather.we.service.SportService;
import com.gather.we.service.StadiumInfoService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	SportService sportService;
	@Autowired
	StadiumInfoService stadiumInfoService;
	@Autowired
	RankGameService rankGameService;
	@Autowired
	AdminManagerService adminManagerService;
	
	// 종목 목록
	@GetMapping("/sport/sportlist")
	public ModelAndView sportList() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/sport/sportList");
		
		return mav;
	}
	
	// 종목 등록
	@GetMapping("/sport/new")
	public ModelAndView sportNew() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/sport/sportNew");
		
		return mav;
	}
	
	// 종목 등록(DB)
	@PostMapping("/sport/newOk")
	public ModelAndView sportNewOk(HttpServletRequest request){
		SportDTO dto = new SportDTO();
		dto.setSportname(request.getParameter("sportname"));
		dto.setSportdesc(request.getParameter("sportdesc"));
		
		// 파일 업로드 구현
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request;
		
		// mr에서 MultipartFile객체를 얻어오기
		MultipartFile file = mr.getFile("filename"); //form에 있는 name
		
		// 파일을 서버에 업로드할 위치의 절대주소
		String path = request.getSession().getServletContext().getRealPath("/uploadfile/sport");
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
				dto.setFilename(orgFilename);
			}
		}

		ModelAndView mav = new ModelAndView();
		try {
			// 작성된 글 내용을 DB에 저장
			int result = sportService.sportInsert(dto);

			// 정상처리되면 종목 목록 페이지로 이동
			mav.setViewName("redirect:sportlist");
			
		}catch(Exception e) {
			// 레코드 추가 에러
			e.printStackTrace();
			
			// 파일삭제 
			fileDelete(path, dto.getFilename());
			
			// DB에 저장된 레코드 삭제
			sportService.sportDelete(dto.getS_no());
			
			mav.addObject("msg", "종목 등록 실패하였습니다.");
			mav.setViewName("admin/dataResult");
		}
		
		return mav;
	}           

	// 업로드된 파일 삭제
	public void fileDelete(String path, String filename) {
		File f = new File(path, filename);
		f.delete();
	}
	
	// 랭크경기 목록
	@GetMapping("/rankgame/rankgamelist")
	public ModelAndView rankGameList() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/rankGame/rankGameList");
		
		return mav;
	}
	
	// 랭크경기 등록
	@GetMapping("/rankgame/new")
	public ModelAndView rankGameNew() {
		ModelAndView mav = new ModelAndView();
		
		List<SportDTO> sportList = sportService.sportAllSelect();
		List<StadiumInfoDTO> stadiumInfoList = stadiumInfoService.stadiumInfoAllSelect();
		
		mav.addObject("sportList", sportList);
		mav.addObject("stadiumInfoList", stadiumInfoList);
		mav.setViewName("admin/rankGame/rankGameNew");
		
		return mav;
	}
	
	// 랭크경기 등록(DB)
	@PostMapping("/rankgame/newOk")
	public ModelAndView rankgameNewOk(RankGameDTO dto){
		ModelAndView mav = new ModelAndView();
		try {
			// 작성된 랭크경기 내용을 DB에 저장
			int result = rankGameService.rankGameInsert(dto);

			// 정상처리되면 랭크경기 목록 페이지로 이동
			mav.setViewName("redirect:rankgamelist");
			
		}catch(Exception e) {
			// 레코드 추가 에러
			e.printStackTrace();
			
			mav.addObject("msg", "랭크경기 등록 실패하였습니다.");
			mav.setViewName("admin/dataResult");
		}
		
		return mav;
	}   
	
	// 매니저 승인 요청 목록
	@GetMapping("/manager/approvelist")
	public ModelAndView managerApproveList() {
		ModelAndView mav = new ModelAndView();
		
		// 매니저 계정 승인 요청 목록을 DB에서 조회
		mav.addObject("list", adminManagerService.approveList());
		
		mav.setViewName("admin/allManager/managerApproveList");
		
		return mav;
	}
	
	// 매니저 승인 요청 상세
	@GetMapping("/manager/approvedetail")
	public ModelAndView managerApproveDetail(String managerid) {
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("dto", adminManagerService.approveDetail(managerid));
		
		mav.setViewName("admin/allManager/managerApproveDetail");
		
		return mav;
	}
	
	// 매니저 요청 승인 (매니저 계정 활성화)
	@PostMapping("/manager/approveOk")
	public ModelAndView managerApproveOk(String managerid) {
		ModelAndView mav = new ModelAndView();
		
		adminManagerService.approveOk(managerid);
		
		mav.setViewName("redirect:approvelist");
		
		return mav;
	}
	
	// 매니저 요청 거부 (요청 계정 DB에서 삭제)
	@PostMapping("/manager/refuseOk")
	public ModelAndView managerRefuseOk(String managerid) {
		ModelAndView mav = new ModelAndView();
		
		adminManagerService.refuseOk(managerid);
		
		
		mav.setViewName("redirect:approvelist");
		
		return mav;
	}
	
	// 매니저 목록 조회
	@GetMapping("/manager/managerlist")
	public ModelAndView managerList() {
		ModelAndView mav = new ModelAndView();
		List<ManagerDTO> olist = adminManagerService.managerList();
		List<ManagerDTO> nlist = new ArrayList<ManagerDTO>();
		
		try {
			Iterator<ManagerDTO> ir = olist.iterator();
			
			while(ir.hasNext()) {
				ManagerDTO dto = ir.next();
				String managerid = dto.getManagerid();
				
				List<RankGameDTO> rank = adminManagerService.managerRecent(managerid);
				
				if(!rank.isEmpty()) dto.setRankgameList(rank);
				
				nlist.add(dto);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		mav.addObject("list", nlist);
		
		mav.setViewName("admin/allManager/managerList");
		
		return mav;
	}
}
