/*
 * 李先瞧
 * 2015-7-23
 *
 */

package com.hades.framework.core.model;

import java.util.List;

/**
 * 
 * HadesProject
 * @author 李先瞧
 * 2015-7-23
 * 封装分页和排序查询的结果,
 * 并继承QueryParameter的所有查询请求参数.
 * @param <T> Page中的记录类型.
 * @param <T>
 */
public class Page<T> extends QueryParameter {
	
	private List<T> result = null;

	private long totalCount = -1;

	public Page() {
	}

	public Page(int pageSize) {
		this.pageSize = pageSize;
	}

	public Page(int pageSize, boolean autoCount) {
		this.pageSize = pageSize;
		this.autoCount = autoCount;
	}

	/**
	 * 取得倒转的排序方向
	 */
	public String getInverseOrder() {
		if (order.endsWith(DESC))
			return ASC;
		else
			return DESC;
	}

	/**
	 * 页内的数据列表.
	 */
	public List<T> getResult() {
		return result;
	}

	public void setResult(List<T> result) {
		this.result = result;
	}

	/**
	 * 总记录数.
	 */
	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 计算总页数.
	 */
	public long getTotalPages() {
		if (totalCount == -1)
			return -1l;

		long count = totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			count++;
		}
		return new Long(count);
	}

	/**
	 * 是否还有下一页.
	 */
	public boolean isHasNext() {
		return (pageNo + 1 <= getTotalPages());
	}

	/**
	 * 返回下页的页号,序号从1开始.
	 */
	public int getNextPage() {
		if (isHasNext())
			return pageNo + 1;
		else
			return pageNo;
	}

	/**
	 * 是否还有上一页. 
	 */
	public boolean isHasPre() {
		return (pageNo - 1 >= 1);
	}

	/**
	 * 返回上页的页号,序号从1开始.
	 */
	public int getPrePage() {
		if (isHasPre())
			return pageNo - 1;
		else
			return pageNo;
	}
}