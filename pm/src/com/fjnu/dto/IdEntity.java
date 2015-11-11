package com.fjnu.dto;

/**
 * data transfer object(数据传输对象模型)
 * 用于不同层（UI层、服务层或者域模型层）直接的数据传输，
 * 以隔离不同层，降低层间耦合
 * 
 * 定义一个所有实体类的父类
 * 所有的表都有一个没有业务含义的主键ID，
 * IdEntity类封装了非业务的主键信息
 * @author vengeance
 *
 */
public class IdEntity {
	//主键ID
	public Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
