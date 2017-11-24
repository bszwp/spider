package com.aboat.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.aboat.view.WindowFrame;

/**
 * 抓取图片
 * @author bs
	2017年11月22日
	下午10:13:50
 *
 */
public class DownLoadPic {

	// 编码
	private static final String ECODING = "UTF-8";
	// 获取img标签正则
	private static final String IMGURL_REG = "<img.*src=(.*?)[^>]*?>";
	// 获取src路径的正则
	private static final String IMGSRC_REG = "http:\"?(.*?)(\"|>|\\s+)";

	private static final String TITLE = "<title>.*?</title>";

	public static void downloadPic(String url, String filePath) {
		// 获得html文本内容
		String HTML = null;
		String tit1 = null;
		try {
			HTML = DownLoadPic.getHTML(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (null != HTML && !"".equals(HTML)) {

			// 获取图片标签
			List<String> imgUrl = DownLoadPic.getImageUrl(HTML);
			// 获取图片src地址
			List<String> imgSrc = DownLoadPic.getImageSrc(imgUrl);
			// 获取图片标题

			List<String> imgTitle = DownLoadPic.getImagetitle(HTML);
			for (String tit : imgTitle) {

				tit1 = tit.substring(tit.indexOf(">") + 1, tit.lastIndexOf("<"));
				System.out.println(tit1);

			}

			System.out.println(imgSrc);
			System.out.println(imgUrl);
			// 下载图片
			if (imgSrc != null) {
				DownLoadPic.download(imgSrc, filePath);
			}
		}
	}



	/***
	 * 获取HTML内容
	 * 
	 * @param url
	 * @return
	 * @throws Exception
	 */
	private static String getHTML(String url) throws Exception {
		URL uri = new URL(url);
		URLConnection connection = uri.openConnection();
		InputStream in = connection.getInputStream();
		byte[] buf = new byte[1024];
		int length = 0;
		StringBuffer sb = new StringBuffer();
		while ((length = in.read(buf, 0, buf.length)) > 0) {
			sb.append(new String(buf, ECODING));
		}
		in.close();

		System.out.println(sb.toString());
		return sb.toString();

	}

	/***
	 * 获取ImageUrl地址
	 * 
	 * @param HTML
	 * @return
	 */
	private static List<String> getImageUrl(String HTML) {
		Matcher matcher = Pattern.compile(IMGURL_REG).matcher(HTML);
		List<String> listImgUrl = new ArrayList<String>();
		while (matcher.find()) {
			listImgUrl.add(matcher.group());
		}
		return listImgUrl;
	}

	/***
	 * 获取ImageSrc地址
	 * 
	 * @param listImageUrl
	 * @return
	 */
	private static List<String> getImageSrc(List<String> listImageUrl) {
		List<String> listImgSrc = new ArrayList<String>();
		for (String image : listImageUrl) {
			Matcher matcher = Pattern.compile(IMGSRC_REG).matcher(image);
			while (matcher.find()) {
				listImgSrc.add(matcher.group().substring(0, matcher.group().length() - 1));
			}
		}
		return listImgSrc;
	}

	/***
	 * 获取TITLE
	 * 
	 * @param HTML
	 * @return
	 */
	public static List<String> getImagetitle(String HTML) {
		Matcher matcher = Pattern.compile(TITLE).matcher(HTML);
		List<String> titleList = new ArrayList<String>();
		while (matcher.find()) {
			titleList.add(matcher.group());
		}
		return titleList;
	}

	/***
	 * 下载图片
	 * 
	 * @param listImgSrc
	 */
	private static void download(List<String> listImgSrc, String filePath) {

		for (String url : listImgSrc) {
			try {
				File file = new File(WindowFrame.textStoragePath.getText());
				if (!file.exists()) {
					file.mkdir();
				}
				String imageName = url.substring(url.lastIndexOf("/") + 1, url.length());
				imageName = WindowFrame.textStoragePath.getText()+"//" + imageName;
	
				URL uri = new URL(url);
				WindowFrame.textContent.append("保存图片:"+uri+"\r\n");
				System.out.println("------------" + uri);
				InputStream in = uri.openStream();
				FileOutputStream fo = new FileOutputStream(new File(imageName));
				byte[] buf = new byte[1024];
				int length = 0;
				while ((length = in.read(buf, 0, buf.length)) != -1) {
					fo.write(buf, 0, length);
				}
				in.close();
				fo.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
