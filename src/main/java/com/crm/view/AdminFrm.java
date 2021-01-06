package com.crm.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.crm.utils.utils_ui.setFrameCenter;

public class AdminFrm extends JFrame {
    private JPanel contentPane;
    private JDesktopPane table;
    /**
     * 创建窗体
     */
    public AdminFrm() {
        setTitle("管理员服务主界面");
        setIconImage(Toolkit.getDefaultToolkit().getImage(AdminFrm.class.getResource("/com/crm/images/1.jpg")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 200, 900, 800);

        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu menu = new JMenu("查看");
        menu.setIcon(new ImageIcon(AdminFrm.class.getResource("/com/crm/images/search.png")));
        menuBar.add(menu);

        JMenuItem menu_2 = new JMenuItem("基本信息");
        menu_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                //table.add(main);
            }
        });
        menu_2.setIcon(new ImageIcon(AdminFrm.class.getResource("/com/crm/images/userName.png")));
        menu.add(menu_2);

        JMenuItem menu_3 = new JMenuItem("消费情况");
        menu_3.setIcon(new ImageIcon(AdminFrm.class.getResource("/com/crm/images/reset.png")));
        menu.add(menu_3);

        JMenuItem menuItem_1 = new JMenuItem("安全退出");
        menuItem_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitSystemActionPerformed(e);
            }
        });
        menuItem_1.setIcon(new ImageIcon(AdminFrm.class.getResource("/com/crm/images/exit.png")));
        menu.add(menuItem_1);

        JMenu menu2 = new JMenu("编辑");
        menu2.setIcon(new ImageIcon(AdminFrm.class.getResource("/com/crm/images/edit.png")));
        menuBar.add(menu2);
        JMenuItem jmiAdd = new JMenuItem("添加用户");
        jmiAdd.setIcon(new ImageIcon(AdminFrm.class.getResource("/com/crm/images/add.png")));
        menu2.add(jmiAdd);
        jmiAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserReg userReg = new UserReg();
                setFrameCenter(userReg);
                userReg.setVisible(true);
            }
        });
        JMenuItem jmiQuery = new JMenuItem("查询用户");
        jmiQuery.setIcon(new ImageIcon(AdminFrm.class.getResource("/com/crm/images/search.png")));
        menu2.add(jmiQuery);
        jmiQuery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectTable query = new selectTable();
                query.setVisible(true);
            }
        });

        JMenu menu_1 = new JMenu("联系我们");
        menu_1.setIcon(new ImageIcon(AdminFrm.class.getResource("/com/crm/images/edit.png")));
        menuBar.add(menu_1);

        JMenuItem menuItem = new JMenuItem("联系方式");
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                MyContactInterFrm myContactInterFrm = new MyContactInterFrm();
              //  myContactInterFrm.setVisible(true);
                //table.add(myContactInterFrm);

            }
        });
        menuItem.setIcon(new ImageIcon(AdminFrm.class.getResource("/com/crm/images/about.png")));
        menu_1.add(menuItem);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        table = new JDesktopPane();
        contentPane.add(table, BorderLayout.CENTER);

        // 居中显示
        this.setLocationRelativeTo(null);

        // 最大化处理
        // this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * 安全退出系统
     *
     * @param e
     */
    private void exitSystemActionPerformed(ActionEvent e) {
        int n = JOptionPane.showConfirmDialog(null, "你确定要离开系统么");
        if (n == 0) {
            dispose();
            return;
        }
    }

    /**
     * 运行程序
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminFrm frame = new AdminFrm();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
