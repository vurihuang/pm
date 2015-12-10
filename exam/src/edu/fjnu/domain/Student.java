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
				+ ", sclass=" + sclass + "]";
	}
	
}
