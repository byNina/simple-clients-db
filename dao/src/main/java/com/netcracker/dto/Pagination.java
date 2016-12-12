/**
 * 
 */
package com.netcracker.dto;

/**
 * @author Shevchenko,2016
 *
 */
public class Pagination {

	private int resultsPerPage;
	private int pages;
	private int page;
	private int firstResult;
	private int lastResult;

	public Pagination(int resultsPerPage, int page) {
		super();
		this.resultsPerPage = resultsPerPage;
		this.page = page;
	}

	public Pagination() {
	}

	public int getResultsPerPage() {
		return resultsPerPage;
	}

	public void setResultsPerPage(int resultsPerPage) {
		this.resultsPerPage = resultsPerPage;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getLastResult() {
		return lastResult;
	}

	public void setLastResult(int lastResult) {
		this.lastResult = lastResult;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + firstResult;
		result = prime * result + lastResult;
		result = prime * result + pages;
		result = prime * result + resultsPerPage;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pagination other = (Pagination) obj;
		if (firstResult != other.firstResult)
			return false;
		if (lastResult != other.lastResult)
			return false;
		if (pages != other.pages)
			return false;
		if (resultsPerPage != other.resultsPerPage)
			return false;
		return true;
	}



}
