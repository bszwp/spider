package com.aboat.action;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 删除页面关键字
 * @author bs
	2017年11月22日
	下午10:09:05
 *
 */
public class DelgjzListener implements ActionListener {
    DefaultTableModel tableModel;
    JTable table;
    public DelgjzListener(DefaultTableModel tableModel, JTable table) {
        this.tableModel = tableModel;
        this.table = table;
    }

   
    public void actionPerformed(ActionEvent e) {
        int row = table.getSelectedRow();
        if(row>-1){
            tableModel.removeRow(row);
        }
    }
}
