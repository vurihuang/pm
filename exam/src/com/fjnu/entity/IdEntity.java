package com.fjnu.entity;

/**
 * 定义一个所有实体类的父类
 * 所有的表都有一个没有业务含义的主键ID，
 * IdEntity类封装了非业务的主键信息
 * @author vengeance
 *
 */
public class IdEntity {
	/*
	 * 主键ID
	 */
	public int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
