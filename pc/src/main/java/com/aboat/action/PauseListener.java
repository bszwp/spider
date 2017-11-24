package com.aboat.action;

import com.aboat.view.WindowFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 暂停
 * @author bs
	2017年11月22日
	下午10:10:14
 *
 */
public class PauseListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        
        WindowFrame.actionButton.setEnabled(true);
    }
}
