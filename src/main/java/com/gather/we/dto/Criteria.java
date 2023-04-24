package com.gather.we.dto;


public class Criteria {

	private int nowPage = 1;//현재페이지
	private int onePageRecord = 10; //한 페이지에 표시할 레코드 수
	private int totalRecord;//총 레코드 수
	private int totalPage;//총 페이지 수
	//마지막 페이지에 남아 있는 레코드 수. 
	private int lastPageRecord;
//	private int onPageNumCount=3; //한페이지 당 페이지 개수
	private int startPageNum = 1;
	private int onePageNumCount=5;
	
	private double amount;
	
	private int pageNum;
	
	public Criteria() {
		this(1,10);
	}
	
	
	
	
	
	public Criteria(int pageNum, int amount) {
		this.pageNum = pageNum;
		this.amount = amount;
	}





	@Override
	public String toString() {
		return "Criteria [nowPage=" + nowPage + ", onePageRecord=" + onePageRecord + ", totalRecord=" + totalRecord
				+ ", totalPage=" + totalPage + ", lastPageRecord=" + lastPageRecord + ", startPageNum=" + startPageNum
				+ ", onePageNumCount=" + onePageNumCount + ", amount=" + amount + ", pageNum=" + pageNum + "]";
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getOnePageRecord() {
		return onePageRecord;
	}
	public void setOnePageRecord(int onePageRecord) {
		this.onePageRecord = onePageRecord;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getLastPageRecord() {
		return lastPageRecord;
	}
	public void setLastPageRecord(int lastPageRecord) {
		this.lastPageRecord = lastPageRecord;
	}
	public int getStartPageNum() {
		return startPageNum;
	}
	public void setStartPageNum(int startPageNum) {
		this.startPageNum = startPageNum;
	}
	public int getOnePageNumCount() {
		return onePageNumCount;
	}
	public void setOnePageNumCount(int onePageNumCount) {
		this.onePageNumCount = onePageNumCount;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	
	
	
	
	
	
}
