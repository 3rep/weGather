package com.gather.we.dao;

import com.gather.we.dto.MypageDTO;

public interface MypageDAO {
	//db�� ��ϵ� ����� ���� ��������
	public MypageDTO getUserinfo(String userid);
	//username �����ʾƷ��� �ֱ�
	public String getUsername(String userid);
}
