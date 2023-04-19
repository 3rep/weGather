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
		private int onePageNumCount=5;
		
		//
		//�˻��� �ʿ��� ������
		private String searchKey;
		private String searchWord;
		
		
		
		
		@Override
		public String toString() {
			return "PagingVO [nowPage=" + nowPage + ", onePageRecord=" + onePageRecord + ", totalRecord=" + totalRecord
					+ ", totalPage=" + totalPage + ", lastPageRecord=" + lastPageRecord + ", startPageNum=" + startPageNum
					+ ", onePageNumCount=" + onePageNumCount + ", searchKey=" + searchKey + ", searchWord=" + searchWord
					+ "]";
		}
		public int getNowPage() {
			return nowPage;
			

			//����� ������ ���� ��ȣ. 
			
		}
		public void setNowPage(int nowPage) {
			this.nowPage = nowPage;
		
			startPageNum= ((nowPage-1)/onePageNumCount)*onePageNumCount+1;
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
			
			//�ѷ��ڵ� ���� �̿��Ͽ� �������� ���� ���ϱ� 
			
			totalPage = (int)Math.ceil((double)totalRecord/onePageRecord);
			
			//������ �������� ���� �ִ� ���ڵ� ��
			
			lastPageRecord = onePageRecord;
			if(nowPage==totalPage) {
				if(totalRecord%onePageRecord==0){//�������� 0�� ���� lastPageRecord<- onePageRecord
					lastPageRecord = onePageRecord;
				}else{//�������� ���� ��� ���� �ִ� ���ڵ���� lastpageRecord
					lastPageRecord = totalRecord % onePageRecord;
				}
			}
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

		public String getSearchKey() {
			return searchKey;
		}

		public void setSearchKey(String searchKey) {
			this.searchKey = searchKey;
		}

		public String getSearchWord() {
			return searchWord;
		}

		public void setSearchWord(String searchWord) {
			this.searchWord = searchWord;
		}
		//�˻��� �ʿ��� ������
		
		
		
	}