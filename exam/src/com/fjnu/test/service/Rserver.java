package com.fjnu.test.service;


import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

import com.fjnu.utils.SqlTool;

//public class Rserver {
//	public static void main(String[] args) throws REngineException {
//		
//		RConnection r_conn = new RConnection();
////		double[] arr = c.eval("rnorm(10)").asDoubles();
////        for (double a : arr) {//循环打印变量arr
////            System.out.print(a + ",");
////        }
//        
//        Random ran = new Random();
//		double[] x = new double[100];
//		int[] y = new int[100];
//		String[] date = {"rrr","tttt","YYY","rrr","RRRR","rr","TTTTT","tt",
//							"tt","yyy","TTTT","YYYY","yyyy","UUUYU","tttt",
//							"yyyyyy","ttttt","tttww","tttrr","RRR"};
//		
//		for(int i=0; i < 20; i++)
//		{
//			x[i] = ran.nextDouble();
//		}
//		
//		for( int i=1; i<=20; i++)
//		{
//			y[i] = i;
//		}
//////        File file = new File("./");
//////        String filePath = file.getAbsolutePath(); 
//        r_conn.assign("y", y);
//        r_conn.assign("x", x);
//        r_conn.eval("jpeg('/Users/vengeance/Documents/workspaceMars/exam/image/rserver.jpg')");
//		r_conn.eval("ggplot(data.frame(x,y), aes(x = x, y = y)) + geom_line()+geom_point()");
//		r_conn.eval("dev.off()");
//		
//		
//		
//		
//		System.out.println("done");
////		RConnection c;
////        try {
////           c = new RConnection();//连接
////           double[] w={75.0, 64.0, 47.4, 66.9, 62.2, 62.2, 58.7, 63.5,66.6, 64.0, 57.0, 69.0, 56.9, 50.0, 72.0};
////           c.eval("jpeg('/Users/vengeance/Documents/workspaceMars/exam/image/rserver.jpg')"); //存储路径
////           c.assign("x",w);  //赋值
////           c.eval("hist(x,freq = FALSE)");//绘图函数
////           c.eval("lines(density(x), col = 'blue')");//线条颜色
////           c.eval("dev.off()");//关闭设备
////           c.close();//记得关闭连接，否则内存的资源不被释放，会引起进程冲突
////           System.out.println("done");
////        } catch (RserveException e) {
////        	e.printStackTrace();
////        	} 
////		}
//	}
//}

