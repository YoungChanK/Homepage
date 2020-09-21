package org.young.domain;

public class Criteria {
	//페이지 번호
	private int pageNum;
	//페이지 당 데이터 수
	private int amount;
	//검색 종류(제목만, 내용만,작성자만, 제목 + 내용 ...)
	//keyword
	private String type;
	private String keyword;
	private String userid;
	public Criteria() {
		this(1,10);
	}
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}
	
	
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		if(pageNum<0) {
			this.pageNum=1;
			return;
		}
		
		this.pageNum = pageNum;
	}
	public int getAmount() {
		return amount;
	}
	public int getpageStart() {
		return (this.pageNum-1)*amount;
	}
	
	public void setAmount(int amount) {
		if(amount<=0 ||amount >100) {
			this.amount=10;
			return;
		}
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Criteria [pageNum=" + pageNum + ", amount=" + amount + ", type=" + type + ", keyword=" + keyword
				+ ", userid=" + userid + "]";
	}
}
