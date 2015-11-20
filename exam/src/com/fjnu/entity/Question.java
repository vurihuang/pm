package com.fjnu.entity;

/**
 * 题库表类t_question
 * @author vengeance
 *
 */
public class Question extends IdEntity{
//	private Long fkQuestionId;	//主键ID
	private int answer;	//答案
	private String choiceA;	//选项A
	private String choiceB;	//选项B
	private String choiceC;	//选项C
	private String choiceD;	//选项D
	private String createDate;	//创建日期
	private int difficultyLevel;	//难度
	private String keyword;	//关键词
	private int num;	//被做过的次数
	private int successNum;	//做正确的次数
	private int parentQuestionFkQuestionId;	//题目类型；普通题-1，阅读题-2，完形填空-3
	private int sequence;	//该小题在完形填空或阅读理解的顺序
	private int status;	//使用状态；正在使用1，不使用0
	private String subject;	//题干
	private int scopePkScopeId;	//该题所属范围
	
	public int getAnswer() {
		return answer;
	}
	public void setAnswer(int answer) {
		this.answer = answer;
	}
	public String getChoiceA() {
		return choiceA;
	}
	public void setChoiceA(String choiceA) {
		this.choiceA = choiceA;
	}
	public String getChoiceB() {
		return choiceB;
	}
	public void setChoiceB(String choiceB) {
		this.choiceB = choiceB;
	}
	public String getChoiceC() {
		return choiceC;
	}
	public void setChoiceC(String choiceC) {
		this.choiceC = choiceC;
	}
	public String getChoiceD() {
		return choiceD;
	}
	public void setChoiceD(String choiceD) {
		this.choiceD = choiceD;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public int getDifficultyLevel() {
		return difficultyLevel;
	}
	public void setDifficultyLevel(int difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getSuccessNum() {
		return successNum;
	}
	public void setSuccessNum(int successNum) {
		this.successNum = successNum;
	}
	public int getParentQuestionFkQuestionId() {
		return parentQuestionFkQuestionId;
	}
	public void setParentQuestionFkQuestionId(int parentQuestionFkQuestionId) {
		this.parentQuestionFkQuestionId = parentQuestionFkQuestionId;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getScopePkScopeId() {
		return scopePkScopeId;
	}
	public void setScopePkScopeId(int scopePkScopeId) {
		this.scopePkScopeId = scopePkScopeId;
	}
}
