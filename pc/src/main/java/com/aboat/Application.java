package com.aboat;

import java.awt.Font;
import java.awt.Frame;

import javax.swing.UIManager;
import javax.swing.plaf.InsetsUIResource;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import com.aboat.view.WindowFrame;



/**
 * 主程序方法
 * @author bs
	2017年11月22日
	下午10:02:05
 *
 */
 
public class Application {
    public static Frame sFrame;
    public static void main(String[] arge){
        try
        {  //构建一个beautyeye,并设置一些属性
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
   

            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.osLookAndFeelDecorated;
            BeautyEyeLNFHelper.launchBeautyEyeLNF();
            UIManager.put("RootPane.setupButtonVisible", false);
            UIManager.put("TabbedPane.tabAreaInsets", new InsetsUIResource(0,0,0,0));
            UIManager.put("TabbedPane.contentBorderInsets", new InsetsUIResource(0,0,2,0));
            UIManager.put("TabbedPane.tabInsets", new InsetsUIResource(3,10,9,10));
            Font frameTitleFont = (Font)UIManager.get("InternalFrame.titleFont");
            frameTitleFont = frameTitleFont.deriveFont(Font.PLAIN);
            UIManager.put("InternalFrame.titleFont", frameTitleFont);
        }
        catch(Exception e)
        {
            //TODO exception
        }
        //新建一个windowFeame
        sFrame = new WindowFrame();
    }
}
