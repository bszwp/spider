package com.aboat.view.panel;

import com.aboat.view.GBC;
import com.aboat.view.WindowFrame;

import javax.swing.*;
import java.awt.*;

/**
 * 信息展示面板
 * @author bs
	2017年11月22日
	下午10:45:03
 *
 */
public class InfoPanel extends JPanel {
    public InfoPanel(){
        setPreferredSize(new Dimension(975,220));
        this.setBorder(BorderFactory.createLineBorder(Color.gray,1));
        GridBagLayout gridbag = new GridBagLayout();
        setLayout(gridbag);

        JLabel content = new JLabel("爬取信息输出");

        WindowFrame.textContent.setEditable(false);
        WindowFrame.textContent.setLineWrap(true);

        this.add(content,new GBC(0,0,1,1).setWeight(900,10));
        this.add(new JScrollPane(WindowFrame.textContent),new GBC(0,1,1,1).setWeight(900,200));
    }
}
