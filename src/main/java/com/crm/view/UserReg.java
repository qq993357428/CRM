package com.crm.view;

import com.crm.model.User_Model;
import com.crm.utils.UserDaoImp;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UserReg extends JFrame implements ActionListener {
    JTextField jtfid, jtfname, jtfcredit, jtfphone, jtfeid, jtfaddress;
    JPasswordField jpwd, rejpwd;
    JButton jButton1, jButton2;
    JLabel label, label_1, label_2, label_3, label_4, label_5, label_6, label_7, lb_id, lb_pwd, lb_repwd, lb_name;

    public UserReg() {
        super("添加用户");
        setSize(300, 500);
        setDefaultCloseOperation(2);
        addusertype();
        setVisible(true);
        setResizable(false);
        jButton1.grabFocus();
    }


    private void addusertype() {
        jtfid = new JTextField();
        jtfid.setLocation(90, 12);
        jtfid.setSize(177, 25);
        jpwd = new JPasswordField();
        jpwd.setLocation(90, 62);
        jpwd.setSize(177, 25);
        rejpwd = new JPasswordField();
        rejpwd.setLocation(90, 112);
        rejpwd.setSize(177, 25);
        jtfname = new JTextField();
        jtfname.setLocation(90, 162);
        jtfname.setSize(177, 25);
        jtfcredit = new JTextField();
        jtfcredit.setLocation(90, 212);
        jtfcredit.setSize(177, 25);
        jtfphone = new JTextField();
        jtfphone.setLocation(90, 262);
        jtfphone.setSize(177, 25);
        jtfeid = new JTextField();
        jtfeid.setLocation(90, 312);
        jtfeid.setSize(177, 25);
        jtfaddress = new JTextField();
        jtfaddress.setLocation(90, 362);
        jtfaddress.setSize(177, 25);
        jButton1 = new JButton("添加");
        jButton1.setBounds(65, 412, 74, 32);
        jButton2 = new JButton("重置");
        jButton2.setBounds(149, 412, 74, 32);
        getContentPane().setLayout(null);
        getContentPane().add(jtfid);
        getContentPane().add(jpwd);
        getContentPane().add(rejpwd);
        getContentPane().add(jtfname);
        getContentPane().add(jtfphone);
        getContentPane().add(jtfcredit);
        getContentPane().add(jtfeid);
        getContentPane().add(jtfaddress);
        getContentPane().add(jtfcredit);
        getContentPane().add(jButton1);
        getContentPane().add(jButton2);

        label = new JLabel("用户名:");
        label.setBounds(15, 12, 60, 23);
        getContentPane().add(label);

        label_1 = new JLabel("用户密码:");
        label_1.setBounds(15, 62, 70, 23);
        getContentPane().add(label_1);

        label_2 = new JLabel("确认密码:");
        label_2.setBounds(15, 112, 70, 23);
        getContentPane().add(label_2);

        label_3 = new JLabel("真实姓名:");
        label_3.setBounds(15, 162, 70, 23);
        getContentPane().add(label_3);

        label_4 = new JLabel("信用度：");
        label_4.setBounds(15, 212, 70, 23);
        getContentPane().add(label_4);

        label_5 = new JLabel("联系电话：");
        label_5.setBounds(15, 262, 70, 23);
        getContentPane().add(label_5);

        label_6 = new JLabel("员工编号：");
        label_6.setBounds(15, 312, 70, 23);
        getContentPane().add(label_6);

        label_7 = new JLabel("联系地址：");
        label_7.setBounds(15, 362, 70, 23);
        getContentPane().add(label_7);

        lb_id = new JLabel("");
        lb_id.setBounds(76, 38, 130, 23);
        getContentPane().add(lb_id);

        lb_pwd = new JLabel("");
        lb_pwd.setBounds(76, 88, 130, 23);
        getContentPane().add(lb_pwd);

        lb_repwd = new JLabel("");
        lb_repwd.setBounds(76, 138, 130, 23);
        getContentPane().add(lb_repwd);

        lb_name = new JLabel("");
        lb_name.setBounds(76, 188, 130, 23);
        getContentPane().add(lb_name);

        lb_id.setForeground(Color.RED);
        lb_pwd.setForeground(Color.RED);
        lb_repwd.setForeground(Color.RED);
        lb_name.setForeground(Color.RED);


        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
    }

    public static void main(String[] args) {
        new UserReg();
    }

    public void actionPerformed(ActionEvent e) {
        String uid = jtfid.getText();
        String username = jtfname.getText();
        String password = new String(jpwd.getPassword());
        String repassword = new String(rejpwd.getPassword());
        String userphone = jtfphone.getText();
        String address = jtfaddress.getText();
        String credit = jtfcredit.getText();
        String eid = jtfeid.getText();

        User_Model user = new User_Model();
        user.setUid(uid);
        user.setUname(username);
        user.setPwd(password);
        user.setPhone(userphone);
        user.setAddress(address);
        user.setCredit(credit);
        user.setEid(eid);


        if (e.getSource() == jButton1) {
            if (!uid.equals("")) {
                try {
                    if (new UserDaoImp().CheckUser(uid, repassword, "1") == -1) {
                        if (!password.equals("")) {
                            if (password.equals(repassword)) {
                                if (!username.equals("")) {
                                    if (new UserDaoImp().addUser(user)) {
                                        JOptionPane.showMessageDialog(this, "添加成功", "注册", JOptionPane.INFORMATION_MESSAGE);
                                    } else {
                                        JOptionPane.showMessageDialog(this, "添加成功", "注册", JOptionPane.INFORMATION_MESSAGE);
                                    }

                                } else {
                                    lb_name.setText("姓名不能为空");
                                    return;
                                }
                            } else {
                                lb_repwd.setText("密码不一致");
                                return;
                            }
                        } else {
                            lb_pwd.setText("密码不能为空");
                            return;
                        }
                    } else {
                        lb_id.setText("此账号已存在");
                        return;
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            } else {
                lb_id.setText("账号不能为空");
                return;
            }

        }
        if (e.getSource()==jButton2) {
            jtfname.setText("");
            jtfid.setText("");
            jpwd.setText("");
            rejpwd.setText("");
            jtfphone.setText("");
            jtfaddress.setText("");
            jtfeid.setText("");
            jtfcredit.setText("");
            lb_id.setText("");
            lb_pwd.setText("");
            lb_repwd.setText("");
            lb_name.setText("");
            JOptionPane.showMessageDialog(this, "重置完成", "重置", JOptionPane.INFORMATION_MESSAGE);
        }
    }

}
