package edu.fjnu.domain;
/**
 * 老师表teacher
 * @author vengeance
 *
 */
public class Teacher {
	private String teacherID;//老师ID
	private String tname;//老师名
	private String tsex;//老师性别
	private String course;//老师课程
	private String tpassword;//老师密码
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getTeacherID() {
		return teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTsex() {
		return tsex;
	}
	public void setTsex(String tsex) {
		this.tsex = tsex;
	}
	public String getTpassword() {
		return tpassword;
	}
	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}
	@Override
	public String toString() {
		return "Teacher [teacherID=" + teacherID + ", tname=" + tname + ", tsex=" + tsex + ", course=" + course
				+ ", tpassword=" + tpassword + "]";
	}
	
}
