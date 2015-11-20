package com.fjnu.entity;

/**
 * 课程用户关联表类t_course_t_member
 * @author vengeance
 *
 */
public class CourseMember extends IdEntity{
//	private Long coursesCourseId;	//课程ID coursesCourseId = id
	private int membersMemberId;	//用户ID
	
	public int getMembersMemberId() {
		return membersMemberId;
	}
	public void setMembersMemberId(int membersMemberId) {
		this.membersMemberId = membersMemberId;
	}
}
