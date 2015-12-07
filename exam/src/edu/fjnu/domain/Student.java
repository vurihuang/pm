package edu.fjnu.domain;

/**
 * 学生表student
 * @author vengeance
 *
 */
public class Student {
	private String studentID;
	private String sname;
	private String ssex;
	private String spassword;
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
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
				+ "]";
	}
	
}
