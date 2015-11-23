package com.fjnu.test.service;

import com.fjnu.service.impl.ExamAnalyseImpl;

public class AnalyseTest {
	public static void main(String[] args) {
		String sql = "select sum(case when t_testmain.realscore>=80 then 1 else 0 end)/Count(*) from  t_testmain  where  grandient_grandientId in (select grandient_grandientId from t_grandient_t_scope where scopes_pk_scope_id in(SELECT pk_scope_id from t_scope where name like '人教版'));";
		ExamAnalyseImpl ea = new ExamAnalyseImpl();
		float excellentRate = ea.getExcellentRate(sql);
		System.out.println(excellentRate);
	}
}
