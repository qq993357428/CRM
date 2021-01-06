package com.crm.view;

import java.awt.Toolkit;

import javax.swing.*;

public class MyContactInterFrm extends JInternalFrame{
	private JPanel contentPane;
	private JFrame jf;
	
	public MyContactInterFrm() {
		contentPane=new JPanel();
		jf=new JFrame();
		jf.setTitle("联系方式");
		jf.setIconImage(Toolkit.getDefaultToolkit().getImage(UserFrm.class.getResource("/com/crm/images/user1.png")));
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setBounds(300, 300, 400, 500);

		JLabel label1 = new JLabel();
		label1.setText("QQ：3079118617");
		label1.setIcon(new ImageIcon("D:/Java swing实现学生信息管理系统源码/CRM客户管理系统/target/classes/com/crm/images/笑脸.png"));
		label1.setHorizontalAlignment(SwingUtilities.CENTER);
		label1.setVerticalAlignment(SwingUtilities.CENTER);
		contentPane.add(label1);
		jf.setContentPane(contentPane);
		jf.pack();
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		new MyContactInterFrm();
	}

}
