package edu.fjnu.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import edu.fjnu.domain.Student;
import edu.fjnu.domain.VScope;
import edu.fjnu.service.PdfUpdateService;
import edu.fjnu.service.StudentPaperService;
import net.sf.json.JSONObject;

@WebServlet("/PDFServlet")
public class PDFServlet extends BaseServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private StudentPaperService sts = new StudentPaperService();
	private String grade;

	public String loadGrades(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {

		String studentID = (String) request.getSession().getAttribute("sID");
		// 通过学生ID得到他所有的年级列表
		List<VScope> vScopeList = sts.getStudentGradeList(Integer.parseInt(studentID));
		request.setAttribute("gradeList", vScopeList);
		grade = request.getParameter("grade");
		request.setAttribute("selectedGrade", grade);
		return "f:/index/jsp/util/download.jsp";
	}
	
	public void downloadPDF(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String mygrade = request.getParameter("mygrade");
		String realgrade = mygrade.substring(0, 3);
		
		PdfUpdateService pdfService = new PdfUpdateService();
		Student stu = new Student();
		String stuName = (String) request.getSession().getAttribute("sname");// 得到学生的名字
		stu.setSname(stuName);
		String studentID = (String) request.getSession().getAttribute("sID");
		stu.setStudentID(studentID);
		System.out.println("stuName :" + stuName + "studentID :" + studentID + "grade" + realgrade);


		try {
			pdfService.PdfForAll(stu, realgrade);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JSONObject json = new JSONObject();
		json.put("showgrade", "导出成功!");
		response.getWriter().print(json);
	}
}
