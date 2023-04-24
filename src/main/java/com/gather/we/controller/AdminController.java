package com.gather.we.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.AdminDTO;
import com.gather.we.dto.RegisterDTO;
import com.gather.we.service.AdminService;
import com.gather.we.service.RegisterService;


import java.io.File;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;


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
	
	//濡쒓렇�씤(DB)
	@PostMapping("/loginAdminOk")
	public ModelAndView loginAdminOk(String adminid, String password, HttpServletRequest request, HttpSession session) {
		// Session 媛앹껜 �뼸�뼱�삤湲�
		// 留ㅺ컻蹂��닔濡� HttpServletRequest request -> Session 援ы븯湲�
		// 留ㅺ컻蹂��닔濡� HttpSession session
		System.out.println("admin->"+adminid);
		AdminDTO dto = service.loginAdminOk(adminid, password);
		// dto->null�씤 寃쎌슦 �꽑�깮�젅肄붾뱶媛� �뾾�떎. -濡쒓렇�씤�떎�뙣
		// 		null�씠 �븘�땶 寃쎌슦 �꽑�깮�젅肄붾뱶 �엳�떎. - 濡쒓렇�씤 �꽦怨�
		ModelAndView mav = new ModelAndView();
		if(dto!=null) {//濡쒓렇�씤 �꽦怨�
			session.setAttribute("logId", dto.getAdminid());
			session.setAttribute("logName", dto.getAdmin_name());
			session.setAttribute("logStatus", "Y");
			mav.setViewName("redirect:/");
		}else{//濡쒓렇�씤 �떎�뙣
			mav.setViewName("redirect:loginAdmin");
			System.out.println(adminid);
			System.out.println(password);
		}
		return mav;
	}
			
			//(愿�由ъ옄 �럹�씠吏�)�쉶�썝 由ъ뒪�듃
			@GetMapping("admin/userList")
			public ModelAndView loginList() {
				ModelAndView mav = new ModelAndView();
				
				List<RegisterDTO> list = regservice.dataAllSelect();
				
				mav.addObject("list", list);
				mav.setViewName("admin/userList");
				
				return mav;
			}
			//(愿�由ъ옄 �럹�씠吏�)�쉶�썝�젙蹂� �닔�젙�뤌
			@GetMapping("admin/userEdit/{userid}")
			public ModelAndView loginEdit(@PathVariable("userid") String userid) {
				RegisterDTO dto = regservice.registerEdit(userid);
				ModelAndView mav = new ModelAndView();
				mav.addObject("dto", dto);
				mav.setViewName("admin/userEdit");
				return mav;
			}
	// �넫�굝�걠 筌뤴뫖以�
	@GetMapping("/sport/sportlist")
	public ModelAndView sportList() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/sport/sportList");
		
		return mav;
	}
	
	// �넫�굝�걠 占쎈쾻嚥∽옙
	@GetMapping("/sport/new")
	public ModelAndView sportNew() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/sport/sportNew");
		
		return mav;
	}
	
	// �넫�굝�걠 占쎈쾻嚥∽옙(DB)
	@PostMapping("/sport/newOk")
	public ModelAndView sportNewOk(HttpServletRequest request){
		SportDTO dto = new SportDTO();
		dto.setSportname(request.getParameter("sportname"));
		dto.setSportdesc(request.getParameter("sportdesc"));
		
		// 占쎈솁占쎌뵬 占쎈씜嚥≪뮆諭� �뤃�뗭겱
		MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request;
		
		// mr占쎈퓠占쎄퐣 MultipartFile揶쏆빘猿쒐몴占� 占쎈섯占쎈선占쎌궎疫뀐옙
		MultipartFile file = mr.getFile("filename"); //form占쎈퓠 占쎌뿳占쎈뮉 name
		
		// 占쎈솁占쎌뵬占쎌뱽 占쎄퐣甕곌쑴肉� 占쎈씜嚥≪뮆諭띰옙釉� 占쎌맄燁살꼷�벥 占쎌쟿占쏙옙雅뚯눘�꺖
		String path = request.getSession().getServletContext().getRealPath("/uploadfile/sport");
		System.out.println("path->" + path);
		
		if(file!=null) {//占쎈씜嚥≪뮆諭� 占쎈솁占쎌뵬占쎌뵠 占쎌뿳占쎌뱽 野껋럩�뒭			
			String orgFilename = file.getOriginalFilename();// 占쎄텢占쎌뒠占쎌쁽揶쏉옙 占쎈씜嚥≪뮆諭띰옙釉� 占쎈솁占쎌뵬筌륅옙
			if(orgFilename != null && !orgFilename.equals("")) {
				// 揶쏆늿占� 占쎈솁占쎌뵬筌뤿굞�뵠 占쎌뵠沃섓옙 鈺곕똻�삺占쎈릭筌롳옙 rename 占쎈땾占쎈뻬
				File f = new File(path, orgFilename);
				if(f.exists()) {
					//	abc.gif -> abc (1).gif -> abc (2).gif -> abc (3).gif
					for(int renameNum=1;;renameNum++) {// 1,2,3,4....
						// 占쎈솁占쎌뵬筌륅옙, 占쎌넇占쎌삢占쎌쁽�몴占� 占쎄돌占쎈듌占쎈뼄.
						int point = orgFilename.lastIndexOf(".");// 筌띾뜆占쏙쭕占� .占쎌벥 占쎌맄燁살꼵�럡占쎈릭疫뀐옙
						String orgFile = orgFilename.substring(0, point);// 占쎌넇占쎌삢占쎌쁽�몴占� 筌먲옙 占쎈솁占쎌뵬筌륅옙
						String orgExt = orgFilename.substring(point+1);// 占쎌넇占쎌삢占쎌쁽
						
						String newFilename = orgFile+" ("+renameNum+")."+orgExt;//占쎄퉱嚥≪뮆彛뷂옙諭억옙堉깍쭪占� 占쎈솁占쎌뵬筌륅옙
						f = new File(path, newFilename);
						if(!f.exists()) {// 占쎄퉱嚥∽옙 筌띾슢諭� 占쎈솁占쎌뵬占쎌뵠 鈺곕똻�삺占쎈릭筌욑옙 占쎈륫占쎌몵筌롳옙 獄쏆꼶�궗�눧占� 餓λ쵎�뼊
							orgFilename = newFilename;
							break;
						}
					}
				}
				
				// 占쎈솁占쎌뵬 占쎈씜嚥≪뮆諭� 占쎈땾占쎈뻬
				try {
					file.transferTo(new File(path, orgFilename));
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				// 占쎈솁占쎌뵬筌뤿굞�뱽 DB占쎈퓠 占쏙옙占쎌삢占쎈릭疫뀐옙 占쎌맄占쎈퉸 dto占쎈퓠 占쎈�묕옙�샒
				dto.setFilename(orgFilename);
			}
		}

		ModelAndView mav = new ModelAndView();
		try {
			// 占쎌삂占쎄쉐占쎈쭆 疫뀐옙 占쎄땀占쎌뒠占쎌뱽 DB占쎈퓠 占쏙옙占쎌삢
			int result = sportService.sportInsert(dto);

			// 占쎌젟占쎄맒筌ｌ꼶�봺占쎈┷筌롳옙 �넫�굝�걠 筌뤴뫖以� 占쎈읂占쎌뵠筌욑옙嚥∽옙 占쎌뵠占쎈짗
			mav.setViewName("redirect:sportlist");
			
		}catch(Exception e) {
			// 占쎌쟿�굜遺얜굡 �빊遺쏙옙 占쎈퓠占쎌쑎
			e.printStackTrace();
			
			// 占쎈솁占쎌뵬占쎄텣占쎌젫 
			fileDelete(path, dto.getFilename());
			
			// DB占쎈퓠 占쏙옙占쎌삢占쎈쭆 占쎌쟿�굜遺얜굡 占쎄텣占쎌젫
			sportService.sportDelete(dto.getS_no());
			
			mav.addObject("msg", "�넫�굝�걠 占쎈쾻嚥∽옙 占쎈뼄占쎈솭占쎈릭占쏙옙占쎈뮸占쎈빍占쎈뼄.");
			mav.setViewName("admin/dataResult");
		}
		
		return mav;
	}           

	// 占쎈씜嚥≪뮆諭띰옙留� 占쎈솁占쎌뵬 占쎄텣占쎌젫
	public void fileDelete(String path, String filename) {
		File f = new File(path, filename);
		f.delete();
	}
	
	// 占쎌삻占쎄쾿野껋럡由� 筌뤴뫖以�
	@GetMapping("/rankgame/rankgamelist")
	public ModelAndView rankGameList() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("admin/rankGame/rankGameList");
		
		return mav;
	}
	
	// 占쎌삻占쎄쾿野껋럡由� 占쎈쾻嚥∽옙
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
	
	// 占쎌삻占쎄쾿野껋럡由� 占쎈쾻嚥∽옙(DB)
	@PostMapping("/rankgame/newOk")
	public ModelAndView rankgameNewOk(RankGameDTO dto){
		ModelAndView mav = new ModelAndView();
		try {
			// 占쎌삂占쎄쉐占쎈쭆 占쎌삻占쎄쾿野껋럡由� 占쎄땀占쎌뒠占쎌뱽 DB占쎈퓠 占쏙옙占쎌삢
			int result = rankGameService.rankGameInsert(dto);

			// 占쎌젟占쎄맒筌ｌ꼶�봺占쎈┷筌롳옙 占쎌삻占쎄쾿野껋럡由� 筌뤴뫖以� 占쎈읂占쎌뵠筌욑옙嚥∽옙 占쎌뵠占쎈짗
			mav.setViewName("redirect:rankgamelist");
			
		}catch(Exception e) {
			// 占쎌쟿�굜遺얜굡 �빊遺쏙옙 占쎈퓠占쎌쑎
			e.printStackTrace();
			
			mav.addObject("msg", "占쎌삻占쎄쾿野껋럡由� 占쎈쾻嚥∽옙 占쎈뼄占쎈솭占쎈릭占쏙옙占쎈뮸占쎈빍占쎈뼄.");
			mav.setViewName("admin/dataResult");
		}
		
		return mav;
	}   

}
