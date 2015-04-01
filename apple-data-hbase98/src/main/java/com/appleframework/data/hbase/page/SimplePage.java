package com.appleframework.data.hbase.page;

import java.io.Serializable;

/**
 * �򵥷�ҳ��
 * 
 * @author xusm
 * 
 */
public class SimplePage implements Paginable, Serializable {
	
	private static final long serialVersionUID = -5755581162278120462L;

	public static final long DEF_COUNT = 20;

	protected long totalCount = 0;
	protected long pageSize = 20;
	protected long pageNo = 1;

	/**
	 * ���ҳ�� checkPageNo
	 * 
	 * @param pageNo
	 * @return if pageNo==null or pageNo<1 then return 1 else return pageNo
	 */
	public static long cpn(Integer pageNo) {
		return (pageNo == null || pageNo < 1) ? 1 : pageNo;
	}

	public SimplePage() {
	}

	/**
	 * ������
	 * 
	 * @param pageNo
	 *            ҳ��
	 * @param pageSize
	 *            ÿҳ��������
	 * @param totalCount
	 *            �ܹ���������
	 */
	public SimplePage(long pageNo, long pageSize, long totalCount) {
		setTotalCount(totalCount);
		setPageSize(pageSize);
		setPageNo(pageNo);
		adjustPageNo();
	}
	
	/**
	 * ������
	 * 
	 * @param pageNo
	 *            ҳ��
	 * @param pageSize
	 *            ÿҳ��������
	 * @param totalCount
	 *            �ܹ���������
	 */
	public SimplePage(long pageNo, long pageSize) {
		setPageSize(pageSize);
		setPageNo(pageNo);
	}

	/**
	 * ����ҳ�룬ʹ���������ҳ��
	 */
	public void adjustPageNo() {
		if (pageNo == 1) {
			return;
		}
		long tp = getTotalPage();
		if (pageNo > tp) {
			pageNo = tp;
		}
	}

	/**
	 * ���ҳ��
	 */
	public long getPageNo() {
		return pageNo;
	}

	/**
	 * ÿҳ��������
	 */
	public long getPageSize() {
		return pageSize;
	}

	/**
	 * �ܹ���������
	 */
	public long getTotalCount() {
		return totalCount;
	}
	

	/**
	 * �ܹ���ҳ
	 */
	public long getTotalPage() {
		long totalPage = totalCount / pageSize;
		if (totalPage == 0 || totalCount % pageSize != 0) {
			totalPage++;
		}
		return totalPage;
	}

	/**
	 * �Ƿ��һҳ
	 */
	public boolean isFirstPage() {
		return pageNo <= 1;
	}

	/**
	 * �Ƿ����һҳ
	 */
	public boolean isLastPage() {
		return pageNo >= getTotalPage();
	}

	/**
	 * ��һҳҳ��
	 */
	public long getNextPage() {
		if (isLastPage()) {
			return pageNo;
		} else {
			return pageNo + 1;
		}
	}

	/**
	 * ��һҳҳ��
	 */
	public long getPrePage() {
		if (isFirstPage()) {
			return pageNo;
		} else {
			return pageNo - 1;
		}
	}

	/**
	 * if totalCount<0 then totalCount=0
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(long totalCount) {
		if (totalCount < 0) {
			this.totalCount = 0;
		} else {
			this.totalCount = totalCount;
		}
	}

	/**
	 * if pageSize< 1 then pageSize=DEF_COUNT
	 * 
	 * @param pageSize
	 */
	public void setPageSize(long pageSize) {
		if (pageSize < 1) {
			this.pageSize = DEF_COUNT;
		} else {
			this.pageSize = pageSize;
		}
	}

	/**
	 * if pageNo < 1 then pageNo=1
	 * 
	 * @param pageNo
	 */
	public void setPageNo(long pageNo) {
		if (pageNo < 1) {
			this.pageNo = 1;
		} else {
			this.pageNo = pageNo;
		}
	}
}
