package com.fjnu.test.service;

import java.util.List;

public class studentPage {
	public List<Double> score;
	public List<String> date;
	
	public void onlyBranchGradeStatistics(List<Double> highScore, List<Double> lowScore, List<Double> avgScore){
//		File file = new ("")
//		(List<Double> highScore, List<Double> lowScore;)
		
		int length = highScore.size();
		double[] highest = new double[length];
		double[] lowest = new double[length];
		double[] avg = new double[length];
		
		for(int i=0; i<length; i++){
			highest[i] = highScore.get(i);
			lowest[i] = lowScore.get(i);
			avg[i] = avgScore.get(i);
			
		}
	}
}
