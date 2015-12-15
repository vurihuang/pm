package com.upeoe.domain;

/**
 * 分类范围表
 * @author vengeance
 *
 */
public class Scope {
	private int pk_scope_ID;//分类范围ID
	private int level;//层次
	private String name;//分类范围名称
	public int getPk_scope_ID() {
		return pk_scope_ID;
	}
	public void setPk_scope_ID(int pk_scope_ID) {
		this.pk_scope_ID = pk_scope_ID;
	}
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
	
	@Override
	public String toString() {
		return "Scope [pk_scope_ID=" + pk_scope_ID + ", level=" + level + ", name=" + name + "]";
	}
	
}
