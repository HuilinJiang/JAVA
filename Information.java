package 学生信息管理系统;
import java.awt.*;
import java.awt.event.*;
import javax.security.auth.login.LoginContext;
import javax.swing.*;
import java.io.*;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Information extends JFrame{
	private JTextField number=new JTextField();
	private JLabel snumber=new JLabel("学号：");
	private JTextField name=new JTextField();
	private JLabel sname=new JLabel("姓名：");
	private JTextField dor=new JTextField();
	private JLabel sdor=new JLabel("宿舍：");
	private JTextField address=new JTextField();
	private JLabel saddress=new JLabel("家庭住址：");
	private JTextField sex=new JTextField();
	private JLabel ssex=new JLabel("性别：");
	private JTextField date=new JTextField();
	private JLabel sdate=new JLabel("出生日期：");
	private JTextField pol=new JTextField();
	private JLabel spol=new JLabel("政治面貌：");
	private JTextField phone=new JTextField();
	private JLabel sphone=	new JLabel("电话号码：");
	private JTextField acad=new JTextField();
	private JLabel sacad=new JLabel("学院：");
	private JTextField major=new JTextField();
	private JLabel smajor=new JLabel("专业：");
	private JTextField grade=new JTextField();
	private JLabel sgrade=new JLabel("年级：");
	private JTextField cla=new JTextField();
	private JLabel scla=new JLabel("班级：");
	private JTextField dep=new JTextField();
	private JLabel sdep=new JLabel("园区：");
	private JTextField enterDate=new JTextField();
	private JLabel senterDate=new JLabel("入学时间：");
	private JButton but0=new JButton("退出");
	private JButton but1=new JButton("增加");
    private JButton but2=new JButton("删除");
    private JButton but3=new JButton("修改");
    private JButton but4=new JButton("查看");
    private JButton but5=new JButton("显示全部学生信息");
    private JButton but6=new JButton("清空");
    private JTextArea show = new JTextArea(16, 30);
    private JFrame frame = new JFrame("显示信息");
    private File file=new File("file1.txt");
    private Hashtable<String,Student> has=new Hashtable<String,Student>();
    public Information() {
    	if (!file.exists()) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                out.writeObject(has.toString());
                out.close();
            } catch (IOException e) {}
    	}
    	but0.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(e.getSource()==but0) {
        			setVisible(false);
        			new Login();
        		}
        	}
        });
    	but1.addActionListener(new ActionListener() { // 增加，内部类
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but1) {
                    but3.setEnabled(false);//使but3这个按钮变灰不可点击了
                    String number1 = number.getText();
                    if (number1.length() == 10) {
                        try {
                            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));//读回对象
                            has = (Hashtable<String, Student>) in.readObject();                                                 
                            in.close();
                        } catch (Exception e1) {
                        }
                                    } else {
                        JOptionPane.showMessageDialog(null, "请输入10位数字的学号");
                    }
                    //
                    if (number1.length() == 10) {
                    if (has.containsKey(number1)) {                     
                    	JOptionPane.showMessageDialog(null, "该生信息已存在，请到修改页面修改！");
                    } else {
                    	number1 = number.getText();
    	                String name1 = name.getText();
    	                String dor1 = dor.getText();
    	                String address1 = address.getText();
    	                String sex1 = sex.getText();
    	                String date1 = date.getText();
    	                String pol1 = pol.getText();
    	                String phone1 = phone.getText();
    	                String acad1=acad.getText();
    	            	String major1=major.getText();
    	            	String grade1=grade.getText();
    	            	String cla1=cla.getText();
    	            	String dep1=dep.getText();
    	            	String enterDate1=enterDate.getText();
    	                Student per = new Student(number1, name1, dor1, address1, sex1, date1, pol1, phone1,acad1,major1,grade1,cla1,dep1,enterDate1);
    	                has.put(number1, per);
    	                try {
                            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
                            out.writeObject(has);
                            out.close();
                       JOptionPane.showMessageDialog(null, "添加成功！");
                        } catch (Exception e1) {}
                    }
                    }
                }
            }
        });
    	but5.addActionListener(new ActionListener() {
			@SuppressWarnings({ "unchecked" })
			public void actionPerformed(ActionEvent e) {
    	        if (e.getSource() == but5) {
    	            frame.setVisible(true);
    	            show.setText("");
    	            show.setEditable(false);
    	            try {
    	                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
    	                 has = (Hashtable<String, Student>) in.readObject();
    	                in.close();
    	            } catch (Exception ee) {
    	            }
    	            if (has.isEmpty()) {
    	                show.append("目前还没有学生的信息记录！\n");
    	} else {
    	                                    
    	            for (Enumeration<Student> enu = has.elements(); enu.hasMoreElements();) {
    	                    Student per = enu.nextElement();
    	                    String str = "  <学号>：" + per.getNum() + "\n" + 
    	                    "  <姓名>：" + per.getName() + "\n" + 
    	                    "  <宿舍号>："+ per.getDor() + "\n" + 
    	                    "  <家庭住址>：" + per.getAddress() + "\n" + 
    	                    "  <性别>："+ per.getSex() + "\n" +
    	                    "<出生日期>：" + per.getDate() + "\n" + 
    	                    "  <政治面貌>："+ per.getPol() + "\n" + 
    	                    " <电话>：" + per.getPhone() + "\n" +
    	                    "<学院>:"+per.getAcad()+"\n"+
    	                    "<专业>:"+per.getMajor()+"\n"+
    	                    "<年级>:"+per.getGrade()+"\n"+
    	                    "<班级>:"+per.getCla()+"\n"+
    	                    "<园区>:"+per.getDep()+"\n"+
    	                    "<入学时间>:"+per.getEnterDate()+"\n"+
    	                    "\n";
    	                    show.append(str);
    	                }
    	                String str2 = "------------------------------结束---------------------------------------------------"
    	                        + "\n";
    	                show.append(str2);
    	            }
    	        }
    	    }

    	});
    	but2.addActionListener(new ActionListener() {
            @SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
                if (e.getSource() == but2) {
                    but3.setEnabled(false);
                    String number1 = number.getText();
                    if (number1.length() == 10) {
                        try {
                            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
                            has = (Hashtable<String, Student>) in.readObject();
                            in.close();
                        } catch (Exception e1) {
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "请输入10位数字的学号");
                    }
                    if (has.containsKey(number1)) {
                        has.remove(number1);
                        ObjectOutputStream out = null;
                        JOptionPane.showMessageDialog(null, "删除成功");
                        try {
                            out = new ObjectOutputStream(new FileOutputStream(file));
                            //out.writeObject(has);
                            out.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Information.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "学号不存在");
                    }
                }
            }
        });
    	but3.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {

    	            if (e.getSource() == but3) {
    	                but3.setEnabled(false);
    	                String number1 = number.getText();
    	                String name1 = name.getText();
    	                String dor1 = dor.getText();
    	                String address1 = address.getText();
    	                String sex1 = sex.getText();
    	                String date1 = date.getText();
    	                String pol1 = pol.getText();
    	                String phone1 = phone.getText();
    	                String acad1=acad.getText();
    	            	String major1=major.getText();
    	            	String grade1=grade.getText();
    	            	String cla1=cla.getText();
    	            	String dep1=dep.getText();
    	            	String enterDate1=enterDate.getText();
    	                Student per = new Student(number1, name1, dor1, address1, sex1, date1, pol1, phone1,acad1,major1,grade1,cla1,dep1,enterDate1);
    	                has.put(number1, per);
    	                JOptionPane.showMessageDialog(null, "修改成功");
    	                try {
    	                    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
    	                    out.writeObject(has);
    	                    out.close();
    	                } catch (Exception e1) {
    	                }
    	            }
    	        }
    	    });
    	but4.addActionListener(new ActionListener() {
    	    public void actionPerformed(ActionEvent e) {

    	            if (e.getSource() == but4) {
    	                but3.setEnabled(false);
        	            try {
        	                ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        	                 has = (Hashtable<String, Student>) in.readObject();
        	                in.close();
        	            } catch (Exception ee) {
        	            }
        	            if (has.isEmpty()) {
        	} else {
        	                                    
        	            for (Enumeration<Student> enu = has.elements(); enu.hasMoreElements();) {
        	                    Student per = enu.nextElement();
        	                    String str = "  <学号>：" + per.getNum() + "\n" + 
        	                    "  <姓名>：" + per.getName() + "\n" + 
        	                    "  <宿舍号>："+ per.getDor() + "\n" + 
        	                    "  <家庭住址>：" + per.getAddress() + "\n" + 
        	                    "  <性别>："+ per.getSex() + "\n" +
        	                    "<出生日期>：" + per.getDate() + "\n" + 
        	                    "  <政治面貌>："+ per.getPol() + "\n" + 
        	                    " <电话>：" + per.getPhone() + "\n" +
        	                    "<学院>:"+per.getAcad()+"\n"+
        	                    "<专业>:"+per.getMajor()+"\n"+
        	                    "<年级>:"+per.getGrade()+"\n"+
        	                    "<班级>:"+per.getCla()+"\n"+
        	                    "<园区>:"+per.getDep()+"\n"+
        	                    "<入学时间>:"+per.getEnterDate()+"\n"+
        	                    "\n";
        	                }
        	                String str2 = "------------------------------结束---------------------------------------------------"
        	                        + "\n";
        	            }
    	                String number1 = number.getText();
    	                if (number1.length() == 10) {
    	                    if (has.containsKey(number1)) {
    	                        try {
    	                            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
    	                            has = (Hashtable<String, Student>) in.readObject();
    	                            in.close();
    	                        } catch (Exception e1) {
    	                        }
    	                        Student per = has.get(number1);
    	                        
    	                        name.setText(per.getName());
    	                        dor.setText(per.getDor());
    	                        address.setText(per.getAddress());
    	                        sex.setText(per.getSex());
    	                        date.setText(per.getDate());
    	                        pol.setText(per.getPol());
    	                        phone.setText(per.getPhone());
    	                        acad.setText(per.getAcad());
    	    	            	major.setText(per.getMajor());
    	    	            	grade.setText(per.getGrade());
    	    	            	cla.setText(per.getCla());
    	    	            	dep.setText(per.getDep());
    	    	            	enterDate.setText(per.getEnterDate());
    	                        but3.setEnabled(true);
    	                    } else {
    	                        JOptionPane.showMessageDialog(null, "学号不存在");
    	                    }
    	                } else {
    	                    JOptionPane.showMessageDialog(null, "请输入10位数字的学号");
    	                }
    	            }
    	        }

    	    });
    	 but6.addActionListener(
    			 new ActionListener(){
    			             public void actionPerformed(ActionEvent e){
    			                 if(e.getSource()==but6){
    			                	 number.setText("");
    			                	 name.setText("");
    	    	                     dor.setText("");
    	    	                     address.setText("");
    	    	                      sex.setText("");
    	    	                      date.setText("");
    	    	                      pol.setText("");
    	    	                      phone.setText("");
    	    	                      acad.setText("");
    	    	    	              major.setText("");
    	    	    	              grade.setText("");
    	    	    	             cla.setText("");
    	    	    	             dep.setText("");
    	    	    	             enterDate.setText("");
    			                 }
    			             }

    			         });

    	setSize(600,450);
    	setVisible(true);
    	setLayout(null);
    	but0.setBounds(470,330, 70, 30);
    	but1.setBounds(30, 20,  70, 30);
    	but2.setBounds(140, 20, 70, 30);
    	but3.setBounds(250, 20, 70, 30);
    	but4.setBounds(360, 20, 70, 30);
    	but5.setBounds(30, 350, 150, 30);
    	but6.setBounds(200, 350, 70, 30);
    	add(but0);
    	add(but1);
    	add(but2);
    	add(but3);
    	add(but4);
    	add(but5);
    	add(but6);
	    snumber.setBounds(30,70,80,40); 
	    sname.setBounds(160,70,80,40);
	    ssex.setBounds(290,70,80,40);
	    sphone.setBounds(420, 70, 80, 40);
	    sdep.setBounds(30,130,80,40);
	    sdor.setBounds(160, 130, 80, 40);
	    sacad.setBounds(30,190,80,40);
	    smajor.setBounds(160,190,80,40);
	    sgrade.setBounds(30,250,80,40);
	    scla.setBounds(160,250,80,40);
	    sdate.setBounds(290, 130, 80, 40);
	    senterDate.setBounds(290,190,80,40);
	    spol.setBounds(290,250,80,40);
	    saddress.setBounds(30, 300, 160, 40);
	    add(snumber);
	    add(sname);
	    add(ssex);
	    add(sphone);
	    add(sdep);
	    add(sdor);
	    add(sacad);
	    add(smajor);
	    add(sgrade);
	    add(scla);
	    add(sdate);
	    add(senterDate);
	    add(spol);
	    add(saddress);
	    number.setBounds(70,70,80,40); 
	    name.setBounds(195,70,80,40);
	    sex.setBounds(325,70,80,40);
	    phone.setBounds(480, 70, 80, 40);
	    dep.setBounds(70,130,80,40);
	    dor.setBounds(195, 130, 80, 40);
	    acad.setBounds(70,190,80,40);
	    major.setBounds(195,190,80,40);
	    grade.setBounds(70,250,80,40);
	    cla.setBounds(195,250,80,40);
	    date.setBounds(355, 130, 80, 40);
	    enterDate.setBounds(355,190,80,40);
	    pol.setBounds(355,250,80,40);
	    address.setBounds(100, 300, 240, 40);
	    add(number);
	    add(name);
	    add(sex);
	    add(phone);
	    add(dep);
	    add(dor);
	    add(acad);
	    add(major);
	    add(grade);
	    add(cla);
	    add(date);
	    add(enterDate);
	    add(pol);
	    add(address);
	    JScrollPane scroll = new JScrollPane(show);
        frame.add(scroll,BorderLayout.CENTER);  
        frame.setBounds(200, 200, 400, 300);
        frame.setVisible(false);
	    setResizable(false);
    }     
}
