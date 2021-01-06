package com.crm.view;

import javax.swing.*;
import java.awt.*;

public class About extends JInternalFrame {
    public About() {
        getContentPane().setBackground(Color.RED);
        setClosable(true);
        setTitle("关于系统");
        setBounds(100, 100, 600, 300);

        JLabel lblNewLabel = new JLabel("");
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(98)
                                .addComponent(lblNewLabel)
                                .addContainerGap(126, Short.MAX_VALUE))
        );

        groupLayout.setVerticalGroup(
                groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(groupLayout.createSequentialGroup()
                                .addGap(48)
                                .addComponent(lblNewLabel)
                                .addContainerGap(149, Short.MAX_VALUE))
        );
        getContentPane().setLayout(groupLayout);
    }
}
