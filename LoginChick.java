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
public class LoginChick {
	private String name;
	private String password;
	public LoginChick(String name,String password)
	{
		this.name=name;
		this.password=password;
	}
	public boolean equals(){
        if("sa".equals(name)&&"admin".equals(password)){
            return true;
        }
        else{
            return false;
        }
    }
}
