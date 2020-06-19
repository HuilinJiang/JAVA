package 学生信息管理系统;
import java.awt.*;
import java.awt.event.*;
import javax.security.auth.login.LoginContext;
import javax.swing.*;
import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Login {
	    private JFrame frame=new JFrame("学生信息管理系统");
	    private JTextField name=new JTextField();
	    private JPasswordField pass=new JPasswordField();
	    private JLabel but1=new JLabel("用户名:");
	    private JLabel but2=new JLabel("密   码:");
	    private JButton but3=new JButton("登陆");
	    private JButton but4=new JButton("重置");
	    public Login(){
	        but3.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e){
	                if(e.getSource()==but3){
	                    String sname=name.getText();
	                    String spass=new String(pass.getPassword());
	                    LoginChick log=new LoginChick(sname,spass);
	                    if(log.equals()){
	                        try {
	                            new Information();
	                        } catch (Exception e1) {
	                            
	                            e1.printStackTrace();
	                        }
	                        frame.setVisible(false);
	                        
	                    }else{
	                        JOptionPane.showMessageDialog(null, "登录失败，错误的用户名或密码！");
	                    }
	                }
	            }                   
	        });
	        but4.addActionListener(
	        		new ActionListener(){
	        		            public void actionPerformed(ActionEvent e){
	        		                if(e.getSource()==but4){
	        		                    name.setText("");
	        		                    pass.setText("");
	        		                }
	        		            }

	        		        });
	        frame.setLayout(null);
	        but1.setBounds(80, 40 , 80,30);
	        name.setBounds(140,40, 120, 30);   
	        but2.setBounds(80, 80 , 80,30);
	        pass.setBounds(140,80, 120, 30);
	        but3.setBounds(100, 150 , 60,30);
	        but4.setBounds(180, 150 , 60,30);
	        frame.setSize(400,330);     
	        frame.setLocation(300, 200);
	        frame.add(but1);
	        frame.add(name);
	        frame.add(pass);
	        frame.add(but2);
	        frame.add(but3);
	        frame.add(but4);
	        frame.setVisible(true);
	        frame.setResizable(false);
	    }
	}




