package com.gather.we.dto;

public class PagingVO {
	//private static final int onePageNumCount = 0;
		//����¡�� �ʿ��� ������
		private int nowPage = 1;//����������
		private int onePageRecord = 4; //�� �������� ǥ���� ���ڵ� ��
		private int totalRecord;//�� ���ڵ� ��
		private int totalPage;//�� ������ ��
		//������ �������� ���� �ִ� ���ڵ� ��. 
		private int lastPageRecord;
//		private int onPageNumCount=3; //�������� �� ������ ����
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
		//�˻��� �ʿ��� ������



}





