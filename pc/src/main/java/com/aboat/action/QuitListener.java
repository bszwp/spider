package com.aboat.action;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * 退出监听按钮
 * @author bs
	2017年11月22日
	下午10:12:50
 *
 */
public class QuitListener implements ActionListener {
    
    public void actionPerformed(ActionEvent e) {
        if(JOptionPane.showConfirmDialog(null,"退出","提示",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {


            System.exit(0);
        }
    }
}
