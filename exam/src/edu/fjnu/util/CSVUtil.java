package edu.fjnu.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
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
    public boolean exportCsv(File file, List<String> dataList)
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
    
    public static void main( String[] args)
    {
		List<String> test = new ArrayList<String>();
		
		test.add("a");
		test.add("es");
		test.add("ed");
		test.add("ef");
		test.add("eg");
		test.add("eh");
		
		String str = test.toString();
		
		str = str.replace("[", "");
		str = str.replaceAll("]", "");
		
		
		
		String t = "dddd        dddd          44444    555";
		t = t.replaceAll("\\s{1,}", " ");
		
		System.out.println(t);
    }
}
