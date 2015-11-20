package com.fjnu.entity;

/**
 * 用户表类t_member
 * @author vengeance
 *
 */
public class Member extends IdEntity{
//	private Long memberId;	//用户ID memberId = id
	private String accoundNo;	//用户账号
	private int degree;	//年级
	private String name;	//姓名
	private Long password;	//密码
	public String getAccoundNo() {
		return accoundNo;
	}
	public void setAccoundNo(String accoundNo) {
		this.accoundNo = accoundNo;
	}
	public int getDegree() {
		return degree;
	}
	public void setDegree(int degree) {
		this.degree = degree;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPassword() {
		return password;
	}
	public void setPassword(Long password) {
		this.password = password;
	}
	
	
}
