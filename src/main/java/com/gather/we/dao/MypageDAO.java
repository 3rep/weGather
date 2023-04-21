package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.MypageApplyListDTO;
import com.gather.we.dto.MypageRankDTO;
import com.gather.we.dto.MypageUserDTO;

public interface MypageDAO {
	//db�� ��ϵ� ����� 1���� ���� �������� --test��
	public MypageUserDTO getUserinfo(String userid);
	//username �����ʾƷ��� �ֱ�
	public String getUsername(String userid);
	
	//applyList �������� �ʿ��� �޼ҵ�
	//��� ���(��ũ+�Ϲ�)
	public List<MypageApplyListDTO> allgameList(String userid);
	//��ũ��
	public List<MypageApplyListDTO> rankgameList(String userid); 
	//�Ϲ���
	public List<MypageApplyListDTO> normgameList(String userid);
	
	//rank ���� ��������
	public List<MypageRankDTO> rank(String userid, String sportname);

}
