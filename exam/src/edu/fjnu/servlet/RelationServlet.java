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
import edu.fjnu.util.RelationResult;

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
	private RelationResult rr = new RelationResult();// 知识点关联工具

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
			// 设置R图
			setPicture(request, response);
			// 调用R画出图，然后读取
			// try {
			// rsh.createRForRelastion(courseName, grade);
			// } catch (RserveException e) {
			// e.printStackTrace();
			// }
			String course = request.getParameter("course");
			System.out.println(course);
			// 截取前面三个字符串，得到类似于（三年级）
			String year = request.getParameter("grade").substring(0, 3);
			System.out.println(year);

			String[] keywordArr = rr.getKeywordArr(year, course);
			for (String x : keywordArr) {
				System.out.println(x);
			}
			Object[][] stvArr = rr.getStvArr(year, course);
			for (int i = 0; i < stvArr.length; i++) {
				for (int j = 0; j < stvArr[i].length; j++) {
					System.out.print(stvArr[i][j] + "\t");
				}
				System.out.println();
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
		return "f:/index/jsp/relation/relation.jsp";

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

	/**
	 * 根据科目和年级拼接5张R图路径并设置到jsp
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void setPicture(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String course = request.getParameter("course");
		// 截取前面三个字符串，得到类似于（三年级）
		String grade = request.getParameter("grade").substring(0, 3);

		StringBuffer picturePath = new StringBuffer("relation/");

		if (course.equals("语文")) {
			picturePath.append("语文/").append(grade + "/");
		} else if (course.equals("数学")) {
			picturePath.append("数学/").append(grade + "/");
		} else if (course.equals("英文")) {
			// 英文只有三年级的数据
			picturePath.append("英文/").append("三年级/");
		} else {
			System.out.println("course不正确或为空");
		}

		String fsetsLiftPath = picturePath.toString() + "fsetsLift.png";
		String ScottPlotPath = picturePath.toString() + "ScottPlot.png";
		String fsetsSupPath = picturePath.toString() + "fsetsSup.png";
		String GraphPath = picturePath.toString() + "Graph.png";
		String GroupedMatrixPath = picturePath.toString() + "GroupedMatrix.png";

		request.setAttribute("img_fsetsLift", fsetsLiftPath);
		request.setAttribute("img_ScottPlot", ScottPlotPath);
		request.setAttribute("img_fsetsSup", fsetsSupPath);
		request.setAttribute("img_Graph", GraphPath);
		request.setAttribute("img_GroupedMatrix", GroupedMatrixPath);
	}
}
