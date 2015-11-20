package com.fjnu.entity;

/**
 * 课程类型表类t_coursetype
 * @author vengeance
 *
 */
public class CourseType extends IdEntity{
//	private Long courseTypeId;	//课程类型ID courseTypeId = id
	private int status;	//状态
	private int gradePkScopeId;	//年级ID 

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getGradePkScopeId() {
		return gradePkScopeId;
	}
	public void setGradePkScopeId(int gradePkScopeId) {
		this.gradePkScopeId = gradePkScopeId;
	}
	
}
