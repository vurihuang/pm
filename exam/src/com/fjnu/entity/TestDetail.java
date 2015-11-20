package com.fjnu.entity;

/**
 * 测试详细表类t_test_detail
 * @author vengeance
 *
 */
public class TestDetail {
//	private Long pkTestId;	//测试详细ID pkTestId = id
	private String answer;	//正确答案
	private float score;	//分数
	private int sequence;	//顺序
	private String stuAnswer;	//学生答案
	private Long questionFkQuestionId;	//问题表相关ID
	private Long testMainPkTestMainId;	//测试主表相关ID
	
	public Long getQuestionFkQuestionId() {
		return questionFkQuestionId;
	}
	public void setQuestionFkQuestionId(Long questionFkQuestionId) {
		this.questionFkQuestionId = questionFkQuestionId;
	}
	public Long getTestMainPkTestMainId() {
		return testMainPkTestMainId;
	}
	public void setTestMainPkTestMainId(Long testMainPkTestMainId) {
		this.testMainPkTestMainId = testMainPkTestMainId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public float getScore() {
		return score;
	}
	public void setScore(float score) {
		this.score = score;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public String getStuAnswer() {
		return stuAnswer;
	}
	public void setStuAnswer(String stuAnswer) {
		this.stuAnswer = stuAnswer;
	}
}
