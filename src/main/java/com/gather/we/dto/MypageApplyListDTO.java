package com.gather.we.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MypageApplyListDTO {

	private String userid; //���̵�
	private int no; //����Ϸù�ȣ 
	private String sportname; //�����
	private Date gametime; //���ð�
	private String stadium; //�����
	private int g_status; //��ũ��� ������
	private Date gt2ago;
	
	
	


	
	
}
