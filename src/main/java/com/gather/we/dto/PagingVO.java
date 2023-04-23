package com.gather.we.dto;

public class PagingVO {
	//private static final int onePageNumCount = 0;
		//페이징에 필요한 변수들
		private int nowPage = 1;//현재페이지
		private int onePageRecord = 4; //한 페이지에 표시할 레코드 수
		private int totalRecord;//총 레코드 수
		private int totalPage;//총 페이지 수
		//마지막 페이지에 남아 있는 레코드 수. 
		private int lastPageRecord;
//		private int onPageNumCount=3; //한페이지 당 페이지 개수
		private int startPageNum = 1;
		private int onePageNumCount=4;
		
						
		
		
		
		@Override
		public String toString() {
			return "PagingVO [nowPage=" + nowPage + ", onePageRecord=" + onePageRecord + ", totalRecord=" + totalRecord
					+ ", totalPage=" + totalPage + ", lastPageRecord=" + lastPageRecord + ", startPageNum="
					+ startPageNum + ", onePageNumCount=" + onePageNumCount + "]";
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
		
		//
		//검색에 필요한 변수들



}





