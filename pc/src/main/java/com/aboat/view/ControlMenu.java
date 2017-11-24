package com.aboat.view;

import com.aboat.action.*;

import javax.swing.*;

/**
 * 控制菜单
 * @author bs
	2017年11月22日
	下午10:43:30
 *
 */
public class ControlMenu extends JMenuBar{
    public ControlMenu() {
        JButton startButton = new JButton("启动");
        JButton pauseButton = new JButton("暂停");
        JButton quitButton = new JButton("退出");     
        startButton.addActionListener(new StartListener(startButton));
        pauseButton.addActionListener(new PauseListener());
        quitButton.addActionListener(new QuitListener());
        this.add(startButton);
        this.add(pauseButton);
        this.add(quitButton);
      
        
    }
}
