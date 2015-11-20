package com.fjnu.entity;

/**
 * 测试主表类t_testmain
 * @author vengeance
 *
 */
public class TestMain {
	private Long pkTestMainId;	//测试主表ID pkTestMainId = id
	private int easyCnt;	//简单题数目
	private int aveCnt;		//中等题数目
	private int diffCnt;	//困难题数目
	private int clozeCnt;	//完形题数目
	private int readingCnt;	//阅读题数目
	private int easyErrCnt;	//简单题错误数目
	private int aveErrCnt;		//中等题错误数目
	private int diffErrCnt;		//困难题错误数目
	private int clozeErrCnt;	//完形题错误数目
	private int readingErrCnt;	//阅读题错误数目
	private float easyRatio;	//简单题占比
	private float aveRatio;		//中等题占比
	private float diffRatio;	//困难题占比
	private String scope;		//测试范围名称
	private String scopeMD5;	//测试范围标识
	private float realScore;	//实际分数
	private String subject;		//学科
	private int testType;		//测试类型
	private int status;			//状态
	private Long studentMemberId;	//学员相关ID
	private int grandientGrandientId;	//梯度相关ID
	
	public Long getPkTestMainId() {
		return pkTestMainId;
	}
	public void setPkTestMainId(Long pkTestMainId) {
		this.pkTestMainId = pkTestMainId;
	}
	public int getEasyCnt() {
		return easyCnt;
	}
	public void setEasyCnt(int easyCnt) {
		this.easyCnt = easyCnt;
	}
	public int getAveCnt() {
		return aveCnt;
	}
	public void setAveCnt(int aveCnt) {
		this.aveCnt = aveCnt;
	}
	public int getDiffCnt() {
		return diffCnt;
	}
	public void setDiffCnt(int diffCnt) {
		this.diffCnt = diffCnt;
	}
	public int getClozeCnt() {
		return clozeCnt;
	}
	public void setClozeCnt(int clozeCnt) {
		this.clozeCnt = clozeCnt;
	}
	public int getReadingCnt() {
		return readingCnt;
	}
	public void setReadingCnt(int readingCnt) {
		this.readingCnt = readingCnt;
	}
	public int getEasyErrCnt() {
		return easyErrCnt;
	}
	public void setEasyErrCnt(int easyErrCnt) {
		this.easyErrCnt = easyErrCnt;
	}
	public int getAveErrCnt() {
		return aveErrCnt;
	}
	public void setAveErrCnt(int aveErrCnt) {
		this.aveErrCnt = aveErrCnt;
	}
	public int getDiffErrCnt() {
		return diffErrCnt;
	}
	public void setDiffErrCnt(int diffErrCnt) {
		this.diffErrCnt = diffErrCnt;
	}
	public int getClozeErrCnt() {
		return clozeErrCnt;
	}
	public void setClozeErrCnt(int clozeErrCnt) {
		this.clozeErrCnt = clozeErrCnt;
	}
	public int getReadingErrCnt() {
		return readingErrCnt;
	}
	public void setReadingErrCnt(int readingErrCnt) {
		this.readingErrCnt = readingErrCnt;
	}
	public float getEasyRatio() {
		return easyRatio;
	}
	public void setEasyRatio(float easyRatio) {
		this.easyRatio = easyRatio;
	}
	public float getAveRatio() {
		return aveRatio;
	}
	public void setAveRatio(float aveRatio) {
		this.aveRatio = aveRatio;
	}
	public float getDiffRatio() {
		return diffRatio;
	}
	public void setDiffRatio(float diffRatio) {
		this.diffRatio = diffRatio;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
	public String getScopeMD5() {
		return scopeMD5;
	}
	public void setScopeMD5(String scopeMD5) {
		this.scopeMD5 = scopeMD5;
	}
	public float getRealScore() {
		return realScore;
	}
	public void setRealScore(float realScore) {
		this.realScore = realScore;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getTestType() {
		return testType;
	}
	public void setTestType(int testType) {
		this.testType = testType;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Long getStudentMemberId() {
		return studentMemberId;
	}
	public void setStudentMemberId(Long studentMemberId) {
		this.studentMemberId = studentMemberId;
	}
	public int getGrandientGrandientId() {
		return grandientGrandientId;
	}
	public void setGrandientGrandientId(int grandientGrandientId) {
		this.grandientGrandientId = grandientGrandientId;
	}
}
