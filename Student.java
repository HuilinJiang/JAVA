package 学生信息管理系统;
import java.io.Serializable;

import javax.swing.JLabel;
import javax.swing.JTextField;
public class Student implements Serializable{
	private String num;
    private String name;
    private String dor;
    private String address;
    private String sex;
    private String date;
    private String pol;
    private String phone;
    private String acad;
	private String major;
	private String grade;
	private String cla;
	private String dep;
	private String enterDate;
    public Student(){}
    public Student(String num,String name,String dor,String address,String sex,String date,String pol,String phone,
    		String acad,String major,String grade,String cla,String dep,String enterDate){
        this.num=num;
        this.name=name;
        this.dor=dor;
        this.address=address;
        this.sex=sex;
        this.date=date;
        this.pol=pol;
        this.phone=phone;
        this.acad=acad;
        this.major=major;
        this.grade=grade;
        this.cla=cla;
        this.dep=dep;
        this.enterDate=enterDate;
        }
    public void setNum(String num){
        this.num=num;
        }
    public String getNum(){
        return num;
        } 
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setDor(String dor){
        this.dor=dor;
    }
    public String getDor(){
        return dor;
    }
    public void setAddress(String address){
        this.address=address;
    }
    public String getAddress(){
        return address;
    }
    public void setSex(String sex){
        this.sex=sex;
    }
    public String getSex(){
        return sex;
    }
    public void setDate(String date){
        this.date=date;
    }
    public String getDate(){
        return date;
    }
    public void setPol(String pol){
        this.pol=pol;
    }
    public String getPol(){
        return pol;
        }
    public void setPhone(String phone){
        this.phone=phone;
        }
    public String getPhone(){
        return phone;
        }
    public void setAcad(String acad)
    {
    	this.acad=acad;
    }
    public String getAcad()
    {
    	return acad;
    }
    public void setMajor(String major)
    {
    	this.major=major;
    }
    public String getMajor() {
    	return major;
    }
    public void setGrade(String grade)
    {
    	this.grade=grade;
    }
    public String getGrade() {
    	return grade;
    }
    public void setCla(String cla) {
    	this.cla=cla;
    }
    public String getCla() {
    	return cla;
    }
    public void setDep(String dep) {
    	this.dep=dep;
    }
    public String getDep() {
    	return dep;
    }
    public void setEnterDate(String enterDate) {
    	this.enterDate=enterDate;
    }
    public String getEnterDate() {
    	return enterDate;
    }
}

