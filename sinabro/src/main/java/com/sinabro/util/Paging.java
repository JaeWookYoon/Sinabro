package com.sinabro.util;

public class Paging {

	private Integer pageSize;// �������� ������ �� ��
	private Integer pageBlock;// ��������ȣ ǥ�ü�
	private Integer count; // ��ü �� ��
	private Integer currentPage; // ���� ��������

	public Paging() {
		super();
	}

	/*
	 * ����¡ (�� ȭ�鿡 ������ �� ��, ������ ���� ��, �� ���� ����, ���� ���� �ִ� ������ ��ȣ);
	 */
	public void setPaging(int pageSize, int pageBlock, int count, int currentPage) {
		this.pageSize = pageSize;
		this.pageBlock = pageBlock;
		this.count = count;
		this.currentPage = currentPage;
	}

	/*
	 * �� ������ ���� �������ִ� �޼ҵ� ��ü �ۼ��� �������� ������ �ۼ��� ���� ���� ��ü �ۼ��� �������� ������ �ۼ��� ������������ �Ͽ� ����
	 * ���� 0���� ũ�� 1�� ���ϰ� �ƴϸ� 0�� ����
	 * 
	 * @return �����̼�
	 */

	public Integer getPage_Count() {
		return (count / pageSize) + (count % pageSize > 0 ? 1 : 0);
	}

	/*
	 * ������ ���� ���� �������ִ� �޼ҵ�
	 * 
	 * @return ������ ���ۼ�
	 */

	public Integer getPage_Start() {
		return ((currentPage - 1) / pageBlock) * pageBlock + 1;
	}

	/*
	 * ������ ������ ���� �������ִ� �޼ҵ�
	 * 
	 * @return ������ ������ ��
	 */

	public Integer getPage_End() {
		return getPage_Start() + pageBlock - 1;
	}

	/*
	 * Pre ǥ�� ����
	 * 
	 * @return boolean
	 */

	public boolean isPre() {
		return getPage_Start() > pageBlock;
	}

	/*
	 * next ǥ�� ����
	 * 
	 * @return boolean
	 */

	public boolean isNext() {
		return getPage_End() < getPage_Count();
	}

	/*
	 * �� ���� ���� ��ȣ
	 * 
	 * @return �� ���� ���� ��ȣ
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
	 * �� ���� �� ��ȣ
	 * 
	 * @return �� ���� �� ��ȣ
	 */
	public Integer getWriting_End() {
		return currentPage * pageSize;
	}

	

	

}
