package edu.fjnu.test.domain;

public class Score {
	private String sname;
	private String subject;
	private String pr;
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getPr() {
		return pr;
	}
	public void setPr(String pr) {
		this.pr = pr;
	}
	@Override
	public String toString() {
		return "Score [sname=" + sname + ", subject=" + subject + ", pr=" + pr + "]";
	}
	
}
