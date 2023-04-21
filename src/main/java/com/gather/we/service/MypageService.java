package com.gather.we.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gather.we.dao.MypageDAO;
import com.gather.we.dto.MypageApplyListDTO;
import com.gather.we.dto.MypageRankDTO;
import com.gather.we.dto.MypageUserDTO;

@Service
public interface MypageService {
	//db�� ��ϵ� ����� 1���� ���� �������� --test��
	public MypageUserDTO getUserinfo(String userid);
	
	public String getUsername(String userid); 
	
	//////applyList�� �ʿ��� ���� ��������
	//��� ���(��ũ+�Ϲ�)
	public List<MypageApplyListDTO> allgameList(String userid);
	//��ũ��
	public List<MypageApplyListDTO> rankgameList(String userid); 
	//�Ϲ���
	public List<MypageApplyListDTO> normgameList(String userid);
	
	//rank ���� ��������
	public List<MypageRankDTO> rank(String userid, String sportname);




}
