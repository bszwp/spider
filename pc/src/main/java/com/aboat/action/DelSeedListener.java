package com.aboat.action;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 删除种子url
 * @author bs
	2017年11月22日
	下午10:09:43
 *
 */
public class DelSeedListener implements ActionListener {
    DefaultTableModel tableModel;
    JTable table;
    public DelSeedListener(DefaultTableModel tableModel,JTable table) {
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
