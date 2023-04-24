package com.gather.we.dto;



public class PageDTO {
	
	private int startPage;
	private int endPage;
	private boolean prev, next;
	
	private int total;
	private Criteria cri;
	private int realEnd;			
	
	

	@Override
	public String toString() {
		return "PageDTO [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", cri=" + cri + ", realEnd=" + realEnd + "]";
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Criteria getCri() {
		return cri;
	}
	public void setCri(Criteria cri) {
		this.cri = cri;
	}
	
	

	public int getRealEnd() {
		return realEnd;
	}

	public void setRealEnd(int realEnd) {
		this.realEnd = realEnd;
	}

	public PageDTO(Criteria cri, int total) {
		
		this.cri = cri;
		this.total =total;
		
		this.endPage = (int) (Math.ceil(cri.getStartPageNum() / 10.0)) * 10;
		
		this.startPage = this.endPage - 9;
		
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		this.prev = this.startPage > 1;
		
		this.next = this.endPage < realEnd;
	}
	
}