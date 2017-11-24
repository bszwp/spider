package com.aboat.view.panel;

import com.aboat.view.WindowFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * 其他面板
 * @author bs
	2017年11月22日
	下午10:45:22
 *
 */
public class OtherPanel extends JPanel {
    public OtherPanel(){
        JLabel storagePath = new JLabel("存储路径:");
        JButton pathButton = new JButton("设置");
        pathButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                fileChooser.setDialogTitle("设置爬取图片存储路径");
                int result = fileChooser.showOpenDialog(new JPanel());
                if(result == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    String filePath  = file.getAbsolutePath();
                    WindowFrame.textStoragePath.setText(filePath);
                }
            }
        });
        this.add(storagePath);
        this.add(pathButton);
        this.add(WindowFrame.textStoragePath);
    
    }
}
