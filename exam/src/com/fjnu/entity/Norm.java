package com.fjnu.entity;

/**
 * 常模表类t_norm
 * @author vengeance
 *
 */
public class Norm extends IdEntity{
//	private Long pkNormId;	//常模ID pkNormId = id
	private float pr;	//PR值
	private int count;	//人数
	private String grade;	//年级
	private int grandient;	//梯度
	private float score;	//分数
	private String subject;	//学科
	
	public float getPr() {
		return pr;
	}
	public void setPr(float pr) {
		this.pr = pr;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public int getGrandient() {
		return grandient;
	}
	public void setGrandient(int grandient) {
		this.grandient = grandient;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
}
