package edu.fjnu.domain;

/**
 * 学生表student
 * @author vengeance
 *
 */
public class Student {
	private String studentID;//学生ID
	private String sname;//学生名
	private String ssex;//学生性别
	private String spassword;//学生密码
	private String sclass;//学生班级
	private Sscore sscore;//学生成绩表信息
	private Scourse scourse;//学生课程表信息
	public Scourse getScourse() {
		return scourse;
	}
	public void setScourse(Scourse scourse) {
		this.scourse = scourse;
	}
	public Sscore getSscore() {
		return sscore;
	}
	public void setSscore(Sscore sscore) {
		this.sscore = sscore;
	}
	public String getSclass() {
		return sclass;
	}
	public void setSclass(String sclass) {
		this.sclass = sclass;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String string) {
		this.studentID = string;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
	@Override
	public String toString() {
		return "Student [studentID=" + studentID + ", sname=" + sname + ", ssex=" + ssex + ", spassword=" + spassword
				+ ", sclass=" + sclass + ", sscore=" + sscore + ", scourse=" + scourse + "]";
	}
	
}
