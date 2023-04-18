package com.gather.we.dao;

import java.util.List;

import com.gather.we.dto.MypageApplyListDTO;
import com.gather.we.dto.MypageUserDTO;

public interface MypageDAO {
	//db�� ��ϵ� ����� 1���� ���� �������� --test��
	public MypageUserDTO getUserinfo(String userid);
	//username �����ʾƷ��� �ֱ�
	public String getUsername(String userid);
	
	//////applyList�� �ʿ��� ���� �������� : ��ũ��, �Ϲ���
	//	��ũ��
	//����� ��������
	public List<MypageApplyListDTO> getSportName(String userid);
	//��⳯¥, ��ũ������
	public List<MypageApplyListDTO> getRankgameInfo(String userid);
	//��ⱸ���
	public List<MypageApplyListDTO> getStadium(String userid);

}
