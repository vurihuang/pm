package edu.fjnu.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 生成CSV文件的工具
 * @author Li
 *
 */
public class CSVUtil 
{
	/**
     * 导出cvs文件
     * 
     * @param file csv文件(路径+文件名)，csv文件不存在会自动创建
     * @param dataList 数据
     * @return
     */
    public static boolean exportCsv(File file, List<String> dataList)
    {
        boolean isSucess=false;
        
        FileOutputStream out=null;
        OutputStreamWriter osw=null;
        BufferedWriter bw=null;
        try {
            out = new FileOutputStream(file);
            osw = new OutputStreamWriter(out);
            bw =new BufferedWriter(osw);
            if(dataList!=null && !dataList.isEmpty()){
                for(String data : dataList){
                    bw.append(data).append("\r");
                }
            }
            isSucess=true;
        } catch (Exception e) {
            isSucess=false;
        }finally{
            if(bw!=null){
                try {
                    bw.close();
                    bw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
            if(osw!=null){
                try {
                    osw.close();
                    osw=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
            if(out!=null){
                try {
                    out.close();
                    out=null;
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
        }
        
        return isSucess;
    }
    
    /**
     * 导入
     * 
     * @param filename csv文件(路径+文件)
     * @return
     * @throws FileNotFoundException 
     */
    public static List<String[]> importCsv(String filename) throws FileNotFoundException
    {
    	File file = new File(filename);
    	DataInputStream in = new DataInputStream(new FileInputStream(file));
    	List<String[]> lineList = new ArrayList<String[]>();
    	BufferedReader br = null;
        try { 
        	br= new BufferedReader(new InputStreamReader(in,"GBK"));
            String line = "";
            String csvSplitBy = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
            while ((line = br.readLine()) != null) { 
//            	String [] major = line.split(csvSplitBy);  
                lineList.add(line.split(csvSplitBy));
//            	System.out.println("major"+major[5]);   
                
            }
        }catch (Exception e) {
        }finally{
            if(br!=null){
                try {
                    br.close();
                    br=null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
 
        return lineList;
    }
    
    
    public static void main( String[] args) throws FileNotFoundException
    {
		List<String[]> list = CSVUtil.importCsv("D:/R/temp/Relation/rules.csv");
		for( int i=0; i<list.size(); i++)
		{
			for( int j=0; j<list.get(i).length; j++)
			{
				System.out.println(list.get(i)[j]);
			}
			System.out.println();
		}
    }
}
