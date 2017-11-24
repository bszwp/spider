package com.aboat.model;
/**
 * 过滤link
 * @author bs
	2017年11月22日
	下午10:15:29
 *
 */
public interface LinkFilter {
	public boolean accept(String url);
}