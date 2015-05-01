package com.appleframework.data.core.page;

/**
 * ��ҳ�ӿ�
 * 
 * @author xusm
 * 
 */
public interface Paginable {
	
	/**
	 * �ܼ�¼��
	 * 
	 * @return
	 */
	public long getTotalCount();

	/**
	 * ��ҳ��
	 * 
	 * @return
	 */
	public long getTotalPage();

	/**
	 * ÿҳ��¼��
	 * 
	 * @return
	 */
	public long getPageSize();

	/**
	 * ��ǰҳ��
	 * 
	 * @return
	 */
	public long getPageNo();

	/**
	 * �Ƿ��һҳ
	 * 
	 * @return
	 */
	public boolean isFirstPage();

	/**
	 * �Ƿ����һҳ
	 * 
	 * @return
	 */
	public boolean isLastPage();

	/**
	 * ������ҳ��ҳ��
	 */
	public long getNextPage();

	/**
	 * ������ҳ��ҳ��
	 */
	public long getPrePage();

}
