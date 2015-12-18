package edu.fjnu.domain;

/**
 * 题库表
 * @author vengeance
 *
 */
public class VQuestion {
	private int fk_question_ID;//主键ID
	private String answer;//答案
	private String choiceA;//选项A
	private String choiceB;//选项B
	private String choiceC;//选项C
	private String choiceD;//选项D
	private String choiceE;//选项E
	private int difficultyLevel;//难度
	private String keyword;//关键词
	private int num;//做过次数
	private int successNum;//做对的次数
	private String subject;//题干
	private double wrong;  //知识点错误率
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getFk_question_ID() {
		return fk_question_ID;
	}
	public void setFk_question_ID(int fk_question_ID) {
		this.fk_question_ID = fk_question_ID;
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
	public String getChoiceE() {
		return choiceE;
	}
	public void setChoiceE(String choiceE) {
		this.choiceE = choiceE;
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getSuccessNum() {
		return successNum;
	}
	public void setSuccessNum(int successNum) {
		this.successNum = successNum;
	}
	
	
	public double getWrong() {
		return wrong;
	}
	public void setWrong(double wrong) {
		this.wrong = wrong;
	}
	@Override
	public String toString() {
		return "Question [fk_question_ID=" + fk_question_ID + ", answer=" + answer + ", choiceA=" + choiceA
				+ ", choiceB=" + choiceB + ", choiceC=" + choiceC + ", choiceD=" + choiceD + ", choiceE=" + choiceE
				+ ", difficultyLevel=" + difficultyLevel + ", keyword=" + keyword + ", num=" + num + ", successNum="
				+ successNum + ", subject=" + subject + "]";
	}
	
}
