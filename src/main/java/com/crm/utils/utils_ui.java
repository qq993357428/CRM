package com.crm.utils;

import javax.swing.*;
import java.awt.*;

public class utils_ui {
    public static void setFrameCenter(JFrame jf) {
        /*
         * 1.获取屏幕的长、宽
         * 2、获取窗体的长、宽
         * 3、（屏幕的长-窗体的长）/ 2; (屏幕的宽-窗体的宽) / 2； 作为新坐标
         *
         * */

        // 获取工具对象
        Toolkit tk = Toolkit.getDefaultToolkit();

        // 获取屏幕的宽、高
        Dimension d = tk.getScreenSize();
        double screenWidth = d.getWidth();
        double screenHeight = d.getHeight();

        // 获取窗体的宽、高
        int frameWidth = jf.getWidth();
        int frameHeight = jf.getHeight();

        int width = (int) (screenWidth - frameWidth) / 2;
        int height = (int) (screenHeight - frameHeight) / 2;

        // 设置窗体的坐标
        jf.setLocation(width, height);

    }
}
