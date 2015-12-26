package edu.fjnu.util;

import java.io.File;

/**
 * 文件操作工具
 * @author Li
 *
 */
public class FileTools 
{
	/**
	 *  检测文件夹是否存在。不存在则创建
	 * @param path
	 */
	public void createFolder( String path)
	{
		try 
		{
			if (!(new File(path).isDirectory()))
			{
			    new File(path).mkdir();
			 }
		}
		catch (SecurityException e) 
		{
		   e.printStackTrace();
		}
	}
	
//	public static void main(String[] args)
//	{
//		FileTools t = new FileTools();
//		t.createFolder("d:/我在测试");
//	}
}
