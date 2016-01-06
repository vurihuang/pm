package edu.fjnu.domain;

/**
 * 存储知识点，传输给view使用
 * 
 * @author vengeance
 *
 */
public class D3Keyword {
	private String keyword;// 存储关联分析后的知识点

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "D3Keyword [keyword=" + keyword + "]";
	}

}
