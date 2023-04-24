package com.gather.we.dto;

import lombok.Data;

@Data
public class Criteria {
	
	private int pageNum; // 현재 페이지 - page
	private int amount; //한페이지에 표시되는 데이터 갯수 - perPageNum
	
	public Criteria() {//기본값
		this.pageNum = 1;
		this.amount = 4;//한페이지에 데이터 4개씩 출력
	}
	
}
