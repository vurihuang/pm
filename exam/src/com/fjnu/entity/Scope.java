package com.fjnu.entity;

/**
 * 分类范围表类t_scope
 * @author vengeance
 *
 */
public class Scope {
//	private Long pkScopeId;	//分类范围ID pkScopeId = id
	private int level;	//层次
	private String name;	//分类范围的名称
	private int sequence;	//当前分类在它父分类下层范围的顺序
	private int status;	//使用状态；正在使用1，暂停使用0
	private int fkParentId;	//分类层次；id为空表示最顶层
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getFkParentId() {
		return fkParentId;
	}
	public void setFkParentId(int fkParentId) {
		this.fkParentId = fkParentId;
	}
}
