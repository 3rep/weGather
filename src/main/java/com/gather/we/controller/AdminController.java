package com.gather.we.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.AdminDTO;
import com.gather.we.dto.RegisterDTO;
import com.gather.we.service.AdminService;
import com.gather.we.service.RegisterService;


import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.RankGameDTO;
import com.gather.we.dto.SportDTO;
import com.gather.we.dto.StadiumInfoDTO;
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
	AdminService service;
	
	@Autowired
	RegisterService regservice;
	//로그인폼
			@GetMapping("/loginAdmin")
			public String loginAdmin() {
				return "admin/loginAdmin";	//	/WEB-INF/views/register/loginForm.jsp
			}
			
			//로그인(DB)
			@PostMapping("/loginAdminOk")
			public ModelAndView loginAdminOk(String adminid, String password, HttpServletRequest request, HttpSession session) {
				// Session 객체 얻어오기
				// 매개변수로 HttpServletRequest request -> Session 구하기
				// 매개변수로 HttpSession session
				System.out.println("admin->"+adminid);
				AdminDTO dto = service.loginAdminOk(adminid, password);
				// dto->null인 경우 선택레코드가 없다. -로그인실패
				// 		null이 아닌 경우 선택레코드 있다. - 로그인 성공
				ModelAndView mav = new ModelAndView();
				if(dto!=null) {//로그인 성공
					session.setAttribute("logId", dto.getAdminid());
					session.setAttribute("logName", dto.getAdmin_name());
					session.setAttribute("logStatus", "Y");
					mav.setViewName("redirect:/");
				}else{//로그인 실패
					mav.setViewName("redirect:loginAdmin");
					System.out.println(adminid);
					System.out.println(password);
				}
				return mav;
			}
			
			//(관리자 페이지)회원 리스트
			@GetMapping("admin/userList")
			public ModelAndView loginList() {
				ModelAndView mav = new ModelAndView();
				
				List<RegisterDTO> list = regservice.dataAllSelect();
				
				mav.addObject("list", list);
				mav.setViewName("admin/userList");
				
				return mav;
			}
			//(관리자 페이지)회원정보 수정폼
			@GetMapping("admin/userEdit/{userid}")
			public ModelAndView loginEdit(@PathVariable("userid") String userid) {
				RegisterDTO dto = regservice.registerEdit(userid);
				ModelAndView mav = new ModelAndView();
				mav.addObject("dto", dto);
				mav.setViewName("admin/userEdit");
				return mav;
			}
	// 醫낅ぉ 紐⑸줉
	@GetMapping("/sport/sportlist")
	public ModelAndView sportList() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/sport/sportList");
		
		return mav;
	}
	
	// 醫낅ぉ �벑濡�
	@GetMapping("/sport/new")
	public ModelAndView sportNew() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/sport/sportNew");
		
		return mav;
	}
	
	// 醫낅ぉ �벑濡�(DB)
	@PostMapping("/sport/newOk")
	public ModelAndView sportNewOk(HttpServletRequest request){
		SportDTO dto = new SportDTO();
		dto.setSportname(request.getParameter("sportname"));
		dto.setSportdesc(request.getParameter("sportdesc"));
		
		// �뙆�씪 �뾽濡쒕뱶 援ы쁽
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request;
		
		// mr�뿉�꽌 MultipartFile媛앹껜瑜� �뼸�뼱�삤湲�
		MultipartFile file = mr.getFile("filename"); //form�뿉 �엳�뒗 name
		
		// �뙆�씪�쓣 �꽌踰꾩뿉 �뾽濡쒕뱶�븷 �쐞移섏쓽 �젅��二쇱냼
		String path = request.getSession().getServletContext().getRealPath("/uploadfile/sport");
		System.out.println("path->" + path);
		
		if(file!=null) {//�뾽濡쒕뱶 �뙆�씪�씠 �엳�쓣 寃쎌슦			
			String orgFilename = file.getOriginalFilename();// �궗�슜�옄媛� �뾽濡쒕뱶�븳 �뙆�씪紐�
			if(orgFilename != null && !orgFilename.equals("")) {
				// 媛숈� �뙆�씪紐낆씠 �씠誘� 議댁옱�븯硫� rename �닔�뻾
				File f = new File(path, orgFilename);
				if(f.exists()) {
					//	abc.gif -> abc (1).gif -> abc (2).gif -> abc (3).gif
					for(int renameNum=1;;renameNum++) {// 1,2,3,4....
						// �뙆�씪紐�, �솗�옣�옄瑜� �굹�늿�떎.
						int point = orgFilename.lastIndexOf(".");// 留덉�留� .�쓽 �쐞移섍뎄�븯湲�
						String orgFile = orgFilename.substring(0, point);// �솗�옣�옄瑜� 類� �뙆�씪紐�
						String orgExt = orgFilename.substring(point+1);// �솗�옣�옄
						
						String newFilename = orgFile+" ("+renameNum+")."+orgExt;//�깉濡쒕쭔�뱾�뼱吏� �뙆�씪紐�
						f = new File(path, newFilename);
						if(!f.exists()) {// �깉濡� 留뚮뱾 �뙆�씪�씠 議댁옱�븯吏� �븡�쑝硫� 諛섎났臾� 以묐떒
							orgFilename = newFilename;
							break;
						}
					}
				}
				
				// �뙆�씪 �뾽濡쒕뱶 �닔�뻾
				try {
					file.transferTo(new File(path, orgFilename));
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				// �뙆�씪紐낆쓣 DB�뿉 ���옣�븯湲� �쐞�빐 dto�뿉 �뀑�똿
				dto.setFilename(orgFilename);
			}
		}

		ModelAndView mav = new ModelAndView();
		try {
			// �옉�꽦�맂 湲� �궡�슜�쓣 DB�뿉 ���옣
			int result = sportService.sportInsert(dto);

			// �젙�긽泥섎━�릺硫� 醫낅ぉ 紐⑸줉 �럹�씠吏�濡� �씠�룞
			mav.setViewName("redirect:sportlist");
			
		}catch(Exception e) {
			// �젅肄붾뱶 異붽� �뿉�윭
			e.printStackTrace();
			
			// �뙆�씪�궘�젣 
			fileDelete(path, dto.getFilename());
			
			// DB�뿉 ���옣�맂 �젅肄붾뱶 �궘�젣
			sportService.sportDelete(dto.getS_no());
			
			mav.addObject("msg", "醫낅ぉ �벑濡� �떎�뙣�븯���뒿�땲�떎.");
			mav.setViewName("admin/dataResult");
		}
		
		return mav;
	}           

	// �뾽濡쒕뱶�맂 �뙆�씪 �궘�젣
	public void fileDelete(String path, String filename) {
		File f = new File(path, filename);
		f.delete();
	}
	
	// �옲�겕寃쎄린 紐⑸줉
	@GetMapping("/rankgame/rankgamelist")
	public ModelAndView rankGameList() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/rankGame/rankGameList");
		
		return mav;
	}
	
	// �옲�겕寃쎄린 �벑濡�
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
	
	// �옲�겕寃쎄린 �벑濡�(DB)
	@PostMapping("/rankgame/newOk")
	public ModelAndView rankgameNewOk(RankGameDTO dto){
		ModelAndView mav = new ModelAndView();
		try {
			// �옉�꽦�맂 �옲�겕寃쎄린 �궡�슜�쓣 DB�뿉 ���옣
			int result = rankGameService.rankGameInsert(dto);

			// �젙�긽泥섎━�릺硫� �옲�겕寃쎄린 紐⑸줉 �럹�씠吏�濡� �씠�룞
			mav.setViewName("redirect:rankgamelist");
			
		}catch(Exception e) {
			// �젅肄붾뱶 異붽� �뿉�윭
			e.printStackTrace();
			
			mav.addObject("msg", "�옲�겕寃쎄린 �벑濡� �떎�뙣�븯���뒿�땲�떎.");
			mav.setViewName("admin/dataResult");
		}
		
		return mav;
	}   

}
