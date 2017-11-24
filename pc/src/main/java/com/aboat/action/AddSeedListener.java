package com.aboat.action;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 添加目的页面url(种子)
 * @author bs
	2017年11月22日
	下午10:08:20
 *
 */
public class AddSeedListener implements ActionListener {
    DefaultTableModel tableModel;
    JTextField field;
    public AddSeedListener(DefaultTableModel tableModel,JTextField field) {
        this.tableModel = tableModel;
        this.field = field;
    }



   
    public void actionPerformed(ActionEvent e) {
        String str = field.getText();
        if(str != null) {
            str = str.replace(" ", "");
            if(str.trim().length()>0){
                str = str.trim();
                String[] tableVales = {str};
                tableModel.addRow(tableVales);
                field.setText("");
            }
        }
    }
}
