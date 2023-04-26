package com.gather.we.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gather.we.dto.RParticipateDTO;
import com.gather.we.dto.RankGameDetailDTO;
import com.gather.we.dto.UserPayDTO;
import com.gather.we.dto.UserPayDoneDTO;
import com.gather.we.dto.UsersDTO;
import com.gather.we.service.RParticipateService;
import com.gather.we.service.RankGameService;
import com.gather.we.service.UserPayService;
import com.gather.we.service.UsersService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

@RestController
public class UserPayController {
	@Autowired
	RankGameService rankGameService;
	
	@Autowired
	UsersService usersService;
	
	@Autowired
	UserPayService userPayService;
	
	@Autowired
	RParticipateService rParticipateService;
	
	// 로그인기능 완료되면 세션에서 받아오는걸로 수정
	String userid = "man2";
	
	// 결제페이지
	@GetMapping("/payment")
	public ModelAndView makePayment(int no, String gametype) {
		ModelAndView mav = new ModelAndView();
		
		RankGameDetailDTO rankGameDetail = rankGameService.rankGameDetailSelect(no);
		UsersDTO participantInfo = usersService.participantInfoSelect(userid);
		
		mav.addObject("gametype", gametype);
		mav.addObject("rankGameDetail", rankGameDetail);
		mav.addObject("participantInfo", participantInfo);
		mav.setViewName("user/payment/payment");
		
		return mav;
	}
	
	// 결제(DB)
	@PostMapping("/paymentOk")
	public JsonObject makePaymentOk(int no, String gametype, String payment_no, String payer_name, int paid_amount, int paid_at, String success) {
		
		UserPayDTO userPayDTO = new UserPayDTO();
		userPayDTO.setPayment_no(payment_no);
		userPayDTO.setPayer_name(payer_name);
		userPayDTO.setPaid_amount(paid_amount);
		userPayDTO.setPaid_at(paid_at);
		userPayDTO.setSuccess(success);
		
		RParticipateDTO rParticipateDTO = new RParticipateDTO();
		rParticipateDTO.setUserid(userid);
		rParticipateDTO.setNo(no);
		rParticipateDTO.setPayment_no(payment_no);
		
		try {
			// 사용자결제 테이블에 결제내역 저장
			int userPayResult = userPayService.userPayInsert(userPayDTO);
		    if(userPayResult<=0) {
		    	throw new Exception("사용자 결제내역 저장을 실패하였습니다.");			    	
		    }
		    
			// 경기유형이 랭크경기인 경우
			if(gametype.equals("rankgame")) {
				// 랭크경기참여 테이블에 데이터 저장
				int rParticipateResult = rParticipateService.rParticipateInsert(rParticipateDTO);
				
				// 랭크경기 테이블에 현재인원수 업데이트
				int currPeopleCountResult = rankGameService.currPeopleCount(no);
				
			    if(rParticipateResult<=0) {
			    	throw new Exception("랭크경기 참여내역 저장을 실패하였습니다.");	    	
			    } else if(currPeopleCountResult<=0) {
			    	throw new Exception("랭크경기 현재인원수 업데이트를 실패하였습니다.");    	
			    }
			}
		} catch (Exception e)    {
			    System.out.println("err_msg : " + e.getMessage());
			    e.printStackTrace();
		}
		
		// 결제번호와 경기유형을 json으로 저장하여 뷰페이지에 전달
		JsonObject paymentObj = new JsonObject();
		paymentObj.addProperty("payment_no", payment_no);
        paymentObj.addProperty("gametype", gametype);
		
		return paymentObj;
	}
	
	// 결제완료 페이지
	@GetMapping("/payment/paymentDone")
	public ModelAndView completePayment(String payment_no) {
		ModelAndView mav = new ModelAndView();
		
		// 결제완료 페이지에 보여줄 경기정보와 결제금액을 DB에서 받아오기
		UserPayDoneDTO payDoneInfo = userPayService.rankPayDoneSelect(payment_no);
		
		mav.addObject("payDoneInfo", payDoneInfo);
		mav.setViewName("user/payment/paymentDone");
		
		return mav;
	}
}