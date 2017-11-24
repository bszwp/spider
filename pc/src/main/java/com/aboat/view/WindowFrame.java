package com.aboat.view;

import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.aboat.view.panel.GjzPanel;
import com.aboat.view.panel.InfoPanel;
import com.aboat.view.panel.OtherPanel;
import com.aboat.view.panel.SeedPanel;


/**
 * 程序界面
 *
 * @author aboat
 * @email clear_windy@yeah.net
 * @create 2017-04-03 13:02
 */
public class WindowFrame extends JFrame{
    public static DefaultTableModel seedTableModel;//种子列表实体
    public static ArrayList<String> seedList = new ArrayList<String>();//种子列表
    public static DefaultTableModel gjzurlTableModel;//页面包含关键字
    public static ArrayList<String> gjzList = new ArrayList<String>();
    public static JTextField textStoragePath = new JTextField("D:/tupian",29);//存储路径
    public static JTextArea textContent = new JTextArea (8,130);//面板记录输出
    public static JButton actionButton;//启动按钮
    public WindowFrame(){
        setTitle("爬虫");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        ImageIcon image = new ImageIcon("/pc/src/main/java/tubiao.jpg");
        setIconImage(image.getImage());
        setJMenuBar(new ControlMenu());
        GridBagLayout gridbag = new GridBagLayout();
        setLayout(gridbag);
        add(new SeedPanel(),new GBC(0,0,1,1).setWeight(300,100).setInsets(1));
        add(new InfoPanel(),new GBC(0,2,3,1).setWeight(900,250).setInsets(1));
        add(new GjzPanel(),new GBC(2,0,1,1).setWeight(300,100).setInsets(1));
        add(new OtherPanel(),new GBC(0,1,3,1).setWeight(900,50).setInsets(1));
        WindowFrame.textContent.append("欢迎使用疾风爬虫小助手！"+"\r\n");
    	WindowFrame.textContent.selectAll();
        setVisible(true);
    }
}
