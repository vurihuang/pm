package edu.fjnu.domain;

/**
 * 存储知识点所出题目难中易题数信息
 * 
 * @author vengeance
 *
 */
public class DifficultInfo {
	private int difficultLevel; // 难度系数
	private int questionCount; // 出现次数

	public int getDifficultLevel() {
		return difficultLevel;
	}

	public void setDifficultLevel(int difficultLevel) {
		this.difficultLevel = difficultLevel;
	}

	public int getQuestionCount() {
		return questionCount;
	}

	public void setQuestionCount(int questionCount) {
		this.questionCount = questionCount;
	}

	@Override
	public String toString() {
		return "DifficultInfo [difficultLevel=" + difficultLevel + ", questionCount=" + questionCount + "]";
	}

}
