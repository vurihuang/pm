/**
 * 
 */
package edu.fjnu.service;

import java.util.List;

import edu.fjnu.dao.StudentGrowDao;
import edu.fjnu.domain.StudentPr;

/**
 * 个人成长轨迹模块的service
 * @author Administrator
 *
 */
public class GrowService {
	StudentGrowDao studentGrowDao=new StudentGrowDao();
	public List<StudentPr> getStudentPrs(String name,String subject){
		return studentGrowDao.getStuPrList(name, subject);
	}
}
