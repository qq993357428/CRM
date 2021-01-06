package com.crm.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.SQLException;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.crm.model.User_Model;
import com.crm.utils.UserDaoImp;

public class selectTable extends JFrame{
		private JPanel contentPane;
	    private JTable table;
	    private String head[]=null;
	    private Object [][]data=null;
	    private UserDaoImp user=new UserDaoImp();
	    

	    /**
	     * Launch the application.
	     */
	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                try {
						selectTable frame = new selectTable();
	                    frame.setVisible(true);
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	            }
	        });
	    }

	    /**
	     * Create the frame.
	     */
	    public selectTable() {
	        setResizable(false);
	        
	        setTitle("");
	        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setBounds(100, 100, 700, 300);
	        Dimension   us=this.getSize();
	        Dimension them=Toolkit.getDefaultToolkit().getScreenSize();
	              
	              int   x=(them.width-us.width)/2;  
	              int   y=(them.height-us.height)/2;   
	              
	              this.setLocation(x, y);
	        contentPane = new JPanel();
	        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	        setContentPane(contentPane);
	        
	        JScrollPane scrollPane = new JScrollPane();
	        scrollPane.setBounds(0,0,700,250);
	        
	        table = new JTable();
	         
	        table.setBorder(new LineBorder(new Color(0, 0, 0)));
	        head=new String[] {
					"id", "姓名", "联系方式", "信用度", "住址","联系人id",
	        };
	        
	        DefaultTableModel tableModel=new DefaultTableModel(queryData(),head){
	            public boolean isCellEditable(int row, int column)
	            {
	                return false;
	            }
	        };
	        table.setModel(tableModel);

	        scrollPane.setViewportView(table);
	        GroupLayout gl_contentPane = new GroupLayout(contentPane);
	        gl_contentPane.setHorizontalGroup(
	            gl_contentPane.createParallelGroup(Alignment.LEADING)
	                .addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
	        );
	        gl_contentPane.setVerticalGroup(
	            gl_contentPane.createParallelGroup(Alignment.LEADING)
	                .addGroup(gl_contentPane.createSequentialGroup()
	                    .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
	                    .addGap(66))
	        );
	        contentPane.setLayout(gl_contentPane);
	        

	    }
	    
	    //���ɱ������
	    /**
	     * @return
	     */
	    public Object[][] queryData(){
			List<User_Model> list= null;
			try {
				list = user.selectAll();
				data=new Object[list.size()][head.length];

				for(int i=0;i<list.size();i++){
					for(int j=0;j<head.length;j++){
						data[i][0]=list.get(i).getUid();
						data[i][1]=list.get(i).getUname();
						data[i][2]=list.get(i).getPhone();
						data[i][3]=list.get(i).getAddress();
						data[i][4]=list.get(i).getCredit();
						data[i][5]=list.get(i).getEid();
					}
				}
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
	        return data;
	    }
}
