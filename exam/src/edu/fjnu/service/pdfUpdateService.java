package edu.fjnu.service;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;

import edu.fjnu.domain.Student;
import edu.fjnu.util.CSVUtil;
import edu.fjnu.util.ImagUtil;
import edu.fjnu.util.PDFUtil;

public class PdfUpdateService 
{
	/**
	 * 成绩 分析
	 * @param stu
	 * @param scope
	 * @param pdf
	 * @throws Exception 
	 * @throws DocumentException 
	 */
	public static void GreadeAnalasisForAll( Student stu, String scope, Document pdf) throws DocumentException, Exception
	{
		GradesPdfService gps = new GradesPdfService();
		
		Paragraph para = new Paragraph("\n");
		PDFUtil tools = new PDFUtil();
		tools.InsertModuleTitle(pdf, "1    成绩分析报告");
		String [] subject = new String[]{"语文", "数学", "英语"};
		
		for( int i=0; i<subject.length; i++)
		{
			tools.InsertTitle(pdf, "1."+(i+1) +"	"+ subject[i]);
			tools.InsertSubhead(pdf, "1."+(i+1) + ".1	 前测后测成绩对比分析报告");
			pdf.add(para);
			
			
			Paragraph par = new Paragraph();
			par.add(PDFUtil.convertChunkByChinese("前 测 成 绩", 18, Font.BOLD, Color.BLACK));
			par.setAlignment(Element.ALIGN_CENTER);
			pdf.add(par);
			pdf.add(para);
			String[] TableHeader = new String[]{"考试名称","考试类型", "分数"};
			
			List<String[]> tableHeader = new ArrayList<String[]>();
			tableHeader.add(TableHeader);
			tools.InsertTable(pdf, new float[]{40,40,20}, 100, tableHeader, 20, Font.BOLD, Color.BLACK);
			List<String[]> preScore = gps.getPreScore(stu.getSname(), scope, subject[i]);
			tools.InsertTable(pdf, new float[]{40,40,20}, 100, preScore, 15, Font.NORMAL, Color.BLACK);
			pdf.add(para);
			
			
			par = new Paragraph();
			par.add(PDFUtil.convertChunkByChinese("后 测 成 绩", 18, Font.BOLD, Color.BLACK));
			par.setAlignment(Element.ALIGN_CENTER);
			pdf.add(par);
			pdf.add(para);
			TableHeader = new String[]{"考试名称","考试类型", "分数"};
			tableHeader.clear();
			tableHeader.add(TableHeader);
			tools.InsertTable(pdf, new float[]{40,40,20}, 100, tableHeader, 20, Font.BOLD, Color.BLACK);
			List<String[]> lastScore = gps.getLastScore(stu.getSname(), scope, subject[i]);
			tools.InsertTable(pdf, new float[]{40,40,20}, 100, lastScore, 15, Font.NORMAL, Color.BLACK);
			pdf.add(para);
			
			tools.InsertSubhead(pdf, "1."+(i+1) + ".2 	成长轨迹");
			pdf.newPage();
		}
		
		pdf.newPage();
	}
	
	
	/**
	 * 试卷分析
	 * @param stu
	 * @param scope
	 * @param pdf
	 * @throws DocumentException
	 * @throws Exception
	 */
	public static void TestAnalasisForAll(Student stu, String scope, Document pdf ) throws DocumentException, Exception 
	{

		Paragraph para = new Paragraph("\n");
		PDFUtil tools = new PDFUtil();
		tools.InsertModuleTitle(pdf, "2 	试卷分析报告");
		String [] subject = new String[]{"语文", "数学", "英语"};
		for( int i=0; i<subject.length; i++)
		{
			tools.InsertTitle(pdf, "2."+(i+1) +"	"+ subject[i]);
			
			
			
			tools.InsertSubhead(pdf, "2."+(i+1) + ".1 	试题错误率统计");
			pdf.add(para);
			String[] tableHeader = new String[]{"知识点", "错误率"};
			List<String[]> tableHeader1 = new ArrayList<String[]>();
			tableHeader1.add(tableHeader);
			tools.InsertTable(pdf, new float[]{70,20}, 100, tableHeader1, 20, Font.BOLD, Color.BLACK);
			TestPdfService tps = new TestPdfService();
			List<String[]> point = tps.getWrongList(Integer.valueOf(stu.getStudentID()), scope, subject[i]);
			tools.InsertTable(pdf, new float[]{70,20}, 100, point, 13, Font.NORMAL, Color.BLACK);
			pdf.add(para);
			pdf.newPage();
		}
		pdf.newPage();
	}
	
	
	/**
	 * 关联规则分析模块
	 * @param stu
	 * @param scope
	 * @param pdf
	 * @throws DocumentException
	 * @throws Exception
	 */
	public static void RelationAnalasisForAll(Student stu, String scope, Document pdf ) throws DocumentException, Exception 
	{
		
		// 修改年级乙方万一
		String[] nj = new String[]{"一年级","二年级","三年级","四年级","五年级","六年级"};
		if( true == scope.contains(nj[0])){
			scope = "一年级";
		}else if(true == scope.contains(nj[1])){
			scope = "二年级";
		}else if( true == scope.contains(nj[2])){
			scope = "三年级";
		}else if( true == scope.contains(nj[3])){
			scope = "四年级";
		}else if( true == scope.contains(nj[4])){
			scope = "五年级";
		}else{
			scope = "六年级";
		}
		
		Paragraph para = new Paragraph("\n");
		PDFUtil tools = new PDFUtil();
		tools.InsertModuleTitle(pdf, "3 	知识点关联分析报告");
		
		tools.InsertTitle(pdf, "3.1		关联规则关键词解释");
		tools.InsertSubhead(pdf, "3.1.1		支持度(Support):");
		pdf.add(para);
		tools.InsertParagh(pdf, "某个知识点、某几个知识点构成的集合或某条规则出现的概率，Support的值越大，代表出现次数越多。");
		pdf.add(para);
		tools.InsertSubhead(pdf, "3.1.2		置信度(Confidence):");
		pdf.add(para);
		tools.InsertParagh(pdf, "知识点A,B同时出现和知识点A出现的次数的比值。");
		pdf.add(para);
		tools.InsertSubhead(pdf, "3.1.3		提升度(Lift):");
		pdf.add(para);
		tools.InsertParagh(pdf, " 提升度比率越高，规则越强，可信度越高。");
		pdf.add(para);
		
		String[] subject = new String[3];
		
		if("三年级" == scope){
			subject = new String[]{"语文","数学","英文"};
		}else{
			subject = new String[]{"语文","数学"};
		}
		for( int i=0; i<subject.length; i++)
		{
			tools.InsertTitle(pdf, "3."+(i+2) +"	"+ subject[i]);
			tools.InsertSubhead(pdf, "3."+(i+2) + ".1	知识点频数集分析");
			List< String[]> fsetData = CSVUtil.importCsv(System.getProperty("user.dir").replace("\\", "/")
													+"/WebContent/Relation/"
													+subject[i]+"/"
													+scope
													+"/fstes.csv");
			
			pdf.add(para);
			String[] temp = new String[fsetData.get(1).length];
			temp[0] = " ";
			temp[1] = fsetData.get(0)[0];
			temp[2] = fsetData.get(0)[1];
			List<String[]> tableHeader1 = new ArrayList<String[]>();
			tableHeader1.add(temp);
			tools.InsertTable(pdf, new float[]{20,70,30}, 150, tableHeader1, 20, Font.BOLD, Color.BLACK);
			fsetData.remove(0);
			tools.InsertTable(pdf, new float[]{20,70,30}, 100, fsetData, 15, Font.NORMAL, Color.BLACK);
			int page1 = pdf.getPageNumber();
			tools.InsertImg(pdf, System.getProperty("user.dir").replace("\\", "/")
					+"/WebContent/Relation/"
					+subject[i]+"/"
					+scope
					+"/fsetsSup.png");
			tools.InsertImg(pdf, System.getProperty("user.dir").replace("\\", "/")
					+"/WebContent/Relation/"
					+subject[i]+"/"
					+scope
					+"/fsetsLift.png");
			pdf.newPage();
			
			
			tools.InsertSubhead(pdf, "3."+(i+3) + ".2	知识点关联规则分析");
			List< String[]> rulesData = CSVUtil.importCsv(System.getProperty("user.dir").replace("\\", "/")
					+"/WebContent/Relation/"
					+subject[i]+"/"
					+scope
					+"/rules.csv");
			pdf.add(para);
			temp = new String[4];
			temp = rulesData.get(0);
			tableHeader1.clear();
			tableHeader1.add(temp);
			tools.InsertTable(pdf, new float[]{55,15,15,15}, 100, tableHeader1, 20, Font.BOLD, Color.BLACK);
			rulesData.remove(0);
			tools.InsertTable(pdf, new float[]{55,15,15,15}, 100, rulesData, 15, Font.NORMAL, Color.BLACK);
			tools.InsertImg(pdf, System.getProperty("user.dir").replace("\\", "/")
					+"/WebContent/Relation/"
					+subject[i]+"/"
					+scope
					+"/ScottPlot.png");
			ImagUtil.resizeImage(
					System.getProperty("user.dir").replace("\\", "/")
					+"/WebContent/Relation/"
					+subject[i]+"/"
					+scope
					+"/", 
					"GroupedMatrix.png",
					"GroupedMatrix(1).png",
					700,
					1000);
			tools.InsertImg(pdf, System.getProperty("user.dir").replace("\\", "/")
					+"/WebContent/Relation/"
					+subject[i]+"/"
					+scope
					+"/GroupedMatrix(1).png");
			ImagUtil.resizeImage(
					System.getProperty("user.dir").replace("\\", "/")
					+"/WebContent/Relation/"
					+subject[i]+"/"
					+scope
					+"/", 
					"Graph.png",
					"Graph.png(1).png",
					750,
					900);
			tools.InsertImg(pdf, System.getProperty("user.dir").replace("\\", "/")
					+"/WebContent/Relation/"
					+subject[i]+"/"
					+scope
					+"/Graph.png(1).png");
			pdf.newPage();
		}
		
		pdf.newPage();
	}
	
	
	/**
	 * 聚类分析
	 * @param stu
	 * @param scope
	 * @param pdf
	 * @throws DocumentException
	 * @throws Exception
	 */
	public static void ClusterAnalasisForAll(Student stu, String scope, Document pdf ) throws DocumentException, Exception 
	{
		
		// 修改年级乙方万一
		String[] nj = new String[]{"一年级","二年级","三年级","四年级","五年级","六年级"};
		if( true == scope.contains(nj[0])){
			scope = "一年级";
		}else if(true == scope.contains(nj[1])){
			scope = "二年级";
		}else if( true == scope.contains(nj[2])){
			scope = "三年级";
		}else if( true == scope.contains(nj[3])){
			scope = "四年级";
		}else if( true == scope.contains(nj[4])){
			scope = "五年级";
		}else{
			scope = "六年级";
		}
		Paragraph para = new Paragraph("\n");
		PDFUtil tools = new PDFUtil();
		tools.InsertModuleTitle(pdf, "4  	知识点聚类分析报告");
		String [] subject = new String[]{"语文", "数学", "英语"};
		for( int i=0; i<subject.length; i++)
		{
			tools.InsertTitle(pdf, "4."+(i+1) +"	"+ subject[i]);
			tools.InsertSubhead(pdf, "4."+(i+1) + ".1	 知识点常模");
			pdf.add(para);
			String[] TableHeader = new String[]{scope+"(上)",scope+"下"};
			List<String[]> tableHeader = new ArrayList<String[]>();
			tableHeader.add(TableHeader);
			tools.InsertTable(pdf, new float[]{50,50}, 100, tableHeader, 20, Font.BOLD, Color.BLACK);
			TableHeader = new String[]{"知识点","错误次数","知识点","错误次数"};
			tableHeader.clear();
			tableHeader.add(TableHeader);
			tools.InsertTable(pdf, new float[]{35,15,35,15}, 100, tableHeader, 16, Font.BOLD, Color.BLACK);
			ClusterPdfService cps = new ClusterPdfService();
			List<String[]> cluster = cps.getClusterMatrix( Integer.valueOf(stu.getStudentID()), scope, subject[i]);
			tools.InsertTable(pdf, new float[]{35,15,35,15}, 100, cluster, 12, Font.NORMAL, Color.BLACK);
			pdf.add(para);
		}
	}
	/**
	 * 报告完整版
	 * @param stu
	 * @param scope
	 * @throws Exception
	 */
	public void PdfForAll( Student stu, String scope) throws Exception
	{

		
		PDFUtil pdftool = new PDFUtil();
		Document pdf = pdftool.createDocument(System.getProperty("user.dir").replace("\\", "/")
												+"/WebContent/Grades/"
												+stu.getSname()
												+scope
												+"分析报告.pdf");
		pdf.open(); 
		
		// 制作封面
		pdftool.makePDFCover(pdf, scope+"\n综合分析报 告", "\n学号："+ stu.getStudentID() 
														+ "\n姓名：" +stu.getSname());
		
		PdfUpdateService.GreadeAnalasisForAll(stu, scope, pdf);
		PdfUpdateService.TestAnalasisForAll(stu, scope, pdf);
		PdfUpdateService.RelationAnalasisForAll(stu, scope, pdf);
		PdfUpdateService.ClusterAnalasisForAll(stu, scope, pdf);
		
		pdf.close();
	}
	
	public static void main( String[] args) throws BadElementException, IOException, Exception
	{
		PDFUtil pdftool = new PDFUtil();
		Document pdf = pdftool.createDocument(System.getProperty("user.dir").replace("\\", "/")
												+"/WebContent/Grades/"
												+"分析报告1.pdf");
		pdf.open(); 
		
		Student stu = new Student();
		// 制作封面
		pdftool.makePDFCover(pdf, "\n综 合 分 析 报 告", "学号："+"\n姓名：");
		PdfUpdateService.GreadeAnalasisForAll(stu, " ", pdf);
		PdfUpdateService.TestAnalasisForAll(stu, " ", pdf);
		PdfUpdateService.RelationAnalasisForAll(stu, "三年级", pdf);
		PdfUpdateService.ClusterAnalasisForAll(stu, "三年级", pdf);
		pdf.close();
		
		
	}
}
