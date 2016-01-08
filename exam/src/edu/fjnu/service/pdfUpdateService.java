package edu.fjnu.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.handlers.BeanHandler;

import com.lowagie.text.Document;

import edu.fjnu.dao.StudentDao;
import edu.fjnu.domain.Student;
import edu.fjnu.util.CSVUtil;
import edu.fjnu.util.ImagUtil;
import edu.fjnu.util.PDFUtil;

public class pdfUpdateService 
{
	/**
	 * 生成关联分析pdf
	 * @param course
	 * @param year
	 * @throws Exception
	 */
	public void updateRelationPDF( String course, String year) 
			throws Exception
	{
		PDFUtil pdftool = new PDFUtil();
		Document pdf = pdftool.createDocument(System.getProperty("user.dir").replace("\\", "/")
												+"/WebContent/Relation/"
												+course+"/"
												+year.replace("%", "")
												+"/Relation.pdf");
		pdf.open();
		// 设置pdf封面
		pdftool.makePDFCover(pdf, 
							year.replace("%", "")+course+"知识点关联分析报告",
							"");
		// 第一章（关于关键词解说）
		pdftool.InsertTitle(pdf, "关联规则关键词解释");
		pdftool.InsertSubhead(pdf, "支持度(Support):");
		pdftool.InsertParagh(pdf, "某个知识点、某几个知识点构成的集合或某条规则出现的概率，Support的值越大，代表出现次数越多。");
		pdftool.InsertSubhead(pdf, "置信度(Confidence):");
		pdftool.InsertParagh(pdf, "知识点A,B同时出现和知识点A出现的次数的比值。");
		pdftool.InsertSubhead(pdf, "提升度(Lift):");
		pdftool.InsertParagh(pdf, " 提升度比率越高，规则越强，可信度越高。");
		pdf.newPage();
		// 第二章（知识点频数集分析）
		pdftool.InsertTitle(pdf, "知识点频数集分析报告");
		List< String[]> fsetData = CSVUtil.importCsv(System.getProperty("user.dir").replace("\\", "/")
												+"/WebContent/Relation/"
												+course+"/"
												+year.replace("%", "")
												+"/fstes.csv");
		String[] temp = new String[fsetData.get(1).length];
		temp[0] = " ";
		temp[1] = fsetData.get(0)[0];
		temp[2] = fsetData.get(0)[1];
		fsetData.remove(0);
		fsetData.add(0, temp);
		pdftool.InsertSubhead(pdf, "知识点频数统计表");
		pdftool.InsertParagh(pdf, "频数集代表的是支持度大于等于特定最小支持度(Support)的项集，"
									+"即该知识点在该年段试卷内出现的概率大于某个最小的出现概率。");
//		pdftool.InsertTable(pdf, {}, list);
		pdftool.InsertTable(pdf, new float[]{30,270,60}, fsetData);
		pdftool.InsertImg(pdf, System.getProperty("user.dir").replace("\\", "/")
												+"/WebContent/Relation/"
												+course+"/"
												+year.replace("%", "")
												+"/fsetsSup.png");
		pdftool.InsertImg(pdf, System.getProperty("user.dir").replace("\\", "/")
				+"/WebContent/Relation/"
				+course+"/"
				+year.replace("%", "")
				+"/fsetsLift.png");
		pdf.newPage();
		// 第三章(知识点规则分析)
		pdftool.InsertTitle(pdf, "\n知识点关联规则分析报告");
		List< String[]> rulesData = CSVUtil.importCsv(System.getProperty("user.dir").replace("\\", "/")
				+"/WebContent/Relation/"
				+course+"/"
				+year.replace("%", "")
				+"/rules.csv");
		pdftool.InsertSubhead(pdf, "知识点关联规则统计表");
		pdftool.InsertTable(pdf, new float[]{250,50,50,50}, rulesData);
		pdftool.InsertImg(pdf, System.getProperty("user.dir").replace("\\", "/")
				+"/WebContent/Relation/"
				+course+"/"
				+year.replace("%", "")
				+"/ScottPlot.png");
		ImagUtil.resizeImage(
				System.getProperty("user.dir").replace("\\", "/")
				+"/WebContent/Relation/"
				+course+"/"
				+year.replace("%", "")
				+"/", 
				"GroupedMatrix.png",
				"GroupedMatrix(1).png",
				700,
				1000);
		pdftool.InsertImg(pdf, System.getProperty("user.dir").replace("\\", "/")
				+"/WebContent/Relation/"
				+course+"/"
				+year.replace("%", "")
				+"/GroupedMatrix(1).png");
		ImagUtil.resizeImage(
				System.getProperty("user.dir").replace("\\", "/")
				+"/WebContent/Relation/"
				+course+"/"
				+year.replace("%", "")
				+"/", 
				"Graph.png",
				"Graph.png(1).png",
				750,
				900);
		pdftool.InsertImg(pdf, System.getProperty("user.dir").replace("\\", "/")
				+"/WebContent/Relation/"
				+course+"/"
				+year.replace("%", "")
				+"/Graph.png(1).png");
		pdf.close();
	}
	
	/**
	 * 学生成绩分析文档
	 * @param StudentID
	 * @param sourse
	 * @throws Exception 
	 */
	public void updateGradesAnalasis( int studentID) throws Exception
	{
		// 通过学生的学号返回学生的ID（自我测试时）
		studentID = 2564;
		//获取学生信息
		
		PDFUtil pdftool = new PDFUtil();
		Document pdf = pdftool.createDocument(System.getProperty("user.dir").replace("\\", "/")
												+"/WebContent/Grades/"
												+studentID
												+"_成绩分析报告.pdf");
		pdf.open();
		pdftool.makePDFCover(pdf, "学习成绩分析报告", "\n学号: "+studentID);
		// 综合表现
		pdftool.InsertTitle(pdf, "综合表现");
		
		pdf.newPage();
		// 获取科目名
		String[] subject = new String[]{"语文","数学","英语"};
		for( int i=0; i<subject.length; i++)
		{
			pdftool.InsertTitle(pdf, subject[i]);
			if( subject.length-1 != i)
			{
				pdf.newPage();
			}
		}
		
		pdf.close();
	}
	
	public void updateTestAnanlisis( String test) {
		
	}
	
	public static void main( String[] args) throws Exception
	{
		pdfUpdateService pdf = new pdfUpdateService();
//		pdf.updateRelationPDF("语文", "一年级%");
//		pdf.updateRelationPDF("语文", "二年级%");
//		pdf.updateRelationPDF("语文", "三年级%");
//		pdf.updateRelationPDF("语文", "四年级%");
//		pdf.updateRelationPDF("语文", "五年级%");
//		pdf.updateRelationPDF("语文", "六年级%");
//		pdf.updateRelationPDF("数学", "一年级%");
//		pdf.updateRelationPDF("数学", "二年级%");
//		pdf.updateRelationPDF("数学", "三年级%");
//		pdf.updateRelationPDF("数学", "四年级%");
//		pdf.updateRelationPDF("数学", "五年级%");
//		pdf.updateRelationPDF("数学", "六年级%");
//		pdf.updateRelationPDF("英文", "三年级%");
		
//		pdf.updateGradesAnalasis(2564);
		
		Student stu = new Student();
		stu.setStudentID("");
		
	}
}
