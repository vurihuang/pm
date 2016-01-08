package edu.fjnu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rosuda.REngine.Rserve.RserveException;

import cn.itcast.servlet.BaseServlet;
import edu.fjnu.domain.Cluster;
import edu.fjnu.domain.VScope;
import edu.fjnu.service.ClusterService;
import edu.fjnu.service.RelationService;
import edu.fjnu.service.RelationshipService;
import edu.fjnu.service.StudentTestService;
import edu.fjnu.service.TeacherTestService;

/**
 * 处理关联分析模块
 * 
 * @author vengeance
 *
 */
@WebServlet("/RelationServlet")
public class RelationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private boolean isStudent;// 判断当前是否为学生登录
	private RelationService rs = new RelationService();// 用来处理关联分析模块的d3图以及表格数据
	private RelationshipService rsh = new RelationshipService();// 用来处理R图数据及调用
	private TeacherTestService tts = new TeacherTestService();// 得到老师的教学信息
	private ClusterService cluserService = new ClusterService();// 引入聚类service
	private StudentTestService sts = new StudentTestService();// 为了得到学生所做过试卷的年级列表

	/**
	 * 处理关联分析
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public String relation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String courseName = "";// 学科
		String grade = "";// 年级
		// 加载下拉框年级信息
		loadInfo(request, response);

		courseName = request.getParameter("course");
		// 把选择的科目设置回去以供下拉框传值（另一种做法是直接把course设为session域）
		request.setAttribute("selectedCourse", courseName);
		grade = request.getParameter("grade");// 得到下拉框选择的年级
		// 把选择的年级设置回去以供下拉框显示选中哪个年纪
		request.setAttribute("selectedGrade", grade);

		if (grade != null) {
			// 调用R画出图，然后读取
//			try {
//				rsh.createRForRelastion(courseName, grade);
//			} catch (RserveException e) {
//				e.printStackTrace();
//			}
			String[] keywordArr = null;
			Object[][] stvArr = null;
			keywordArr = rs.keywordArray(courseName, grade);// 设置d3的点
			stvArr = rs.stvArray();// 设置d3的连线关系

			for (String keyword : keywordArr) {
				System.out.println(keyword);
			}
			System.out.println("------------------------");
			for(int i=0; i<stvArr.length; i++){
				for(int j=0; j<stvArr[i].length; j++){
					System.out.println(stvArr[i][j]);
				}
			}
			System.out.println("------------------------");
			for (Object[] stv : stvArr) {
				for (Object s : stv) {
					System.out.print(s + ",");
				}
				System.out.println("");
			}

			// 定义两个转化后的二维数组，分别由keywordArr，stvArr转化。
			String[][] newKeywordArr = new String[keywordArr.length][2];
			Object[][] newStvArr = new Object[stvArr.length][4];
			// 存放可以高亮的知识点下标，供stvArr转化使用
			List<Integer> sourceList = new ArrayList<Integer>();
			// 存放知识点List
			List<Cluster> clusterList = new ArrayList<Cluster>();
			if (isStudent) {// 当前登录为学生
				String studentID = (String) request.getSession().getAttribute("userID");
				// 得到该学生所需知识点List
				clusterList = cluserService.getKeywordListOfStudent(grade, courseName, Integer.parseInt(studentID));

			}
			// 转化keywordArr数组为带高亮参数的二维数组
			for (int i = 0; i < keywordArr.length; i++) {
				newKeywordArr[i][0] = keywordArr[i];
				if (isStudent) {
					int j;
					for (j = 0; j < clusterList.size(); j++) {
						if (clusterList.get(j).getName() == keywordArr[i]) {
							newKeywordArr[i][1] = "1";
							sourceList.add(i);
							break;
						}
					}
					if (j == clusterList.size()) {
						newKeywordArr[i][1] = "0";
					}
				} else {
					newKeywordArr[i][1] = "0";
				}
			}
			// 转化stvArr数组为带高亮参数的二维数组
			for (int i = 0; i < stvArr.length; i++) {
				newStvArr[i][0] = stvArr[i][0];
				newStvArr[i][1] = stvArr[i][1];
				newStvArr[i][2] = stvArr[i][2];
				if (isStudent) {
					int j;
					for (j = 0; j < sourceList.size(); j++) {
						if (sourceList.get(j) == stvArr[i][0]) {
							newStvArr[i][3] = "1";
							break;
						}
					}
					if (j == sourceList.size()) {
						newStvArr[i][3] = "0";
					}
				} else {
					newStvArr[i][3] = "0";
				}
			}
			System.out.println("------------------------");
			for (String[] newKeyword : newKeywordArr) {
				System.out.print(newKeyword[0] + ",");
				System.out.print(newKeyword[1]);
			}

			request.setAttribute("keywordArray", newKeywordArr);
			request.setAttribute("edges", newStvArr);
		}

		return "f:/index/jsp/relation/relation-s.jsp";

	}

	/**
	 * 加载下拉框年级信息
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void loadInfo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<String> gradeList = new ArrayList<String>();
		// 能得到sID表明现在是学生登录
		if ((String) request.getSession().getAttribute("sID") != null) {
			String studentID = (String) request.getSession().getAttribute("userID");
			// 得到学生所有做过试卷的年级列表
			List<VScope> vScopeList = sts.getStudentGradeList(Integer.parseInt(studentID));
			for (int i = 0; i < vScopeList.size(); i++) {
				VScope vscope = vScopeList.get(i);
				gradeList.add(vscope.getName());
			}
			isStudent = true;
		} else {// 否则是教师登录
			String teacherID = (String) request.getSession().getAttribute("userID");// 得到教师ID
			gradeList = tts.getGradeList(Integer.parseInt(teacherID));// 得到教师的年级列表
			isStudent = false;
		}

		request.setAttribute("gradeList", gradeList);

	}

}
