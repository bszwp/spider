package com.aboat.model;

import java.util.HashSet;
import java.util.Set;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
/**
 * htmlpareser工具类
 * @author bs
	2017年11月22日
	下午10:14:47
 *
 */
public class HtmlParserTool {

	@SuppressWarnings("serial")
	public static Set<String> extracLinks(String url, LinkFilter filter) {
		Set<String> links = new HashSet<String>();
		try {
			Parser parser = new Parser(url);
			parser.setEncoding("UTF-8");

			NodeFilter frameFilter = new NodeFilter() {
				@Override
				public boolean accept(Node node) {
					if (node.getText().startsWith("frame src=")) {
						return true;
					}
					return false;
				}
			};

			OrFilter linkFilter = new OrFilter(new NodeClassFilter(LinkTag.class), frameFilter);
			NodeList list = parser.extractAllNodesThatMatch(linkFilter);
			for (int i = 0; i < list.size(); i++) {
				Node tag = list.elementAt(i);
				if (tag instanceof LinkTag) {
					LinkTag link = (LinkTag) tag;
					String linkUrl = link.getLink();
					if (filter.accept(url)) {
						links.add(linkUrl);
					} else {
						String frame = tag.getText();
						int start = frame.indexOf("src=");
						if (start != -1) {
							frame = frame.substring(start);
						}
						int end = frame.indexOf(" ");
						String frameUrl = "";
						if (end == -1) {
							end = frame.indexOf(">");
							if (end - 1 > 5) {
								frameUrl = frame.substring(5, end - 1);
							}
						}

						if (filter.accept(frameUrl)) {
							links.add(frameUrl);
						}

					}
				}
			}

		} catch (ParserException e) {
			e.printStackTrace();
		}
		return links;
	}
}