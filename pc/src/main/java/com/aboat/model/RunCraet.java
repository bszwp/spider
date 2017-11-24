package com.aboat.model;

import javax.swing.JTextField;

import com.aboat.view.WindowFrame;

/**
 * 线程运性
 * @author bs
	2017年11月22日
	下午10:42:56
 *
 */
public class RunCraet extends Thread implements Runnable{

    public void run() {

    	MainCrawler crawler = new MainCrawler();
    	WindowFrame.textContent.append("开始爬取..."+"\r\n");
    	WindowFrame.textContent.selectAll();
		crawler.crawling();
	
        
    }
    
   
}

    
    
    


