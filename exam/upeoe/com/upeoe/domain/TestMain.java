package com.upeoe.domain;

/**
 * 测试主表
 * @author vengeance
 *
 */
public class TestMain {
	private int pk_test_main_ID;//测试主表ID
	private String scope;//测试范围名
	private String subject;//学科
	public int getPk_test_main_ID() {
		return pk_test_main_ID;
	}
	public void setPk_test_main_ID(int pk_test_main_ID) {
		this.pk_test_main_ID = pk_test_main_ID;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "TestMain [pk_test_main_ID=" + pk_test_main_ID + ", scope=" + scope + ", subject=" + subject + "]";
	}
	
}
