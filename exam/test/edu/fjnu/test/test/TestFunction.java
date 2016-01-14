package edu.fjnu.test.test;

import org.junit.Test;

import edu.fjnu.domain.Student;
import edu.fjnu.service.GradeInfoService;
import edu.fjnu.service.PdfUpdateService;
import edu.fjnu.util.DoubleFormat;

public class TestFunction {
	GradeInfoService gradeInfoService = new GradeInfoService();

	@Test
	public void test1() {
		// DecimalFormat df = new DecimalFormat("0.00");
		// double tstDouble = 0;
		DoubleFormat df = new DoubleFormat();
		// double RstDouble = d
		// BigDecimal a=new BigDecimal(tstDouble);
		// double af = a.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
		// double rstDouble = df.getDoubleFormat(0);
		System.out.println(df.getDoubleFormat(47.620000000000005));
		double rst = df.getDivideFormat(1.11111, 1.211111) * 100;
		System.out.println(rst);
	}

	@Test
	public void test2() throws Exception {
		PdfUpdateService pdfService = new PdfUpdateService();
		Student stu = new Student();
		stu.setSname("林彦希");
		stu.setStudentID("2560");
		String scope = "三年级";
		pdfService.PdfForAll(stu, scope);
	}

}
