package com.fjnu.entity;

/**
 * 权限表类t_permission
 * @author vengeance
 *
 */
public class Permission extends IdEntity{
//	private Long permissionId;	//权限ID permissionId = id
	private String permissionName;	//权限名称
	private String permissionUrl;	//权限URL
	private int fkParentId;	//父级权限ID
	private int roleRoleId;	//角色ID
	private int clazz;	//级别
	private String descn;	//描述
	
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	public String getPermissionUrl() {
		return permissionUrl;
	}
	public void setPermissionUrl(String permissionUrl) {
		this.permissionUrl = permissionUrl;
	}
	public int getFkParentId() {
		return fkParentId;
	}
	public void setFkParentId(int fkParentId) {
		this.fkParentId = fkParentId;
	}
	public int getRoleRoleId() {
		return roleRoleId;
	}
	public void setRole_roleId(int roleRoleId) {
		this.roleRoleId = roleRoleId;
	}
	public int getClazz() {
		return clazz;
	}
	public void setClazz(int clazz) {
		this.clazz = clazz;
	}
	public String getDescn() {
		return descn;
	}
	public void setDescn(String descn) {
		this.descn = descn;
	}
}
