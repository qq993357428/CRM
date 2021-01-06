package com.crm.view;

import com.crm.utils.UserDaoImp;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Login extends JFrame implements ActionListener, MouseListener, FocusListener {
    /**
     *
     */

    JTextField jtf;
    JPasswordField jpwd;
    JButton button1;
    private JCheckBox adminCheckBox;
    private JCheckBox employeeCheckBox;

    public Login() {
        super("客户管理系统");
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        addkongjian();
        setVisible(true);
        setResizable(false);
        button1.grabFocus();
    }

    public void addkongjian() {
        jtf = new JTextField(16);
        jtf.setBounds(50, 71, 200, 40);
        jtf.setText("请输入账号");
        jtf.addFocusListener(this);
        jtf.addMouseListener(this);
        jpwd = new JPasswordField(16);
        jpwd.setBounds(50, 125, 200, 40);
        jpwd.setText("请输入密码");
        jpwd.setEchoChar((char) 0);
        jpwd.addFocusListener(this);
        jpwd.addMouseListener(this);
        button1 = new JButton("登录");
        button1.setBounds(50, 230, 200, 40);
        button1.addActionListener(this);
        JLabel jlbt = new JLabel("客户管理系统");
        jlbt.setBounds(55, 10, 200, 48);
        jlbt.setFont(new Font("黑体", Font.BOLD, 30));
        getContentPane().setLayout(null);
        getContentPane().add(jtf);
        getContentPane().add(jpwd);
        getContentPane().add(button1);
        getContentPane().add(jlbt);
        adminCheckBox = new JCheckBox("管理员登录");
        adminCheckBox.setBounds(50, 175, 103, 23);
        getContentPane().add(adminCheckBox);
        employeeCheckBox = new JCheckBox("职员登录");
        employeeCheckBox.setBounds(50, 200, 103, 23);
        getContentPane().add(employeeCheckBox);
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        new Login();
    }

        public void actionPerformed (ActionEvent e){
            String name = jtf.getText();
            String password = new String(jpwd.getPassword());
            String admin = "0", user = "1", client = "2";
            if (e.getSource() == button1) {
                if (name.equals("") || (name.equals("请输入账号"))) {
                    JOptionPane.showMessageDialog(this, "请输入账号", "错误", JOptionPane.ERROR_MESSAGE);
                } else if (password.equals("")) {
                    JOptionPane.showMessageDialog(this, "请输入密码", "错误", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (adminCheckBox.isSelected()) {
                        try {
                            int i = new UserDaoImp().CheckUser(name, password, admin);
                            if (i < 0) {
                                JOptionPane.showMessageDialog(this, "未找到此管理员", "错误", JOptionPane.ERROR_MESSAGE);
                            } else if (i > 0) {
                                JOptionPane.showMessageDialog(this, "密码错误", "错误", JOptionPane.ERROR_MESSAGE);
                            } else {
                                AdminFrm a = new AdminFrm();
                                a.setVisible(true);
                                this.dispose();
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    } else if (employeeCheckBox.isSelected()) {
                        try {
                            int i = new UserDaoImp().CheckUser(name, password, client);
                            if (i < 0) {
                                JOptionPane.showMessageDialog(this, "未找到职员账号", "错误", JOptionPane.ERROR_MESSAGE);
                            } else if (i > 0) {
                                JOptionPane.showMessageDialog(this, "密码错误", "错误", JOptionPane.ERROR_MESSAGE);
                            } else {
                                //             new Admin(new UserDao().selectUser(admin, name));
                                this.dispose();
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    } else {
                        try {
                            int i = new UserDaoImp().CheckUser(name, password, user);
                            if (i < 0) {
                                JOptionPane.showMessageDialog(this, "未找到此账号", "错误", JOptionPane.ERROR_MESSAGE);
                            } else if (i > 0) {
                                JOptionPane.showMessageDialog(this, "密码错误", "错误", JOptionPane.ERROR_MESSAGE);
                            } else {
                                //             new Mainf(new UserDao().selectuser(user, name));
                                this.dispose();
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
            }
        }

        public void mouseClicked (MouseEvent e){
        }

        public void mouseEntered (MouseEvent e){
        }

        public void mouseExited (MouseEvent e){
        }

        public void mousePressed (MouseEvent arg0){
            // TODO Auto-generated method stub

        }

        public void mouseReleased (MouseEvent arg0){
            // TODO Auto-generated method stub

        }

        public void focusGained (FocusEvent e){
            if (e.getSource() == jtf && jtf.getText().equals("请输入账号")) {
                jtf.setText("");
            }
            if (e.getSource() == jpwd && new String(jpwd.getPassword()).equals("请输入密码")) {
                jpwd.setText("");
                jpwd.setEchoChar('*');
            }
        }

        public void focusLost (FocusEvent e){
            if (e.getSource() == jtf) {
                if (jtf.getText().equals("") && !jtf.getText().equals("请输入账号")) {
                    jtf.setText("请输入账号");
                }
            }
            if (e.getSource() == jpwd) {
                if (new String(jpwd.getPassword()).equals("") && !new String(jpwd.getPassword()).equals("请输入密码")) {
                    jpwd.setEchoChar((char) 0);
                    jpwd.setText("请输入密码");
                }

            }
        }
    }
