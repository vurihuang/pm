package edu.fjnu.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import edu.fjnu.dao.QuestionDao;
import edu.fjnu.domain.VQuestion;
import edu.fjnu.domain.VTestDetail;
import edu.fjnu.domain.VTestMain;
import edu.fjnu.service.PaperService;

public class TestVQuestion {
	VQuestion question = new VQuestion();
	QuestionDao questionDao = new QuestionDao();
	PaperService pservice = new PaperService();

	@Test
	public void searchWrong() throws SQLException {
		question = questionDao.getHard();
		System.out.println(question.getWrong());
	}

	@Test
	public void searchScoreBySubjectId() throws SQLException {
		System.out.println(questionDao.getScoreBySubjectId().getScore());
	}
	
	@Test
	public void getWrongRealScore() throws SQLException {
		List<VQuestion> listWrong = new ArrayList(questionDao.getWrong());
		List<VTestDetail> listScore = new ArrayList(questionDao.getScore());
		
	}
	
	@Test
	public void testWrongAndRealScore() throws SQLException {
		PaperService pservice = new PaperService();
		double[] arrayWrong = pservice.getWrongArray();
		double[] arrayScore = pservice.getRealScoreArray();
		
		System.out.println(Arrays.toString(arrayWrong));
		System.out.println(Arrays.toString(arrayScore));
	}
	@Test
	public void getStdDevisionById() throws SQLException {
		Long questionID = 2L;
		List<VTestDetail> list = questionDao.getStdDeviation(questionID);
		double length = list.size();
		double sum = 0;
		double cnt = 0;
		
		for (int i=0; i<length; i++){
			sum += list.get(i).getScore();
		}
		
		double avg = sum / length;
		
		for(int i=0; i<length; i++){
			cnt += (list.get(i).getScore() - avg) * (list.get(i).getScore() - avg);
		}
		
		System.out.println(Math.sqrt(cnt));
	}
	
	@Test
	public void getStdDevision() throws SQLException {
		System.out.println(pservice.getStdDevisionById((long) 2));
	}
	
	@Test
	/**
	 * 根据试卷ID得信度
	 * @throws SQLException
	 */
	public void getPaperStd() throws SQLException {
		PaperService pservice = new PaperService();
		
		VTestMain testmain = new VTestMain();
		testmain.setPk_test_main_ID(2);
		System.out.println(pservice.getStdByTestId(testmain));
	}
	
	@Test
	public void getAllTesIdtList() throws SQLException {
		List<VTestMain> list = questionDao.getAllTestId();
		VTestMain testmain = new VTestMain();
		for (int i=0; i<list.size(); i++){
			testmain.setPk_test_main_ID(list.get(i).getPk_test_main_ID());
			System.out.print(pservice.getStdByTestId(testmain) + ",");;
		}
	}
}
