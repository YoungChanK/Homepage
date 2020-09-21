package org.young.domain;

public class PageDTO {
	//첫번째 페이지
	private int startPage;
	private int endPage;
	//페이지 당 데이터 수
	private int amount;
	//이전 ,다음 페이지 여부
	private boolean prev,next;
	//게시물 총 갯수
	private int total;
	private Criteria cri;
	// startPage, endPage 계산
	public PageDTO(Criteria cri,int total) {
		this.cri=cri;
		this.total=total;
		
		//endPage
		//Math.ceil 은 올림함수
		this.endPage=(int)(Math.ceil(cri.getPageNum()/10.0))*10;
		System.out.println("this.end="+this.endPage);
		//startPage 계산식
		this.startPage=this.endPage-9;
		
		int realEnd = (int)(Math.ceil((total*1.0)/cri.getAmount()));
		
		if(realEnd <endPage) {
			System.out.println("realEnd="+realEnd);//디버깅
			this.endPage=realEnd;
		}
		this.prev = this.startPage>1;
		this.next = this.endPage <realEnd;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	@Override
	public String toString() {
		return "PageDTO [startPage=" + startPage + ", endPage=" + endPage + ", amount=" + amount + ", prev=" + prev
				+ ", next=" + next + ", total=" + total + ", cri=" + cri + "]";
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
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
}
