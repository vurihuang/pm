package edu.fjnu.test.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
	VTestDetail testdetail = new VTestDetail();
	VTestMain testmain = new VTestMain();

	@Test
	public void searchWrong() throws SQLException {
//		question = questionDao.getHard();
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

		for (int i = 0; i < length; i++) {
			sum += list.get(i).getScore();
		}

		double avg = sum / length;

		for (int i = 0; i < length; i++) {
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
	 * 
	 * @throws SQLException
	 */
	public void getPaperStd() throws SQLException {
		PaperService pservice = new PaperService();

		VTestMain testmain = new VTestMain();
		testmain.setPk_test_main_ID(2);
//		System.out.println(pservice.getStdByTestId(testmain));
	}

	@Test
	public void getAllTesIdtList() throws SQLException {
		List<VTestMain> list = questionDao.getAllTestId();
		VTestMain testmain = new VTestMain();
		for (int i = 0; i < list.size(); i++) {
			testmain.setPk_test_main_ID(list.get(i).getPk_test_main_ID());
//			System.out.print(pservice.getStdByTestId(testmain) + ",");
			;
		}
	}

	// @Test
	// public void getStuIdAndScore() throws SQLException {
	// List<VTestMain> list = new
	// ArrayList<VTestMain>(questionDao.getStuIdAndScoreByQstId());
	// System.out.println(list);
	// }

	// @Test
	// public void getStuAvgScore() throws SQLException {
	//// List<VTestMain> list = new
	// ArrayList<VTestMain>(questionDao.getStuAvgScoreOfScope());
	// VTestMain testmain = new VTestMain();
	// testmain.setStudent_memberId(1048);
	// List<VTestMain> list = new
	// ArrayList<VTestMain>(questionDao.getStuAvgScoreById(testmain));
	// System.out.println(list);
	// }
	// @Test
	// public void getStuIdScoreRealScore() throws SQLException{
	// List<VTestMain> stuIdScoreList = new
	// ArrayList<VTestMain>(questionDao.getStuIdAndScoreByQstId());
	// List<VTestMain> realScoreList = new
	// ArrayList<VTestMain>(questionDao.getStuAvgScoreOfScope());

	// List<List<Object>> stuIdScoreRealScoreList = new
	// ArrayList<List<Object>>();
	//
	// for(int i=0; i<stuIdScoreList.size(); i++){
	// List<Object> temp = new ArrayList<Object>();
	// temp.add(stuIdScoreList.get(i).getStudent_memberId());
	// temp.add(stuIdScoreList.get(i).getTestdetail().getRealScore());
	// temp.add(realScoreList.get(i).getRealscore());
	// stuIdScoreRealScoreList.add(temp);
	// }

	// System.out.println(stuIdScoreRealScoreList);
	// System.out.print(stuIdScoreList);
	// System.out.println();
	// System.out.print(realScoreList);
	// }

	@Test
	public void getStuIdScoreRealScore() throws SQLException {

		testdetail.setQuestion_fk_question_id(2L);
		// 通过试题ID得到学生ID及该题得分
		List<VTestMain> stuIdScorelist = new ArrayList<VTestMain>(questionDao.getStuIdAndScoreByQstId(testdetail));

		List<List<Object>> stuIdScoreRealScoreList = new ArrayList<List<Object>>();
		List<Double> stuAvgScore = new ArrayList<Double>();

		for (int i = 0; i < stuIdScorelist.size(); i++) {
			testmain.setStudent_memberId(stuIdScorelist.get(i).getStudent_memberId());
			List<VTestMain> temp = questionDao.getStuAvgScoreById(testmain);

			double sum = 0;
			double count = 0;
			for (int j = 0; j < temp.size(); j++) {
				if (temp.get(j).getRealscore() == 0)
					continue;
				sum += temp.get(j).getRealscore();
				count++;
			}
			if (count != 0)
				stuAvgScore.add(sum / count);
			else {
				stuAvgScore.add((double) 0);// 根据学生ID得到学生阶段分数
			}

		}
		System.out.println(stuAvgScore);

		for (int i = 0; i < stuIdScorelist.size(); i++) {
		}
		System.out.println(stuIdScoreRealScoreList);// 得到学生ID、题目得分、阶段平均分

		// for(int i=0; i<length; i++) {
		// System.out.println(stuIdScoreRealScoreList.get(i).get(2));
		// }

	}

	@Test
	public void getIdScore() throws SQLException {
		testdetail.setQuestion_fk_question_id((long) 2);
		List<VTestMain> idScore = questionDao.getStuIdAndScoreByQstId(testdetail);
		List<Object> avgList = new ArrayList<Object>();
		List<Object> idScoreRealScore = new ArrayList<Object>();
		for (int i = 0; i < idScore.size(); i++) {
			testmain.setStudent_memberId(idScore.get(i).getStudent_memberId());
			List<VTestMain> temp = questionDao.getStuAvgScoreById(testmain);

			double sum = 0;
			double count = 0;
			for (int j = 0; j < temp.size(); j++) {
				if (temp.get(j).getRealscore() == 0)
					continue;
				sum += temp.get(j).getRealscore();
				count++;
			}
			if (count != 0)
				avgList.add(sum / count);
			else {
				avgList.add((double) 0);// 根据学生ID得到学生阶段分数
			}
		}
		System.out.println(avgList);

		for (int i = 0; i < idScore.size(); i++) {
			List<Object> temp = new ArrayList<Object>();
			temp.add(idScore.get(i).getStudent_memberId());
			temp.add(idScore.get(i).getTestdetail().getRealScore());
			temp.add(avgList.get(i));
			idScoreRealScore.add(temp);
		}
		double max = 0;
		int index = 0;
		List<Object> result = new ArrayList<Object>();
		System.out.println(idScoreRealScore);
		int length = idScoreRealScore.size();

		Collections.sort(idScoreRealScore, null);
		System.out.println(idScoreRealScore);
	}

//	public void setAvgforIdScore() {
//		List<VTestDetail> idScore = new ArrayList<VTestDetail>()
//	}
}
