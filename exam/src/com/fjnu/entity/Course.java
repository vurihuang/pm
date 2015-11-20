package com.fjnu.entity;

/**
 * 课程表类t_course
 * @author vengeance
 *
 */
public class Course extends IdEntity{
//	private Long courseId;	//课程ID courseId = id
	private int grandientNumber;	//梯度题目
	private int isTemplate;	//是否为梯度模板
	private String remark;	//备注
	private int status;	//状态
	private int coachId;	//coachID
	private int courseTypeId;	//课程类型ID
	private int currentGrandientGrandientId;	//当前梯度编号
	
	public int getGrandientNumber() {
		return grandientNumber;
	}
	public void setGrandientNumber(int grandientNumber) {
		this.grandientNumber = grandientNumber;
	}
	public int getIsTemplate() {
		return isTemplate;
	}
	public void setIsTemplate(int isTemplate) {
		this.isTemplate = isTemplate;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCoachId() {
		return coachId;
	}
	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}
	public int getCourseTypeId() {
		return courseTypeId;
	}
	public void setCourseTypeId(int courseTypeId) {
		this.courseTypeId = courseTypeId;
	}
	public int getCurrentGrandientGrandientId() {
		return currentGrandientGrandientId;
	}
	public void setCurrentGrandientGrandientId(int currentGrandientGrandientId) {
		this.currentGrandientGrandientId = currentGrandientGrandientId;
	}
}
