package edu.fjnu.util;

import java.math.BigDecimal;

/**
 * 格式化double的小数位数
 * 
 * @author vengeance
 *
 */
public class DoubleFormat {
	private static final int FORMAT_LEN = 2;// 保留的小数位数
	private static final int FORMAT_MODE = BigDecimal.ROUND_HALF_UP;// 取值方式(这里选择四舍五入)
	private BigDecimal bd;

	/**
	 * 格式化double值
	 * 
	 * @param doubleInput
	 * @return 格式化后的double
	 */
	public double getDoubleFormat(double doubleInput) {
		bd = new BigDecimal(doubleInput);
		double result = bd.setScale(FORMAT_LEN, FORMAT_MODE).doubleValue();
		bd = null;
		return result;
	}

	/**
	 * 两个BigDecimal之间相除
	 * 
	 * @param doubleInputS
	 * @param doubleInputT
	 * @return 结果
	 */
	public double getDivideFormat(double doubleInputS, double doubleInputT) {
		bd = new BigDecimal(doubleInputS);
		BigDecimal bdT = new BigDecimal(doubleInputT);
		double result = bd.divide(bdT, FORMAT_LEN, FORMAT_MODE).doubleValue();
		bd = null;
		bdT = null;
		return result;
	}
}
