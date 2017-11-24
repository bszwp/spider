package com.aboat.action;

import com.aboat.model.RunCraet;
import com.aboat.view.WindowFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * 开始监听按钮
 * @author bs
	2017年11月22日
	下午10:13:24
 *
 */
public class StartListener  implements ActionListener{


    public StartListener(JButton actionButton) {
        WindowFrame.actionButton = actionButton;
    }
    public StartListener() {}

    
    public void actionPerformed(ActionEvent e) {
        boolean mark = true;
        WindowFrame.actionButton.setEnabled(false);
        WindowFrame.seedList.clear();//清空列表
        WindowFrame.gjzList.clear();

        /*种子*/
        Vector seedVector = WindowFrame.seedTableModel.getDataVector();
        if(mark && seedVector.size()>0){
            for(int i=0;i<seedVector.size();i++){
                String str = seedVector.get(i).toString();
                str = str.substring(1,str.length()-1);
                WindowFrame.seedList.add(str);
            }
        }else{
            mark = false;
            JOptionPane.showMessageDialog(null, "请新增种子，至少要有一条种子才能爬取！","警告", JOptionPane.INFORMATION_MESSAGE);
        }
        
        Vector gjzVector = WindowFrame.gjzurlTableModel.getDataVector();
        if(mark && gjzVector.size()>0){
            for(int i=0;i<gjzVector.size();i++){
                String str = gjzVector.get(i).toString();
                str = str.substring(1,str.length()-1);
                WindowFrame.gjzList.add(str);
            }
        }


        

        /*存储路径*/
        if(mark && WindowFrame.textStoragePath == null){
            mark = false;
            JOptionPane.showMessageDialog(null,"请选择存储路径！", "警告", JOptionPane.INFORMATION_MESSAGE);
        }
        if(mark){
        	new RunCraet().start();
        }

       
    }
}
