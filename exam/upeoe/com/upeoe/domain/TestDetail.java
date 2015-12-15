package com.upeoe.domain;

/**
 * 测试详细表
 * @author vengeance
 *
 */
public class TestDetail {
	private Long pk_test_ID;//测试详细表ID
	private String answer;//正确答案
	private int score;//分数
	private int sequeence;//顺序
	private String stuAnswer;//学生答案
	public Long getPk_test_ID() {
		return pk_test_ID;
	}
	public void setPk_test_ID(Long pk_test_ID) {
		this.pk_test_ID = pk_test_ID;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getSequeence() {
		return sequeence;
	}
	public void setSequeence(int sequeence) {
		this.sequeence = sequeence;
	}
	public String getStuAnswer() {
		return stuAnswer;
	}
	public void setStuAnswer(String stuAnswer) {
		this.stuAnswer = stuAnswer;
	}
	@Override
	public String toString() {
		return "TestDetail [pk_test_ID=" + pk_test_ID + ", answer=" + answer + ", score=" + score + ", sequeence="
				+ sequeence + ", stuAnswer=" + stuAnswer + "]";
	}
	
}
