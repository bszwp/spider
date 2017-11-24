package com.aboat.view.panel;

import com.aboat.action.AddSeedListener;
import com.aboat.action.DelSeedListener;
import com.aboat.view.WindowFrame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

/**
 * 种子输入面板
 * @author bs
	2017年11月22日
	下午10:45:40
 *
 */
public class SeedPanel extends JPanel{
    public SeedPanel(){
        setPreferredSize(new Dimension(320,220));
        setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBorder(BorderFactory.createLineBorder(Color.gray,0));
        JLabel seedLabel = new JLabel("种子:");
        JTextField seedField = new JTextField("",31);
        JButton addSeedButton = new JButton("+");
        JButton delSeedButton = new JButton("-");

        this.add(seedLabel);
        this.add(seedField);
        this.add(addSeedButton);
        this.add(delSeedButton);

        String[] columnNames = {"种子列表"};   //列名
        String[][] tableVales={}; //数据
        WindowFrame.seedTableModel = new DefaultTableModel(tableVales,columnNames);
        JTable table = new JTable(WindowFrame.seedTableModel );
        addSeedButton.addActionListener(new AddSeedListener(WindowFrame.seedTableModel,seedField));
        delSeedButton.addActionListener(new DelSeedListener(WindowFrame.seedTableModel,table));
        table.setPreferredScrollableViewportSize(new Dimension(285, 120));
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollpane = new JScrollPane(table);
        this.add(scrollpane);

    }
}
