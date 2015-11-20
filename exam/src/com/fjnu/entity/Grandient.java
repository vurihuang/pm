package com.fjnu.entity;

/**
 * 梯度表类t_grandient
 * @author vengeance
 *
 */
public class Grandient extends IdEntity{
//	private Long grandientId;	//梯度ID grandientId = id
	private int grandientSecequenceNO;	//该梯度为第几梯度
	private int status;	//状态
	private int courseCourseId;	//该梯度所属课程ID
	
	public int getGrandientSecequenceNO() {
		return grandientSecequenceNO;
	}
	public void setGrandientSecequenceNO(int grandientSecequenceNO) {
		this.grandientSecequenceNO = grandientSecequenceNO;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getCourseCourseId() {
		return courseCourseId;
	}
	public void setCourseCourseId(int courseCourseId) {
		this.courseCourseId = courseCourseId;
	}
}
