package com.aboat.view.panel;

import com.aboat.action.AddgjzListener;
import com.aboat.action.DelgjzListener;
import com.aboat.view.WindowFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * 页面包含关键字模板
 * @author bs
	2017年11月22日
	下午10:44:39
 *
 */
public class GjzPanel extends JPanel {
    public GjzPanel(){
        setPreferredSize(new Dimension(320,220));
        setLayout(new FlowLayout(FlowLayout.LEFT));

        this.setBorder(BorderFactory.createLineBorder(Color.gray,0));
        JLabel gjzLabel = new JLabel("输入网页包含关键字母(html/net/php等):");
        JTextField gjzField = new JTextField("",27);
        JButton addgjzButton = new JButton("+");
        JButton delgjzButton = new JButton("-");
        this.add(gjzLabel);
        this.add(gjzField);
        this.add(addgjzButton);
        this.add(delgjzButton);
        String[] columnNames = {"关键字列表"};   //列名
        String[][] tableVales={}; //数据
        WindowFrame.gjzurlTableModel = new DefaultTableModel(tableVales,columnNames);
        JTable table = new JTable(WindowFrame.gjzurlTableModel);
        addgjzButton.addActionListener(new AddgjzListener(WindowFrame.gjzurlTableModel,gjzField));
        delgjzButton.addActionListener(new DelgjzListener(WindowFrame.gjzurlTableModel,table));
        table.setPreferredScrollableViewportSize(new Dimension(285, 120));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollpane = new JScrollPane(table);
        this.add(scrollpane);
    }
}
