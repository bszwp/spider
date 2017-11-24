package com.aboat.model;

import java.util.HashSet;
import java.util.Set;
/**
 * 链接的队列
 * @author bs
	2017年11月22日
	下午10:15:56
 *
 */
/**
 * 记录哪些URL访问过
 * 哪些待访问
 * */
public class LinkQueue {
    //已被访问的url集合
    private static Set visitedUrl=new HashSet();
    //待访问的url集合
    private static Queue unVisitedUrl=new Queue();
     
    //获得URL队列
    public static Queue getUnVisitedUrl(){
        return unVisitedUrl;
    }
    //添加到访问过的URL队列中
    public static void addVisitedUrl(String url){
        visitedUrl.add(url);
    }
    //移除访问过的url
    public static void removeVisitedUrl(String url){
        visitedUrl.remove(url);
    }
    //未被访问过的url出队列
    public static Object unVisitedUrlDeQueue(){
        return unVisitedUrl.deQueue();
    }
    /**
     * 保证每个URL只被访问一次
     * */
    public static void addUnvisitedUrl(String url) {
        if(url!=null&& !url.trim().equals("")
                && !visitedUrl.contains(url)
                && !unVisitedUrl.contains(url)){
            unVisitedUrl.enQueue(url);
        }
    }
    //获得已经访问过的url数量
    public static int getVisitedUrlNum(){
        return visitedUrl.size();
    }
    //判断未访问的url队列是否为空
    public static boolean unVisitedUrlIsEmpty(){
        return unVisitedUrl.enpty();
    }
}