public class Rserver{
		public static void OnlyBranchGradeStatistics(List<Object> params)
				throws REXPMismatchException, REngineException, SQLException, IOException
		{
			String sql = "select realscore, begintime from t_testmain "
					+"where  subject like ？ and student_memberId in"
					+"  (select memberid from t_member" 
					+ " where name like ？)"
					+ "and grandient_grandientId in"   
					+ "(select grandient_grandientId from t_grandient_t_scope "
					+ "where scopes_pk_scope_id in"
					+ "(SELECT pk_scope_id from t_scope" 
					+ "      where name like ？))"
					+" and grandient_grandientId in"
					+"    (select grandientId from t_grandient "
					+"   where grandientsecequenceno=  1  )"
					+"ORDER BY begintime";
			SqlTool tool = new SqlTool();
			tool.setSql(sql);
			tool.setParams(params);
			
			ResultSet rs = tool.executeQuery();
			List<Double> score = new ArrayList<Double>();
			
			try {
				while(rs.next()){
					List<Double> temp = new ArrayList<Double>();
					temp.add(rs.getDouble(1));
					score.addAll(temp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println(score);
			
		
			/*连接到R语言*/
//			RConnection r_conn = new RConnection();
//			int len = score.size();
//			double[] _score = new double[len];
//			try{
//				for(int i=0; i<len; i++){
//					_score[i] = score.get(i);
//				 }
//				
//				r_conn.assign("x", _score);
//		        r_conn.eval("jpeg('/Users/vengeance/Documents/workspaceMars/exam/image/rserver.jpg')");
//				r_conn.eval(" plot(_score,type='l')");
//				r_conn.eval("dev.off()");
//				System.out.println("done");
//			}catch (REngineException e) {  
//		        e.printStackTrace();  
//		    } finally {  
//		        r_conn.close();
//		    }
	}
		public static void main(String[] args) throws REXPMismatchException, REngineException, SQLException, IOException {
//			List<Object> list = new ArrayList<Object>();
//			String subject = "数学";
//			String studentName = "测试学生";
//			String scopeName = "人教版";
//			list.add(subject);
//			list.add(studentName);
//			list.add(scopeName);
//			print(list);
//			System.out.println("fall");
			List<Double> high = new ArrayList<Double>();
			List<Double> low = new ArrayList<Double>();
			List<Double> avg = new ArrayList<Double>();
			double s1 = 20;
			double s2 = 13;
			double s3 = 33;
			high.add(s1);
			high.add(s2);
			high.add(s3);
			low.add(s1);
			low.add(s2);
			low.add(s3);
			avg.add(s1);
			avg.add(s2);
			avg.add(s3);
			printScore(high, low, avg);
		}
		public static void printScore(List<Double> highScore, List<Double> lowScore, List<Double> avgScore) throws REngineException{
			
				 
				 int length = highScore.size();
				 double[] highest = new double[length];
				 double[] lowest = new double[length];
				 double[] avg = new double[length];
				 		
				 for(int i=0; i<length; i++){
					highest[i] = highScore.get(i);
					lowest[i] = lowScore.get(i);
					avg[i] = avgScore.get(i);
				 			
				 }
//				 for(int i=0; i<length; i++){
//					 System.out.print(highest[i] + " ");
//					 System.out.print(lowest[i] + " ");
//					 System.out.print(avg[i] + " ");
//				 }
				 
				 
				 double[] w1={75.0, 65.0, 47.4, 66.9, 62.2, 62.2, 58.7, 63.5,66.6, 64.0, 57.0, 69.0, 56.9, 50.0, 72.0};
				 double[] w2={80.0, 70.0, 47.4, 66.9, 62.2, 62.2, 58.7, 63.5,66.6, 64.0, 57.0, 69.0, 56.9, 50.0, 72.0};
				 double[] w3={85.0, 75.0, 47.4, 66.9, 62.2, 62.2, 58.7, 63.5,66.6, 64.0, 57.0, 69.0, 56.9, 50.0, 72.0};
				 
				 File file = null;
				 String filePath = file.getAbsolutePath();
					/*连接到R语言*/
					RConnection r_conn = new RConnection();
					try{
						
//						r_conn.assign("Highest", highest);
//						r_conn.assign("Lowest", lowest);
//						r_conn.assign("AVG",  avg);
						
						r_conn.assign("Highest", w1);
						r_conn.assign("Lowest", w2);
						r_conn.assign("AVG",  w3);
						
			            r_conn.eval("jpeg('/Users/vengeance/Documents/workspaceMars/exam/image/bbb.jpg')");
//						r_conn.eval(" ggplot(data.frame(Highest,y), aes(x = Highest, y = y)) + geom_line()+geom_point()");
//						r_conn.eval(" ggplot(data.frame(Lowest,y), aes(x = Lowest, y = y),add=TRUE) + geom_line()+geom_point()");
//						r_conn.eval(" ggplot(data.frame(AVG,y), aes(x = AVG, y = y),add=True) + geom_line()+geom_point()");
			            
			            
			            
			            r_conn.eval("plot(Highest,type='l')");
			            r_conn.eval("plot(Lowest,type='l')");
			            r_conn.eval("plot(AVG,type='l')");
			            
						r_conn.eval("dev.off()");
						
						
					} catch (REngineException e) {  
			            e.printStackTrace();  
			        } finally {  
			            r_conn.close();
			        }
					
				
//				RConnection c;
//		        try {
//		           c = new RConnection();//连接
//		           double[] w={75.0, 64.0, 47.4, 66.9, 62.2, 62.2, 58.7, 63.5,66.6, 64.0, 57.0, 69.0, 56.9, 50.0, 72.0};
//		           c.eval("jpeg('/Users/vengeance/Documents/workspaceMars/exam/image/123.jpg')"); //存储路径
//		           c.assign("x",w);  //赋值
//		           c.eval("hist(x,freq = FALSE)");//绘图函数
//		           c.eval("lines(density(x), col = 'blue')");//线条颜色
//		           c.eval("dev.off()");//关闭设备
//		           c.close();//记得关闭连接，否则内存的资源不被释放，会引起进程冲突
//		           System.out.println("done");
//		        } catch (RserveException e) {
//		        	e.printStackTrace();
//		        	} 
		        
		        
//		}
//					System.out.println(highScore);
//					System.out.println(lowScore);
//					System.out.println(avgScore);
		}
		
		public static void print(List<Object> params) throws REngineException{
			String sql = "select realscore from t_testmain  LEFT JOIN t_grandient ON t_testmain.grandient_grandientId = t_grandient.grandientId where  subject like ? and student_memberId in (select memberid from t_member where name like ?) and grandient_grandientId in (select grandient_grandientId from t_grandient_t_scope where scopes_pk_scope_id in (SELECT pk_scope_id from t_scope where name like ?)) and realscore ORDER BY begintime";
			
			SqlTool tool = new SqlTool();
			tool.setSql(sql);
			tool.setParams(params);
			ResultSet rs = tool.executeQuery();
			List<Double> list = new ArrayList<Double>();
			try {
				while(rs.next()){
					List<Double> temp = new ArrayList<Double>();
					temp.add(rs.getDouble(1));
					list.addAll(temp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
//			System.out.println(list);
			
		RConnection c;
        try {
           c = new RConnection();//连接
           double[] w={75.0, 64.0, 47.4, 66.9, 62.2, 62.2, 58.7, 63.5,66.6, 64.0, 57.0, 69.0, 56.9, 50.0, 72.0};
           c.eval("jpeg('/Users/vengeance/Documents/workspaceMars/exam/image/aaa.jpg')"); //存储路径
           c.assign("x",w);  //赋值
           c.eval("hist(x,freq = FALSE)");//绘图函数
           c.eval("lines(density(x), col = 'blue')");//线条颜色
           c.eval("dev.off()");//关闭设备
           c.close();//记得关闭连接，否则内存的资源不被释放，会引起进程冲突
           System.out.println("done");
        } catch (RserveException e) {
        	e.printStackTrace();
        	} 
		}
//			RConnection r_conn = new RConnection();
//			int len = list.size();
//			double[] _score = new double[len];
//			try{
//				for(int i=0; i<len; i++){
//					_score[i] = list.get(i);
//				 }
//				
//				r_conn.assign("x", _score);
//		        r_conn.eval("jpeg('/Users/vengeance/Documents/workspaceMars/exam/image/bbb.jpg')");
//				r_conn.eval(" plot(_score)");
//				r_conn.eval("dev.off()");
//				System.out.println("done"); 
//			}catch (REngineException e) {  
//		        e.printStackTrace();  
//		    } finally {  
//		        r_conn.close();
//		    }
//		}
		
}