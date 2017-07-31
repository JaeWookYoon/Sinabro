package com.sinabro.util;

public class Paging {

	private Integer pageSize;// 페이지당 보여줄 글 수
	private Integer pageBlock;// 페이지번호 표시수
	private Integer count; // 전체 글 수
	private Integer currentPage; // 현재 페이지수

	public Paging() {
		super();
	}

	/*
	 * 페이징 (한 화면에 보여질 글 수, 페이지 분할 수, 총 글의 갯수, 현재 보고 있는 페이지 번호);
	 */
	public void setPaging(int pageSize, int pageBlock, int count, int currentPage) {
		this.pageSize = pageSize;
		this.pageBlock = pageBlock;
		this.count = count;
		this.currentPage = currentPage;
	}

	/*
	 * 총 페이지 수를 리턴해주는 메소드 전체 글수를 페이지당 보여줄 글수로 나눈 값에 전체 글수를 페이지당 보여줄 글수로 나머지연산을 하여 구한
	 * 값이 0보다 크면 1을 더하고 아니면 0을 더함
	 * 
	 * @return 총페이수
	 */

	public Integer getPage_Count() {
		return (count / pageSize) + (count % pageSize > 0 ? 1 : 0);
	}

	/*
	 * 페이지 시작 수를 리턴해주는 메소드
	 * 
	 * @return 페이지 시작수
	 */

	public Integer getPage_Start() {
		return ((currentPage - 1) / pageBlock) * pageBlock + 1;
	}

	/*
	 * 페이지 마지막 수를 리턴해주는 메소드
	 * 
	 * @return 페이지 마지막 수
	 */

	public Integer getPage_End() {
		return getPage_Start() + pageBlock - 1;
	}

	/*
	 * Pre 표시 여부
	 * 
	 * @return boolean
	 */

	public boolean isPre() {
		return getPage_Start() > pageBlock;
	}

	/*
	 * next 표시 여부
	 * 
	 * @return boolean
	 */

	public boolean isNext() {
		return getPage_End() < getPage_Count();
	}

	/*
	 * 글 범위 시작 번호
	 * 
	 * @return 글 범위 시작 번호
	 */

	public Integer getWriting_Start() {
		 return (currentPage - 1) * pageSize + 1;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Integer getPageBlock() {
		return pageBlock;
	}

	public Integer getCount() {
		return count;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	/*
	 * 글 범위 끝 번호
	 * 
	 * @return 글 범위 끝 번호
	 */
	public Integer getWriting_End() {
		return currentPage * pageSize;
	}

	

	

}
