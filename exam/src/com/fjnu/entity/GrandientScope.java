package com.fjnu.entity;

/**
 * 梯度范围关联表t_grandient_scope
 * @author vengeance
 *
 */
public class GrandientScope extends IdEntity{
	private int grandientGrandientId;	//梯度ID
//	private Long scopesPkScopeId;	//范围ID scopesPkScopeId = id

	public int getGrandientGrandientId() {
		return grandientGrandientId;
	}

	public void setGrandientGrandientId(int grandientGrandientId) {
		this.grandientGrandientId = grandientGrandientId;
	}
	
	
}
