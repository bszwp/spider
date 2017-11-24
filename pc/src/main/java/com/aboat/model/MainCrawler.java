package com.aboat.model;

import java.util.Set;

import com.aboat.view.WindowFrame;
/**
 * 爬虫主方法
 * @author bs
	2017年11月22日
	下午10:18:25
 *
 */
public class MainCrawler {

	public static void crawling() {
		 boolean PROCESS =true;
		 String eUrl = null;
	     final String sUrl = WindowFrame.seedList.get(0).toString();
	     System.out.println(sUrl);
		for(String str1 : WindowFrame.gjzList){
            eUrl = str1;
        }
		
		
 
		LinkFilter filter = new LinkFilter() {

			
			public boolean accept(String url) {
				if (url.startsWith(sUrl)) {
					return true;
				}
				return false;
			}
		};
		LinkQueue.addVisitedUrl(sUrl);
		Set<String> links = HtmlParserTool.extracLinks(sUrl, filter);
		for (String link : links) {
			System.out.println();
			if (link.startsWith(sUrl) && link.contains(eUrl)) {
				LinkQueue.addVisitedUrl(link);
				DownLoadPic downLoadpic = new DownLoadPic();
				downLoadpic.downloadPic(link, WindowFrame.textStoragePath.getText());

			}
		}
		System.out.println("-----图片下载完成------");
		end();
		
	}
	public static void end(){
		 WindowFrame.textContent.append("爬取结束"+"\r\n");
		 WindowFrame.textContent.selectAll();
	}

	
}