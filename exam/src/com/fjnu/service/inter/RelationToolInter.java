package com.fjnu.service.inter;

import java.util.List;
import java.util.Map;

/**
 * 知识点关联分析接口
 * @author vengeance
 *
 */
public interface RelationToolInter {
	/**
	 * 从数据源获得数据并加载到列表中
	 * @param targetList
	 */
	public void getRecord(List<List<String>> targetList);
	
	/**
	 * 分析知识点关联
	 * @param targetList
	 */
	public void relationTool(List<List<String>> targetList);
	
	/**
	 * 从指定的数据源获取第一级项集Candidate
	 * @return 一级项集
	 */
	public List<List<String>> findFirstCandidate();
	
	/**
	 * 计算获得项集C中满足最小置信度的频繁项集L
	 * @param cItemset
	 * @return 项集L
	 */
	public List<List<String>> getSupportItemset(List<List<String>> cItemset);
	
	/**
	 * 计算某知识点出现的次数
	 * @param list
	 * @return 出现次数
	 */
	public int countFrequent(List<String> list);
	
	/**
	 * 求出满足最低置信度的项集
	 * @param ikItemset
	 * @param lItemset
	 * @param dkCountMap2
	 * @param dCountMap2
	 * @return 如果满足，在confItemset中添加满足条件项集
	 * 			否则返回null
	 */
	public List<List<String>> getConfidencedItemset(List<List<String>> ikItemset, List<List<String>> lItemset,
			Map<Integer, Integer> dkCountMap2, Map<Integer, Integer> dCountMap2);
	
	/**
	 * 检查项集list是否满足最小置信度；
	 * 如果满足，在全局变量confItemset中添加list
	 * 否则返回null
	 * @param list
	 * @param lItemset
	 * @param count
	 * @param dCountMap2
	 * @return 频繁项集L
	 */
	public List<String> getConfItem(List<String> list, List<List<String>> lItemset,
			Integer count, Map<Integer, Integer> dCountMap2);
	
	/**
	 * 查找tempList中的内容在lItemset中的位置
	 * @param tempList
	 * @param iItemset
	 * @return 存在该内容，返回下标
	 * 		   否则，返回-1
	 */
	public int findConf(List<String> tempList, List<List<String>> iItemset);
	
	/**
	 * 判断list项集中是否含有某string
	 * @param string
	 * @param list
	 * @return 存在，返回true
	 * 		   否则，返回false
	 */
	public boolean haveThisItem(String string, List<String> list);
	
	/**
	 * 根据cItemset求出下一级的备选项集C，得到的C项集中的每个集合元素个数都比cItemset中的集合元素大1
	 * 也就是连接操作，从Lk-1频繁项集中得到Ck项集
	 * @param cItemset
	 * @return 项集C
	 */
	public List<List<String>> getNextCandidate(List<List<String>> cItemset);
	
	/**
	 * 检测tempList是否是cItemset的子集
	 * @param tempList
	 * @param cItemset
	 * @return true : 是它的子集
	 * 		   false : 不是它的子集
	 */
	public boolean isSubsetInC(List<String> tempList, List<List<String>> cItemset);
	
	/**
	 * 检测nextItemset中是否包含集合copyValueHelpList
	 * @param copyValueHelpList
	 * @param nextItemset
	 * @return true : 包含
	 * 		   false : 不包含
	 */
	public boolean isHave(List<String> copyValueHelpList, List<List<String>> nextItemset);
	
	/**
	 * 将得到的关系列表保存到待获取的列表中
	 * @param confItemset2
	 */
	public void getRelationList(List<List<String>> confItemset2);
	
	/**
	 * @return 返回关系列表
	 */
	public List<List<String>> getList();
}
