package com.fjnu.entity;

/**
 * 学员错题本表类t_err_que_back
 * @author vengeance
 *
 */
public class ErrQueBack {
//	private int pkErId;	//错题本ID号	pkErId = id
	private int errCnt;	//错误总和
	private int gradePkScopeId;	//错题的年级ID号
	private Long questionFkQuestionId;	//错题的ID号
	private Long studentMemberId;	//学生ID号
	private int subjectPkScopeId;	//错题科目的ID号
	
	public int getErrCnt() {
		return errCnt;
	}
	public void setErrCnt(int errCnt) {
		this.errCnt = errCnt;
	}
	public int getGradePkScopeId() {
		return gradePkScopeId;
	}
	public void setGradePkScopeId(int gradePkScopeId) {
		this.gradePkScopeId = gradePkScopeId;
	}
	public Long getQuestionFkQuestionId() {
		return questionFkQuestionId;
	}
	public void setQuestionFkQuestionId(Long questionFkQuestionId) {
		this.questionFkQuestionId = questionFkQuestionId;
	}
	public Long getStudentMemberId() {
		return studentMemberId;
	}
	public void setStudentMemberId(Long studentMemberId) {
		this.studentMemberId = studentMemberId;
	}
	public int getSubjectPkScopeId() {
		return subjectPkScopeId;
	}
	public void setSubjectPkScopeId(int subjectPkScopeId) {
		this.subjectPkScopeId = subjectPkScopeId;
	}
	
	
}
