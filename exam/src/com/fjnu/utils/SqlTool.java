package com.fjnu.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 * 数据库操作类
 * @author vengeance
 *
 */
public class SqlTool {
	private String sql = null;	//声明字段存放sql语句
	private List<Object> params = null;	//存放sql中占位符的位置
	private Connection conn = null;	//数据库连接对象
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	/*
	 * 初始化sql语句
	 */
	public void setSql(String sql){
		this.sql = sql;
	}
	
	/*
	 * 初始化sql语句中的参数
	 */
	public void setParams(List<Object> params){
		this.params = params;
	}
	
	/*
	 * 填充sql语句
	 */
	public void fillSql(){
		for(int i=0; i<params.size(); i++){
			try {
				ps.setObject(i+1, params.get(i));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * 返回从数据库中查询的数据
	 */
	public ResultSet executeQuery(){
		try {
			conn = ConnectionDB.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
			
			if(params != null && params.size() > 0){
				this.fillSql();
			}
			
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
	/*
	 * 执行更新语句，包括添加、修改、删除
	 */
	public void executeUpdate(){
		try {
			conn = ConnectionDB.getInstance().getConnection();
			ps = conn.prepareStatement(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(params != null && params.size() > 0){
			this.fillSql();
		}
		
		try {
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		 * 关闭连接
		 */
		ConnectionDB.closeAll(ps, rs, conn);
	}
	
}
