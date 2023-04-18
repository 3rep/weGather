package com.gather.we.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gather.we.dao.MypageDAO;
import com.gather.we.dto.MypageApplyListDTO;
import com.gather.we.dto.MypageUserDTO;

@Service
public interface MypageService {
	//db�� ��ϵ� ����� 1���� ���� �������� --test��
	public MypageUserDTO getUserinfo(String userid);
	
	public String getUsername(String userid); 
	
	//////applyList�� �ʿ��� ���� ��������
	//����� ��������
	public List<MypageApplyListDTO> getSportName(String userid);
	//��⳯¥, ��ũ������
	public List<MypageApplyListDTO> getRankgameInfo(String userid);
	//��ⱸ���
	public List<MypageApplyListDTO> getStadium(String userid);




}
