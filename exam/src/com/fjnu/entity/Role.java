package com.fjnu.entity;

/**
 * 角色表类t_role
 * @author vengeance
 *
 */
public class Role extends IdEntity{
//	private Long roleId;	//角色ID roleId = id
	private String descn;	//角色描述
	private String roleName;	//角色名称
	
	public String getDescn() {
		return descn;
	}
	public void setDescn(String descn) {
		this.descn = descn;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
}
